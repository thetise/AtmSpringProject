package com.project.atm.repos;

import com.project.atm.entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepositRepository extends JpaRepository<Deposit, Long> {
}
