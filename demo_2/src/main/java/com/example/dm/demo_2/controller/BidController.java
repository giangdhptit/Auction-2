package com.example.dm.demo_2.controller;

import com.example.dm.demo_2.model.Bid;
import com.example.dm.demo_2.model.ResObject;
import com.example.dm.demo_2.service.BidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Bids")
public class BidController {
    @Autowired
    private BidServiceImpl BidServiceImpl;

    @GetMapping("")
    List<Bid> getAllBids(){
        return BidServiceImpl.getAllBids();
    }

    @GetMapping("/{Bid_id}")
    ResponseEntity<ResObject> getBid(int Bid_id){
        return BidServiceImpl.getBid(Bid_id);
    }

    @PostMapping("/add")
    ResponseEntity<ResObject> addBid(Bid newBid){
        return BidServiceImpl.addBid(newBid);
    }

    @PutMapping("/{Bid_id}/update")
    ResponseEntity<ResObject> updateBid(@RequestParam int Bid_id, @RequestBody Bid Bid){
        return BidServiceImpl.updateBid(Bid_id,Bid);
    }

}
