package day06;
import java.util.Arrays;
import java.util.Scanner;
public class Ex08_ReverseNumber_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner number=new Scanner(System.in);
		int []a=new int[4];
		System.out.println("다음 4자리 정수를 입력하세요.");
		int n=number.nextInt();
		//배열 없이 숫자 추출
		int t=n;
		if(!checkNumber(t,4)) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		while(t>0) {
			System.out.print(t%10+" ");
			t /= 10;
		}
		System.out.println("");
		System.out.println("-------------------");
		//배열로 숫자 추출
		int d=10;
		/*	int t=n;
		 * for(int i=0;i<a.length;i++){
		 * int ln =t/(int)pow(10,a.length-i-1);
		 * a[i]=ln;
		 * t=t%(int)pow(10,a.length-i-1);
		 * }
		 * */
		for(int i=0;i<4;i++) {
			a[i]=n%d;
			n=n/10;
		}
		System.out.println(Arrays.toString(a));
		
		int a1=0, a2=0;
		a1=a[2];
		a2=a[3];		
		a[3]=a[0];
		a[2]=a[1];
		a[1]=a1;
		a[0]=a2;
		System.out.println(Arrays.toString(a));
		
	}
	
	public static boolean checkNumber(int n3, int n4) {
		int min = 1*(int)Math.pow(10, n4-1);
		int max= 1*(int)Math.pow(10, n4);
		if(n3>=max || n3<min) {
			return false;
		}
		return true;
	}
	
	public static double pow(int n1, int n2) {
		if(n2==0) {
			return 1;
		}
		int res=1;
		if(n2>0) {
			for(int i=0;i<n2;i++) {
				res*=n1;
			}
			return res;
		}
		n2=-n2;
		for(int i=0;i<n2;i++) {
			res /=(double)n1;
		}
		return res;
	}

}

