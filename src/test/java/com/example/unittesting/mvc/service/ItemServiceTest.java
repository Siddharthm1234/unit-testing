package com.example.unittesting.mvc.service;

import com.example.unittesting.mvc.domain.Item;
import com.example.unittesting.mvc.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void getData() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList
                (new Item(1L, "BallTest", 100, 1)
                        , new Item(2L, "BatTest", 1500, 2)));

        List<Item> items = itemService.getData();

        assertEquals(2, items.size(), "There should be 2 items");
        assertEquals(100, items.get(0).getValue(), "The value us 100 * 1 = 100");
        assertEquals(3000, items.get(1).getValue(), "The value us 1500 * 2 = 300");

    }
}