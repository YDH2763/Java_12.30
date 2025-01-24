package day17.BaseBallGame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex01_Client {
	
	private static Scanner number=new Scanner(System.in);
	//private  static ObjectInputStream ois;
	//private static ObjectOutputStream oos;
	public static void main(String[] args) {
		
		int s;
		//서버와 연결
		int port = 1000;
		Socket socket ;
		String ip = "192.0.0.10";
		ObjectInputStream ois;
		ObjectOutputStream oos;
		try {
			socket = new Socket(ip, port);
			System.out.println("게임 시작");
			//IO스트림 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		}catch(Exception e) {
			System.out.println("게임 시작 실패");
			System.out.println("프로그램 종료");
			return;
		}
		
		for(int i=0;;i++) {
			
			selectGame();
			
			s=number.nextInt();
			//생성한 IO스트림을 넘겨줌
			try {
				oos.writeInt(s);
			}catch(IOException e) {
				e.printStackTrace();
			}
			startGame(s,ois,oos);
			
			if(s==3) {
				break;
			}
		}
	}
	
	private static void selectGame() {
		System.out.println("--야구 게임--");
		System.out.println("1.게임 시작");
		System.out.println("2.게임 기록");
		System.out.println("3.게임 종료");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}

	private static void startGame(int s, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(s) {
		case 1:
			System.out.println("게임을 시작합니다.");
			play(ois,oos);
			break;
		case 2:
			recordView(ois,oos);
			break;
		case 3:
			System.out.println("게임 종료");
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;
		}
		
	}

	private static void play(ObjectInputStream ois,ObjectOutputStream oos) {
		//랜덤 리스트 생성
		List<Integer> nums =randomList(1,9,3);
		Record r=playGame(nums);
		//서버에 전송
		sendRecord(r,ois,oos);
		
	}

	private static void sendRecord(Record r,ObjectInputStream ois,ObjectOutputStream oos) {
		
		
		try {
		//메뉴를 전송
			oos.writeInt(1);	
		//기록을 전송
			oos.writeObject(r);
			oos.flush();	
		//서버에게 결과를 확인받고 실패한 경우 알림
			boolean resolt=ois.readBoolean();
			if(!resolt) {
				System.out.println("기록되지 않았습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static List<Integer> randomList(int min, int max, int size) {
		List<Integer> list =new ArrayList<Integer>();
		Set<Integer> set =new HashSet<Integer>();
		
		while(set.size() < size) {
			set.add(random(min,max));
		}
		list.addAll(set);
		Collections.shuffle(list);
		System.out.println(list);
		return list;
	}

	private static void recordView(ObjectInputStream ois,ObjectOutputStream oos) {
		
		
		try {
		// 메뉴를 서버에 전송
			oos.writeInt(2);
			oos.flush();
		//전송받은 기록 리스트를 받아옴
			List<Record> list =(List<Record>)ois.readObject();
			showRecord(list);
			oos.writeObject(list);
		//받아온 기록 리스트를 출력
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	private static boolean showRecord(List<Record> list) {
		if(list==null||list.size()==0) {
			System.out.println("아직 기록이 없습니다.");
			return false;
		}
		for(int i=0;i<5;i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
		return true;
	}

	public static Record playGame(List<Integer> nums) {
		int strike, ball;
		List<Integer> user=new ArrayList<Integer>();
		int count=0;
		do {
			user.clear();
			System.out.println("입력");
			
			//사용자가 중복되지 않게 입력했다고 가정
			while(user.size()<3) {
				user.add(number.nextInt());
			}
			++count;
			
			strike=getStrike(nums,user);
			
			ball=getBall(nums,user);
			
			printResult(strike,ball);
			
		}while(strike<3);
		
		System.out.print("이니셜 입력(최대 3자) : ");
		String nickName=number.next();
		
		return new Record(count,nickName);
	}
	
	private static int getStrike(List<Integer> nums, List<Integer> user) {
		int count=0;
		//이중 반복문을 이용하여 ball의 개수를 확인
		/*for(int i=0;i<nums.size();i++) {
			for(int j=0;j<user.size();j++) {
				if(i!=j&&nums.get(i)==user.get(j)) {
					count++;
				}
			}
		}*/
		
		
		for(int i=0;i<nums.size();i++) {
			if(nums.get(i)==user.get(i)) {
				count++;
			}
		}
		
		return count;
	}

	private static int getBall(List<Integer> nums, List<Integer> user) {
		int count=0;
		
		for(int num:nums) {
			if(user.contains(num)) {
				count++;
			}
		}
		
		return count-getStrike(nums,user);
	}

	private static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.println(strike+"S");
		}
		if(ball != 0) {
			System.out.println(ball+"B");
		}
		if(strike == 0 && ball == 0) {
			System.out.println("O");
		}
		System.out.println();
	}

	private static int random(int min, int max) {
		if(max<min) {
			int temp=min;
			min=max;
			max=temp;
		}
		return (int)Math.random()*(max-min+1)+min;
	}
}
