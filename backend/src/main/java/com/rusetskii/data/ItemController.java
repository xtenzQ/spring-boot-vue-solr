package com.rusetskii.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable Long itemId) {
        Optional<Item> result = itemRepository.findById(itemId);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
        }
    }

    @PostMapping("")
    public Item createItem(@RequestBody Item item) {
        // Set the date created and updated to the current time
        item.setDateCreated(new Date());
        item.setDateUpdated(new Date());
        return itemRepository.save(item);
    }

    @PutMapping("/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody Item item) {
        Optional<Item> result = itemRepository.findById(itemId);
        if (result.isPresent()) {
            Item existingItem = result.get();
            existingItem.setTitle(item.getTitle());
            existingItem.setDescription(item.getDescription());
            existingItem.setDateUpdated(new Date());
            return itemRepository.save(existingItem);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
        }
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
