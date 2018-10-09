package com.yst.business.redis.client;

import com.yst.common.constats.GlobConts;
import com.yst.common.utils.PropertieUtils;
import com.yst.common.utils.SpringSerializer;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

/**
 * redis客户端
 * Created by wonpera on 2017/1/3.
 */
@Component
public class JedisConfigration {

    private ShardedJedisPool shardedJedisPool;

    public static final long ONE_MILLI_NANOS = 1000000L;
    //加锁标志
    public static final String LOCKED = "TRUE";
    //锁状态标志
    private boolean locked = false;

    public static final Random r = new Random();


    @PostConstruct
    public void init(){
        if(shardedJedisPool == null){
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            int maxTotal = PropertieUtils.getInt("redis.pool.maxTotal");
            int maxIdle = PropertieUtils.getInt("redis.pool.maxIdle");
            int maxWaitMillis = PropertieUtils.getInt("redis.pool.maxWaitMillis");
            boolean testOnBorrow = PropertieUtils.getBoolean("redis.pool.testOnBorrow");
            boolean testOnReturn = PropertieUtils.getBoolean("redis.pool.testOnReturn");
            boolean testWhileIdle = PropertieUtils.getBoolean("redis.pool.testWhileIdle");
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxTotal(maxTotal);
            jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
            jedisPoolConfig.setTestOnBorrow(testOnBorrow);
            jedisPoolConfig.setTestOnReturn(testOnReturn);
            jedisPoolConfig.setTestWhileIdle(testWhileIdle);
            List<JedisShardInfo> shardInfoList = Lists.newArrayList();
            String host = PropertieUtils.getString("redis.host");
            int port = PropertieUtils.getInt("redis.port");
            int timeout = PropertieUtils.getInt("redis.timeout");
            String password = PropertieUtils.getString("redis.password");
            JedisShardInfo jedisShardInfo = new JedisShardInfo(host,port,timeout);
            if(StringUtils.isNoneBlank(password)){
                jedisShardInfo.setPassword(password);
            }
            shardInfoList.add(jedisShardInfo);
            shardedJedisPool = new ShardedJedisPool(jedisPoolConfig,shardInfoList);
        }
    }



    private ShardedJedis getResource(){
        if(shardedJedisPool == null){
            init();
        }
        return shardedJedisPool.getResource();
    }


    public Long remove(Object key){
        ShardedJedis jedis = getResource();
        Long res;
        try {
            res = jedis.del(serializerBytes(key));
        } finally {
            close(jedis);
        }
        return res;
    }

    public boolean put(Object key,Object object){
        return put(key, GlobConts.MAX_EXPIRE_TIME,object);
    }

    public boolean put(Object key,long milliseconds,Object object){
        ShardedJedis jedis = getResource();
        String result;
        try {
            result = jedis.setex(serializerBytes(key), Long.valueOf(milliseconds / 1000L).intValue(), serializerBytes(object));
        } finally {
            close(jedis);
        }
        return "OK".equals(result);//redis加入成功会返回OK
    }

    public Object getObject(Object key){
        byte[] bytes;
        ShardedJedis jedis = getResource();
        try {
            bytes = jedis.get(serializerBytes(key));
            if(bytes == null){
                return null;
            }
        } finally {
            close(jedis);
        }
        return deSerializer(bytes);
    }

    public Long getObjectExpire(Object key){
        Long expire;
        ShardedJedis jedis = getResource();
        try {
            expire = jedis.ttl(serializerBytes(key));
        } finally {
            close(jedis);
        }
        return expire;
    }

    public boolean exists(Object key){
        Boolean flag;
        ShardedJedis jedis = getResource();
        try {
            flag = jedis.exists(serializerBytes(key));
        } finally {
            close(jedis);
        }
        return flag;
    }

    private byte[] serializerBytes(Object key){
        return SpringSerializer.serialize(key);
    }

    private Object deSerializer(byte[] bytes){
        return SpringSerializer.deserialize(bytes);
    }


    public void close(ShardedJedis jedis){
        shardedJedisPool.returnBrokenResource(jedis);
    }

    public boolean lock(Object key,long timeout) {
        long nano = System.nanoTime();
        timeout *= ONE_MILLI_NANOS;
        try {
            while ((System.nanoTime() - nano) < timeout) {
                if (put(key,timeout,LOCKED)) {
                    locked = true;
                    return locked;
                }
                // 短暂休眠，nano避免出现活锁
                Thread.sleep(3, r.nextInt(500));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 无论是否加锁成功，必须调用
    public void unlock(Object key) {
        if (locked)
            remove(key);
    }

}
