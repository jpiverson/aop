package site.penn.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculateHandle implements InvocationHandler {

	private Object targetObject;

	public Object newProxyInstance(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),
				this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.print(args[0] + " ");
		System.out.print(method.getName() + " ");
		System.out.print(args[1] + " ");
		Object result = method.invoke(targetObject, args);
		System.out.println("is " + result);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(1 / 0);
	}

}
