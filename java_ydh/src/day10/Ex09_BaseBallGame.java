package day10;
import java.util.Scanner;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Ex09_BaseBallGame {
	static Scanner number = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*숫자 야구 게임을 구현하세요.*/
		int st=0, ba=0, ou=0;
		
		System.out.println("배열의 최대 개수를 설정해주세요.");
		int n =number.nextInt();
		System.out.println("범위를 입력하세요.");
		System.out.print("최솟값 : ");
		int a =number.nextInt();
		System.out.print("최댓값 : ");
		int b =number.nextInt();
		
		ArrayList<Integer> quiz =new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size()<n) {
			int r=(int)(Math.random()*(b-a+1)+a);
			set.add(r);
		}
		quiz.addAll(set);
		//System.out.println(quiz);
		
		ArrayList<Integer> ansure =new ArrayList<Integer>();
		System.out.println("수를"+n+"개 만큼 입력하세요.");
		for(int i=1;i<=n;i++) {
			//ansure.clear();
			int n1=number.nextInt();
			ansure.add(n1);
			if(ansure.get(i-1)==quiz.get(i-1)) {
				st++;
			}
			else if(quiz.contains(ansure.get(i-1))) {
				ba++;
			}
			else {
				ou++;
			}
		}
		System.out.println("Q : "+quiz);
		System.out.println("A : "+ansure);
		if(st>=n) {
			System.out.println("3Strike Out!");
		}
		else {
			System.out.println(st+"strike "+ba+"ball "+ou+"hit");
		}
		
	}

}
