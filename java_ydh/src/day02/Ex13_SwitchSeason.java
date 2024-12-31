package day02;
import java.util.Scanner;
public class Ex13_SwitchSeason {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		m=sc.nextInt();
		/*
		switch(m) {
		case 1:
			System.out.println(m+"월은 겨울입니다.");
			break;
		case 2:
			System.out.println(m+"월은 겨울입니다.");
			break;
		case 3:
			System.out.println(m+"월은 봄입니다.");
			break;
		case 4:
			System.out.println(m+"월은 봄입니다.");
			break;
		case 5:
			System.out.println(m+"월은 봄입니다.");
			break;
		case 6:
			System.out.println(m+"월은 여름입니다.");
			break;
		case 7:
			System.out.println(m+"월은 여름입니다.");
			break;
		case 8:
			System.out.println(m+"월은 여름입니다.");
			break;
		case 9:
			System.out.println(m+"월은 가을입니다.");
			break;	
		case 10:
			System.out.println(m+"월은 가을입니다.");
			break;
		case 11:
			System.out.println(m+"월은 가을입니다.");
			break;
		case 12:
			System.out.println(m+"월은 겨울입니다.");
			break;
		default:
			System.out.println("잘못입력했습니다.");
			break;
		*/
		switch(m) {
		
			case 3,4,5:
				System.out.println(m+"월은 봄입니다.");
			break;
			case 6,7,8:
				System.out.println(m+"월은 여름입니다.");
			break;
			case 9,10,11:
				System.out.println(m+"월은 가을입니다.");
			break;
			case 12,1,2:
				System.out.println(m+"월은 겨울입니다.");
			break;
			default:
				System.out.println("잘못 입력했습니다.");
			break;
		
		}
		
		

	}

}
