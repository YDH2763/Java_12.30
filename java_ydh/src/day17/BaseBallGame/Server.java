package day17.BaseBallGame;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Server {
	
	private Socket socket;
	private List<Record> list;
	public void run() {
		Thread t=new Thread(()->{
			try{
				ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
				
				System.out.println("연결 성공!");
				
				while(true) {
					//메뉴를 입력 받음
					int s=ois.readInt();
					System.out.println(s);
					//입력받은 메뉴에 맞는 기능을 실행
					startMenu(s,oos,ois);
					
				}
			}catch(Exception e) {
				System.out.println("연결 해제");
			}
		});
		t.start();
	}
	
	private static void recordView(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			// 클라이언트에게 기록 리스트를 전송(최대 5개)
			List<Record> templist=list.subList(0,Math.min(5, list.size()));
			List<Record> sendlist=new ArrayList<Record>();
			sendlist.addAll(templist);
			oos.writeObject(sendlist);
			oos.flush();
			
		}catch(Exception e) {
			System.out.println("기록 조회시 예외 발생!");
		}
	}

}
