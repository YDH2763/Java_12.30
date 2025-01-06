package day04;
import java.util.Random;
import java.util.Scanner;
public class Ex10_Homework {

	public static void main(String[] args) {
		/* 다음과 같이 실행되도록 프로그램을 작성하세요.(day03_UpDown참고)
		 * 
		 * 메뉴
		 * 1.UpDown 게임 실행
		 * 2.최고 기록 확인
		 * 3.프로그램 종료
		 * 메뉴 선택:2
		 * 게임을 실행한 적이 없습니다.
		 * 메뉴
		 * 1.UpDown 게임 실행
		 * 2.최고 기록 확인
		 * 3.프로그램 종료
		 * 메뉴 선택 :1
		 * 입력 : 50
		 * Down!
		 * 입력 :25
		 * 정답!
		 * 메뉴
		 * 1.UpDown 게임 실행
		 * 2.최고 기록 확인
		 * 3.프로그램 종료
		 * 메뉴 선택 :3
		 * 프로그램을 종료합니다.
		 * */
		Scanner number= new Scanner(System.in);
		System.out.println("범위를 입력해주세요.");
		int a=number.nextInt();
		int b=number.nextInt();
		
		int count=0;
		Random random = new Random();
		int r=(int)(Math.random()*(b-a +1)+a);
		
		if(a>b) {
			System.out.println("최솟값이 최댓값보다 높게 입력됬습니다.");
		}
		else {
			for(int i=0;;i++) {
				System.out.println("다음 메뉴를 선택하세요.");
				System.out.println("1. 프로그램 실행");
				System.out.println("2. 최고 기록 확인");
				System.out.println("3. 프로그램 종료");
				char c=number.next().charAt(0);
				switch(c){
				case '1' :
					Game(r, count);
					
				case '2' :
					if(count>0) {
						System.out.println("정답을 맞추는데 까지 실행한 횟수는");
						System.out.println(count+ "회 입니다.");
					}
					else {
						System.out.println("아직 실행하지 않았습니다.");
					}
					
				case '3' :
					System.out.print("");
					break;
				default :
					System.out.println("다시 입력해주세요.");
				}
				if(c=='3') {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
		}
	}
	public static void Game(int r, int n1){
		for(int j=1;;j++) {
			Scanner number= new Scanner(System.in);
			System.out.print("정수를 입력하세요.");
			int d=number.nextInt();
			if(d>r) {
				System.out.println("다운!");
			}
			else if(d<r) {
				System.out.println("업!");
			}
			else {
				System.out.println("정답");
				break;
			}
			n1++;
		}
		
	}
	public static void Menu(){
		
	}
}
