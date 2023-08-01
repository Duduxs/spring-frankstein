package com.edudev.grpc.services;

import com.edudev.grpc.entities.Category;
import com.edudev.grpc.protos.CategoryServiceGrpc.CategoryServiceImplBase;
import com.edudev.grpc.protos.CreateCategoryRequest;
import com.edudev.grpc.repositories.CategoryRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

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
}
