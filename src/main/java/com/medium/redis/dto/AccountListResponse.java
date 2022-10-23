package com.medium.redis.dto;

import com.medium.redis.models.Account;
import lombok.Data;

import java.util.List;

@Data
public class AccountListResponse {

    private List<Account> accountList;
    private String executionTime;
}
