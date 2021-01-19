package com.bidzapp.controller;

import com.bidzapp.model.Item;
import com.bidzapp.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    // item
    Item item;
    Long itemId;
    ItemService itemService;
    ItemController itemController;
    List<Item> itemList;

    @BeforeEach
    public void setup(){
        itemService = Mockito.mock(ItemService.class);
        itemController = new ItemController(itemService);
        itemId = 1L;
        item = new Item(itemId, null, null, null);
        itemList = Arrays.asList(item);
    }

    @Test
    public void getAllItems_shouldReturnEmptyList() {
        // assert
        assertEquals(Collections.emptyList(), itemController.getItems());
    }

    @Test
    public void getAllItems_callsItemService() {
        Mockito.when(itemService.getAllItems()).thenReturn(itemList);

        assertEquals(itemList, itemController.getItems());
    }

    @Test
    public void getItemById_shouldReturnItem(){
        Mockito.when(itemService.getItemById(itemId)).thenReturn(item);

        assertEquals(item, itemController.getItem(itemId));
    }

    @Test
    public void saveItem_shouldReturnSavedItem() {
        Mockito.when(itemService.save(item)).thenReturn(item);

        assertEquals(item, itemController.saveItem(item));
    }

    @Test
    public void updateItem_shouldReturnUpdatedItem() {
        Mockito.when(itemService.update(item)).thenReturn(item);

        assertEquals(item, itemController.updateItem(item));
    }

    @Test
    public void deleteItem_callsItemServiceDelete() {
        itemController.deleteItem(itemId);
        Mockito.verify(itemService).delete(itemId);
    }
}