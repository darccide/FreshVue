
package com.darccide.FreshVue.controllers;

import com.darccide.FreshVue.entities.Item;
import com.darccide.FreshVue.services.ItemService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/items")
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    
    private final ItemService itemService;
    
    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }
    
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(itemService.save(item));
    }
    
    @GetMapping("/{itemId}")
    public ResponseEntity<Item> findById(@PathVariable Long itemId) {
        Optional<Item> item = itemService.findById(itemId);
        if (!item.isPresent()) {
            log.error("Item ID " + itemId + " does not exist");
            ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(item.get());
    }
    
    @PutMapping("/{itemId}")
    public ResponseEntity<Item> update(@PathVariable Long itemId,
            @Valid @RequestBody Item item) {
        if (!itemService.findById(itemId).isPresent()) {
            log.error("Item ID " + itemId + " does not exist");
            ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(itemService.save(item));
    }
    
    @DeleteMapping("/{itemId}")
    public ResponseEntity delete(@PathVariable Long itemId) {
        if (!itemService.findById(itemId).isPresent()) {
            log.error("Item ID " + itemId + " does not exist");
            ResponseEntity.badRequest().build();
        }
        
        itemService.deleteById(itemId);
        
        return ResponseEntity.ok().build();
    }
}
