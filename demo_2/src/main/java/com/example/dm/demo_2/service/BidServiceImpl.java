package com.example.dm.demo_2.service;

import com.example.dm.demo_2.model.Auction;
import com.example.dm.demo_2.model.ResObject;
import com.example.dm.demo_2.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService{

    @Autowired
    AuctionRepository AuctionRepository;

    @Override
    public List<Auction> getAllAuctions() {
        List<Auction> AuctionList = AuctionRepository.findAll();
        return AuctionList;
    }

    @Override
    public ResponseEntity<ResObject> getAuction(int Auction_id) {
        Optional<Auction> foundAuction = AuctionRepository.findById(Auction_id);
        if (foundAuction.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResObject("ok","succeeded",foundAuction)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResObject("false","Cannot find "+Auction_id,"")
            );
        }
    }

    @Override
    public ResponseEntity<ResObject> addAuction(Auction Auction) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResObject("ok","succeeded",AuctionRepository.save(Auction))
        );
    }


    @Override
    public ResponseEntity<ResObject> updateAuction(int Auction_id,Auction Auction) {
        Optional<Auction> foundAuction = AuctionRepository.findById(Auction_id);
        if (foundAuction!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResObject("ok","succeeded",AuctionRepository.save(Auction))
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResObject("false","Cannot find "+Auction_id,"")
            );
        }
    }

    @Override
    public ResponseEntity<ResObject> deleteAuction(int Auction_id) {
        Auction foundAuction = AuctionRepository.findById(Auction_id).map(Auction -> {
            Auction.setDeleted(true);
            return Auction;
        }).orElseGet(()->{
            return null;
        });
        if (foundAuction!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResObject("ok","succeeded",AuctionRepository.save(foundAuction))
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResObject("false","Cannot find "+Auction_id,"")
            );
        }
    }
}
