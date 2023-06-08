package com.project.atm.requests;

import lombok.Data;

@Data
public class DepositCreateRequest {

    Long id;
    Long userId;
    Long amount;
}
