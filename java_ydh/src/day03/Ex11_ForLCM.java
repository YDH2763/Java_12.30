package day03;
import java.util.Scanner;
public class Ex11_ForLCM {

	public static void main(String[] args) {
		/*정수 a와 b를 입력받고 두 정수의 최소 공배수를 구하는 코드를 작성*/
		Scanner number = new Scanner(System.in);
		System.out.println("정수 a를 입력하세요.");
		int a=number.nextInt();
		System.out.println("정수 b를 입력하세요.");
		int b=number.nextInt();
		int c=0;
		int f=1;
		
		if(a<=0||b<=0){
			System.out.println("잘못 입력하였습니다.");
		}
		for(int i=1;;i++,f++) {
			int d=a*i;
			int e=b*i;
			c=a*b;
			if(d%c==0&&e%c==0) {
				System.out.println(f+"번 반복하였습니다.");
				System.out.println(a+"와"+b+"의 최소 공배수는"+c+"입니다.");
				break;
			}
		}
		for(int j=1;;j++,f++) {
			if(j%a==0&&j%b==0) {
				System.out.println(f+"번 반복하였습니다.");
				System.out.println(a+"와"+b+"의 최소 공배수는"+j+"입니다.");
				break;
			}
		}

	}

}
