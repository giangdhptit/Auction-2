package com.example.dm.demo_2.controller;

import com.example.dm.demo_2.model.Item;
import com.example.dm.demo_2.model.ResObject;
import com.example.dm.demo_2.repository.ItemRepository;
import com.example.dm.demo_2.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/items")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @GetMapping("")
    List<Item> getAllItems(){
        return itemServiceImpl.getAllItems();
    }

    @GetMapping("/{item_id}")
    ResponseEntity<ResObject> getItem(int item_id){
        return itemServiceImpl.getItem(item_id);
    }

    @PostMapping("/add")
    ResponseEntity<ResObject> addItem(Item newItem){
        return itemServiceImpl.addItem(newItem);
    }

    @PutMapping("/{item_id}/update")
    ResponseEntity<ResObject> updateItem(@RequestParam int item_id, @RequestBody Item item){
        return itemServiceImpl.updateItem(item_id,item);
    }

    @DeleteMapping("/{item_id}/delete")
    ResponseEntity<ResObject> deleteItem(int item_id){
        return  itemServiceImpl.deleteItem(item_id);
    }
}
