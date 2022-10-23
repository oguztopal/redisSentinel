package com.medium.redis.repository;

import com.medium.redis.models.Account;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {

    @Query(value = "select a from Account a where a.accountName like %:accountName% ")
    List<Account> findAccountByAccountNameLike(@Param("accountName") String accountName);
}
