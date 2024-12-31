package day02;
//import java.util.Scanner;
public class Ex09_IfSeason {

	public static void main(String[] args) {
		/*월이 주어졌을 때 월에 맞는 계절을 출력하세요.
		 * 봄 : 3~5
		 * 여름 : 6~8
		 * 가을 : 9~11
		 * 겨울 : 12~2
		 * 그 외 : 잘못된 월*/
		//Scanner a=new Scanner(System.in);
		int m=12;
		/*int m;
		m=a.nextInt();*/
		if(m>=3&&m<=5) {
			System.out.println(m+"월은 봄입니다.");
		}
		else if(m>=6 && m<=8) {
			System.out.println(m+"월은 여름입니다.");
		}
		else if(m>=9 && m<=11) {
			System.out.println(m+"월은 가을입니다.");
		}
		else if(m<1 || m>12) {
			System.out.println("잘못 입력하였습니다.");
		}
		else {
			System.out.println(m+"월은 겨울입니다.");
		}
		
		
	}

}
