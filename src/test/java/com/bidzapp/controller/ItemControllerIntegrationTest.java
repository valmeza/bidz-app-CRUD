package com.bidzapp.controller;


import com.bidzapp.model.Item;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ItemController.class)
public class ItemControllerIntegrationTest {

    MockMvc mockMvc;
    Item item;

    @SpyBean
    ItemController itemController;

}
