package com.yst.business.cache;

import com.yst.business.redis.client.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by wangpeng on 2016/9/30.
 */
@Component
public class RedisCacheManager {

    @Autowired
    private JedisClient jedisClient;

    public void put(Object key,Object value){
        jedisClient.add(key,value);
    }

    public void put(Object key,Object value,Long expireTime){
        jedisClient.add(key,expireTime,value);
    }

    public Object get(Object key){
        if(isExist(key)){
            return jedisClient.get(key);
        }
        return null;
    }

    public String getString(Object key){
        Object value = get(key);
        return value != null ? (String)value : null;
    }

    public Integer getInt(Object key){
        Object value = get(key);
        return value != null ? (Integer)value  : null;
    }

    public Long getLong(Object key){
        Object value = get(key);
        return value != null ? Long.parseLong(String.valueOf(value)) : null;
    }

    public Long getExpire(Object key){
        return jedisClient.getExpire(key)*1000;
    }

    public boolean isExist(Object key){
        if(jedisClient.hasKey(key)){
            return true;
        }
        return false;
    }

    public void delete(Object key){
        jedisClient.del(key);
    }


    public boolean lock(Object key,Long expireTime){
        return jedisClient.lock(key,expireTime);
    }

    public void unlock(Object key){
        jedisClient.unlock(key);
    }
}
