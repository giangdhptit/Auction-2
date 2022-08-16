package com.example.dm.demo_2.request;

import com.example.dm.demo_2.model.Auction;
import com.example.dm.demo_2.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidRequest {
    Auction auction;
    User user;
    int bid_price;
}
