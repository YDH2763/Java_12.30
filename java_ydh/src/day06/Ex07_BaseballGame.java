package day06;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Ex07_BaseballGame {

	public static void main(String[] args) {
		/* 1~9 숫자 야구 게임을 구현하세요.
		 * s:숫자가 있고, 위치가 같은 경우
		 * b:숫자는 있지만 위치가 다른경우
		 * o: 숫자는 있지만 위치가 다른경우
		 * 3o: 일치하는 숫자가 하나도 없는 경우
		 * 
		 * */
		//스트라이크 존 생성
		int a[]= new int[3];
		int sz1=1, sz2=9;
		creatRandomArray(sz1,sz2, a);
		System.out.println(Arrays.toString(a));
		
		int b[]= new int[3];	//입력한 수를 배치할 배열
		int s=0 ,ball=0;
		do {
			s=0;
			ball=0;
			b=new int[3];
			//정수 입력
			if(!inputNum(b)) {
				continue;
			}
			
			//판별
			//스트라이크 판별
			s=getStrike(a,b);
			//볼 판별
			ball=getBall(a,b);
			//스트라이크와 볼의 개수에 따라 출력
			printResult(s,ball);
			
		}while(s<3);
		System.out.println("프로그램을 종료합니다.");
		//입력할 숫자 입력
		/*for(int i=0;i<3;i++) {
			System.out.println("숫자를 입력하세요.");
			int num=number.nextInt();
			b[i]=num;
		}
		System.out.print("입력한 값 : ");
		for(int i=0;i<3;i++) {
			System.out.print(b[i]+", ");
		}
		System.out.println(" ");
		System.out.println("-----------");*/
		
		
		
		
	}
	
	private static boolean inputNum(int[] b) {
		// TODO Auto-generated method stub
		Scanner number=new Scanner(System.in);
		System.out.println("정수를 입력하세요.(1~9, 중복x)");
		boolean outOfbounds = false;
		boolean duplicated = false;
		for(int i=0;i<b.length;i++) {
			int t=number.nextInt();
			
			if(t<1||t>9) {
				System.out.println("범위를 벗어 났습니다.");
				outOfbounds = true;
			}
			if(contains(b,t)) {
				duplicated = true;
			}
			b[i]=t;
		}
		if(outOfbounds || duplicated) {
			System.out.println("범위를 벗어났거나 중복되었습니다.");
		}
		return !outOfbounds && !duplicated;
	}
	
	private static void printResult(int s, int ball) {
		if(s!=0) {
			System.out.println(s+"S");
		}
		if(ball !=0) {
			System.out.println(ball+"B");
		}
		if(s==0&&ball==0) {
			System.out.println("3O");
		}
		
	}
	
	private static int getBall(int[] a, int[] b) {
		int c=0;
		for(int t:a) {
			if(contains(b,t)) {
				c++;
			}
		}
		return c-getStrike(a,b);
	}
	
	public static boolean contains(int[] b, int num) {
		for(int t: b) {
			if(t==num) {
				return true;
			}
		}
		return false;
	}
	
	private static int getStrike(int[] a, int[] b) {
		int s=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==b[i]) {
				s++;
			}
		}
		return s;
	}
	public static int [] creatRandomArray(int n1, int n2, int n3) {
		if(n2<n1) {
			int t =n2;
			n2=n1;
			n1=t;
		}
		if(n2-n1+1<n3) {
			return null;
		}
		if(n3<=0) {
			return null;
		}
		int c=0;
		int []arr=new int[n3];
		do {
			int r=(int)(Math.random()*(n2-n1+1)+n1);
			if(!contains(arr,r)) {
				arr[c++]=r;
			}
		}while(c<3);
		return arr;
		
	}
}
