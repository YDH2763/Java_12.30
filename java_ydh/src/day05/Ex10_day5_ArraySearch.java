package day05;
import java.util.Scanner;
public class Ex10_day5_ArraySearch {

	public static void main(String[] args) {
		/* 다음 배열에 num이 있는지 없는지 판별하는 코드를 작성하세요.
		 * 
		 * */
		Scanner number =new Scanner(System.in);
		
		System.out.println("범위를 정할 두 정수를 입력하세요.");
		int a=number.nextInt();
		int b=number.nextInt();
		
		System.out.println("다음 범위내 숫자에서 뽑을 수를 입력하세요.");
		
		int c=number.nextInt();
		int []d=new int[c];
		
		System.out.print("다음 정수를 입력하세요. : ");
		int n= number.nextInt();
		
		ArraySearch(a,b,c,d,n);
		/*System.out.print("다음 정수를 입력하세요. : ");
		int n= number.nextInt();*/
		
		/*for(int i=0;i<=(c-1);i++) {
			int r=(int)(Math.random()*(b-a +1)+a);
			d[i]=r;
			System.out.println(d[i]);
			if(n==d[i]) {
				System.out.println((i+1)+"번째 열에 입력한 숫자와 같은 수가 있습니다.");
			}
			else {
				System.out.println((i+1)+"번째 열 숫자은(는) 입력한 숫자와 같지 않습니다.");	
				}
		}*/
		
	}
	/**/
		public static int [] ArraySearch(int n1, int n2,int n3, int n4[], int n5) {
			for(int i=0;i<=(n3-1);i++) {
				int r=(int)(Math.random()*(n2-n1 +1)+n1);
				n4[i]=r;
				System.out.println(n4[i]);
				if(n5==n4[i]) {
				System.out.println((i+1)+"번째 열에 입력한 숫자와 같은 수가 있습니다.");
				}
				else {
				System.out.println((i+1)+"번째 열 숫자은(는) 입력한 숫자와 같지 않습니다.");	
			}
			
		}
			return n4;
	}
}
