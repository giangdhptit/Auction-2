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
@Table(name = "UserInRoom")
public class UserInRoom implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUserInRoom")
    private int id;
    @Column(name = "timeJoin")
    private int timeJoin;
    @Column(name = "timeLeave")
    private int timeLeave; 
    @ManyToOne
    @JoinColumn(name = "idAuction",nullable = false)
    private Auction auctionUser;
    @ManyToOne
    @JoinColumn(name = "idUser",nullable = false)
    private User userAuction;

    public UserInRoom() {
    }

    public UserInRoom(int id, int timeJoin, int timeLeave, Auction auctionUser, User userAuction) {
        this.id = id;
        this.timeJoin = timeJoin;
        this.timeLeave = timeLeave;
        this.auctionUser = auctionUser;
        this.userAuction = userAuction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeJoin() {
        return timeJoin;
    }

    public void setTimeJoin(int timeJoin) {
        this.timeJoin = timeJoin;
    }

    public int getTimeLeave() {
        return timeLeave;
    }

    public void setTimeLeave(int timeLeave) {
        this.timeLeave = timeLeave;
    }

    public Auction getAuctionUser() {
        return auctionUser;
    }

    public void setAuctionUser(Auction auctionUser) {
        this.auctionUser = auctionUser;
    }

    public User getUserAuction() {
        return userAuction;
    }

    public void setUserAuction(User userAuction) {
        this.userAuction = userAuction;
    }

   

  

   
    
    
}