package com.kh.test;

import java.util.Scanner;

public class test {
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String str=null;
		count(str);
		
	}
	private static void count(String str) {
		do{
			System.out.println("문자열을 입력해주세요.:");
			str=sc.nextLine();
			if(str.equals(str)) {
				break;
			}
			else {
				System.out.println(str.length()+"글자입니다.");
				//length() :문자열에 대한 글자 수 반환 메소드
			}
		}while(!str.equals("exit"));
		System.out.println("프로그램을 종료합니다.");
	}
	
}
