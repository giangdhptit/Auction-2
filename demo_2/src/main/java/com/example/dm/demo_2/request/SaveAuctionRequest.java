package com.example.dm.demo_2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveAuctionRequest {
    private int initPrice;
    private int currentPrice;
    private String timeStart;
    private String timeEnd;
    private int user_id;
    private int item_id;
}
