package com.medium.redis.services.impl;

import com.medium.redis.dto.AccountListResponse;
import com.medium.redis.models.Account;
import com.medium.redis.services.AccountService;
import com.medium.redis.util.AccountCacheService;
import com.medium.redis.util.ExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountCacheService cacheService;

    @Override
    public AccountListResponse getAccountList() {
        AccountListResponse response = new AccountListResponse();
        ExecutionTime withRedis = new ExecutionTime(true);
        List<Account> fromCache = cacheService.getAccountFromCache("redisCache10");
        withRedis.endTime();
        response.setExecutionTime(ExecutionTime.formatElapsedTime(withRedis.duration()));
        response.setAccountList(fromCache);
        return response;
    }


}
