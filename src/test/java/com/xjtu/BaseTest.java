package com.xjtu;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by llh.xjtu on 17-4-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-web.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public abstract class BaseTest {
}
