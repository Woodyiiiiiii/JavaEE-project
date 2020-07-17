package com.woody.service;

import redis.clients.jedis.Jedis;

/**
 * 模拟业务场景：
 *      1. 设定A，B，C三个用户
 *      2. A用户限制10次/分调用，B用户限制30次/分调用，C用户不限制
 */
public class ServiceImpl {

    // 控制单元
    public void service() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.close();
    }

    // 业务单元
    public void business() {
        System.out.println("正在执行业务方法。。。");
    }
}
class MyThread extends Thread {

    public ServiceImpl service = new ServiceImpl();

    @Override
    public void run() {
        while (true) {
            service.business();
        }
    }
}
class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }
}