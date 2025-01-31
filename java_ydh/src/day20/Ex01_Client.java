package day20;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Ex01_Client {
	private static Scanner number = new Scanner(System.in);
	private static List<Product> product =new ArrayList<Product>();
	private static List<User> member  = new ArrayList<User>();
	private static int s1, s2;
	public static void main(String[] args) {
		int s;
		final int e=3;
		//관리자 샘플 데이터
		member.add(new User("관리자","admin","admin","관리자"));
		
		for(int i=0;;i++) {
			loginMenu();
			s=number.nextInt();
			number.nextLine();
			login(s);
			if(s==e) {
				break;
			}
		}

	}

	private static void loginMenu() {
		System.out.println("----메인 메뉴----");
		System.out.println("1.로그인");
		System.out.println("2.회원 가입");
		System.out.println("3.프로그램 종료");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void login(int s) {
		switch(s) {
		case 1:
			startLogin();
			break;
		case 2:
			Sign();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
		
	}

	private static void startLogin() {
		if(member.isEmpty()) {
			System.out.println("아직 관리자, 사용자가 없습니다.");
			return;
		}
		//로그인 기능
		//아이디,비번을 입력받음
		System.out.print("아이디 : ");
		String id=number.next();
		System.out.print("비밀번호 : ");
	    String pw=number.next();
	    //객체를 생성
	    User temp=new User("",id,pw,"");
	    //객체 정보와 일치하는 회원 정보(아이디,비밀번호)가 있는지 확인해서 있으면 회원정보를 가져옴
	    User temp1=getMember(member,temp);
	    if(temp1!=null) {
	    	String authority=temp.getAuthority();
	    	/*String authority = "사용자";
	    	if(id=="admin") {
	    		 authority = "관리자";
	    	}*/
			switch(authority) {
			case "사용자":
				user();
				break;
			case "관리자":
				manager();
				break;
			default:
				System.out.println("[로그인을 실패 했습니다.]");
			}
	    }
	    else {
	    	System.out.println("아이디 또는 비밀번호를 맞게 입력하지 않았습니다.");
	    	return;
	    }
	}

	private static User getMember(List<User> member, User temp) {
		if(member==null||member.isEmpty()) {
			return null;
		}
		if(temp==null) {
			return null;
		}
		int index=member.indexOf(temp);
		//아이디가 일치하지 않는 경우
		if(index<0) {
			return null;
		}
		User temp1=member.get(index);
		//비번이 일치하면
		if(temp1.getPassword().equals(temp.getPassword())) {
			return temp1;
		}
		//일치하지 않으면
		return null;
	}

	private static void manager() {
		do {
		managerMenu();
		s1=number.nextInt();
		number.nextLine();
		runManager(s1);
		}while(s1==5);
	}

	private static void runManager(int s1) {
		switch(s1) {
			case 1:
				insertProduct();
				break;
			case 2:
				updateProduct();
				break;
			case 3:
				deleteProduct();
				break;
			case 4:
				stockProduct();
				break;
			case 5:
				System.out.println("이전 화면으로 돌아갑니다.");
				break;
			default:
				System.out.println("다시 입력해주세요.");
				break;
		}
		
	}

	private static void insertProduct() {
		
		System.out.print("분류(문구, 의류, 식품, 가전, 기타) : ");
		String category=number.next();
		number.nextLine();
		System.out.print("제품이름 : ");
		String name=number.nextLine();
		System.out.print("옵션 : ");
		String option=number.nextLine();
		System.out.print("가격 : ");
		int price=number.nextInt();
		//제품 정보로 객체를 생성
		String codePrefix=Product.getCodePrefix(category);
		int max=getLastNum(product,codePrefix);
		Product pro=new Product(max,category,name,option,price);
		if(product.contains(pro)) {
			System.out.println("이미 등록된 제품입니다.");
			return;
		}
		product.add(pro);
		System.out.println("제품이 추가되었습니다.");
		System.out.println(product);
	}

	private static int getLastNum(List<Product> product, String codePrefix) {
		if(product==null||product.isEmpty()) {
			return-1;
		}
		int max=0;
		for(Product temp:product) {
			//ABC001에서 ABC는 prefix, 001은 suffix
			String productCodePrefix=temp.getCode().substring(0,3);
			String productCodeSubfix=temp.getCode().substring(3);
			if(productCodePrefix.equals(codePrefix)) {
				//"001"=>1로 변환
				int num=Integer.parseInt(productCodeSubfix);
				if(max<num) {
					max=num;
				}
			}
		}
		return max;
	}

	private static void updateProduct() {
		System.out.print("코드 : ");
		String code=number.next();
		Product temp=new Product(code,"","","",0,0);
		if(!getCode(product, temp)) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		int index=product.indexOf(temp);
		System.out.print("분류 : ");
		String newcategory=number.next();
		System.out.print("제품이름 : ");
		String newname=number.next();
		System.out.print("옵션 : ");
		String newoption=number.next();
		System.out.print("가격 : ");
		int newprice=number.nextInt();
		Product pro=new Product(code,newcategory,newname,newoption,newprice,0);
		product.remove(index);
		product.add(pro);
		System.out.println("수정 되었습니다.");
		
	}

	private static boolean getCode(List<Product> product, Product temp) {
		if(product==null||product.isEmpty()) {
			return false;
		}
		if(temp==null) {
			return false;
		}
		int index=product.indexOf(temp);
		if(index<0) {
			return false;
		}
		
		return true;
	}

	private static void deleteProduct() {
		System.out.print("코드 : ");
		String code=number.next();
		Product temp=new Product(code,"","","",0,0);
		if(!getCode(product, temp)) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		int index=product.indexOf(temp);
		product.remove(index);
		System.out.println("제품이 삭제되었습니다.");
		
	}

	private static void stockProduct() {
		System.out.print("코드 : ");
		String code=number.next();
		Product temp=new Product(code,"","","",0,0);
		if(!getCode(product, temp)) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		
		System.out.println("입고된 갯수를 입력하세요.");
		int stock=number.nextInt();
		if(stock<0) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		temp.setPrice(stock);
		
	}

	private static void managerMenu() {
		System.out.println("-관리자 메뉴-");
		System.out.println("1.재품 등록");
		System.out.println("2.재품 수정");
		System.out.println("3.재품 삭제");
		System.out.println("4.제품 입고");
		System.out.println("5.로그 아웃");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void user() {
		do {
		userMenu();
		s2=number.nextInt();
		number.nextLine();
		runUser(s2);
		}while(s2==2);
	}

	private static void runUser(int s2) {
		switch(s2) {
			case 1:
				checkProduct();
				break;
			case 2:
				System.out.println("이전 화면으로 돌아갑니다.");
				break;
			default:
				System.out.println("다시 입력해주세요.");
				break;
		}
		
	}

	private static void checkProduct() {
		System.out.println("제품을 조회합니다.");
		int s;
		for(int i=0;;i++) {
			printCheckMenu();
			s=number.nextInt();
			number.nextLine();
			runCheckMenu(s);
			if(s==7) {
				break;
			}
		}
		
	}

	private static void printCheckMenu() {
		System.out.println("-제품 조회-");
		System.out.println("1.문구 조회");
		System.out.println("2.의류 조회");
		System.out.println("3.식품 조회");
		System.out.println("4.가전 조회");
		System.out.println("5.기타 조회");
		System.out.println("6.전체 조회");
		System.out.println("7.이전 화면");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}

	private static void runCheckMenu(int s) {
		switch(s) {
		case 1,2,3,4,5:
			check(s);
			break;
		case 6:
			check();
			break;
		case 7:
			System.out.println("이전 화면으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못입력하였습니다.");
		}
		
	}

	private static void check() {
		//제품 목록 조회
		
		//제품을 선택
		
		//선택된 제품을 출력(예외 처리)
		int s;
		do {
			printCheckdetailMenu();
			s=number.nextInt();
			number.nextLine();
			runCheckdetailMenu(s);
		}while(s!=2);
		
	}

	private static void printCheckdetailMenu() {
		System.out.println("-----------");
		System.out.println("1.제품 구매");
		System.out.println("2.이전 화면");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runCheckdetailMenu(int s) {
		switch(s) {
		case 1:
			
			break;
		case 2:
			System.out.println("이전 화면으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못입력하였습니다.");
		}
	}

	private static void check(int categoryNum) {
		//제품 목록 조회
		
		//제품을 선택
				
		//선택된 제품을 출력(예외 처리)
		int s;
		do {
			printCheckdetailMenu();
			s=number.nextInt();
			number.nextLine();
			runCheckdetailMenu(s);
		}while(s!=2);
		
	}

	private static void userMenu() {
		System.out.println("-사용자 메뉴-");
		System.out.println("1.재품 조회");
		System.out.println("2.로그 아웃");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}

	private static void Sign() {
		//회원 가입 정보를 입력(아이디, 비번, 비번확인)
		System.out.print("이름 : ");
		String name =number.next();
		System.out.print("아이디 : ");
		String id=number.next();
		/*if(member.contains(name)&&member.contains(id)) {
			System.out.println("이미 존재하는 아이디 입니다.");
			return;
		}*/
		System.out.print("비밀번호 : ");
	    String pw=number.next();
		System.out.print("비밀번호 확인 : ");
		String pw1=number.next();
		//비번과 비번 확인이 일치하지 않으면 알림 후 종료
		if(!pw.equals(pw1)) {
			System.out.println("비밀번호가 같지 않습니다.");
			return;
		}
		//입력받은 정보를 이용하여 객체를 생성
		User user=new User(name,id,pw1,"사용자");
		if(member.contains(user)) {
			//있으면 알림
			System.out.println("이미 존재하는 아이디 입니다.");
			return;
		}
		//생성한 객체가 등록되었는지 확인 후 없으면 추가 후 알림
		member.add(user);
		System.out.println("회원가입이 완료되었습니다.");
		
	}

	

}
