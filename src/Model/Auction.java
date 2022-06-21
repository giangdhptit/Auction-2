/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author bakhoat
 */
@Entity
@Table(name = "Auction")
public class Auction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAuction")
    private int id;
    @Column(name = "initPrice")
    private int initPrice;
    @Column(name = "curentPrice")
    private int curentPrice;
    @Column(name = "timeStart")
    private int timeStart;
    @Column(name = "timeEnd")
    private int timeEnd;
    
    
    
    @OneToOne
    @JoinColumn(name = "idItem",nullable = false)
    private Item item;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auctionBids")
    private List<Bids> listBid;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auctionUser")
    private List<UserInRoom> listUserInRoom;
    @ManyToOne
    @JoinColumn(name = "idUser",nullable = false)
    private User userCreatAuction;

    public Auction() {
    }

    public Auction(int id, int initPrice, int curentPrice, int timeStart, int timeEnd, List<Bids> listBid, List<UserInRoom> listUserInRoom, User userCreatAuction) {
        this.id = id;
        this.initPrice = initPrice;
        this.curentPrice = curentPrice;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.listBid = listBid;
        this.listUserInRoom = listUserInRoom;
        this.userCreatAuction = userCreatAuction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitPrice() {
        return initPrice;
    }

    public void setInitPrice(int initPrice) {
        this.initPrice = initPrice;
    }

    public int getCurentPrice() {
        return curentPrice;
    }

    public void setCurentPrice(int curentPrice) {
        this.curentPrice = curentPrice;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public List<Bids> getListBid() {
        return listBid;
    }

    public void setListBid(List<Bids> listBid) {
        this.listBid = listBid;
    }

    public List<UserInRoom> getListUserInRoom() {
        return listUserInRoom;
    }

    public void setListUserInRoom(List<UserInRoom> listUserInRoom) {
        this.listUserInRoom = listUserInRoom;
    }

    public User getUserCreatAuction() {
        return userCreatAuction;
    }

    public void setUserCreatAuction(User userCreatAuction) {
        this.userCreatAuction = userCreatAuction;
    }

   

   
    
}