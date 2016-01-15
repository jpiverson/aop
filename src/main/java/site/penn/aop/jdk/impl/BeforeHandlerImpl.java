package site.penn.aop.jdk.impl;

import java.lang.reflect.Method;

import site.penn.aop.jdk.BeforeHandler;

public class BeforeHandlerImpl extends BeforeHandler {

	@Override
	public void handleBefore(Object proxy, Method method, Object[] args) {
		System.out.println(method.getName() + "前置通知........");
	}
}