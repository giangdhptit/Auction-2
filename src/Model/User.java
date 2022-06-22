package Model;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;
    @Column(name = "role")
    private String role;
    @Column(name = "money")
    private int money;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userBids")
    private List<Bids> listBidUser;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userAuction")
    private List<UserInRoom> listUserInRoom;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userCreatAuction")
    private List<Auction> listAuctionCreated;

    public User() {
    }

//    public Object[] toObject(){
//        return new Object[]{
//            this.id,this.name,this.status
//        };
//    }

    public User(int id, String username, String password, String address, String name, String email, int age, String role, int money, List<Bids> listBidUser, List<UserInRoom> listUserInRoom, List<Auction> listAuctionCreated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.name = name;
        this.email = email;
        this.age = age;
        this.role = role;
        this.money = money;
        this.listBidUser = listBidUser;
        this.listUserInRoom = listUserInRoom;
        this.listAuctionCreated = listAuctionCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Bids> getListBidUser() {
        return listBidUser;
    }

    public void setListBidUser(List<Bids> listBidUser) {
        this.listBidUser = listBidUser;
    }

    public List<UserInRoom> getListUserInRoom() {
        return listUserInRoom;
    }

    public void setListUserInRoom(List<UserInRoom> listUserInRoom) {
        this.listUserInRoom = listUserInRoom;
    }

    public List<Auction> getListAuctionCreated() {
        return listAuctionCreated;
    }

    public void setListAuctionCreated(List<Auction> listAuctionCreated) {
        this.listAuctionCreated = listAuctionCreated;
    }

  
   
}
