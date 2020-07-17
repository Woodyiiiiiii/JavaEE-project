package com.woody;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03LoggingApplicationTests {

    // 注意是slf4j的接口
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        /**
         * 日志的级别：
         * trace < debug < info < warn < error
         * 可以调整日志级别，可以让某个级别以上的日志提示才生效
         */
        logger.trace("trace logging...");
        logger.debug("debug logging...");
        logger.info("info logging...");
        logger.warn("warn logging...");
        logger.error("error logging...");
    }

}
