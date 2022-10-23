package com.medium.redis.util;

import com.medium.redis.models.Account;
import com.medium.redis.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class AccountCacheService {

    private final RedisUtil<Account> redisUtil;
    private final AccountRepository accountRepository;

    @Cacheable(cacheNames = "accountByName", key = "#key", unless = "#key == null")
    public List<Account> getAccountFromCache(String key) {
        return accountRepository.findAccountByAccountNameLike(key);
    }

    public void cacheAccount(String key, Account account) {
        redisUtil.putValue(key, account);
    }

    public Account getAccount(String key) {
        return redisUtil.getValue(key);
    }

    public List<Account> getListAccount(String key) {
        return redisUtil.getList(key);
    }

    public void cacheWithExpire(String key, Account account) {
        redisUtil.putValue(key, account);
        redisUtil.setExpire(key, 30, TimeUnit.MINUTES);
    }


}
