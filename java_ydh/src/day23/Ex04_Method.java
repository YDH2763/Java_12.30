package day23;

import java.util.Scanner;

public class Ex04_Method {
	
	private static Scanner number=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("a값 : ");
		int a=number.nextInt();
		System.out.print("b값 : ");
		int b=number.nextInt();
		
		intSum(a,b);
		System.out.print("c값 : ");
		int c=number.nextInt();
		intSum1(a,b,c);
	}

	private static void intSum1(int a, int b, int c) {
		System.out.println(a+"+"+b+"+"+c+"="+(a+b+c));
		
	}

	private static void intSum(int a, int b) {
		System.out.println(a+"+"+b+"="+(a+b));
		
	}

}
