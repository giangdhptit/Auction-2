package com.example.dm.demo_2.service;

import com.example.dm.demo_2.model.Auction;
import com.example.dm.demo_2.model.ResObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuctionService {
    List<Auction> getAllAuctions();
    ResponseEntity<ResObject> getAuction(int Auction_id);
    ResponseEntity<ResObject> addAuction(Auction Auction);
    ResponseEntity<ResObject> updateAuction(int Auction_id,Auction Auction);
    ResponseEntity<ResObject> deleteAuction(int Auction_id);
}
