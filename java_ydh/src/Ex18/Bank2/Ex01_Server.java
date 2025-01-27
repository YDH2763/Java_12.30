package Ex18.Bank2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Ex01_Server {

	public static void main(String[] args) {
		
		int port = 5003;
		ServerSocket serversocket;
		
		try{
			serversocket=new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("[예외가 발생하여 서버가 종료됩니다.]");
			e.printStackTrace();
			return;
		} 
		
		List<Account> list =new ArrayList<Account>();
		String fileName="src/Ex18.Bank2/data.txt";
		list=(List<Account>) load(fileName);
		if(list==null) {
			list = new ArrayList<Account>();
		}
		
		while(true){
			save(fileName,list);
			//클라이언트와 연결
			Socket socket ;
			
			try {
				socket = serversocket.accept();
				System.out.println("[클라이언트와 연결되었습니다.]");
			} catch (IOException e) {
				System.out.println("[예외가 발생하여 클라이언트와 연결을 종료합니다.]");
				e.printStackTrace();
				continue;
			}
			
			//서버를 실행
			Server server =new Server(socket, list);
			server.run();
		}

	}
	
	private static List<Account> load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				
				return (List<Account>) ois.readObject();
				
			} catch (Exception e) {
				System.out.println("-----------------");
				System.out.println("불러오기 실패");
				System.out.println("-----------------");
			}
			return null;
	}

	private static void save(String fileName, List<Account> postlist) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(fileName);
				
			} catch (Exception e) {
				System.out.println("-----------------");
				System.out.println("저장하기 실패");
				System.out.println("-----------------");
			}
	}
}
