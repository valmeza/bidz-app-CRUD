package com.bidzapp.controller;

import com.bidzapp.model.Item;
import com.bidzapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ItemController {

    @Autowired
    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Item getItem(Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/items")
    public Item saveItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/update")
    public Item updateItem(@RequestBody Item item) {
        return itemService.update(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(Long id) {
        itemService.delete(id);
    }
}
