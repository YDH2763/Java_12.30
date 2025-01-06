package day05;
import java.util.Random;
import java.util.Scanner;
public class Ex10_Homework_1 {

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
		
		Random random = new Random();
		int r=(int)(Math.random()*(b-a +1)+a);
		int count=0;
		if(a>b) {
			System.out.println("최솟값이 최댓값보다 높게 입력됬습니다.");
		}
		else {
			/*for(int i=0;;i++) {
				System.out.println("다음 메뉴를 선택하세요.");
				System.out.println("1. 프로그램 실행");
				System.out.println("2. 최고 기록 확인");
				System.out.println("3. 프로그램 종료");
				char c=number.next().charAt(0);
				switch(c){
				case '1' :
					for(int j=1;;j++) {
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
					count++;
					}
				case '2' :
					if(count>0) {
						System.out.println("정답을 맞추는데 까지 실행한 횟수는");
						System.out.println(count+ "회 입니다.");
						System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
						number.nextLine();
						number.nextLine();
						}
					else {
						System.out.println("아직 실행하지 않았습니다.");
						System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
						number.nextLine();
						number.nextLine();
					}
					
				case '3' :
					System.out.print("");
					break;
				default :
					System.out.println("다시 입력해주세요.");
					System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
					number.nextLine();
					number.nextLine();
				}
				if(c=='3') {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
		*/
			Mainmenu(r, count);}
	}
private static void Mainmenu(int n1, int n2) {
	for(int i=0;;i++) {
		Scanner number= new Scanner(System.in);
		System.out.println("다음 메뉴를 선택하세요.");
		System.out.println("1. 프로그램 실행");
		System.out.println("2. 최고 기록 확인");
		System.out.println("3. 프로그램 종료");
		char c=number.next().charAt(0);
	}
	
}
private static void Run_menu(char n1, int n2) {
	switch(n1) {
		case '1' :
			Game(n1,n2);
		case '2' :
			Record(n2);
		case '3' :
			
		default:
				
	}
}
private static void Record(int n1) {
	Scanner number= new Scanner(System.in);
	if(n1>0) {
		System.out.println("정답을 맞추는데 까지 실행한 횟수는");
		System.out.println(n1+ "회 입니다.");
		System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
		number.nextLine();
		number.nextLine();
		}
	else {
		System.out.println("아직 실행하지 않았습니다.");
		System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
		number.nextLine();
		number.nextLine();
	}
}
private static void Game(int n1, int n2) {
	Scanner number= new Scanner(System.in);
	for(int j=1;;j++) {
		n2++;
		System.out.print("정수를 입력하세요.");
		int d=number.nextInt();
		if(d>n1) {
			System.out.println("다운!");
		}
		else if(d<n1) {
			System.out.println("업!");
		}
		else {
			System.out.println("정답");
			break;
		}
		return ;
}
}
}