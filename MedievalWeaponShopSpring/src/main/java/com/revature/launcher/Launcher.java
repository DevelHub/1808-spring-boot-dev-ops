package com.revature.launcher;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.screens.LoginScreen;
import com.revature.screens.Screen;


public class Launcher {
	private static Logger log = Logger.getRootLogger();
	public static void main(String[] args) throws InterruptedException {
		log.trace("trace log");
		log.debug("debug log");
		log.info("info log");
		log.warn("warn log");
		log.error("error log");
		log.fatal("fatal log");
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Screen s = (Screen) ac.getBean("LoginScreen");
		while(true) {
			s = s.start();
		}
	}
}
