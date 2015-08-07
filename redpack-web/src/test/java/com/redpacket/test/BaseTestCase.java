package com.redpacket.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@ContextConfiguration(locations = {
        "classpath:/spring/redpack-support.xml" })
public class BaseTestCase extends AbstractTransactionalJUnit4SpringContextTests {
	static {
		System.setProperty("catalina.home",	"D:\\soft\\apache-tomcat-7.0.63");
	}
}
