package day10;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Collections;
import java.util.Comparator;

public class Ex10_Dictionary {
	
static Scanner number = new Scanner(System.in);
	public static void main(String[] args) {
		/*다음 기능을 갖는 프로그램을 작성하세요.
		 * -----------------
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 삭제
		 * 4. 단어 검색
		 * 5. 종료
		 * 메뉴 선택 : 1
		 * 단어 : apple
		 * 의미 : 사과, 회사명
		 * 단어가 등록되었습니다.
		 * ------------------
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 삭제
		 * 4. 단어 검색
		 * 5. 종료
		 * 메뉴 선택 : 1
		 * 단어 : apple
		 * 의미 : apple
		 * 이미 등록되었습니다.
		 * ------------------
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 삭제
		 * 4. 단어 검색
		 * 5. 종료
		 * 메뉴 선택 : 2
		 * 단어 : apple
		 * 의미 : 사과, 회사명(애플)
		 * 단어가 수정되었습니다.
		 * ------------------
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 삭제
		 * 4. 단어 검색
		 * 5. 종료
		 * 메뉴 선택 : 4
		 * 단어 : a
		 * apple:사과, 회사명(애플)
		 * ------------------
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 삭제
		 * 4. 단어 검색
		 * 5. 종료
		 * 메뉴 선택 : 3
		 * 단어 : apple
		 * 단어가 삭제되었습니다.
		 * ------------------
		 * */
		ArrayList<String> word = new ArrayList<String>();
		ArrayList<String> meaning = new ArrayList<String>();
		int c=0;
		for(int i=1;;i++) {
			System.out.println(c);
			System.out.println("1.단어 등록");
			System.out.println("2.단어 수정");
			System.out.println("3.단어 삭제");
			System.out.println("4.단어 조회");
			System.out.println("5.종료");
			System.out.print("메뉴 선택 : ");
			char s=number.next().charAt(0);
			
			switch(s) {
			case '1':
				System.out.println("1.단어 등록");
				System.out.println("단어를 입력하세요.");
				number.nextLine();
				String w=number.nextLine();
				System.out.println("단어의 의미를 입력하세요.");
				//number.nextLine();
				String m=number.nextLine();
				//Word wordobj = new Word(word, meaning);
				if(c>=1 && word.contains(w)) {
					System.out.println("이미 입력한 단어 입니다.");
					break;
				}
				word.add(w);
				meaning.add(m);
				c++;
				break;
			case '2':
				if(c==0) {
					System.out.println("아직 입력하지 않았습니다.");
					break;
				}
				System.out.println("2.단어 수정");
				System.out.println("수정할 단어를 입력하세요.");
				String rw=number.nextLine();
				if(word.contains(rw)) {
					int index=meaning.indexOf(rw);
					System.out.println("단어의 의미를 수정하세요.");
					String rm=number.nextLine();
					meaning.set(index,rm);
				}
				break;
			case '3':
				if(c==0) {
					System.out.println("아직 입력하지 않았습니다.");
					break;
				}
				System.out.println("3.단어 삭제");
				System.out.println("삭제할 단어를 입력하세요.");
				number.nextLine();
				String dw=number.nextLine();
				if(word.contains(dw)) {
					int dw1=word.indexOf(dw);
					int dw2=meaning.indexOf(dw);
					word.remove(dw1);
					meaning.remove(dw2);
					System.out.println("삭제하였습니다.");
				}
				break;
			case '4':
				if(c==0) {
					System.out.println("아직 입력하지 않았습니다.");
					break;
				}
				System.out.println("4.단어 조회");
				System.out.println("조회할 단어를 입력하세요.");
				number.nextLine();
				String sw=number.nextLine();
				if(word.contains(sw)) {
					int index = word.indexOf(sw);
					int index1 = meaning.indexOf(sw);
					System.out.println(word.get(index)+": "+meaning.get(index1));
				}
				else {
					System.out.println("아직 입력하지 않았습니다.");
				}
				break;
			case '5':
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("다시입력해주세요.");
				break;
			}
			
			if(s=='5') {
				break;
			}
		}
		
	}

}
@Data
@AllArgsConstructor
class Word{
	private String word, meaning;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	@Override
	public String toString() {
		return  word + ": " + meaning ;
	}

	public Word(ArrayList<String> word2, ArrayList<String> meaning2) {
		this.word=word;
		this.meaning=meaning;
	}

	

	
	
}
