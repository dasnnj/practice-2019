package com.dasnnj.practice.weixinsell.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description <P> DO : 测试日志 <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-05-12 11:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogTest {
    //使用Lombok的@Slf4j 代替这行
//    private Logger logger = LoggerFactory.getLogger(LogTest.class);
    @Test
    public void test1() {
        log.debug("it's debug msg ... ");
        log.info("it's info msg ... ");
        log.warn("it's warn msg ... ");
        log.error("it's warn error ... ");
        //{}大括号作为占位符,后面的为参数
        log.info("param1 {} , param2 {}", "p1", "p2");
    }
}
