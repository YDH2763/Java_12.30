package day16;

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
	private static List<Post> postlist=new ArrayList<Post>();
	public static void main(String[] args) {
		String fileName="src/day16/postData.txt";
		//postlist = (List<Post>) load(fileName);
		if(postlist==null) {
			postlist=new ArrayList<Post>();
		}
		
		int port = 1010;
		
		try {
			ServerSocket serverSocker =new ServerSocket(port);
			
			while(true) {
				Socket socket = serverSocker.accept();
				System.out.println("연결 성공!");
				ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
				
				while(true) {
					//메뉴를 입력 받음
					int s=ois.readInt();
					//입력받은 메뉴에 맞는 기능을 실행
					startMenu(s, oos,ois);
					
				}
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//save(fileName,postlist);
		}
	}

	private static void startMenu(int s, ObjectOutputStream oos, ObjectInputStream ois) {
		switch(s) {
		case 1:
			System.out.println("게시글을 등록합니다.");
			insertPost(oos,ois);
			return;
		case 2:
			System.out.println("게시글을 수정합니다.");
			updatePost(oos,ois);
			return;
		case 3:
			System.out.println("게시글을 삭제합니다.");
			deletePost(oos,ois);
			return;
		case 4:
			System.out.println("게시글을 조회합니다.");
			searchPost(oos,ois);
			return;
		case 5:
			System.out.println("잘못된 메뉴를 클라이언트가 전송했습니다.");
			return;
		}
	}

	private static void insertPost(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			//게시글 정보를 받음
			Post writer=(Post)ois.readObject();
			//게시글을 등록
			boolean result =true;
			postlist.add(writer);
			//결과를 보냄
			oos.writeBoolean(result);
			oos.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void updatePost(ObjectOutputStream oos, ObjectInputStream ois) {
		try{
		//수정할 객체를 클라이언트에서 받음
		Post writer =(Post)ois.readObject();
		int index =postlist.indexOf(writer);
		boolean resolt =true;
		//객체가 없으면 false를
		if(index <0) {
			resolt=false;
		}
		//있으면 객체를 수정하고 true를 전송
		
		else {
			postlist.get(index).setTitle(writer.getTitle());
			postlist.get(index).setTitle(writer.getContent());
		}
		oos.writeBoolean(resolt);
		oos.flush();
		System.out.println(postlist);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	private static void deletePost(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			// 클라이언트가 보내준 게시글 번호를 받아옴
			int num=ois.readInt();
			//받아온 번호로 객체를 생성
			//삭제를 하고 결과를 클라이언트에게 전송
			oos.writeBoolean(postlist.remove(new Post(num)));
			oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void searchPost(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			//전체 게시글을 클라이언트에게 전송
			oos.writeObject(postlist);
			oos.flush();
			//게시글 번호를 입력
			int num=ois.readInt();
			
			//게시글을 클라이언트에게 전송
			int index =postlist.indexOf(new Post(num));
			Post post =null;
			
			if(index<0) {
				post=postlist.get(index);
			}
			oos.writeObject(post);
			oos.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static List<Post> load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				
				return (List<Post>) ois.readObject();
				
			} catch (Exception e) {
				System.out.println("-----------------");
				System.out.println("불러오기 실패");
				System.out.println("-----------------");
			}
			return null;
	}

	private static void save(String fileName, List<Post> postlist) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(fileName);
				
			} catch (Exception e) {
				System.out.println("-----------------");
				System.out.println("저장하기 실패");
				System.out.println("-----------------");
			}
	}

}
