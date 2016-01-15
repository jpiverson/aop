package site.penn.aop.cglib;

import org.junit.Assert;
import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import site.penn.aop.service.Calculator;
import site.penn.aop.service.CalculatorImpl;

public class CglibTest extends TestCase {

	Calculator cal;

	public CglibTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CglibTest.class);
	}

	@Before
	public void setUp() throws Exception {
		cal = (Calculator) CglibProxyFactory.proxyTarget(new CalculatorImpl());
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
