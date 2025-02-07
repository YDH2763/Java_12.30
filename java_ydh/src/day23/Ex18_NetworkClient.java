package day23;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex18_NetworkClient {

	public static void main(String[] args) {
		//port, ip를 설정
		//ip 설정시 내부 아이피로 설정하면 한 PC에서 테스트할 땐 동작되지만 여려 PC에서 테스트할 땐 안됨
		String ip="123.0.0.9";
		int port = 8888;
		
		try {
			//ip,port를 이용해서 소켓을 생성
			Socket socket =new Socket(ip,port);
			//데이터를 주고 받음
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("안녕");
			oos.flush();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//연결이 될때까지 대기, 연결이 되면 소켓을 생성
		
		//통신을 통해 데이터를 주고 받으면 됨
		
	}

}
