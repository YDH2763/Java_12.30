package Ex18.Bank2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientProgram {
	private Scanner number;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket socket;
	private Type type;
	
	public ClientProgram(Socket socket) {
		this.socket=socket;
		this.number=new Scanner(System.in);
		
		if(socket ==null) {
			return;
		}
		try {
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
		}catch(Exception e) {
			
		}
	}
	public void run() {
		
		if(socket==null||ois==null||oos==null) {
			System.out.println("서버 연결에 실패했습니다.");
			return;
		}
		
		int s;
		do {
			printmenu();
			
			s=number.nextInt();	
			number.nextLine();
			
			runMenu(s);
		}while(s!=3);
	}
	private void printmenu() {
		System.out.println("-은행 계좌 관리 프로그램-");
		System.out.println("1.계좌 조회");
		System.out.println("2.계좌 개설");
		System.out.println("3.프로그램 종료");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
	}
	private void runMenu(int s) {
		switch(s) {
		case 1:
			System.out.println("1.계좌 조회");
			login();
			break;
		case 2:
			System.out.println("2.계좌 개설");
			open();
			break;
		case 3:
			System.out.println("3.프로그램 종료");
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
	}
	private void login() {
		Account account =inputAccount();
		System.out.println("접속중입니다.");
		System.out.println("같은 계정으로 다른 사용자가 먼저 사용중이면 대기할 수 있습니다.");
		Account account2=null;
		
		try {
			//서버와 통신해서 account가 일치하는지 확인 => 서버에게 account와 일치하는지 계좌 정보를 달라고 요청
			oos.writeInt(0);
			oos.writeObject(account);
			oos.flush();
			
			account2 = (Account)ois.readObject();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//일치하지않으면 안내문구 후 종료
		if(account2 ==null) {
			System.out.println("계좌 정보가 잘못 되었습니다.");
			return;
		}
		
		System.out.println("계좌에 접속했습니다.");
		int s=0;
		do {
			try {
				printLoginMenu();
				
				s=number.nextInt();
				//서버에 메뉴를 전송
				number.nextLine();
				oos.writeInt(s);
				
				runLoginMenu(s, account2);
			}catch(InputMismatchException e) {
				System.out.println("메뉴는 숫자입니다.");
				number.nextLine();
			}catch(Exception e) {
				
			}
		}while(s!=4);
		
	}
	private Account inputAccount() {
		String bankName;
		//올바른 은행을 선택하기 전까지 계속 진행
		do{
			Bank.printBanks();
			System.out.println();
			System.out.println("은행의 이름을 입력하세요.");
			bankName=number.nextLine();
		}while(Bank.check(bankName));
		System.out.println("이름을 입력하세요.");
		String name=number.nextLine();
		System.out.println("계좌번호를 입력하세요.");
		String num=number.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		String pw=number.nextLine();
		return new Account(Bank.valueOf(bankName),num,name,pw);
	}
	private void printLoginMenu() {
		// TODO Auto-generated method stub
		
	}
	private void runLoginMenu(int s, Account account) {
		switch(s) {
		case 1:
			System.out.println("1.입금");
			//deposit(account);
			depositAndwithdrawal(type.입금, account);
			break;
		case 2:
			System.out.println("2.출금");
			//withdrawal(account);
			depositAndwithdrawal(type.출금, account);
			break;
		case 3:
			System.out.println("3.조회");
			check(account);
			break;
		case 4:
			System.out.println("4.이전 화면");
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
		
	}
	private void depositAndwithdrawal(Type type2, Account account) {
		System.out.println("입출금할 금액을 입력하세요.");
		long money =number.nextLong();
		number.nextLine();
		try {
			int s=Type.입금==type? 2:3;
			oos.writeInt(s);
			oos.writeLong(money);
			oos.writeObject(account);
			oos.flush();
			//결과를 입력받아 알림
			long result=ois.readLong();
			if(result>=0) {
				System.out.println(type+"했습니다.");
				System.out.println("잔액 : "+result+"원");
			}
			else {
				System.out.println(type+"에 실패했습니다.");
			}
		}catch(Exception e) {
			System.out.println(type+" 전송중 예외 발생");
			e.printStackTrace();
		}
		
	}
	private void deposit(Account account) {
		// 예금액을 입력
		System.out.println("예금할 금액을 입력하세요.");
		long money =number.nextLong();
		number.nextLine();
		
		//예금의 예외 처리
		if(money<=0) {
			System.out.println("0원 보다 큰 금액을 예금하세요.");
			return;
		}
		//메뉴, 예금액과 계정 정보를 서버에 전송
		try {
			oos.writeInt(2);
			oos.writeLong(money);
			oos.writeObject(account);
			oos.flush();
			//결과를 입력받아 알림
			long result=ois.readLong();
			if(result>=0) {
				System.out.println("예금했습니다.");
				System.out.println("잔액 : "+result+"원");
			}
			else {
				System.out.println("예금에 실패했습니다.");
			}
		}catch(Exception e) {
			System.out.println("예금 전송중 예외 발생");
			e.printStackTrace();
		}
		
	}
	private void withdrawal(Account account) {
		//출금액을 입력
		System.out.println("출금할 금액을 입력하세요.");
		long money =number.nextLong();
		number.nextLine();
				
		//출금의 예외 처리
		if(money<=0) {
			System.out.println("0원 보다 큰 금액을 출금하세요.");
			return;
			}
		//메뉴, 출금액과 계정 정보를 서버에 전송
		try {
			int s=3;
			oos.writeInt(s);
			oos.writeLong(money);
			oos.writeObject(account);
			oos.flush();
			//결과를 입력받아 알림
			long result=ois.readLong();
			if(result>=0) {
				System.out.println("출금했습니다.");
				System.out.println("잔액 : "+result+"원");
			}
			else {
				System.out.println("출금에 실패했습니다.");
			}
		}catch(Exception e) {
			System.out.println("출금 전송중 예외 발생");
			e.printStackTrace();
		}
		
	}
	private void check(Account account) {
		try {
		// 메뉴와 계좌 정보를 서버에 전송
		int s=4;
		oos.writeInt(s);
		oos.writeObject(account);
		oos.flush();
		//계좌 정보를 받아옴
		Account receiveaccount =(Account)ois.readObject();
		
		if(receiveaccount==null) {
			//말이 안되는 상황
			System.out.println("계좌 정보가 없습니다.");
		}
		else {
			receiveaccount.print();
		}
		//계좌 정보를 출력
		}catch(Exception e) {
			System.out.println("조회 중예외가 발생했습니다.");
			e.printStackTrace();
		}
		
	}
	private void open() {
		Account account=inputAccount();
		System.out.println("비밀번호를 확인하세요.");
		String pw1=number.nextLine();
		
		
		if(!account.getPw().equals(pw1)) {
			System.out.println("확인용 비밀번호가 일치하지 않습니다.");
			return;
		}
		
		
		try {
			//메뉴 번호 도 같이 서버에게 계좌 정보를 전송
			oos.writeInt(0);
			oos.writeObject(account);
			//서버에게 결과를 받아 알림을 출력
			if(ois.readBoolean()) {
				System.out.println("[계좌를 등록햇습니다.]");
			}
			else {
				System.out.println("[계좌 등록에 실패했습니다.]");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
