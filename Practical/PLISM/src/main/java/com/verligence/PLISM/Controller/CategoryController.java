package com.verligence.PLISM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.verligence.PLISM.Entity.Category;

import com.verligence.PLISM.Repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // post : create
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PostMapping("/bulk")
    public List<Category> createCategories(@RequestBody List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }

    // get : read
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found for id: " + id));
    }

    // put : update
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        // find whether category exists
        Category existinCategory = categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found for id: " + id));

        // Update fields
        existinCategory.setCategoryName(updatedCategory.getCategoryName());

        // save final changes
        return categoryRepository.save(existinCategory);
    }

    // Delete : delete
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        try {
            // Check if category exists
            if (!categoryRepository.existsById(id)) {
                throw new RuntimeException("Category not found for id: " + id);
            }

            // Check associated items count
            Long associatedItemsCount = categoryRepository.findById(id)
                    .map(category -> (long) category.getItems().size())
                    .orElse(0L);

            if (associatedItemsCount > 0) {
                throw new RuntimeException(
                        "Cannot delete category with id: " + id + " because it has associated items.");
            }

            // Perform deletion
            categoryRepository.deleteById(id);
            return "Category with id: " + id + " has been deleted.";

        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging purposes
            return "Error occurred: " + e.getMessage();
        }
    }

}
