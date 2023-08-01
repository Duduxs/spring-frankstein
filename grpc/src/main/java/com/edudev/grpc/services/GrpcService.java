package com.edudev.grpc.services;


import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import person.Dudu;
import person.PersonServiceGrpc;

@GRpcService
public class GrpcService extends PersonServiceGrpc.PersonServiceImplBase {

    @Override
    public void getPerson(Dudu.Description request, StreamObserver<Dudu.Person> responseObserver) {

        var description = request.getDescription();
        var person = Dudu.Person.newBuilder()
                .setId("1")
                .setName("Eduardo José")
                .setDescription(description)
                .build();

        responseObserver.onNext(person);
        responseObserver.onCompleted();


    }
}
