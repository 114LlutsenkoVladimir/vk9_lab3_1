package com.example.lab3_vk9_1.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("helloBean")
@RequestScoped
public class HelloBean {
    public String getMsg() {
        return "it works!";
    }
}
