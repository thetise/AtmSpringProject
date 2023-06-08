package com.project.atm.services;

import com.project.atm.entities.Transfer;
import com.project.atm.entities.User;
import com.project.atm.repos.ITransferRepository;
import com.project.atm.requests.TransferCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private ITransferRepository iTransferRepository;
    private UserService userService;

    public TransferService(ITransferRepository iTransferRepository, UserService userService) {
        this.iTransferRepository = iTransferRepository;
        this.userService = userService;
    }

    public List<Transfer> getAllTransfers() {
        return iTransferRepository.findAll();
    }

    public Transfer saveOneTransfer(TransferCreateRequest newTransferRequest) {
        User user = userService.getOneUser(newTransferRequest.getSenderId());
        User user1= userService.getOneUser(newTransferRequest.getReceiverId());

        if(user == null || user1 == null)
            return null;

        if(user.getMoney() < newTransferRequest.getAmount())
            return null;

        Transfer toSave = new Transfer();
        toSave.setId(newTransferRequest.getId());

        user.setMoney(user.getMoney() - newTransferRequest.getAmount());
        user1.setMoney(user1.getMoney() + newTransferRequest.getAmount());

        toSave.setUserSender(user);
        toSave.setUserReceiver(user1);
        toSave.setAmount(newTransferRequest.getAmount());
        return iTransferRepository.save(toSave);
    }

    public Transfer getOneTransfer(Long transferId) {
        return iTransferRepository.findById(transferId).orElse(null);
    }
}
