package com.edudev.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    @Async
    public void asyncMethod() {
        System.out.println("Async method working... " + Thread.currentThread().getName());
    }

    @Async
    public Future<String> asyncReturnMethod() {
        return new AsyncResult<>("Async result!!");
    }
}
