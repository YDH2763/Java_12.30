package day17.BaseBallGame;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class Ex01_Server {
	private static List<Record> list=new ArrayList<Record>();
	public static void main(String[] args) {
		int port = 1000;
		String fileName="src/day17/record.txt";
		try {
			ServerSocket serverSocker =new ServerSocket(port);
		
			while(true) {
				Socket socket = serverSocker.accept();
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
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void startMenu(int s, ObjectOutputStream oos, ObjectInputStream ois) {
		switch(s) {
		case 1:
			System.out.println("게임을 시작합니다.");
			playRecord(oos,ois);
			break;
		case 2:
			recordView(oos,ois);
			break;
		case 3:
			System.out.println("게임 종료");
			break;
		}
		
	}
	private static void playRecord(ObjectOutputStream oos, ObjectInputStream ois) {
		try{
			// 기록을 수신(클라이언트)
			Record r=(Record)ois.readObject();
			// 기록을 추가
			
			boolean result=list.add(r);
			// 기록을 정렬
			Collections.sort(list,(o1,o2)->{
				Record r1=(Record)o1;
				Record r2=(Record)o2;
				if(r1.getCount() != r2.getCount()) {
					return r1.getCount()-r2.getCount();
				}
				if(!r1.getDate().equals(r2.getDate())) {
					return r1.getDate().compareTo(r2.getNickName());
				}
				return r1.getNickName().compareTo(r2.getNickName());
			});
			System.out.println(list);
			//클라이언트에게 결과를 전달
			oos.writeBoolean(result);
			oos.flush();
			
		}catch(Exception e) {
			System.out.println("기록 추가시 예외 발생!");
		}
	}
	private static void recordSort() {
		list.sort((o1,o2)->o1.getCount()-o2.getCount());
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
