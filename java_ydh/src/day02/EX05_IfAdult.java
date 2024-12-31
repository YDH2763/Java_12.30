package day02;

import java.util.Scanner;

public class EX05_IfAdult {

	public static void main(String[] args) {
		/* 나이를 저장하는 변수 age를 선언 및 초기화 하고
		 * age가 19세이상이면 성인, 아니면 미성년자라고 출력하는 코드를 작성
		 * */
		
		int age ;
		Scanner a = new Scanner(System.in);
		age = a.nextInt();
		
		if(age>=19) {
			System.out.println(age+"살은 성인입니다.");
		}
		if(age<19 && age>=0) {
			System.out.println(age+"살은 미성년자 입니다.");
		}
		if(age<0) {
			System.out.println("잘못 입력하였습니다.");
		}
		
	}

}
