package com.edudev.springshell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommand {

    @ShellMethod(value = "Sum two numbers")
    public Integer sum(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @ShellMethod(value = "Subtract two numbers")
    public Integer subtract(Integer num1, Integer num2) {
        return num1 - num2;
    }

    @ShellMethod(value = "Multiply two numbers")
    public Integer multiply(Integer num1, Integer num2) {
        return num1 * num2;

    }

    @ShellMethod(value = "Divide two numbers")
    public Integer divide(Integer num1, Integer num2) {
        return num1 / num2;
    }


    @ShellMethod(value = "Return the parameter that you've provided")
    public String params(@ShellOption(defaultValue = "ARGS") String arg) {
        return arg;
    }

}


