package com.medium.redis.services.impl;

import com.medium.redis.models.Account;
import com.medium.redis.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final AccountRepository accountRepository;


    @Override
    public void run(ApplicationArguments args) throws SQLException {
        for (int i = 0; i < 2000000; i++) {
            Account account = new Account();
            account.setId(i);
            account.setAccountName("redisCache" + i);
            account.setPhone("555555555");
            account.setEmail("oguz@xxxmail.com");
            accountRepository.save(account);
        }
    }
}
