package com.example.dm.demo_2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Item")
@Table(name = "items")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_at")
    private String create_at;

    @Column(name = "modify_at")
    private String modify_at;

    @Column(name = "stock")
    private int stock;

    @Column(name = "deleted")
    private int deleted;


    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getModify_at() {
        return modify_at;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public void setModify_at(String modify_at) {
        this.modify_at = modify_at;
    }

    public Item() {
    }

    public Item(int id, String name, String create_at, String modify_at, int stock, int deleted) {
        this.id = id;
        this.name = name;
        this.create_at = create_at;
        this.modify_at = modify_at;
        this.stock = stock;
        this.deleted =deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
