package com.example.dm.demo_2.service;

import com.example.dm.demo_2.model.Bid;
import com.example.dm.demo_2.model.ResObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BidService {
    List<Bid> getAllBids();
    ResponseEntity<ResObject> getBid(int Bid_id);
    ResponseEntity<ResObject> addBid(Bid Bid);
    ResponseEntity<ResObject> updateBid(int Bid_id,Bid Bid);

}
