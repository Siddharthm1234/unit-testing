package com.example.unittesting.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SomeBusinessTest {

    @InjectMocks
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