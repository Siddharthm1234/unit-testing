package com.example.unittesting.mvc.service;

import com.example.unittesting.mvc.domain.Item;
import com.example.unittesting.mvc.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item getHardCodedItem() {
        return new Item(1L, "ball", 100, 1);
    }

    public List<Item> getData(){
        List<Item> items = itemRepository.findAll();
        for(Item item : items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
