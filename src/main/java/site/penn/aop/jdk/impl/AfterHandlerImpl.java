package site.penn.aop.jdk.impl;

import java.lang.reflect.Method;

import site.penn.aop.jdk.AfterHandler;

public class AfterHandlerImpl extends AfterHandler {

	@Override
	public void handleAfter(Object proxy, Method method, Object[] args) {
		System.out.println(method.getName() + "后置通知........");
	}

}