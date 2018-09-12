package com.revature.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		SpringScreen ss = (SpringScreen) ac.getBean("Spring Screen");
//		ss.run();
		ac.getBean(Lifecycle.class);
		System.out.println("in use");
		((AbstractApplicationContext) ac).close();
		Thread.sleep(100000);
	}
}
