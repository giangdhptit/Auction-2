package com.example.dm.demo_2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Bid")
@Table(name = "bids")
public class Bid implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "bid_price")
    private int bid_price;

    @Column(name = "create_at")
    private String create_at;

    public Auction getAuctionBid() {
        return auctionBid;
    }

    public void setAuctionBid(Auction auctionBid) {
        this.auctionBid = auctionBid;
    }

    public User getUserBid() {
        return userBid;
    }

    public void setUserBid(User userBid) {
        this.userBid = userBid;
    }

    @Column(name = "modify_at")
    private String modify_at;

    @ManyToOne
    @JoinColumn(name = "auction_id", insertable = false, updatable = false)
    private Auction auction;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Bid() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid_price() {
        return bid_price;
    }

    public void setBid_price(int bid_price) {
        this.bid_price = bid_price;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getModify_at() {
        return modify_at;
    }

    public void setModify_at(String modify_at) {
        this.modify_at = modify_at;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "auction_id", nullable = false)
    private Auction auctionBid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userBid;

    public Bid(int id, int bid_price, String create_at, String modify_at, Auction auction, User user) {
        this.id = id;
        this.bid_price = bid_price;
        this.create_at = create_at;
        this.modify_at = modify_at;
        this.auction = auction;
        this.user = user;
    }
}