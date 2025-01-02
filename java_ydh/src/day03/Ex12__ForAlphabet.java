package day03;

public class Ex12__ForAlphabet {

	public static void main(String[] args) {
		// a부터 z까지 출력하는 코드를 작성하세요.
		
		char ch='a';
		int c=1;
		for(int i=0;;i++, c++) {
			System.out.println("count : " +c);
			System.out.println(ch+" ");
			if(ch=='z') {
				break;
			}
			ch++;
		}
		ch='a';
		for(int i=1;;i++) {
			System.out.println(i+"회");
			System.out.println(ch+" ");
				if(ch=='z') {
					break;
			}
			ch++;
		}

	}

}
