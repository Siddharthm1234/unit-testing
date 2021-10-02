package com.example.unittesting.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**Issues with having stubs approach - Why we move to Mocks
 * 1. We need different stub for checking different cases
 * 2. If we are have a impl stub and a new method is added to interface... we need to update each and every stub with that method
 * 3. We need to check back inside the stub to verify the data passed
 * Overall - Stubs are a big headache and hence we using MOCKS!
 */

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {

    @InjectMocks
    private SomeBusinessServiceMockImpl someBusinessServiceMock;

    @Mock
    private SomeDataService someDataService;

    @Test
    void sum_ZeroValues() {
        when(someDataService.getAllData()).thenReturn(new int[] {});
        assertEquals(0, someBusinessServiceMock.sum(), "expected sum is 0");
    }

    @Test
    void sum_OneValue() {
        when(someDataService.getAllData()).thenReturn(new int[] {1});
        assertEquals(1, someBusinessServiceMock.sum(), "expected sum is 1");
    }

    @Test
    void sum_AllValues() {
        when(someDataService.getAllData()).thenReturn(new int[] {1,2,3,4});
        assertEquals(10, someBusinessServiceMock.sum(), "expected sum is 10");
    }
}