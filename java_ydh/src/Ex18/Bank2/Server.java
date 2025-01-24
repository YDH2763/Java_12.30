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
			deposit();
			break;
		case 3://출금
			withdrawal();
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
		// TODO Auto-generated method stub
		
	}

	private void withdrawal() {
		// TODO Auto-generated method stub
		
	}

	private void check() {
		// TODO Auto-generated method stub
		
	}
	

}
