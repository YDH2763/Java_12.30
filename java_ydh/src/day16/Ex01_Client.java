package day16;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.awt.PageAttributes.PrintQualityType;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Ex01_Client {
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
			try {
				oos.writeInt(s);
			}catch(IOException e) {
				e.printStackTrace();
			}
			startManu(s,ois,oos);
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

	private static void startManu(int s, ObjectInputStream ois, ObjectOutputStream oos ) {
		switch(s) {
		case 1:
			System.out.println("게시글을 등록합니다.");
			insertPost(ois,oos);
			return;
		case 2:
			System.out.println("게시글을 수정합니다.");
			updatePost(ois,oos);
			return;
		case 3:
			System.out.println("게시글을 삭제합니다.");
			deletePost(ois,oos);
			return;
		case 4:
			System.out.println("게시글을 조회합니다.");
			searchPost(ois,oos);
			return;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			return;
		}
	}

	private static void insertPost( ObjectInputStream ois, ObjectOutputStream oos) {
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
			else {
				System.out.println("게시글 등록 실패하였습니다.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		/*postlist.add(post);
		System.out.println("게시글이 작성되엇습니다.");*/
		
	}

	private static Post writePost() {
		Post writer =inputWriter();
		System.out.println("제목을 입력하세요.");
		String title =number.nextLine();
		System.out.println("내용을 입력하세요.");
		String content =number.nextLine();
		writer.setTitle(title);
		writer.setContent(content);
		return writer;
	}

	private static Post inputWriter() {
		System.out.println("작성자를 입력하세요.");
		String writer =number.next();
		return new Post("",writer,"");
	}

	private static void updatePost( ObjectInputStream ois, ObjectOutputStream oos) {
		
		try {
			//게시글 번호를 입력
			int num=number.nextInt();
			Post writer =writePost();
			writer.setNum(num);
			//수정할 제목, 내용을 입력하여 객체 생성
			//객체에 게시글 번호를 입력받은 번호로 수정
			
			//수정할 내용을 전송
			oos.writeObject(writer);
			oos.flush();
			//서버에서 결과를 받아서 알림
			boolean resolt =ois.readBoolean();
			if(resolt) {
				System.out.println("다음 게시글을 수정했습니다.");
			}
			else {
				System.out.println("다음 게시글을 수정하지 못했습니다.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void deletePost( ObjectInputStream ois, ObjectOutputStream oos) {
		try {
		// 삭제할 게시글 번호를 입력
			int num=number.nextInt();
			number.nextLine();
			
		//서버에 번호를 전송
			oos.writeObject(num);
			oos.flush();
		//서버에서 보낸 결과를 이용하여 알림
			boolean resolt =ois.readBoolean();
			if(resolt) {
				System.out.println("다음 게시글을 삭제했습니다.");
			}
			else {
				System.out.println("다음 게시글을 삭제하지 못했습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void searchPost( ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//서버에게 전체 게시글을 요청
			List<Post> list=(List<Post>)ois.readObject();
			if(!printList(list)) {
				return;
			}
			//조회할 게시글 번호를 입력
			System.out.println("조회할 번호를 입력하세요.");
			int num=number.nextInt();
			number.nextLine();
			
			//서버에게 게시글 번호를 전송
			oos.writeObject(num);
			oos.flush();
			//서버에게 게시글을 받아서 출력
			Post post=(Post)ois.readObject();
			if(post==null) {
				System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			}
			else {
				post.print();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static boolean printList(List<Post> list) {
		if(list==null||list.size()==0) {
			System.out.println("등록된 게시글이 없습니다.");
			return false;
		}
		for(Post postlist:list) {
			postlist.print();
		}
		return true;
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
