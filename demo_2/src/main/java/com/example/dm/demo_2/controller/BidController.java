package com.example.dm.demo_2.controller;

import com.example.dm.demo_2.model.Auction;
import com.example.dm.demo_2.model.ResObject;
import com.example.dm.demo_2.repository.AuctionRepository;
import com.example.dm.demo_2.service.AuctionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Auctions")
public class AuctionController {
    @Autowired
    private AuctionServiceImpl AuctionServiceImpl;

    @GetMapping("")
    List<Auction> getAllAuctions(){
        return AuctionServiceImpl.getAllAuctions();
    }

    @GetMapping("/{Auction_id}")
    ResponseEntity<ResObject> getAuction(int Auction_id){
        return AuctionServiceImpl.getAuction(Auction_id);
    }

    @PostMapping("/add")
    ResponseEntity<ResObject> addAuction(Auction newAuction){
        return AuctionServiceImpl.addAuction(newAuction);
    }

    @PutMapping("/{Auction_id}/update")
    ResponseEntity<ResObject> updateAuction(@RequestParam int Auction_id, @RequestBody Auction Auction){
        return AuctionServiceImpl.updateAuction(Auction_id,Auction);
    }

    @DeleteMapping("/{Auction_id}/delete")
    ResponseEntity<ResObject> deleteAuction(int Auction_id){
        return  AuctionServiceImpl.deleteAuction(Auction_id);
    }
}
