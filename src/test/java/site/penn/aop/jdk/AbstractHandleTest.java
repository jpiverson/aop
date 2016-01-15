package site.penn.aop.jdk;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import site.penn.aop.jdk.impl.AfterHandlerImpl;
import site.penn.aop.jdk.impl.BeforeHandlerImpl;
import site.penn.aop.service.Calculator;
import site.penn.aop.service.CalculatorImpl;

public class AbstractHandleTest extends TestCase {

	// CalculateHandle checkerHandle = new CalculateHandle();
	// Calculator cal = (Calculator) checkerHandle.newProxyInstance(new CalculatorImpl());

	Calculator cal;

	public AbstractHandleTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(AbstractHandleTest.class);
	}

	@Before
	public void setUp() throws Exception {
		CalculatorImpl calcImpl = new CalculatorImpl();
		List<AbstractHandler> handlers = new ArrayList<AbstractHandler>();
		BeforeHandler before = new BeforeHandlerImpl();
		AfterHandler after = new AfterHandlerImpl();
		handlers.add(before);
		handlers.add(after);
		cal = (Calculator) JDKProxyFactory.getProxy(calcImpl, handlers);
	}

	public void testPlus() {
		int num1 = 1;
		int num2 = 2;
		int result = 3;
		Assert.assertEquals(result, cal.plus(num1, num2));
	}

	public void testMinus() {
		int num1 = 1;
		int num2 = 2;
		int result = -1;
		Assert.assertEquals(result, cal.minus(num1, num2));
	}

	public void testMultiplied() {
		int num1 = 1;
		int num2 = 2;
		int result = 2;
		Assert.assertEquals(result, cal.multiplied(num1, num2));
	}

	public void testDivided() {
		int num1 = 1;
		int num2 = 2;
		int result = 0;
		Assert.assertEquals(result, cal.divided(num1, num2));
	}
}
