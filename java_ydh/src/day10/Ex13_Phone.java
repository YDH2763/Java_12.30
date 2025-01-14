package day10;
import java.util.Scanner;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;


public class Ex13_Phone {

	private static final PhoneNumber pn = null;
	static Scanner number=new Scanner(System.in);
	static ArrayList<PhoneNumber> list= new ArrayList<PhoneNumber>();
	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성하세요.
		 * 1.전화번호 추가
		 * 	-이름과 전화번호를 입력받아 추가
		 * 	-동명이인이 있을 수 있기 때문에 중복되도 추가
		 * 2.전화번호 수정
		 * 	-이름을 입력
		 * 	-이름과 일치하는 목록을 출력
		 *  -수정하려는 전화번호를 선택
		 *  -새 전화번호를 입력받아 수정
		 * 3.전화번호 삭제
		 *  -이름을 입력
		 * 	-이름과 일치하는 목록을 출력
		 *  -삭제하려는 전화번호를 선택
		 *  -선택한 전화번호를 삭제
		 * 4.전화번호 조회
		 *  -이름을 입력
		 *  -이름이 포함된 전화번호를 출력
		 * 5.프로그램 종료
		 * 메뉴 선택 : */
		//ArrayList<String> name =new ArrayList<String>();
		//ArrayList<String> phonenum =new ArrayList<String>();
		//HashMap<String,String> user =new HashMap<String,String>();
		
		for(int i=1;;i++) {
			
			printMenu();
			char s =number.next().charAt(0);
			number.nextLine();
			
			runMenu(s);
			
			if(s=='5') {
				break;
			}
		}
	}

	private static void printMenu() {
		System.out.println("1.전화번호 추가");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 조회");
		System.out.println("5.프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runMenu(char s ) {
		switch(s) {
		case'1':
			insertName();
			return;
		
		case'2':
			renamaPhoneNumber();
			return;
			
		case'3':
			deletePhoneNumber();
			return;
		case'4':
			searchPhoneNumber();
			return;
			
		case'5':
			System.out.println("5.프로그램 종료");
			return;
		default:
			System.out.println("잘못 입력하였습니다.");
			return;
	
	}
	}

	private static void renamaPhoneNumber() {
		System.out.println("2.전화번호 수정");
		System.out.println("수정할 사람을 입력하세요.");
		String rn=number.nextLine();
		
		ArrayList<PhoneNumber> tmpList =searchPhoneNumberList(rn);
		for(int i=0;i<tmpList.size();i++) {
			System.out.println(i+1+"."+tmpList.get(i));
		}
		System.out.println("수정할 번호를 입력하세요.");
		int index =number.nextInt()-1;
		number.nextLine();
		
		PhoneNumber pn=tmpList.get(index);
		
		System.out.print("이름을 입력하세요.: ");
		String nn=number.nextLine();
		System.out.print("전화번호를 입력하세요.: ");
		String np=number.nextLine();
		
		pn.update(nn,np);
		System.out.println("수정이 완료 되었습니다.");
		return;
	}
	
	

	private static void deletePhoneNumber() {
		System.out.println("3.전화번호 삭제");
		System.out.println("삭제할 사람을 입력하세요.");
		String dn=number.nextLine();
		
		ArrayList<PhoneNumber> tmpList =searchPhoneNumberList(dn);
		for(int i=0;i<tmpList.size();i++) {
			System.out.println(i+1+"."+tmpList.get(i));
		}
		
		if(!printPhoneNumberList(tmpList, true)) {
			return;
		}
		
		System.out.println("삭제할 번호를 입력하세요.");
		int index1 =number.nextInt()-1;
		number.nextLine();
		
		PhoneNumber pn=tmpList.get(index1);
		list.remove(pn);
		System.out.println("삭제되었습니다.");
		
		return;
		
	}

	private static void searchPhoneNumber() {
		System.out.println("4.전화번호 조회");
		System.out.println("이름을 입력하세요.");
		String sn=number.nextLine();
		ArrayList<PhoneNumber> pList=searchPhoneNumberList(sn);
		printPhoneNumberList(pList,false);
		
		/*for(PhoneNumber pn : list) {
			if(pn.getName().contains(sn)) {
				System.out.println(pn.getPhoneNumber());
			}
		}*/
		return;
		
	}

	private static void insertName() {
		System.out.println("1.전화번호 추가");
		System.out.print("이름을 입력하세요.: ");
		
		String n=number.nextLine();
		System.out.print("전화번호를 입력하세요.: ");
		String p=number.nextLine();
		String regex ="^\\d{2,3}(-?\\d{4}){2}$";
		if(!Pattern.matches(regex, p)) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		PhoneNumber pn =new PhoneNumber(n, p);
		list.add(pn);
		System.out.println("전화번호를 등록하였습니다.");
		return;
	}

	private static ArrayList<PhoneNumber> searchPhoneNumberList(String name) {

		ArrayList<PhoneNumber> tmpList = new ArrayList<PhoneNumber>();
		
		for(PhoneNumber pn : list) {
			if(pn.getName().contains(name)) {
				tmpList.add(pn);
			}
		}
		
		return tmpList;
	}
	
	private static boolean printPhoneNumberList(ArrayList<PhoneNumber>pList, boolean isNumber) {
		if(pList==null||pList.size()==0) {
			System.out.println("결과가 없습니다.");
			return false;
		}
		for(int i=0;i<pList.size();i++) {
			if(isNumber) {
				System.out.print(i+1+".");
			}
			System.out.println(pList.get(i));
		}
		return true;
		
	}

}
@Getter
@Setter
@Data
@AllArgsConstructor
class PhoneNumber{
	private String name;
	private String phoneNumber;
	
	
	@Override
	public String toString() {
		return name+":"+phoneNumber;
	}


	public void update(String nn, String np) {
		this.name=nn;
		this.phoneNumber=np;
		
	}
	
	
}
