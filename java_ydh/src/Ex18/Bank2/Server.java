package Ex18.Bank2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Server {
	
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket socket;
	private List<Account> list;
	
	public Server(Socket socket, List<Account> list) {
		this.socket=socket;
		this.list=list;
		
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
		if(socket==null||ois==null||oos==null||list==null) {
			return;
		}
		Thread t= new Thread(()->{
			
		
		//메뉴를 수신
		int s=0;
		try {
			do {
			s=ois.readInt();
			//메뉴에 따라 기능을 실행
			runMenu(s);
			}while(s!=5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		});
		t.start();
	}

	private void runMenu(int s) {
		switch(s) {
		case 0:
			login();
			break;
		case 1://계좌 개설
			open();
			break;
		case 2://입금
			//deposit();
			depositAndWithdrawal(Type.입금);
			break;
		case 3://출금
			//withdrawal();
			depositAndWithdrawal(Type.입금);
			break;
		case 4://조회
			check();
			break;
		default:
			
			break;
			
		}
	}

	private void login() {
		try {
			//클라이언트가 보낸 계좌 정보를 가져옴
			Account account =(Account)ois.readObject();
			int index=list.indexOf(account);
			Account sendAccount=null;
			
			if(index<=0) {
				sendAccount=(Account)list.get(index).clone();
			}
			oos.writeObject(sendAccount);
			oos.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void open() {
		try {
			// 계좌정보를 클라이언트에게 받아옴
			Account account=(Account)ois.readObject();
			boolean res=false;
			//있는지 확인해서 없으면 추가
			if(list.contains(account)) {
				res=true;
			}
			//추가여부를 클라이언트에게 전송
			oos.writeBoolean(res);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void deposit() {
		try {
			// 계좌 정보와 예금을 클라이언트에게 전달 받음
			long money=ois.readLong();
			Account account=(Account)ois.readObject();
			
			long result =-1;
			
			int index =list.indexOf(account);
			//계좌 정보가 있는지 확인, //계좌 정보가 있는지 확인
			if(money<=0) {
				
				//클라이언트에게 결과를 전송
				oos.writeLong(index);
				oos.flush();
				return;
				
			}
			//계좌에 예금을 추가하여, 입출금 내역이 추가되도록 함.
			Account temp= list.get(index);
			synchronized(temp) {
			result = temp.deposit(money) ? temp.getMoney() : -1;
			
			//클라이언트에게 결과를 전송
			oos.writeLong(result);
			oos.flush();
			Thread.sleep(500);
			}
			
			
		}catch(Exception e) {
			System.out.println("입금하는중에 예외가 발생했습니다.");
			e.printStackTrace();
		}
	}

	private void withdrawal() {
		try {
			// 계좌 정보와 예금을 클라이언트에게 전달 받음
			long money=ois.readLong();
			Account account=(Account)ois.readObject();
			
			long result =-1;
			
			int index =list.indexOf(account);
			//계좌 정보가 있는지 확인, //계좌 정보가 있는지 확인
			if(money<=0) {
				
				//클라이언트에게 결과를 전송
				oos.writeLong(index);
				oos.flush();
				return;
				
			}
			//계좌에 출금을 추가하여, 입출금 내역이 추가되도록 함.
			Account temp= list.get(index);
			synchronized(temp) {
			result = temp.withdrawal(money) ? temp.getMoney() : -1;
			
			//클라이언트에게 결과를 전송
			oos.writeLong(result);
			oos.flush();
			Thread.sleep(500);
			}
			
			
		}catch(Exception e) {
			System.out.println("출금하는중에 예외가 발생했습니다.");
			e.printStackTrace();
		}
	}

	private void check() {
		try {
		//계좌 정보를 클라이언트에게 받아옴
		Account account =(Account)ois.readObject();
		//받아온 계좌와 일치하는 계좌의 복사본을 생성해서 전송
		int index=list.indexOf(account);
		Account temp=null;
		if(index>=0) {
			temp=(Account)list.get(index).clone();
		}
		oos.writeObject(temp);
		oos.flush();
		}catch(Exception e) {
			System.out.println("조회 중 예외가 발생했습니다.");
			e.printStackTrace();
		}
		
	}
	

}
