package day05;
import java.util.Scanner;
import java.util.Random;
public class Ex12_Lotto2_practice {

	public static void main(String[] args) {
		/*1~45 사이의 랜덤한 수 6개를 생성하고, 1개의 보너스 번호를 생성한다.
		 * 1~45 사이의 정수 6개를 입력받아 입력한 정수가 몇등인지 확인하는 코드를 작성
		 * 
		 * */
		Scanner number = new Scanner(System.in);
		int a=1, b=45;	//로또 번호 범위
		int c=0;	//당첨되었을 경우 1씩 추가해줄 정수
		int lotto[]=new int[6];		//입력할 정수값
		int lotto1[]= new int[6];	//당첨된 정수값
		
		//System.out.print("로또 번호 :");
		
		LottoAnsure(a,b,lotto1);	//당첨값 출력
		
		/*for(int i=0;i<=5;i++) {
			System.out.print(lotto1[i]+", ");
		}*/
		//System.out.println("");
		
		EnterLotto(lotto);		//정수 입력
		
		System.out.print(" ");
		
		result(lotto, lotto1, c);	//입력값하고 당첨값 비교(같으면 c+1
		
		LottoResult(c);		//당첨 결과
	}
public static int [] LottoAnsure(int n2,int n3,int n1[]) {
	for(int i=0;i<=5;i++) {
		int r1=(int)(Math.random()*(n3-n2 +1)+n2);
		n1[i]=r1;
		if(i>=1) {
			for(int j=0;j<i;j++) {
				if(n1[i]==n1[j]) {
					i--;
				}
			}
		}
		
	}
	return n1;
}

public static void  EnterLotto(int n1[]) {
	Scanner number = new Scanner(System.in);
	for(int i=0;i<=5;i++) {
		for(int j=1;;j++) {
			System.out.println((i+1)+"번째 자리에 숫자를 적으세요");
			int n=number.nextInt();
			if(n>45 ||n<1) {
				System.out.println("다시 입력해주세요.");
			}
			else {
				n1[i]=n;
				break;
			}
		}
	}
	for(int k=0;k<=5;k++) {
		System.out.print(n1[k]+", ");
	}
}

public static void result(int n1[], int n2[], int n3) {
	for(int i=0;i<=5;i++) {
		for(int j=0;j<=5;j++) {
			if(n1[i]==n2[j]) {
				n3++;
			}
		}
	}
	
}

public static int LottoResult(int n1) {
	switch(n1) {
	case 6:
		System.out.println("1등");
		break;
	case 5:
		System.out.println("2등");
		break;
	case 4:
		System.out.println("3등");
		break;
	case 3:
		System.out.println("4등");
		break;
	case 2:
		System.out.println("5등");
		break;
	default:
		System.out.println("꽝");
		break;
	}
	return n1;
}
}
