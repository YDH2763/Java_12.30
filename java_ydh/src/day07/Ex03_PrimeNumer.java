package day07;
import java.util.Scanner;
public class Ex03_PrimeNumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner number = new Scanner(System.in);
		System.out.println("입력값");
		int m= number.nextInt();
		
		int i;
		for(i=2;i<=m;i++) {
			if(m%i==0) {
				break;
			}
			
		}
		//소수일 때 i는 m, 소수가 아닐때는 i는 m보다 작다.
		if(i==m) {
			System.out.println(m+"는 소수이다.");
		}
		else {
			System.out.println(m+"는 소수가 아니다.");
		}
		/* 100이하의 소수를 판별하기 위해 배열을 활용해서 작성*/
		//i가 소수이면 i번지에 true를 i가 소수가 아니면 i번지에 false를 저장
		boolean primeArray [] =new boolean[101];
		int j;
		
		for(j=1;j<=100;j++) {
			//j가 소수이면 ture를 j번지에 저장
			if(isPrimeNumber(j)) {
				primeArray[j]=true;
			}
			//아니면 false를 j번지에 저장
			else {
				primeArray[j]=false;
			}
			primeArray[j]=isPrimeNumber(j);
		}
		//printArray를 이용하여 소수들만 출력하는 코드를 작성하세요.
		for(j=1;j<=100;j++) {
			if(primeArray[i]) {
				System.out.println(i+" ");
			}
		}
	}
 	//소수인지 아닌지를 알려주는 메소드
	public static boolean isPrimeNumber(int n1) {
		
		for(int i=2;i<=n1;i++) {
			if(n1%i==0) {
				return false;
			}
			
		}
		
		return n1==1 ? false : true;
		
	}
}
