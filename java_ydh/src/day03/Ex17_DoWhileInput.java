package day03;
import java.util.Scanner;
public class Ex17_DoWhileInput {

	public static void main(String[] args) {
		Scanner charactor =new Scanner(System.in);
		char ch ;
		do {
			System.out.print("입력 : ");
			ch = charactor.next().charAt(0);
		}while(ch!='q');
		System.out.print("시스템을 종료합니다.");
	}

}
