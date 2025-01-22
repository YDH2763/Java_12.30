package day14;

import java.util.Scanner;

import day16.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Ex01_Post {
	/* 게시글 프로그램을 위한 클래스를 선언하세요.
	 * 게시글 등록
	 * -제목, 내용, 작성자를 입력
	 * 게시글 수정
	 * -게시글 수정
	 * -게시글 번호를 선택
	 * -제목, 내용을 수정
	 * 게시글 삭제
	 * -게시글 번호를 선택해서 삭제
	 * 게시글 조회
	 * -게시글 번호를 이용하여 조회하고 조회수 1증가*/
	static Scanner number =new Scanner(System.in);
	static List<Post> postlist =new ArrayList<Post>();
	static String The_File="src/day14/PostDataName.txt";
	public static void main(String[] args) {
		postlist=(ArrayList<Post>) load_The_File(The_File);
	
		if(postlist==null) {
			postlist=new ArrayList<Post>();
		}
		
		int s=0;
		final int exit = 5;
		for(int i=0;;i++) {
			
			System.out.println(postlist);
			
			printMenu();
			s=number.nextInt();
			number.nextLine();
			runMenu(s);
			if(s==exit) {
				save_The_File(postlist,The_File);
				break;
			}
		}
		

	}

	private static Object load_The_File(String the_File) {
		
		try(FileInputStream fis = new FileInputStream(the_File);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
				 return ois.readObject();
				
				 
					
				} catch (Exception e) {
					System.out.println("[불러오기 실패]");
				}
		
		return null;
	}

	private static void save_The_File(List<Post> postlist, String the_File) {

		try(FileOutputStream fos = new FileOutputStream(the_File);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
			oos.writeObject(postlist);
				
		} catch (Exception e) {
				System.out.println("[저장하기 실패]");
		}
		return;
		
		
	}

	private static void printMenu() {
		System.out.println("------------");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.게시글 조회");
		System.out.println("5.프로그램 종료");
		System.out.println("------------");
		System.out.println("메뉴 입력 : ");
		
	}

	private static void runMenu(int s) {
		switch(s) {
		case 1:
			System.out.println("게시글을 등록합니다.");
			insertPost();
			return;
		case 2:
			System.out.println("게시글을 수정합니다.");
			updatePost();
			return;
		case 3:
			System.out.println("게시글을 삭제합니다.");
			deletePost();
			return;
		case 4:
			System.out.println("게시글을 조회합니다.");
			searchPost();
			return;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
	}

	private static void insertPost() {
		Post post =writePost();
		
		postlist.add(post);
		System.out.println("게시글 작성이 완료되었습니다.");
		
	}

	private static Post writePost() {
		System.out.println("제목을 입력하세요.");
		String title =number.nextLine();
		System.out.println("작성자를 입력하세요.");
		String writer =number.nextLine();
		System.out.println("내용을 입력하세요.");
		String content =number.nextLine();
		return new Post(title,writer,content);
	}

	private static void updatePost() {
		System.out.println("수정할 게시글의 작성자를 입력하세요.");
		String name =number.nextLine();
		/*if(!postlist.contains(name)) {
			System.out.println(name+"님이 등록한 게시글이 없습니다.");
			return ;
		}*/
		List<Post> templist = searchWriter(name);
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+". "+templist.get(i));
		}
		
		System.out.println("다음 작성자 게시물 중 수정할 게시물을 고르세요.");
		System.out.print("번호 : ");
		int sn =number.nextInt()-1;
		number.nextLine();
		Post p=templist.get(sn);
		
		System.out.println("제목을 입력하세요.");
		String newtitle =number.nextLine();
		System.out.println("내용을 입력하세요.");
		String newcontent =number.nextLine();
		
		p.update(newtitle,name,newcontent);
		System.out.println("게시글이 수정되었습니다.");
		return;
		
	}


	private static List<Post> searchWriter(String name) {
		List<Post> templist =new ArrayList<Post>();
		for(Post p : postlist) {
			if(p.getWriter().contains(name)) {
				templist.add(p);
			}
		}
		return templist;
	}

	private static void deletePost() {
		System.out.println("삭제할 게시글의 작성자를 입력하세요.");
		String name =number.nextLine();
		if(!postlist.equals(name)) {
			System.out.println(name+"님이 등록한 게시글이 없습니다.");
			return ;
		}
		List<Post> templist = searchWriter(name);
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+". "+templist.get(i));
		}
		
		System.out.println("다음 작성자 게시물 중 삭제할 게시물을 고르세요.");
		System.out.print("번호 : ");
		int dn =number.nextInt()-1;
		number.nextLine();
		Post p=templist.get(dn);
		
		postlist.remove(dn);
		System.out.println("게시물이 삭제 되었습니다.");
		return;
		
	}

	private static void searchPost() {
		System.out.println("작성자를 입력하세요.");
		String name =number.nextLine();
		if(!postlist.equals(name)) {
			System.out.println(name+"님이 등록한 게시글이 없습니다.");
			return ;
		}
		List<Post> templist = searchWriter(name);
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+". "+templist.get(i));
		}
		System.out.println("조회할 게시물의 번호를 선택해주세요.");
		System.out.print("번호 : ");
		int search =number.nextInt()-1;
		number.nextLine();
		Post p= templist.get(search);
		System.out.println(p);
		return;
	}

}

@Data
@AllArgsConstructor
class Post implements Serializable{
	
	private static final long serialVersionUID = 7950467669298764591L;
	
	private static int count;
	private int num;
	private String title, content, writer;
	private Date date;
	private int view;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		Post other = (Post) obj;
		return num == other.num;
	}

	public void view() {
		view++;
	}

	public Post(String title, String content, String writer) {
		num = ++count;
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
	}
	
	public Post(int num) {
		this.num = num;
	}

	public void print() {
		System.out.println("------------------------");
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + getDateStr() );
		System.out.println("조회수 : " + view);
		System.out.println("------------------------");
	}

	private String getDateStr() {
		//Date -> String
		//yyyy-MM-dd HH:mm:ss
		SimpleDateFormat format = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Post.count = count;
	}
}
