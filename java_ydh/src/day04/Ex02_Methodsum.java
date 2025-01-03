package day04;

import java.util.Scanner;
public class Ex02_Methodsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner number = new Scanner(System.in);
		int a=number.nextInt();
		int b=number.nextInt();
		
		int sum = Sum(a,b);
		System.out.println(a+"+"+b+"="+ sum);
		System.out.println(sum);
		System.out.println(Sum(a,b));
		
	}
	
	//두정수가 주어지면 두 정수의 합을 알려주는 메소드
	//매개변수 : 입력할 두 정수 선언 =>int n1, int n2
	//리턴타입 : 두 정수의 합 => 정수 => int
	//메소드명 : Sum
	
	public static int Sum(int n1, int n2) {
		int Sum =n1+n2;
		return Sum;
	}
}
