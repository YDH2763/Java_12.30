package day03;
import java.util.Scanner;
public class Ex10_ForInput {

	public static void main(String[] args) {
		//문자를 입력받은 문자가 q이면 종료되도록 코드를 작성.
		Scanner scan = new Scanner(System.in);
		for(int i=0 ;;i++) {
			System.out.println("문자를 입력하세요.");
			char a = scan.next().charAt(0);
			if(a=='q') {
				System.out.println("실행을 종료합니다.");
				break;
			}
		}
	}

}
