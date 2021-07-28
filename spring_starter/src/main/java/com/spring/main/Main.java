package com.spring.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.machine.Calculator;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("두 개의 정수를 입력하세요. ex) 3 5");
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.nextLine();

//		Calculator cal = new Calculator();
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/spring/context/root-context.xml");
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		
		System.out.println("1.덧셈\t2.빼기\t3.곱하기\t4.나누기");
		System.out.println("연산을 선택하세요.");
		
		String operator = scan.nextLine();
		
		String result = "";
		switch (operator) {
			case "1":
				result = result + cal.sum(a, b);
				break;
			case "2":
				result = result + cal.minus(a, b);
				break;
			case "3":
				result = result + cal.multi(a, b);
				break;
			case "4":
				result = result + cal.divide(a, b);
				break;
			default:
				System.out.println("연산 선택이 올바르지 않아 프로그램을 종료합니다.");
				return;
		}
		System.out.println("연산결과는 " + result + "입니다.");
	}

}
