package day03;
import java.util.Scanner;
public class Ex16_WhileInput {

	public static void main(String[] args) {
		// 문자를 입력받아 문자가 q일때 종료하는 코드를 작성.
		Scanner charactor =new Scanner(System.in);
		char ch = 'a';
		while(ch!='q') {
			System.out.print("입력 : ");
			ch = charactor.next().charAt(0);
		}
		System.out.print("시스템을 종료합니다.");

	}

}
