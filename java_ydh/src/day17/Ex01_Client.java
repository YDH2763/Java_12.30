package day17;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.awt.PageAttributes.PrintQualityType;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Ex01_Client {
	static Scanner number=new Scanner(System.in);
	static List<Integer> ansure =new ArrayList<Integer>();
	static List<Score> list =new ArrayList<Score>();
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	
	static int st=0,ba=0,ou=0;
	public static void main(String[] args) {
		/*범위, 최댓값, 최솟값 입력*/
		int s;
		int count=0;
		final int finish=3;
		int port = 1111;
		Socket socket =null;
		String ip = "123.456.789.0";
		
		try {
			socket = new Socket(ip, port);
			System.out.println("게임 시작");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			
		}catch(Exception e) {
			System.out.println("[서버와 연결에 실패했습니다.]");
			System.out.println("게임 종료");
			
		}
		
		/*System.out.println("범위 : ");
		int num=number.nextInt();*/
		
		try {
			System.out.print("최솟값 :");
			int min=number.nextInt();
			System.out.print("최댓값 :");
			int max=number.nextInt();
			if(min > max || min<0 || max<0) {
				System.out.println("최솟값,최댓값중 둘중 하나를 잘못 입력하였습니다.");
			}
			List<Integer> quiz=new ArrayList<Integer>();
			HashSet<Integer> set= new HashSet<Integer>();
			while(set.size()<3) {
				int random=(int)(Math.random()*(max-min+1)+min);
				set.add(random);
			}
			quiz.addAll(set);
			oos.writeObject(quiz);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			/*정답 입력*/
			for(int i=0;;i++) {
				gameMenu();
				s=number.nextInt();
				number.nextLine();
				runGame(s);
				if(s==finish) {
					break;
				}
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void gameMenu() {
		System.out.println("--야구 게임--");
		System.out.println("1.게임 시작");
		System.out.println("2.게임 기록");
		System.out.println("3.게임 종료");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}

	private static void runGame(int s) {
		switch(s) {
		case 1:
			System.out.println("1.게임 시작");
			startGame(ois,oos);
			return;
		case 2:
			System.out.println("2.게임 기록");
			gameScore();
			return;
		case 3:
			System.out.println("3.게임 종료");
			System.out.println("게임을 종료합니다.");
			return;
		default:
			System.out.println("다시 입력해주세요.");
			return;
		}
		
	}

	private static void gameScore() {
		try {
			oos.writeObject(2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void startGame(ObjectInputStream ois2, ObjectOutputStream oos2) {
		insertAnsure();
		try {
			oos.writeObject(1);
			oos.writeObject(ansure);
			oos.flush();
			
			boolean result = ois.readBoolean();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void insertAnsure() {
		System.out.println(3+"개 만큼 입력하세요.");
		for(int i=0;i<3;i++) {
			System.out.print((i+1)+"번 답:");
			int n_ansure=number.nextInt();
			ansure.add(n_ansure);
		}
		
	}
}
