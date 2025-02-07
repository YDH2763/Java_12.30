package day23;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex18_NetworkServer {

	public static void main(String[] args) {

		//port를 설정
		int port = 8888;
		try {
			//port를 이용해서 서버 소켓
			ServerSocket serversocket=new ServerSocket(port);
			//연결이 될때까지 대기, 연결이 되면 소켓을 생성
			Socket socket=serversocket.accept();
			System.out.println("연결 완료");
			//통신을 통해 데이터를 주고 받으면 됨
			ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
			String str=ois.readUTF();
			System.out.println("전송 받은 문자열 : " +str);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}

}
