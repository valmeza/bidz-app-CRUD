package com.bidzapp.service;

import com.bidzapp.model.Item;
import com.bidzapp.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    ItemService itemService;
    ItemRepository itemRepository;
    List<Item> itemList;
    Item item;
    java.util.Date utilDate;

    @BeforeEach
    public void setup(){
        utilDate = new java.util.Date();
        itemRepository = Mockito.mock(ItemRepository.class);
        itemService = new ItemService(itemRepository);
//        item = new Item(null, "name", "des", "owner");
        item = new Item(null, "name", "des", "owner", null, null, new Date(utilDate.getTime()), new Date(utilDate.getTime()), null, null, null);
        itemList = Arrays.asList(item);
    }

    @Test
    public void getAllItems_callsRepository(){
        itemService.getAllItems();
        Mockito.verify(itemRepository).findAll();
    }

    @Test
    public void getItemById_callsRepository() {
        itemService.getItemById(1L);
        Mockito.verify(itemRepository).getOne(1L);
    }

    @Test
    public void save_callsRepository() {
        itemService.save(item);
        Mockito.verify(itemRepository).save(item);
    }

    @Test
    public void save_returnsSavedItem() {
        Item newItem = new Item(1L, "name", "des", "owner", null, null, new Date(utilDate.getTime()), new Date(utilDate.getTime()), null, null, null);

        Mockito.when(itemService.save(item)).thenReturn(newItem);

        assertEquals(newItem, itemService.save(item));
    }

    @Test
    public void update_callsRepository(){
        item.setId(1L);
        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        itemService.update(item);
        Mockito.verify(itemRepository).save(item);
    }

    @Test
    public void delete_callsRepository() {
        item.setId(1L);
        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.empty());
        itemService.delete(1L);
        Mockito.verify(itemRepository).deleteById(1L);
    }
}