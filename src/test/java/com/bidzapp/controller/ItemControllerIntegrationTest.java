package com.bidzapp.controller;


import com.bidzapp.model.Item;
import com.bidzapp.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(ItemController.class)
public class ItemControllerIntegrationTest {

    // Main entry point for spring mvc test support
    MockMvc mockMvc;

    // Model
    Item item;

    // Annotation that can be used to provide Mockito spies to a spring application context
    @SpyBean
    ItemController itemController;

    // Annotation that can be used to add mocks to a spring application context
    @MockBean
    ItemService itemService;

    // Annotation that allows shorthand argument captor creation on fields
    @Captor
    private ArgumentCaptor<Item> itemCaptor;

    LocalDate now;
    Date date;

    @BeforeEach
    public void setUp() {
        // Allows shorthand creation of objects required for testing
        MockitoAnnotations.openMocks(this);

        // build a mockMvc instance by registering one or more @Controller instances
        // and configuring mvc infrastructure programmatically
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();

        // initialize testItem
        now = LocalDate.now();
        date = Date.valueOf(now);
        item = new Item(
                null, "SomeName", "This is a description",
                "FirstOwner", "Joe",
                "A photo", date, date,
                1.00, 2.00, 0.00
        );
    }

    @Test
    public void getAllItems_Returns200Status() throws Exception {
        // Perform a request and return a type that allows chaining certain actions
        // such as asserting expectations on the result
        mockMvc.perform(get("/api/v1/items")).andExpect(status().isOk());
    }

    @Test
    public void getAllItems_CallsItemService() throws Exception {
        mockMvc.perform(get("/api/v1/items")).andExpect(status().isOk());
        Mockito.verify(itemService).getAllItems();
    }

    @Test
    public void getItem_Returns200StatusAndCallsItemService() throws Exception {
        mockMvc.perform(get("/api/v1/items/1")).andExpect(status().isOk());
        Mockito.verify(itemService).getItemById(1L);
    }

    @Test
    public void saveItem_Returns201Status() throws Exception {
        String testBody = new ObjectMapper().writeValueAsString(item);
        mockMvc.perform(post("/api/v1/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(testBody)
        ).andExpect(status().isCreated());
        // we want to save the item that is passed in from the request body (saveItem parameter)
        // and capture it
        Mockito.verify(itemService).save(itemCaptor.capture());
//        System.out.println(itemCaptor.getValue());
        assertEquals(item.getId(), itemCaptor.getValue().getId());
    }

    @Test
    public void updateItem_Returns200Status() throws Exception {
        item.setId(1L);
        String testBody = new ObjectMapper().writeValueAsString(item);
        mockMvc.perform(put("/api/v1/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(testBody)
        ).andExpect(status().isOk());
        Mockito.verify(itemService).update(itemCaptor.capture());
        assertEquals(item.getId(), itemCaptor.getValue().getId());
    }

    @Test
    public void deleteItem_Returns204Status() throws Exception {
        mockMvc.perform(delete("/api/v1/items/1")).andExpect(status().isNoContent());
        Mockito.verify(itemService).delete(1L);
    }
}
