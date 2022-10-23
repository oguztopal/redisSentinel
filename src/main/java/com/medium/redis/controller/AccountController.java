package com.medium.redis.controller;

import com.medium.redis.dto.AccountListResponse;
import com.medium.redis.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;


    @GetMapping
    public ResponseEntity<AccountListResponse> getAccountList() {
        return new ResponseEntity<>(accountService.getAccountList(), HttpStatus.OK);
    }
}
