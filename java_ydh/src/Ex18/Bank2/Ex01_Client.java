package Ex18.Bank2;

import java.net.Socket;

public class Ex01_Client {

	public static void main(String[] args) {
		//서버와 소켓으로 연결:실패시 프로그램 종료

		String ip="127.0.0.1";
		int port=5003;
		
		try(Socket socket=new Socket(ip,port);) {
			System.out.println("[서버와 연결되었습니다.]");
			//프로그램 구현
			ClientProgram program=new ClientProgram(socket);
			program.run();
			
		}catch(Exception e) {
			System.out.println("서버와 연결 되지 않아 프로그램을 종료합니다.");
			e.printStackTrace();
			
		}
		
		
		
	}

}
