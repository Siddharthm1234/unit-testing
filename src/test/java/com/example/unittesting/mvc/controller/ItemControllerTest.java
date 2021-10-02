package com.example.unittesting.mvc.controller;

import com.example.unittesting.mvc.domain.Item;
import com.example.unittesting.mvc.repository.ItemRepository;
import com.example.unittesting.mvc.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @MockBean
    private ItemService itemService;

    //Added ItemRepo to main method (CommandLineRunner)
    //to load some dummy data for test env. Therefore
    //need to add a Mock Bean of it..
    @MockBean
    private ItemRepository itemRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getDummyItem_Basic() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                get("/dummy-item")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "id: 1 ," +
                        "name: ball," +
                        "price: 100," +
                        "quantity: 1" +
                        "}"))
                //.andExpect(jsonPath("$", is("")))
                .andReturn();
    }

    @Test
    public void getHardCodedDAtaFromService_Basic() throws Exception {

        when(itemService.getHardCodedItem()).thenReturn(new Item(1L, "Ball Test", 100, 1));

        MvcResult mvcResult = mockMvc.perform(
                get("/item-from-business-service")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "id: 1 ," +
                        "name: \"Ball Test\"," +
                        "price: 100," +
                        "quantity: 1" +
                        "}"))
                //.andExpect(jsonPath("$", is("")))
                .andReturn();
    }

    @Test
    public void getAllItems_Basic() throws Exception {

        when(itemService.getData()).thenReturn(Arrays.asList
                (new Item(1L, "BallTest", 100, 1)
                    , new Item(2L, "BatTest", 1500, 2)));

        MvcResult mvcResult = mockMvc.perform(
                get("/items")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{id: 1 ,name: BallTest, price: 100, quantity: 1 }," +
                        "{id: 2 ,name: BatTest, price: 1500, quantity: 2 }" +
                        "]"))
                .andReturn();
    }
}