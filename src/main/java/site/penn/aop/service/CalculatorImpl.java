package site.penn.aop.service;

public class CalculatorImpl implements Calculator {

	public int plus(int num1, int num2) {
		return num1 + num2;
	}

	public int minus(int num1, int num2) {
		return num1 - num2;
	}

	public int multiplied(int num1, int num2) {
		return num1 * num2;
	}

	public int divided(int num1, int num2) {
		return num1 / num2;
	}

}
