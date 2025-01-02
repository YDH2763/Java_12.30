package day03;

public class Ex20_NestingAlphabet {

	public static void main(String[] args) {
		// 다음과 같이 출력되도록 코드를 작성하세요.
		/**
		 * a
		 * ab
		 * abc
		 * abcd
		 */
		char ch, lastch='a';
		for(lastch='a';lastch<='z';lastch++) {
			for(ch='a';ch<=lastch;ch++) {
				System.out.print(ch);
			}
			System.out.println("");
		}
		
		char a, b='a';
		for(b='a';b<='z';b++) {
			for(a='a';a<=b;a++) {
				System.out.print(a);
			}
			System.out.println();
		}

	}

}
