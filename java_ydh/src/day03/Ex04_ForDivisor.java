package day03;
import java.util.Scanner;
public class Ex04_ForDivisor {

	public static void main(String[] args) {

		Scanner number = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		int n = number.nextInt();
		
		if(n<=0) {
			System.out.println("잘못 입력하였습니다.");
		}
		for(int i=n;i>0;i--){
			if(n%i==0){
				System.out.print(+(n/i)+ ", ");
			}
		}

	}

}
