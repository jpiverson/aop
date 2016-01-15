package site.penn.aop.jdk;

import org.junit.Assert;
import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import site.penn.aop.service.Calculator;
import site.penn.aop.service.CalculatorImpl;

public class CalculateHandleTest extends TestCase {

	Calculator cal;

	public CalculateHandleTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CalculateHandleTest.class);
	}

	@Before
	public void setUp() throws Exception {
		CalculateHandle checkerHandle = new CalculateHandle();
		cal = (Calculator) checkerHandle.newProxyInstance(new CalculatorImpl());
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
