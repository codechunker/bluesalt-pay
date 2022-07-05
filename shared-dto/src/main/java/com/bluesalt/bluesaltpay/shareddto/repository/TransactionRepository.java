package com.bluesalt.bluesaltpay.shareddto.repository;


import com.bluesalt.bluesaltpay.shareddto.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByTranReference(String reference);

}
