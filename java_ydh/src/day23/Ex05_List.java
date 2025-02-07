package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;

public class Ex05_List {
	
	private static Scanner number=new Scanner(System.in);
	private static List<Point> list =new ArrayList<Point>();
	
	public static void main(String[] args) {
		
		
		System.out.print("x값 : ");
		int x = number.nextInt();
		System.out.print("y값 : ");
		int y = number.nextInt();
		//생성자가 없음, 생성자를 추가
		list.add(new Point(x,y));
		list.add(new Point(x));
		
		//리스트에 추가하려면 Point 클래스의 객체가 와야하는데 정수가 와서 안됨
		//Point 클래스의 객체로 변환하거나 삭제
		//list.add(x);
		
		/*리스트에 좌표의 점과 문자열, 정수를 함께 관리하려 한다. 이때 필요한 리스트를 선언하세요.
		 * */
		List<Object> list =new ArrayList<Object>();
		list.add(new Point());
		list.add("안녕");
		list.add(x);

	}

}

@Data
class Point{
	
	int x,y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public Point(int x) {
		this.x=x;
	}

	public Point() {
		// TODO Auto-generated constructor stub
	}
	
	
}