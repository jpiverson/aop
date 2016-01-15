package site.penn.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyFactory implements MethodInterceptor {

	private Object targetObject;

	private CglibProxyFactory(Object object) {
		this.targetObject = object;
	}

	@SuppressWarnings("unchecked")
	public static <T> T proxyTarget(T t) {
		Enhancer en = new Enhancer();
		en.setSuperclass(t.getClass());
		en.setCallback(new CglibProxyFactory(t));
		T tt = (T) en.create();
		return tt;
	}

	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.print(args[0] + " ");
		System.out.print(method.getName() + " ");
		System.out.print(args[1] + " ");
		Object result = method.invoke(targetObject, args);
		System.out.println("is " + result);
		return result;
	}
}