package day03;
import java.util.Scanner;
public class Ex06_ForGCD {

	public static void main(String[] args) {
		/*두 정수를 입력받아 최대 공약수를 구하는 코드를 작성해라*/
		Scanner number = new Scanner(System.in);
		System.out.println("a 정수를 입력하세요.");
		int a = number.nextInt();	//정수 a입력
		System.out.println("b 정수를 입력하세요.");
		int b = number.nextInt();	//정수 b입력
		
		if(a<=0 || b<=0) {
			System.out.println("잘못 입력하였습니다.");
		}
		int c=0;	//최대공약수 결과값 c
		
		/* 반복횟수 : i는 1부터 a까지 1씩 증가 
		 * 규칙성 : i가 a와 b의 공약수이면 i를 c에 저장
		 * 		  i가 a의 약수이고 b의 약수이면 i를 c에 저장
		 * 		  a를 i로 나누었을 때 나머지가 0과 같고 b를 i로 나누었을 때
		 * 		  0과 같다면 i를 c에 저장
		 * 반복문 종료 후 : 결과값 c 출력*/
	//Solution.1
		for(int i=1;i<=a&&i<=b;i++) {	//i는 a와 b를 나눌때 사용하는 정수
			if(a%i==0&&b%i==0) {	//a와 b를 동시에 나누는 수
				c=i;
				System.out.print(c+", ");
			}
		}
		System.out.println(a+"와(과)"+b+"의 최대 공약수는"+c+"이다.");
		
	}

}
