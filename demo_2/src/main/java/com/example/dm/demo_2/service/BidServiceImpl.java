package com.example.dm.demo_2.service;

import com.example.dm.demo_2.model.Bid;
import com.example.dm.demo_2.model.ResObject;
import com.example.dm.demo_2.repository.AuctionRepository;
import com.example.dm.demo_2.repository.BidRepository;
import com.example.dm.demo_2.repository.UserRepository;
import com.example.dm.demo_2.request.BidRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidService{

    @Autowired
    BidRepository BidRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuctionRepository auctionRepository;

    @Override
    public List<Bid> getAllBids() {
        List<Bid> BidList = BidRepository.findAll();
        return BidList;
    }

    @Override
    public ResponseEntity<ResObject> getBid(int Bid_id) {
        Optional<Bid> foundBid = BidRepository.findById(Bid_id);
        if (foundBid.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResObject("ok","succeeded",foundBid)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResObject("false","Cannot find "+Bid_id,"")
            );
        }
    }

    @Override
    public ResponseEntity<ResObject> addBid(BidRequest req) {
        Bid newBid = new Bid();
        System.out.println(req);
        newBid.setAuctionBid(auctionRepository.findById(req.getAuction().getId()).orElse(null));
        newBid.setUserBid(userRepository.findById(req.getUser().getId()).orElse(null));
        newBid.setBid_price(req.getBid_price());
        newBid.setCreate_at(LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResObject("ok","succeeded",BidRepository.save(newBid))
        );
    }





}
