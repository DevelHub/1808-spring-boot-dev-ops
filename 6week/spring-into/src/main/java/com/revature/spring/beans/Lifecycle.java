package com.revature.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Lifecycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
	private UserDao ud;

	public Lifecycle() {
		System.out.println("instantiated bean");
	}

	public UserDao getUd() {
		return ud;
	}

	@Autowired
	public void setUd(UserDao ud) {
		System.out.println("populating properties");
		this.ud = ud;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("initializing beans: after properties set");
	}

	@PostConstruct
	public void customInit() {
		System.out.println("custom init");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	@PreDestroy
	public void customDestory() {
		System.out.println("custom destroy");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("set application context aware");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("set bean factory aware");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("set bean name aware, name is: " + name);
	}

}
