package day16;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Ex01_Client2 {
	private static Scanner number = new Scanner(System.in);
	static List<Post> postlist=new ArrayList<Post>();
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	
	public static void main(String[] args) {
		/*day14/Ex01_Post 예제를 활용하여 게시글 관리 프로그램을 작성하세요.
		 * 단, 네트워크 통신을 이용하여 서버와 클라이언트로 동작하는 프로그램을 작성하세요.
		 * */
		int s;
		final int exit = 5;
		int port = 1010;
		Socket socket =null;
		String ip = "192.168.35.5";
		Scanner number = new Scanner(System.in);
		
		try {
			socket = new Socket(ip, port);
			System.out.println("[프로그램을 시작합니다.]");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		}catch(Exception e) {
			System.out.println("[서버와 연결에 실패했습니다.]");
			System.out.println("[프로그램을 종료합니다.]");
			
		}
		
		for(int i=0;;i++) {
			try {
			theMenu();
			s=inputInt(true);
			startManu(s,socket);
			if(s==exit) {
				break;
			}
			}catch(MenuException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요.");
			}
		}

	}
	
	private static int inputInt() {
		String str = number.nextLine();
		try {
			return Integer.parseInt(str);
		}catch(NumberFormatException e) {
			throw new InputMismatchException();
		}
	}
	
	private static int inputInt(boolean isMenu) {
		try {
			return inputInt();
		}catch(NumberFormatException e) {
			if(isMenu) {
				throw new MenuException();
			}
			throw new InputMismatchException();
		}
	}

	private static void theMenu() {
		System.out.println("------------");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.게시글 조회");
		System.out.println("5.프로그램 종료");
		System.out.println("------------");
		System.out.println("메뉴 입력 : ");
	}

	private static void startManu(int s, Socket socket) {
		switch(s) {
		case 1:
			System.out.println("게시글을 등록합니다.");
			insertPost(socket);
			return;
		case 2:
			System.out.println("게시글을 수정합니다.");
			updatePost(socket);
			return;
		case 3:
			System.out.println("게시글을 삭제합니다.");
			deletePost(socket);
			return;
		case 4:
			System.out.println("게시글을 조회합니다.");
			searchPost(socket);
			return;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			return;
		}
	}

	private static void insertPost(Socket socket) {
		Post writer =writePost();
		
		try {
			oos.writeObject(1);
			oos.writeObject(writer);
			oos.flush();
			boolean result =ois.readBoolean();
			if(result) {
				System.out.println("게시글이 작성되엇습니다.");
				return;
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("게시글 등록 실패하였습니다.");
		/*postlist.add(post);
		System.out.println("게시글이 작성되엇습니다.");*/
		
	}

	private static Post writePost(boolean isWriter) {
		System.out.println("제목을 입력하세요.");
		String title =number.nextLine();
		System.out.println("내용을 입력하세요.");
		String content =number.nextLine();
		String writer ="";
		if(isWriter) {
			System.out.println("작성자를 입력하세요.");
			writer = number.next();
		}
		return isWriter;
	}

	

	private static void updatePost(Socket socket) {
		// TODO Auto-generated method stub
		
	}

	private static void deletePost(Socket socket) {
		// TODO Auto-generated method stub
		
	}

	private static void searchPost(Socket socket) {
		// TODO Auto-generated method stub
		
	}

}
class MenuException extends RuntimeException{
	
	public MenuException(String message) {
		super(message);
	}
	public MenuException() {
		super("올바른 메뉴가 아닙니다.");
	}
}
