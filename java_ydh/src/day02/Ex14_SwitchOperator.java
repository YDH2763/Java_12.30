package day02;
import java.util.Scanner;
public class Ex14_SwitchOperator {

	public static void main(String[] args) {
		/*switch문을 이용해서 두 정수의 산술 연산 결과를 출력하는 코드를 작성*/
		Scanner sc = new Scanner(System.in);
		System.out.println("다음 정수 'a'와 'b'를 입력하세요.");
		double a, b;
		a=sc.nextDouble();
		b=sc.nextDouble();
		
		System.out.println("다음 연산자 'c'를 입력하세요.");
		char c;
		c=sc.next().charAt(0);
		
		System.out.print(""+ a + c +b);
		switch(c) {
		case '+' :
			System.out.print("=" +(a+b) );
			break;
		case '-':
			System.out.print("=" +(a-b) );
			break;
		case '*':
			System.out.print("=" +(a*b) );
			break;
		case '/':
			System.out.print("=" +(a/b) );
			break;
		case '%':
			System.out.print("=" +(a%b) );
			break;
		default:
			System.out.println("'c'를 잘못 입력하였습니다.");
			break;
		
		}
		
	}

}
