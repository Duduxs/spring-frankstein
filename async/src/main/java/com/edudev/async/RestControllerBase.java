package com.edudev.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/async")
public class RestControllerBase {

    @Autowired
    private AsyncTask task;

    @GetMapping
    public String sayHello() throws ExecutionException, InterruptedException {
        var result = task.asyncReturnMethod();
        return result.isDone() ? result.get() : "Not working";
    }


}
