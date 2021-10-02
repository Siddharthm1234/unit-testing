package com.example.unittesting.mvc.repository;

import com.example.unittesting.mvc.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@ActiveProfiles("test")
class ItemRepositoryTest {


    @Autowired
    private ItemRepository itemRepository;


    @Test
    @Sql(
            scripts = { "/items-delete-test.sql", "/items-insert-test.sql"}
    )
    @Sql(
            scripts = "/items-delete-test.sql",
            executionPhase = AFTER_TEST_METHOD)
    public void testFindAll(){
        List<Item> items = itemRepository.findAll();

        System.out.println("items = " + items);
        assertEquals(3, items.size());
        
    }
}