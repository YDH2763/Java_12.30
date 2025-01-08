package day07;
import java.util.Scanner;
public class Ex06_AccountBook {
	
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
			System.out.println("-----------------");
			System.out.println("메뉴");
			System.out.println("1.가계부 등록");
			System.out.println("2.가계부 수정");
			System.out.println("3.가계부 삭제");
			System.out.println("4.가계부 조회");
			System.out.println("5.가계부 종료");
			System.out.println("-----------------");
			System.out.print("메뉴 선택:");
			char selection =number.next().charAt(0);
			System.out.println("-----------------");
			switch(selection) {
			case '1':
				//내역 정보들을 입력
				System.out.println("1.가계부 등록");
				System.out.print("수입/지출 : ");
				String income =number.next();
				System.out.print("분류 : ");
				String type =number.next();
				System.out.print("내용 : ");
				number.nextLine();//next()에서 입력한 엔터를 처리
				String content=number.nextLine();
				System.out.print("금액 : ");
				int money =number.nextInt();
				System.out.print("일시 : ");
				String date =number.next();
				//내역 리스트에 추가
				list[c]= new Account(income, type,content, money, date);
				c++;
				break;
			case '2':
				System.out.println("2.가계부 수정");
				for(int j=0;j<c;j++) {
					list[j-1].print(j);
				}
				System.out.println("금엑을 수정할 번호를 선택하세요.");
				int list1=number.nextInt();
				for(int j=1;j<=c;j++) {
					if(list1==j) {
						System.out.println("수정할 금엑을 입력하세요.");
						int list2=number.nextInt();
						list[j-1].money=list2;
					}
				}
				break;
			case '3':
				System.out.println("3.가계부 삭제");
				
				break;
			case '4':
				//반복문을 이용하여 저장된 내역들을 숫자와 함께 출력.
				System.out.println("4.가계부 조회");
				System.out.println("다음 조회할 번호를 입력하세요.");
				int list0=number.nextInt();
				for(int j=1;j<=n;j++) {
					if(list0==j) {
						list[j-1].print(j);
					}
				}
				break;
			case '5':
				System.out.println("5.가계부 종료");
				break;
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
			System.out.println("-----------------");
			if(selection=='5') {
				break;
			}
			
		}
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