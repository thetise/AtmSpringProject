package com.project.atm.requests;

import lombok.Data;

@Data
public class TransferCreateRequest {

    Long id;
    Long senderId;
    Long receiverId;
    Long amount;
}
