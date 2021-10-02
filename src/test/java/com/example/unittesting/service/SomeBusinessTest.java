package com.example.unittesting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SomeBusinessTest {

    @Autowired
    private SomeBusinessServiceImpl someBusinessService;

    @Test
    void sum_ZeroValues() {
        int actualSum = someBusinessService.sum(new int [] {});
        int expectedSum  = 0;
        assertEquals(expectedSum, actualSum, "expected sum is 0");
    }

    @Test
    void sum_OneValue() {
        int actualSum = someBusinessService.sum(new int [] {5});
        int expectedSum  = 5;
        assertEquals(expectedSum, actualSum, "expected sum is 5");
    }

    @Test
    void sum() {
        int actualSum = someBusinessService.sum(new int [] {1,2,3});
        int expectedSum  = 6;
        assertEquals(expectedSum, actualSum, "expected sum is 6");
    }

}