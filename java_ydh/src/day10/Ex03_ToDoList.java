package day10;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Ex03_ToDoList {
	
	static Scanner number =new Scanner(System.in);
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		/*다음 기능을 갖는 프로그램을 작성하세요.
		 * 1.할일 등록
		 * 2.할일 삭제
		 * 3.할일 조회
		 * 4.종료
		 * 메뉴 선택 : 1
		 * 등원
		 * 1.할일 등록
		 * 2.할일 삭제
		 * 3.할일 조회
		 * 4.종료
		 * 메뉴 선택 : 1
		 * 수업
		 * 1.할일 등록
		 * 2.할일 삭제
		 * 3.할일 조회
		 * 4.종료
		 * 메뉴 선택 : 2
		 * 1.동원
		 * 2.수업
		 * 삭제할 할일 선택 : 1
		 * 삭제되었습니다.
		 * 1.할일 등록
		 * 2.할일 삭제
		 * 3.할일 조회
		 * 4.종료
		 * 메뉴 선택 : 3
		 * 1.수업
		 * 1.할일 등록
		 * 2.할일 삭제
		 * 3.할일 조회
		 * 4.종료
		 * 메뉴 선택 : 4
		 * 종료하였습니다.*/
		Scanner number =new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		int c=0;
		for(int i=1;;i++) {
			//printMenu();
			System.out.println("메뉴");
			System.out.println("1.할일 등록");
			System.out.println("2.할일 삭제");
			System.out.println("3.할일 조회");
			System.out.println("4.종료");
			System.out.print("메뉴 선택 : ");
			char s =number.next().charAt(0);
			System.out.println("");
			
			//runMenu(s,c);
			switch(s) {
			case '1':
				//insertToDo(c);
				System.out.println("1.할일 등록");
				System.out.println("할일을 적어주세요.");
				number.nextLine();
				String p=number.nextLine();
				list.add(p);
				c++;
				break;
			case '2':
				//deleteToDo(c);
				if(c==0) {
					System.out.println("아직 입력하지 않았습니다.");
					break;
				}
				System.out.println("2.할일 삭제");
				System.out.println("오늘 할일");
				for(int j=0;j<c;j++) {
					System.out.println((j+1)+". "+list.get(j));
				}
				System.out.println("삭제할 번호를 입력해주세요.");
				int dn=number.nextInt();
				if(dn>=list.size()||dn<0) {
					System.out.println("잘못입력하였습니다.");
					break;
				}
				list.remove(dn-1);
				System.out.println("삭제하였습니다.");
				c--;
				break;
			case '3':
				//printToDo(c);
				if(c==0) {
					System.out.println("아직 입력하지 않았습니다.");
					break;
				}
				System.out.println("3.할일 조회");
				System.out.println("오늘 할일");
				for(int j=0;j<c;j++) {
				System.out.println((j+1)+". "+list.get(j));
				}
				break;
			case '4':
				System.out.println("종료하였습니다.");
				break;
			default:
				System.out.println("다시입력해주세요.");
				break;
			}
			if(s=='4') {
				break;
			}
			
		}
		

	}

	private static boolean printToDo(int c) {
		if(c==0) {
			System.out.println("아직 입력하지 않았습니다.");
			return false;
		}
		System.out.println("3.할일 조회");
		System.out.println("오늘 할일");
		System.out.println(list);
		/*for(int j=0;j<c;j++) {
			System.out.println(list);
		}*/
		return true;
	}

	private static int deleteToDo(int c) {
		if(c==0) {
			System.out.println("아직 입력하지 않았습니다.");
			return c;
		}
		System.out.println("2.할일 삭제");
		System.out.println("오늘 할일");
		System.out.println(list);
		/*for(int j=0;j<c;j++) {
			System.out.println(list);
		}*/
		System.out.println("삭제할 번호를 입력해주세요.");
		int dn=number.nextInt();
		list.remove(dn-1);
		System.out.println("삭제하였습니다.");
		c--;
		return c;
	}

	private static int insertToDo(int c) {
		System.out.println("1.할일 등록");
		System.out.println("할일을 적어주세요.");
		number.nextLine();
		String p=number.nextLine();
		list.add(p);
		c++;
		return c;
	}

	private static void runMenu(char s, int c) {
		switch(s) {
		case '1':
			System.out.println("1.할일 등록");
			System.out.println("할일을 적어주세요.");
			number.nextLine();
			String p=number.nextLine();
			list.add(p);
			c++;
		case '2':
			if(c==0) {
				System.out.println("아직 입력하지 않았습니다.");
				break;
			}
			System.out.println("2.할일 삭제");
			System.out.println("오늘 할일");
			System.out.println(list);
			/*for(int j=0;j<c;j++) {
				System.out.println(list);
			}*/
			System.out.println("삭제할 번호를 입력해주세요.");
			int dn=number.nextInt();
			list.remove(dn-1);
			System.out.println("삭제하였습니다.");
			c--;
		case '3':
			if(c==0) {
				System.out.println("아직 입력하지 않았습니다.");
				break;
			}
			System.out.println("3.할일 조회");
			System.out.println("오늘 할일");
			System.out.println(list);
			/*for(int j=0;j<c;j++) {
				System.out.println(list);
			}*/
			
		case '4':
			System.out.println("종료하였습니다.");
			
		default:
			System.out.println("다시입력해주세요.");
			
		}
		
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.할일 등록");
		System.out.println("2.할일 삭제");
		System.out.println("3.할일 조회");
		System.out.println("4.종료");
		System.out.print("메뉴 선택 : ");
		char s =number.next().charAt(0);
		System.out.println("");
	}
	

}
