package day23;

import java.util.Scanner;

public class Ex12_String {
	
	private static Scanner number=new Scanner(System.in);
	
	public static void main(String[] args) {
		String str;
		do {
			System.out.println("입력");
			str=number.next();
			System.out.println("출력 : "+str);
			//문자열은 ==나 !=로 비교하면 정상적으로 작동하지 않을 수 있다
			//그래서 'equals'로 비교한다.
		}while(str.equals("exit"));

	}

}
