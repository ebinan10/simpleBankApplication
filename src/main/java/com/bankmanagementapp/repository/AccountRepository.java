package com.bankmanagementapp.repository;

import com.bankmanagementapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select u from Account u where u.account_holder_name = ?1")
    Account findByName(String accountName);

}
