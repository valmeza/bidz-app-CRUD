package com.bidzapp.service;

import com.bidzapp.model.Item;
import com.bidzapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() { return itemRepository.findAll(); }

    public Item getItemById(long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item update(Item item) {
        return itemRepository.save(item);
    }

    public void delete(long id) {
        Item item = itemRepository.findById(id).orElse(null);
        if(item != null) {
            itemRepository.delete(item);
        }
    }
}
