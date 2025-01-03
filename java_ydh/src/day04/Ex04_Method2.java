package day04;
import java.util.Scanner;
public class Ex04_Method2 {

	public static void main(String[] args) {
		//정수 n이하의 소수를 출력하는 코드를 작성(메소드 이용해서)
		Scanner number=new Scanner(System.in);
		int n=number.nextInt();
		int a=Prime(n);
		boolean b=what(n);
		
	}
	
	public static int Prime(int a) {
		int Prime = 0;
		for(int i=2;i<=a;i++) {
			int c=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					c++;
				}
			}
			if(c==2) {
				System.out.print(i+", ");
			}
		}
		System.out.println(" ");
		return Prime;
	}
	
	public static boolean what(int a) {
		int c=0;
		for(int i=a;i>0;i--){
			if(a%i==0){
				c++;
			}
		}
		if(c==2) {
			System.out.println(a+"(은)는 소수입니다.");
		}
		else {
			System.out.println(a+ "(은)는 소수가 아닙니다.");
		}
		return true;
		
	}

}
