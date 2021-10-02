package com.example.unittesting.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SomeBusinessServiceImpl {

    //Generally we have dependency on some other classes
    public int sum(int [] data){
        int sum = 0;
        for(int val : data){
            sum+=val;
        }
        return sum;
    }
}
