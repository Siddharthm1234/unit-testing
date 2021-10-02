package com.example.unittesting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Issues with having stubs approach - Why we move to Mocks
 * 1. We need different stub for checking different cases
 * 2. If we are have a impl stub and a new method is added to interface... we need to update each and every stub with that method
 * 3. We need to check back inside the stub to verify the data passed
 * Overall - Stubs are a big headache and hence we using MOCKS!
 */

@SpringBootTest
class SomeBusinessStubTest {

    @Autowired
    @Qualifier("AllValuesData")
    private SomeDataService allValuesSomeDataService;

    @Autowired
    @Qualifier("ZeroValuesData")
    private SomeDataService zeroValuesSomeDataService;

    @Test
    void sum_ZeroValues() {
        int [] data = zeroValuesSomeDataService.getAllData();

        int actualSum = 0;
        for(int val : data){
            actualSum+=val;
        }
        int expectedSum  = 0;
        assertEquals(expectedSum, actualSum, "expected sum is 0");
    }

    @Test
    void sum_AllValues() {
        int [] data = allValuesSomeDataService.getAllData();
        int actualSum = 0;
        for(int val : data){
            actualSum+=val;
        }
        int expectedSum  = 10;
        assertEquals(expectedSum, actualSum, "expected sum is 10");
    }
}


@Component("ZeroValuesData")
class ZeroValuesSomeDataServiceImpl implements SomeDataService {

    @Override
    public int[] getAllData() {
        return new int[] {};
    }
}

@Component("AllValuesData")
class AllValuesSomeDataServiceImpl implements SomeDataService {

    @Override
    public int[] getAllData() {
        return new int[] {1,2,3,4};
    }
}