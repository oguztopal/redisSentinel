package com.medium.redis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

    @Id
    private Integer id;
    private String accountName;
    private String email;
    private String phone;
}
