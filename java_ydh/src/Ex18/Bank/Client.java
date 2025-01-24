package Ex18.Bank;

import java.util.Scanner;
import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
	/* 은행 계좌 관리 프로그램
	 * -접속
	 * 	-은행.계좌번호,비밀번호
	 * -계좌 개설
	 * 	-은행,이름,계좌번호,비밀번호,비밀번호 확인
	 * -종료
	 * 
	 * -예금조회
	 * -입금
	 * -출금
	 * -이전
	 * 
	 * 주의사항
	 * -한 계좌에 여러명이 동시에 접근하는 경우 먼저 접근한 사람이 사용하도록 처리
	 * */
	private static Scanner number=new Scanner(System.in);
	private static List<BankBook> bankbook =new ArrayList<BankBook>();
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	
	public static void main(String[] args) {
		Socket socket=null;
		String ip= "987.654.321.0";
		int port=5555;
		int s;
		final int Exit=3;
		
		
		try {
			socket = new Socket(ip, port);
			System.out.println("연결 완료");
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		}catch(Exception e) {
			System.out.println("연결 실패");
		}
		
		
		
		for(int i=0;;i++) {
			System.out.println(bankbook);
			BankProgramMenu();
			s=number.nextInt();
			number.nextLine();
			try {
				oos.writeInt(s);
			}catch(Exception e) {
				e.printStackTrace();
			}
			BankProgram(s,ois,oos);
			
			if(s==Exit) {
				break;
			}
		}
		
	}
	private static void BankProgramMenu() {
		System.out.println("-은행 계좌 관리 프로그램-");
		System.out.println("1.계좌 개설");
		System.out.println("2.계좌 조회");
		System.out.println("3.프로그램 종료");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
	}
	private static void BankProgram(int s, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(s) {
		case 1:
			System.out.println("1.계좌 개설");
			insertBankBook(ois,oos);
			break;
		case 2:
			System.out.println("2.계좌 조회");
			lookBankBook(ois,oos);
			break;
		case 3:
			System.out.println("3.프로그램 종료");
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
		
	}
	private static void insertBankBook(ObjectInputStream ois, ObjectOutputStream oos) {
		BankBook customer =inputacountNumber();
		bankbook.add(customer);
		int index=bankbook.indexOf(customer);
		if(customer==null) {
			bankbook.remove(index);
			System.out.println("메인화면으로 돌아갑니다.");
			return;
		}
		try {
			oos.writeInt(1);
			oos.writeObject(customer);
			oos.flush();
			boolean result=ois.readBoolean();
			if(!result) {
				System.out.println("기록 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("기록되었습니다.");
	}
	private static BankBook inputacountNumber() {
		System.out.print("은행 : ");
		String bank=number.next();
		System.out.print("이름 : ");
		String constomer=number.next();
		System.out.print("계좌 번호 : ");
		String accountNumber=number.nextLine();
		number.nextLine();
		System.out.print("비밀번호 : ");
		int password=number.nextInt();
		System.out.print("비밀번호 확인 : ");
		int password1=number.nextInt();
		if(password!=password1) {
			System.out.println("비밀번호가 같지 않습니다.");
			return null;
		}
		if(bankbook.contains(bank)&&bankbook.contains(accountNumber)) {
			System.out.println("이미 등록된 계좌번호 입니다.");
		}
		return new BankBook(bank,constomer,accountNumber,password,0);
		
	}
	private static void lookBankBook(ObjectInputStream ois, ObjectOutputStream oos) {
		
		ArrayList<BankBook> temp=inspectAccount();
		
		try {
			oos.writeInt(2);
			oos.writeObject(temp);
			oos.flush();
			boolean result=ois.readBoolean();
			if(!result) {
				System.out.println("기록된 정보가 없습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(temp);
		for(int i=0;;i++) {
			inquiry();
			int s1=number.nextInt();
			number.nextLine();
			
			try {
				oos.writeInt(s1);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			runInquiry(s1,ois,oos);
			if(s1==4) {
				return;
			}
		}
	}
	
	private static void runInquiry(int s1, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(s1) {
		case 1:
			System.out.println("1.예금조회");
			ArrayList<BankBook> temp=inspectAccount();
			System.out.println(temp);
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("입금");
			System.out.println("입금하실 금액을 입력하세요.");
			int money=number.nextInt();
			number.nextLine();
			
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}

			break;
		case 3:
			System.out.println("출금");
			System.out.println("출금하실 금액을 입력하세요.");
			int outmoney=number.nextInt();
			number.nextLine();
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("이전화면으로 돌아갑니다.");
			break;
		default:
			break;
		}
		
	}
	private static void inquiry() {
		System.out.println("-계좌 조회-");
		System.out.println("1.예금조회");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.이전");
		System.out.println("---------");
		System.out.print("메뉴 선택 : ");
		
	}
	private static ArrayList<BankBook> inspectAccount() {
		ArrayList<BankBook> temp=new ArrayList<BankBook>();
		System.out.print("은행 : ");
		String bank=number.next();
		number.nextLine();
		System.out.print("계좌 번호 : ");
		String accountNumber=number.nextLine();
		number.nextLine();
		if(bankbook.contains(bank)&&bankbook.contains(accountNumber)) {
			System.out.println("비밀번호를 입력하세요.");
			System.out.print("비밀번호 : ");
			int password=number.nextInt();
			if(!bankbook.contains(password)) {
				System.out.println("비밀번호가 틀립니다.");
				return null;
			}
			for(BankBook ban:bankbook) {
				if(ban.getBank().contains(bank)&&ban.getAccountNumber().contains(accountNumber)&&
						ban.getPassword()==password) {
					temp.add(ban);
				}
			}
			return temp;
		}
		else {
			System.out.println("계좌가 존재하지 않습니다.");
			return null;
		}
	}

}
