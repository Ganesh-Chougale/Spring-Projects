package com.verligence.PLISM.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.verligence.PLISM.Entity.Item;
import com.verligence.PLISM.Entity.Category;
import com.verligence.PLISM.Repository.ItemRepository;
import com.verligence.PLISM.Repository.CategoryRepository;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // post : create
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        if (item.getCategory() == null || !categoryRepository.existsById(item.getCategory().getCategoryId())) {
            throw new IllegalArgumentException("Invalid Category ID");
        }

        Category category = categoryRepository.findById(item.getCategory().getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        item.setCategory(category);
        return itemRepository.save(item);
    }

    // get : read
    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new RuntimeException("Item not found for id: " + id);
        }
    }

    // put : update
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        // chech whether item available
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found for id: " + id));

        // update based on item
        existingItem.setItemName(item.getItemName());
        existingItem.setQuantity(item.getQuantity());
        existingItem.setStatus(item.getStatus());

        // update based on category
        if (item.getCategory() != null && categoryRepository.existsById(item.getCategory().getCategoryId())) {
            Category category = categoryRepository.findById(item.getCategory().getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            existingItem.setCategory(category);
        }

        // save final change
        return itemRepository.save(existingItem);

    }

    // Delete : delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found for id: " + id);
        }

        itemRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item with id: " + id + " has been deleted");
    }

}
