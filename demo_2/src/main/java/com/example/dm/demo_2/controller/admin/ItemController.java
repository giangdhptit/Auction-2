package com.example.dm.demo_2.controller.admin;

import com.example.dm.demo_2.model.Item;
import com.example.dm.demo_2.model.ResponseObject;
import com.example.dm.demo_2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/admin/items")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @GetMapping("")
    List<Item> getAllItems(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id){
        Optional<Item> foundItem = repository.findById(id);
        if (foundItem.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","succeeded",foundItem)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","Cannot find "+id,"")
            );
        }
    }

    @PostMapping("/add")
    ResponseEntity<ResponseObject> addItem(@RequestBody Item newItem){
        List<Item> foundItem = repository.findByName(newItem.getName().trim());
        if (foundItem.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","Item already existed","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","succeeded",repository.save(newItem))
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateItem(@RequestBody Item newItem,@PathVariable int id){
        //Optional<Item> foundItem = repository.findById(id);
        Item updatedItem = repository.findById(id).map(item -> {
            item.setName(newItem.getName());
            item.setStock(newItem.getStock());
            //item.setCreate_at(foundItem.getClass().);
            item.setModify_at(LocalDateTime.now());
            return repository.save(item);
        }).orElseGet(()->{
            newItem.setId(id);
            return repository.save(newItem);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Updated",updatedItem)
        );
    }

    @DeleteMapping("id")
    ResponseEntity<ResponseObject> deleteItem(@PathVariable int id){
        //Optional<Item> foundItem = repository.findById(id);
        boolean ex = repository.existsById(id);
        if (ex){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Deleted","")
            );
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "Item not existed", "")
            );

    }
}
