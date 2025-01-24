package day17;

import java.io.DataInput;
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
	/* 숫자 야구 게임을 구현하세요.
	 * 단, 기록은 서버에 통신을 이용하여 저장
	 * 기록은 YDH(영문 2다와 횟수를 기록)
	 * ex. YDH 3
	 * 기록이 같은 경우 먼저 등록된 순으로 순위를 출력*/
	static List<Score> list =new ArrayList<Score>();
	
	public static void main(String[] args) {
		List<Integer> quiz=new ArrayList<Integer>();
		
		try {
		int port = 1111;
		ServerSocket serverSocker=new ServerSocket(port);
		while(true) {
			Socket socket = serverSocker.accept();
			System.out.println("연결 성공!");
			
			ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
			
			while(true) {
				//메뉴를 입력 받음
				int s=ois.readInt();
				System.out.println(s);
				//입력받은 메뉴에 맞는 기능을 실행
				runGame(s, oos,ois);
				
			}
		}
	}catch(Exception e) {
		
	}

	}

	private static void runGame(int s, ObjectOutputStream oos, ObjectInputStream ois) {
		switch(s) {
		case 1:
			System.out.println("1.게임 시작");
			startGame(ois,oos);
			return;
		case 2:
			System.out.println("2.게임 기록");
			gameScore(ois,oos);
			return;
		
		default:
			System.out.println("다시 입력해주세요.");
			return;
		}
	}

	private static void startGame(ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated method stub
		
	}

	private static void gameScore(ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated method stub
		
	}

}
