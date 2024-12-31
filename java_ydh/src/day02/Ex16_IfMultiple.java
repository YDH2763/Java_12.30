package day02;
import java.util.Scanner;
public class Ex16_IfMultiple {

	public static void main(String[] args) {
		/*정수 n이 2의 배수인지 3의 배수인지 6의배수인지 2,3,6의 배수가 아닌지
		 * 판별해라 
		 * */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n%2 == 0) {
			if(n%3 ==0 ) {
				System.out.println(n+"는(은)6의 배수(3의 배수이면서 2의 배수)");
			}
			else {
				System.out.println(n+"는(은)2의 배수");
			}
		}
		else if(n%3==0){
			System.out.println(n+"는(은)3의 배수");
		}
		else {
			System.out.println(n+"는(은) 2,3,6의 배수가 이닙니다.");
		}
		
	}

}
