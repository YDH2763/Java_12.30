package day02;

import java.util.Scanner;

public class Ex11_IfOperator {

	public static void main(String[] args) {
		/*두 정수와 산술 연산자를 입력받는 코드를 작성하기
		 * 예시
		 * 두 정수와 산술 연산자를 입력하세요(1+2):3*4
		 * 입력받은 값이 출력*/
		Scanner num =new Scanner(System.in);
		
		System.out.println("다음 정수를 입력하세요.");
		int a=num.nextInt();
		int b=num.nextInt();
		
		System.out.println("다음 연산자를 입력하세요.");
		char op;
		op =num.next().charAt(0) ;
		
		System.out.println("" + a + op + b );
		
		if(op=='+') {
			System.out.println("=" +(a+b) );
		}
		else if(op == '-'){
			System.out.println("=" +(a-b) );
			
		}
		else if(op == '*'){
			System.out.println("=" +(a*b) );
			
		}
		else if(op == '/'){
			System.out.println("=" +((double)a/b) );
			
		}
		else if(op == '%') {
			System.out.println("=" +(a%b) );
		}
		else {
			System.out.println("잘못입력하였습니다.");
		}
		

	}

}
