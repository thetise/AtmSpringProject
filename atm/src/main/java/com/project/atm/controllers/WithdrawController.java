package com.project.atm.controllers;

import com.project.atm.entities.Withdraw;
import com.project.atm.requests.WithdrawCreateRequest;
import com.project.atm.services.WithdrawService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/withdraws")
public class WithdrawController {

    private WithdrawService withdrawService;

    public WithdrawController(WithdrawService withdrawService) {
        this.withdrawService = withdrawService;
    }

    @GetMapping
    public List<Withdraw> getAllWithdraws(){
        return withdrawService.getAllWithdraws();
    }

    @PostMapping
    public Withdraw createWithdraw(@RequestBody WithdrawCreateRequest newWithdrawRequest){
        return withdrawService.saveOneWithdraw(newWithdrawRequest);
    }

    @GetMapping("/{withdrawId}")
    public Withdraw getOneWithdraw(@PathVariable Long withdrawId){
        return withdrawService.getOneWithdraw(withdrawId);
    }
}
