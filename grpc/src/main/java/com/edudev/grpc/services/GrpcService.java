package com.edudev.grpc.services;


import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import person.Dudu.Description;
import person.PersonServiceGrpc;

import static person.Dudu.Person;

@GRpcService
public class GrpcService extends PersonServiceGrpc.PersonServiceImplBase {

    @Override
    public void getPerson(Description request, StreamObserver<Person> responseObserver) {

        var description = request.getDescription();
        var person = Person.newBuilder()
                .setId("1")
                .setName("Eduardo José")
                .setDescription(description)
                .build();

        responseObserver.onNext(person);
        responseObserver.onCompleted();


    }
}
