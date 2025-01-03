package day04;
import java.util.Scanner;
public class Ex09_Menu {

	public static void main(String[] args) {
		/* 다음과 같이 실행되는 코드를 작성하세요.
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 : 1
		 * 문자를 입력하세요(종료하려면 q):1
		 * 문자를 입력하세요(종료하려면 q):a
		 * 문자를 입력하세요(종료하려면 q):b
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 : 2
		 * 프로그램을 종료합니다.
		 * */
		for(int j =1;;j++) {
			Scanner number = new Scanner(System.in);
			System.out.println("다음 메뉴를 선택하세요.");
			System.out.println("1. 프로그램 실행");
			System.out.println("2. 종료");
			int n=number.nextInt();
			int a=Menu(n);
			if(n==2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
	}
	public static int Menu(int n1) {
		int menu=0;
		Scanner number = new Scanner(System.in);
		switch(n1) {
		case 1:
			for(int i=0;;i++) {
				System.out.println("문자를 입력하세요.(종료하려면 q)");
				char c=number.next().charAt(0);
				if(c=='q') {
					System.out.println("선택화면으로 돌아갑니다.");
					break;
				}
			}
		case 2:
			System.out.print("");
			break;
		default:
			System.out.println("다시 입력해주세요.");
		}
		return menu;
	}
	public static void PrintMenu() {
		System.out.println("------------");
		System.out.println("메뉴");
		System.out.println("1.프로그램 실행");
		System.out.println("2.프로그램 종료");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
	}
	public static void runMenu(char menu) {
		switch(menu){
		 case '1':
      		Program();
      		break;
 		 case '2':
 				System.out.println("프로그램을 종료합니다.");
 				break;
 		 default :
 				System.out.println("잘못된 메뉴입니다.");
	}
	}
	public static void Program() {
		Scanner number = new Scanner(System.in); 
		char ch;
  		do{
  			System.out.print("문자를 입력하세요.:");
  			ch = number.next().charAt(0);
  			}while(ch !='q');
	}
}
/* char menu;
 * Scanner scan = new Scanner(System.in);
 * do{
 * 		System.out.println("------------");
 *		System.out.println("메뉴");
 *		System.out.println("1.프로그램 실행");
 * 		System.out.println("2.프로그램 종료");
 * 		System.out.println("------------");
 *      System.out.print("메뉴 선택 : ");
 *      
 *      menu =scan.next().charAt(0);
 *      
 *      switch(menu){
 *      case '1':
 *      		char ch;
 *      		do{
 *      			System.out.print("문자를 입력하세요.:");
 *      			ch = scan.next().chatAt(0);
 *      			}while(ch !='q');
 *      		break;
 * 		case '2':
 * 				System.out.println("프로그램을 종료합니다.");
 * 				break;
 * 		default :
 * 				System.out.println("잘못된 메뉴입니다.");
 *  	} while(menu!='2');
 * */

	
	
	

