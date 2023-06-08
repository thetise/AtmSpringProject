package com.project.atm.services;

import com.project.atm.entities.User;
import com.project.atm.entities.Withdraw;
import com.project.atm.repos.IWithdrawRepository;
import com.project.atm.requests.WithdrawCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawService {

    private IWithdrawRepository iWithdrawRepository;
    private UserService userService;

    public WithdrawService(IWithdrawRepository iWithdrawRepository, UserService userService) {
        this.iWithdrawRepository = iWithdrawRepository;
        this.userService = userService;
    }

    public List<Withdraw> getAllWithdraws() {
        return iWithdrawRepository.findAll();
    }

    public Withdraw saveOneWithdraw(WithdrawCreateRequest newWithdrawRequest) {
        User user = userService.getOneUser(newWithdrawRequest.getUserId());

        if(user == null)
            return null;

        if(user.getMoney() < newWithdrawRequest.getAmount()){
            return null;
        }

        Withdraw toSave = new Withdraw();
        toSave.setId(newWithdrawRequest.getId());
        user.setMoney(user.getMoney() - newWithdrawRequest.getAmount());
        toSave.setUser(user);
        toSave.setAmount(newWithdrawRequest.getAmount());
        return iWithdrawRepository.save(toSave);
    }

    public Withdraw getOneWithdraw(Long withdrawId) {
        return iWithdrawRepository.findById(withdrawId).orElse(null);
    }
}
