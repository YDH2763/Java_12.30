package day03;
import java.util.Scanner;
public class Ex05_ForPrimNumber {

	public static void main(String[] args) {
		Scanner number = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		int n =number.nextInt();
		int c=0;
		
		if(n<=0) {
			System.out.println("잘못 입력하였습니다.");
		}
		//S.1
		for(int i=n;i>0;i--){
			if(n%i==0){
				c++;
			}
		}
		if(c==2) {
			System.out.println(n+"는 소수입니다.");
		}
		else {
			System.out.println(n+ "는 소수가 아닙니다.");
		}
		
		/*if(n>3) {
			if(n%2!=0){
				if(n%3!=0) {
					
				}
			}
			else {
				System.out.println(n+ "는 소수가 아닙니다.");
			}
		}
		else {
			System.out.println(n+"는 소수입니다.");
		}
		*/
		c=0; //S.2
		for(int i=2;i<n;i++){
			if(n%i==0){
				c++;
			}
		}
		if(c==0 && n!=1) {
			System.out.println(n+"는 소수입니다.");
		}
		else {
			System.out.println(n+ "는 소수가 아닙니다.");
		}
		

	}

}
