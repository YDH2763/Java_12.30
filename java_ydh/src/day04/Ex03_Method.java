package day04;
import java.util.Random;
import java.util.Scanner;
public class Ex03_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*두 정수를 입력받아 최대 공약수를 구하는 메소드를 작성해라*/
		Scanner number = new Scanner(System.in);
		System.out.println("a 정수를 입력하세요.");
		int a = number.nextInt();	//정수 a입력
		System.out.println("b 정수를 입력하세요.");
		int b = number.nextInt();	//정수 b입력
		int c=Gcd(a,b);
		int d=Lcm(a,b);
		int e=beta(a,b);
		
		if(a<=0||b<=0){
			System.out.println("잘못 입력하였습니다.");
		}
		
		System.out.println(a+"와(과)"+b+"의 최대 공약수는"+c+"이다.");
		System.out.println(a+"와(과)"+b+"의 최소 공배수는"+d+"이다.");
		System.out.println(a+"와(과)"+b+"의 사이애서 "+e+"이(가) 출력되었습니다.");
	}
	
	/**
	 *  기능 : 두 정수의 최대 공약수를 알려주는 메소드
	 * 두 정수 =>int n1, int n2
	 * 두 정수의 최대 공약수 =>정수=>int
	 * 메소드명 : Gcd
	 */
	
	public static int Gcd(int n1, int n2) {
		int Gcd = 0;
		for(int i=1;i<=n1&&i<=n2;i++) {
			if(n1%i==0&&n2%i==0) {
				Gcd=i;
			}
		}
		return Gcd;
	}
	
	/**
	 *  기능 : 두 정수의 최소 공배수를 알려주는 메소드
	 * 두 정수 =>int n3, int n4
	 * 두 정수의 최소 공배수 =>정수=>int
	 * 메소드명 : Lcm
	 */
	public static int Lcm(int n3, int n4) {
		int Lcm =0;
		for(int i=1;;i++) {
			if(i%n3==0&&i%n4==0) {
				Lcm=i;
				break;
			}
		}
		return Lcm;
	}
	
	 public static int alpha(int n5, int n6) {
		 int alpha=0;
		 alpha=n5*n6/Gcd(n5,n6);
		 return alpha;
	 }

	 /** 
	  * 기능 : 최솟값과 최댓값 사이의 랜덤한 수를 생성하는 메소드
	  */
	 public static int beta(int n1, int n2) {
		 int beta=0;
		 Random random = new Random();
			beta=(int)(Math.random()*(n2-n1 +1)+n1);;	
		 return beta;
	 }
}
