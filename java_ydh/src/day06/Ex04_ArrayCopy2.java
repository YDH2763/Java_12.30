package day06;
import java.util.Scanner;
public class Ex04_ArrayCopy2 {

	public static void main(String[] args) {
		// 깊은 복사와 얕은 복사를 비교하는 예제
		Scanner number=new Scanner(System.in);
		System.out.println("다음 배열의 크기를 입력하세요.");
		int n=number.nextInt();
		/*int []a=new int[n];
		int []b;*/
		Point[] points=new Point[n];
		for(int i=0;i<points.length;i++) {
			points[i]=new Point(i+1,i+1);
		}
		print(points);
		
		//System.arraycopy의 얕은 복사를 보여주는 예쩨
		Point [] points2=new Point[points.length];
		System.arraycopy(points, 0, points2, 0, points.length);
		
		System.out.println("---------------");
		points[0]=new Point(10,10);
		points[0].x=100;
		print(points2);
		
		//반복문을 이용하여 깊은 복사를 보여주는 예제
		Point [] points3=new Point[points2.length];
		for(int i=0;i<points2.length;i++) {
			points3[i]=new Point (points2[i]);
		}
		points2[0].x=100;
		
		System.out.println("---------------");
		print(points3);
		
		/*for(int i=0;i<=n-1;i++) {
			System.out.println((i+1)+"번째 열에 들어갈 수를 입력하세요.");
			int num=number.nextInt();
			a[i]=num;
		}
		
		b=new int [a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		int c[]=new int[b.length];*/
		
	}
	public static void print(Point[] n1) {
		for(int t=0;t<n1.length;t++) {
			n1[t].print();
		}
	}
}

class Point{
	int x, y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(Point p) {
		this(p.x,p.y);
		//x=p.x
		//y=p.y
	}
	
	public void print() {
		System.out.println("("+x+","+y+")");
	}
	
}