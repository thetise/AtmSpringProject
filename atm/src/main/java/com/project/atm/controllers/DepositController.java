package com.project.atm.controllers;

import com.project.atm.entities.Deposit;
import com.project.atm.requests.DepositCreateRequest;
import com.project.atm.services.DepositService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposits")
public class DepositController {

    private DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @GetMapping
    public List<Deposit> getAllDeposits(){
        return depositService.getAllDeposits();
    }

    @PostMapping
    public Deposit createDeposit(@RequestBody DepositCreateRequest newDepositRequest){
        return depositService.saveOneDeposit(newDepositRequest);
    }

    @GetMapping("/{depositId}")
    public Deposit getOneDeposit(@PathVariable Long depositId){
        return depositService.getOneDeposit(depositId);
    }
}
