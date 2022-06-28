package com.example.dm.demo_2.repository;

import com.example.dm.demo_2.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByName(String name);

}
