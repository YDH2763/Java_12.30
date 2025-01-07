package day06;
import java.util.Scanner;
public class Ex03_ArrayCopy {

	public static void main(String[] args) {
		Scanner number=new Scanner(System.in);
		System.out.println("다음 배열의 크기를 입력하세요.");
		int n=number.nextInt();
		int []a=new int[n];
		int []b;
		
		for(int i=0;i<=n-1;i++) {
			System.out.println((i+1)+"번째 열에 들어갈 수를 입력하세요.");
			int num=number.nextInt();
			a[i]=num;
		}
		
		System.out.print("배열a에 배치된 수:");
		print(a);
		System.out.println(" ");
		
		b=new int [a.length];
		for(int i=0;i<n;i++) {
			b[i]=a[i];
		}
		
		System.out.print("배열b에 배치된 수:");
		print(b);
		System.out.println(" ");
		
		System.out.print("배열c에 배치된 수:");
		int c[]=new int[b.length];
		System.arraycopy(b, 0, c, 0, b.length);
		print(c);
		
		//c에 0번지부터 2개 복사해서 d에2번지부터 2개 덮어씀
		int d[]=new int[c.length];
		System.arraycopy(c, 0, d, 2, 2);
	}
	public static void print(int []n1) {
		for(int i=0;i<n1.length;i++) {
			System.out.print(n1[i]+" ");
		}
		System.out.println();
	}
}
