package day03;
import java.util.Random;
import java.util.Scanner;

public class Ex14_UpDown {

	public static void main(String[] args) {
		// 1에서 100사이의 랜덤한 수를 생성해서 게임을 구현하세요.
		
		Scanner number = new Scanner(System.in);
		System.out.println("범위를 입력해주세요.");
		int a=number.nextInt();
		int b=number.nextInt();

		Random random = new Random();
		int r=(int)(Math.random()*(b-a +1)+a);
		
		for(int i=0;;i++) {
			System.out.println("정답을 입력하세요.");
			int n =number.nextInt();
			if(n>r) {
				System.out.println("다운!");
			}
			else if(n<r){
				System.out.println("업!");
			}
			else {
				System.out.println("정답");
				break;
			}
		}
		
	}

}
