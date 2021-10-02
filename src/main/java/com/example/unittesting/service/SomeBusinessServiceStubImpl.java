package com.example.unittesting.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SomeBusinessServiceStubImpl {

    @Qualifier("AllValuesData")
    private SomeDataService someDataService;

    public int sum(){
        int sum = 0;
        int [] data = someDataService.getAllData();
        for(int val : data){
            sum+=val;
        }
        return sum;
    }
}
