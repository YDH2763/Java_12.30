package day07;

public class Ex02_for {

	public static void main(String[] args) {
		int s=0;
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				s-=i;
			}
			else {
				s+=i;
			}
			if(i==10) {
				System.out.println("1부터 10까지 '홀수의 합'-'짝수의 합'="+s);
			}
		}

	}

}
