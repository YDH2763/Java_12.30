package day02;

import java.util.Scanner;


public class Ex10_Scanner {

	public static void main(String[] args) {
		// Scanner를 이용해서 콘솔에서 입력받은 값 활용하는 예제
		
		Scanner num =new Scanner(System.in);
		
		System.out.print("정수를 입력하세요. : ");//ln: line으로 저걸 안쓰면 그대로 이어서 쓰게됨
		int a=num.nextInt();
		System.out.println("입력받은 정수 : " +a);
		
		System.out.print("실수를 입력하세요. : ");
		double b = num.nextDouble();
		System.out.println("입력받은 실수 : " +b);
		
		System.out.print("단어를 입력하세요");
		String c = num.next();//next()는 공백을 제외한 단어를 가져옴
		System.out.println("입력받은 단어 : " +c);
		
		System.out.print("문자를 입력하세요. : ");
		char ch = num.next().charAt(0);//단어를 가져와서 단어의 첫글자를 가져옴
		System.out.println("입력받은 문자 : " +ch);
		
		num.nextLine();//앞에서 입력한 엔터를 치기 위해서 사용.
		System.out.print("문장을 입력하세요");
		String d = num.nextLine();
		System.out.println("입력받은 문장 : " +d);
		
	}

}
