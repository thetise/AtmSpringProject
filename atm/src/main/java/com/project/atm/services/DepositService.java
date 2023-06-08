package com.project.atm.services;

import com.project.atm.entities.Deposit;
import com.project.atm.entities.User;
import com.project.atm.repos.IDepositRepository;
import com.project.atm.requests.DepositCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositService {

    private IDepositRepository iDepositRepository;
    private UserService userService;

    public DepositService(IDepositRepository iDepositRepository, UserService userService) {
        this.iDepositRepository = iDepositRepository;
        this.userService = userService;
    }

    public List<Deposit> getAllDeposits() {
        return iDepositRepository.findAll();
    }

    public Deposit saveOneDeposit(DepositCreateRequest newDepositRequest) {
        User user = userService.getOneUser(newDepositRequest.getUserId());

        if(user == null)
            return null;
        Deposit toSave = new Deposit();
        toSave.setId(newDepositRequest.getId());

        user.setMoney(user.getMoney() + newDepositRequest.getAmount());

        toSave.setUser(user);
        toSave.setAmount(newDepositRequest.getAmount());
        return iDepositRepository.save(toSave);
    }

    public Deposit getOneDeposit(Long depositId) {
        return iDepositRepository.findById(depositId).orElse(null);
    }
}
