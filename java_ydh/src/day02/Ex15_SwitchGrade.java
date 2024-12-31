package day02;
import java.util.Scanner;
public class Ex15_SwitchGrade {

	public static void main(String[] args) {
		//주어진 성적에 맞는 학점을 출력
		/* A:90~100
		 * B:80~89
		 * C:70~79
		 * D:60~69
		 * F:0~59
		 * 예외:
		 */
		Scanner sc = new Scanner(System.in);
		int g;		
		
		System.out.println("다음 성적을 입력하세요.");
		g=sc.nextInt();
		
		if(g<=100) {
		
			switch(g/10) {
				case 10,9 :
					System.out.println(g+"는 A학점");
					break;
				case 8 :
					System.out.println(g+"는 B학점");
					break;
				case 7 :
					System.out.println(g+"는 C학점");
					break;
				case 6 :
					System.out.println(g+"는 D학점");
					break;
				case 0,1,2,3,4,5 :
					System.out.println(g+"는 F학점");
					break; 
				default:
					System.out.println("성적을 잘못 입력하였습니다.");
					break;
				}
		}
		else {
			System.out.println("성적을 잘못 입력하였습니다.");
		}

	}

}
