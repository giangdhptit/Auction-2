package com.example.dm.demo_2.service;

import com.example.dm.demo_2.model.Item;
import com.example.dm.demo_2.model.ResObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    ResponseEntity<ResObject> getItem(int item_id);
    ResponseEntity<ResObject> addItem(Item item);
    ResponseEntity<ResObject> updateItem(int item_id,Item item);
    ResponseEntity<ResObject> deleteItem(int item_id);
}
