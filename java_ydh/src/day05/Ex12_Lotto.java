package day05;
import java.util.Scanner;
import java.util.Random;
public class Ex12_Lotto {

	public static void main(String[] args) {
		/*1~45 사이의 랜덤한 수 6개를 생성하고, 1개의 보너스 번호를 생성한다.
		 * 1~45 사이의 정수 6개를 입력받아 입력한 정수가 몇등인지 확인하는 코드를 작성
		 * 
		 * */
		Scanner number = new Scanner(System.in);
		int a=1, b=45;
		int c=0;
		int lotto[]=new int[6];
		int lotto1[]= new int[6];
		
		System.out.print("로또 번호 :");
		for(int i=0;i<=5;i++) {
			int r1=(int)(Math.random()*(b-a +1)+a);
			lotto1[i]=r1;
			if(i>=1) {
				for(int j=0;j<i;j++) {
					if(lotto1[i]==lotto1[j]) {
						i--;
					}
				}
			}
			
		}
		for(int i=0;i<=5;i++) {
			System.out.print(lotto1[i]+", ");
		}
		
		System.out.println("");
		
		for(int i=0;i<=5;i++) {
			for(int j=1;;j++) {
				System.out.println((i+1)+"번째 자리에 숫자를 적으세요");
				int n=number.nextInt();
				if(n>45 ||n<1) {
					System.out.println("다시 입력해주세요.");
				}
				else {
					lotto[i]=n;
					break;
				}
			}
		}
		for(int k=0;k<=5;k++) {
			System.out.print(lotto[k]+", ");
		}
		
		System.out.print(" ");
		
		for(int i=0;i<=5;i++) {
			for(int j=0;j<=5;j++) {
				if(lotto[i]==lotto1[j]) {
					c++;
				}
			}
		}
	switch(c) {
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
	}

}
