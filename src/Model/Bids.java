/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author bakhoat
 */
@Entity
@Table(name = "Bids")
public class Bids implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBid")
    private int id;
    @Column(name = "increase")
    private int increase;
    @Column(name = "time")
    private int time;
    
    
    @ManyToOne
    @JoinColumn(name = "idAuction",nullable = false)
    private Auction auctionBids;
    @ManyToOne
    @JoinColumn(name = "idUser",nullable = false)
    private User userBids;

    public Bids() {
    }

    public Bids(int id, int increase, int time, Auction auctionBids, User userBids) {
        this.id = id;
        this.increase = increase;
        this.time = time;
        this.auctionBids = auctionBids;
        this.userBids = userBids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIncrease() {
        return increase;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Auction getAuctionBids() {
        return auctionBids;
    }

    public void setAuctionBids(Auction auctionBids) {
        this.auctionBids = auctionBids;
    }

    public User getUserBids() {
        return userBids;
    }

    public void setUserBids(User userBids) {
        this.userBids = userBids;
    }

    
    
    
 }