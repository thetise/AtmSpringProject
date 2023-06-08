package com.project.atm.requests;

import lombok.Data;

@Data
public class WithdrawCreateRequest {

    Long id;
    Long userId;
    Long amount;


}
