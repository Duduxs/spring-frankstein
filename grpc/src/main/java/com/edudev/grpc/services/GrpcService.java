package com.edudev.grpc.services;


import com.edudev.grpc.Dudu.Description;
import com.edudev.grpc.Dudu.Person;
import com.edudev.grpc.PersonServiceGrpc.PersonServiceImplBase;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;


@GRpcService
public class GrpcService extends PersonServiceImplBase {

    @Override
    public void getPerson(Description request, StreamObserver<Person> responseObserver) {

        var description = request.getDescription();
        var gender = request.getGender();
        var person = Person.newBuilder()
                .setId("1")
                .setName("Eduardo José")
                .setDescription(description)
                .setGender(gender)
                .build();

        responseObserver.onNext(person);
        responseObserver.onCompleted();


    }
}
