package day02;
import java.util.Scanner;
public class Ex12_SwitchEvenNumber {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		
		int n1;
		n1=n.nextInt();
		
		switch(n1%2) {
			case 0 :
				System.out.println(n1+"은 짝수");
				break;
			case 1 :
				System.out.println(n1+"은 홀수");
				break;
		}
	}

}
