package Ex18.Bank;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
	private static List<BankBook> bankbook= new ArrayList<BankBook>();
	public static void main(String[] args) {
		
		int port=5555;
		String fileName ="src/day18.Bank/bankbook.txt";
		try {
			ServerSocket serversocket = new ServerSocket(port);
			while(true) {
				Socket socket =serversocket.accept();
				Thread t=new Thread(()->{
					try {
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						System.out.println("연결 성공");
						
						while(true) {
							int s=ois.readInt();
							System.out.println(s);
							BankProgram(s,ois,oos);
						}
					}catch(Exception e) {
						System.out.println("연결 해제");
					}
				});
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

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
		default:
			break;
		}
	}

	private static void insertBankBook(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			BankBook customer=(BankBook)ois.readObject();
			
			boolean result=bankbook.add(customer);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void lookBankBook(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			BankBook customer=(BankBook)ois.readObject();
			boolean result=bankbook.add(customer);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
