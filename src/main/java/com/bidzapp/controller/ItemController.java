package com.bidzapp.controller;

import com.bidzapp.model.Item;
import com.bidzapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ItemController {

    @Autowired
    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<Item> getItems() {
        return itemService.getAllItems();
    }

    public Item getItem(Long id) {
        return itemService.getItemById(id);
    }

    public Item saveItem(Item item) {
        return itemService.save(item);
    }

    public Item updateItem(Item item) {
        return itemService.update(item);
    }

    public void deleteItem(Long id) {
        itemService.delete(id);
    }
}
