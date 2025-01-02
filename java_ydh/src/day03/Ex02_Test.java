package day03;
import java.util.Scanner;
public class Ex02_Test {

	public static void main(String[] args) {
		/* 월을 입력하고 월의 마지막 일을 출력하는 코드를 입력하라
		 * */
		Scanner season = new Scanner(System.in);
		System.out.print("다음 월을 입력하세요.");
		int m =season.nextInt();
		
		if(m>0 && m<13) {
			switch(m) {
			case 1,3,5,7,8,10,12:
				System.out.print(m+"월은 31일까지 있습니다.");
				break;
			case 4,6,9,11:
				System.out.print(m+"월은 30일까지 있습니다.");
				break;
			case 2:
				System.out.print(m+"월은 28일까지 있고 4년에 한번 29일까지 있습니다.");
				break;
			}
		}
		else {
			System.out.print("월을 잘못 입력하였습니다.");
		}
		
	}

}
