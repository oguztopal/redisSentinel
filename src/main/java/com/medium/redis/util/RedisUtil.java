package com.medium.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil<T> {

    private final RedisTemplate<String,T> redisTemplate;
    private final ValueOperations<String,T> valueOperations;
    private final ListOperations<String, T> listOperations;

    @Autowired
    public RedisUtil(RedisTemplate<String,T> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
        this.listOperations = redisTemplate.opsForList();
    }


    public void putValue(String key, T value) {
        valueOperations.set(key,value);
    }

    public void putValueWithExpire(String key, T value) {
        valueOperations.set(key,value);
    }

    public T getValue(String key){
        return valueOperations.get(key);
    }

    public void setExpire(String key, long timeout, TimeUnit timeUnit){
        redisTemplate.expire(key,timeout,timeUnit);
    }

    public void removeValue(String key){
        redisTemplate.delete(Objects.requireNonNull(redisTemplate.keys(key)));
    }

    public List<T> getList(String key) {
        return listOperations.range(key, 0, -1);
    }

    public void addList(String key, T value) {
        listOperations.leftPush(key, value);
    }

}
