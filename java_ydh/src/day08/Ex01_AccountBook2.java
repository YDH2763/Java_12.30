package day08;
import java.util.Scanner;
public class Ex01_AccountBook2 {
	
	static Scanner number =new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 가계부에 필요한 클래스를 선언하세요.
		 * 메뉴
		 * 1.가계부 등록
		 * 2.가계부 수정
		 * 3.가계부 삭제
		 * 4.가계부 조회
		 * 5.종료
		 * */
		Scanner number = new Scanner(System.in);
		System.out.println("가계부의 크기를 입력하세요.");
		int n=number.nextInt();
		int c=0;
		Account [] list =new Account[n];
		for(int i=0;;i++) {
			printBar('-',10);
			printMenu("메뉴","가계부 추가","가계부 수정","가계부 삭제","가계부 조회","종료");
			char selection =number.next().charAt(0);
			printBar('-',10);
			runMenu(selection,  list,  c);
			printBar('-',10);
			if(selection=='5') {
				break;
			}
			
		}
	}
	
	public static void printBar(char bar, int count) {
		for(int i=1;i<=count;i++) {
			System.out.print(bar);
		}
		System.out.println();
	}
	
	public static void printMenu(String ...menus) {
		printBar('-',10);
		//메뉴가 없는 경우
		if(menus.length==0) {
			System.out.println("메뉴가 없습니다.");
			return;
		}
		//메뉴들을 숫자를 붙여서
		for(int i=0;i<menus.length;i++) {
			String menu=menus[i];
			System.out.println(i+1+"."+menu);
		}
		printBar('-',10);
		System.out.print("메뉴 선택:");
	}
	
	public static int runMenu(char menu, Account[] list, int c) {
		switch(menu) {
		case '1':
			list[c]= inputAccount();
			c++;
			break;
		case '2':
			updateListAccount(list, c);
			break;
			
		case '3':
			c=deleteItemList(list, c);
			break;
		case '4':
			if(c==0) {
				System.out.println("등록된 내역이 없습니다.");
				break;
			}
			//반복문을 이용하여 저장된 내역들을 숫자와 함께 출력.
			System.out.println("4.가계부 조회");
			System.out.println("다음 조회할 번호를 입력하세요.");
			int list0=number.nextInt();
			printAccount(list,c,list0);
			break;
		case '5':
			System.out.println("5.가계부 종료");
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
		return c;
	}
	
	private static void deleteAccount(Account[] list,int list3, int c) {
		// TODO Auto-generated method stub
		for(int j=list3+1;j<c;j++) {
			list[j-1]=list[j];
		}
	}

	private static void updateListAccount(Account[] list, int c) {
		
		if(!printAccount(list,c)) {
			return;
		}
		
			System.out.println("2.가계부 수정");
			for(int j=1;j<=c;j++) {
				list[j-1].print(j);
			}
			System.out.println("금엑을 수정할 번호를 선택하세요.");
			int list1=number.nextInt();
			checkIndex(list1, c);
			for(int j=1;j<=c;j++) {
				if(list1==j) {
					System.out.println("수정할 금엑을 입력하세요.");
					int list2=number.nextInt();
					list[j-1].money=list2;
					System.out.println("수정되었습니다.");
				}
			}
	}

	public static void printAccount(Account[] list, int c, int n) {
		for(int j=1;j<=c;j++) {
			if(n==j) {
				list[j-1].print(j);
			}
		}
	}
	
	public static Account inputAccount() {
		System.out.println("1.가계부 등록");
		System.out.print("수입/지출 : ");
		String income =number.next();
		System.out.print("분류 : ");
		String type =number.next();
		System.out.print("내용 : ");
		number.nextLine();
		String content=number.nextLine();
		System.out.print("금액 : ");
		int money =number.nextInt();
		System.out.print("일시 : ");
		String date =number.next();
		Account account =new Account(income, type,content, money, date);
		return account;
	}
	
	public static boolean printAccount(Account[] list, int c) {
		if(c==0 || list==null) {
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		
		return true;
	}
	public static boolean checkIndex(int index, int c) {
		return index>=0 && index<c;
	}
	
	public static int deleteItemList(Account[] list, int c) {
		printAccount(list, c);
		System.out.println("3.가계부 삭제");
		System.out.println("삭제할 번호를 선택하세요.");
		int list3=number.nextInt()-1;
		if(!checkIndex(list3, c)) {
			System.out.println("잘못입력하였습니다.");
			return c;
		}
		deleteAccount(list, list3, c);
		c--;
		return c;
	}
}
class Account{
	String income;
	String type;
	String content;
	int money;
	String date;
	
	public void print() {
		System.out.println(income+"/"+type+"/"+content+"/"+money+"/"+date);
	}
	
	public void print(int num) {
		System.out.print(num+". ");
		print();
	}
	
	public void setMoney(int money) {
		this.money=money;
	}

	public Account(String income, String type, String content, int money, String date) {
		this.income = income;
		this.type = type;
		this.content = content;
		this.money = money;
		this.date = date;
	}
	
	
}