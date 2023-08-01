package com.edudev.grpc.services;

import com.edudev.grpc.entities.Category;
import com.edudev.grpc.protos.CategoryListResponse;
import com.edudev.grpc.protos.CategoryServiceGrpc.CategoryServiceImplBase;
import com.edudev.grpc.protos.CreateCategoryRequest;
import com.edudev.grpc.protos.Empty;
import com.edudev.grpc.protos.GetCategoryRequest;
import com.edudev.grpc.repositories.CategoryRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GRpcService
public class CourseCategoryService extends CategoryServiceImplBase {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CourseCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(CreateCategoryRequest request, StreamObserver<com.edudev.grpc.protos.Category> responseObserver) {

        var category = new Category(null, request.getName(), request.getDescription());
        categoryRepository.save(category);

        responseObserver.onNext(
                com.edudev.grpc.protos.Category.newBuilder()
                        .setId(category.id.toString())
                        .setName(category.name)
                        .setDescription(category.description)
                        .build()
        );

        responseObserver.onCompleted();
    }

    @Override
    public void getCategory(GetCategoryRequest request, StreamObserver<com.edudev.grpc.protos.Category> responseObserver) {
        var id = request.getId();
        if (id.isEmpty() || id.isBlank())
            throw new IllegalArgumentException("A valid id must be provided");

        var category = categoryRepository.findById(Long.valueOf(id)).orElseThrow(() -> new IllegalArgumentException("Category not found"));

        responseObserver.onNext(com.edudev.grpc.protos.Category.newBuilder()
                .setId(category.id.toString())
                .setName(category.name)
                .setDescription(category.description)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void listCategories(Empty request, StreamObserver<CategoryListResponse> responseObserver) {

        var categories = categoryRepository.findAll().stream().map(category ->
                com.edudev.grpc.protos.Category.newBuilder()
                        .setId(category.id.toString())
                        .setName(category.name)
                        .setDescription(category.description)
                        .build()
        ).toList();

        responseObserver.onNext(CategoryListResponse.newBuilder().addAllCategories(categories).build());
        responseObserver.onCompleted();

    }

    /**
     * Stream right below
     */

    @Override
    public StreamObserver<CreateCategoryRequest> createCategoryClientStream(StreamObserver<CategoryListResponse> responseObserver) {
        return new StreamObserver<>() {

            final List<Category> categoryList = new ArrayList<>();

            @Override
            public void onNext(CreateCategoryRequest value) {
                var category = new Category(null, value.getName(), value.getDescription());
                categoryRepository.save(category);
                categoryList.add(category);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                var categories = categoryList
                        .stream()
                        .map(category ->
                                com.edudev.grpc.protos.Category.newBuilder()
                                        .setId(category.id.toString())
                                        .setName(category.name)
                                        .setDescription(category.description)
                                        .build()
                        ).toList();

                responseObserver.onNext(CategoryListResponse.newBuilder().addAllCategories(categories).build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void createCategoryServerStream(CreateCategoryRequest request, StreamObserver<com.edudev.grpc.protos.Category> responseObserver) {
        categoryRepository.save(new Category(null, request.getName(), request.getDescription()));

        categoryRepository.findAll().stream().map(category -> com.edudev.grpc.protos.Category.newBuilder()
                .setId(category.id.toString())
                .setName(category.name)
                .setDescription(category.description)
                .build()
        ).forEach(responseObserver::onNext);


        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<CreateCategoryRequest> createCategoryBidirectionalStream(StreamObserver<com.edudev.grpc.protos.Category> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(CreateCategoryRequest value) {
                var category = new Category(null, value.getName(), value.getDescription());
                categoryRepository.save(category);

                var response = com.edudev.grpc.protos.Category.newBuilder()
                        .setId(category.id.toString())
                        .setName(category.name)
                        .setDescription(category.description)
                        .build();

                responseObserver.onNext(response);

            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
