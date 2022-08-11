package com.example.dm.demo_2.service;

import com.example.dm.demo_2.model.Item;
import com.example.dm.demo_2.model.ResObject;
import com.example.dm.demo_2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }

    @Override
    public ResponseEntity<ResObject> getItem(int item_id) {
            Optional<Item> foundItem = itemRepository.findById(item_id);
            if (foundItem.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResObject("ok","succeeded",foundItem)
                );
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResObject("false","Cannot find "+item_id,"")
                );
            }
        }

    @Override
    public ResponseEntity<ResObject> addItem(Item item) {
        List<Item> foundItem = itemRepository.findByName(item.getName().trim());
        if (foundItem.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResObject("false","Item already existed","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResObject("ok","succeeded",itemRepository.save(item))
        );
    }


    @Override
    public ResponseEntity<ResObject> updateItem(int item_id,Item item) {
        Optional<Item> foundItem = itemRepository.findById(item_id);
        if (foundItem!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResObject("ok","succeeded",itemRepository.save(item))
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResObject("false","Cannot find "+item_id,"")
            );
        }
    }

    @Override
    public ResponseEntity<ResObject> deleteItem(int item_id) {
        Item foundItem = itemRepository.findById(item_id).map(item -> {
            item.setDeleted(1);
            return item;
        }).orElseGet(()->{
            return null;
        });
        if (foundItem!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResObject("ok","succeeded",itemRepository.save(foundItem))
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResObject("false","Cannot find "+item_id,"")
            );
        }
    }
}
