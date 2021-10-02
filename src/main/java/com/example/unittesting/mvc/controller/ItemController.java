package com.example.unittesting.mvc.controller;

import com.example.unittesting.mvc.domain.Item;
import com.example.unittesting.mvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/dummy-item")
    public Item getDummyItem(){
        return new Item(1L, "ball", 100, 1);
    }

    @GetMapping("/item-from-business-service")
    public Item getItemFromBusinessLayer(){
        return itemService.getHardCodedItem();
    }

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return itemService.getData();
    }

}
