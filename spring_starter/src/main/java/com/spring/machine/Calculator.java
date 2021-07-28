package com.spring.machine;

import com.spring.module.Divide;
import com.spring.module.Minus;
import com.spring.module.Multiplex;
import com.spring.module.Summation;

public class Calculator {
	private Summation sum = new Summation();
	private Minus minus = new Minus();
	private Multiplex multi = new Multiplex();
	private Divide divide = new Divide();
	
	public int sum(int a, int b) {
		return sum.sum(a, b);
	}
	
	public int minus(int a, int b) {
		return minus.minus(a, b);
	}
	
	public int multi(int a, int b) {
		return multi.multi(a, b);
	}
	
	public double divide(int a, int b) {
		return divide.divide(a, b);
	}

	
	public Summation getSum() {
		return sum;
	}

	public void setSum(Summation sum) {
		this.sum = sum;
	}

	public Minus getMinus() {
		return minus;
	}

	public void setMinus(Minus minus) {
		this.minus = minus;
	}

	public Multiplex getMulti() {
		return multi;
	}

	public void setMulti(Multiplex multi) {
		this.multi = multi;
	}

	public Divide getDivide() {
		return divide;
	}

	public void setDivide(Divide divide) {
		this.divide = divide;
	}
	
}
