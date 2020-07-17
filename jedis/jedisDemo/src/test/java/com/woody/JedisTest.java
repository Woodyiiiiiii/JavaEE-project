package com.woody;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * test for jedis
 */
public class JedisTest {

    @Test
    public void testString() {
        // 1. 建立连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2. 操作redis
//        jedis.set("name","woody");
        System.out.println(jedis.get("name"));
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void testHash() {
        // 1. 建立连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2. 操作redis
        jedis.hset("user","name","woody");
        jedis.hset("user","height","170");
        jedis.hset("user","weight","100");

        Map<String, String> map = jedis.hgetAll("user");
        System.out.println(map);
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void testList() {
        // 1. 建立连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2. 操作redis
        jedis.lpush("list","woody", "karen");
        jedis.rpush("list","baby");
        System.out.println(jedis.lrange("list",0,-1));
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void testSet() {
        // 1. 建立连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2. 操作redis
        jedis.sadd("set","woody", "karen");
        Set<String> set = jedis.smembers("set");
        System.out.println(set);
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void testZset() {
        // 1. 建立连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2. 操作redis
        jedis.zadd("scores",99,"woody");
        jedis.zadd("scores",87, "karen");
        Long aLong = jedis.zcard("scores");
        System.out.println(aLong);
        // 3. 关闭连接
        jedis.close();
    }
}
