package com.example.dm.demo_2.service;

import com.example.dm.demo_2.model.Bid;
import com.example.dm.demo_2.model.ResObject;
import com.example.dm.demo_2.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidService{

    @Autowired
    BidRepository BidRepository;

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
    public ResponseEntity<ResObject> addBid(Bid Bid) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResObject("ok","succeeded",BidRepository.save(Bid))
        );
    }


    @Override
    public ResponseEntity<ResObject> updateBid(int Bid_id,Bid Bid) {
        Optional<Bid> foundBid = BidRepository.findById(Bid_id);
        if (foundBid!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResObject("ok","succeeded",BidRepository.save(Bid))
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResObject("false","Cannot find "+Bid_id,"")
            );
        }
    }


}
