package day22;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordNoteUserProgram implements ConsoleProgram {
	
	private Scanner scan;
	private WordsManager wm;
	private MyWordManager mm;
	private String id;

	public WordNoteUserProgram(Scanner scan, List<Word> words, Map<String, List<Word>> myWords, String id) {
		this.scan=scan;
		this.wm=new WordsManager(words);
		this.mm=new MyWordManager(myWords);
		this.id=id;
	}

	@Override
	public void run() {
		int s;
		final int e=3;
		
		wm.print();
		
		do {
			printMenu();
			
			s=scan.nextInt();
			scan.nextLine();
			
			runMenu(s);
			
			
		}while(s!=e);
	}

	@Override
	public void printMenu() {
		System.out.println("----------------");
		System.out.println("1. 단어 검색");
		System.out.println("2. 내 검색 단어 보기");
		System.out.println("3. 종료");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void runMenu(int s) {
		switch(s) {
		case 1:
			search();
			break;
		case 2:
			printMyWords();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("다시 입력하세요.");
			break;
		}
	}

	private void search() {
		System.out.println("단어를 입력하세요.");
		System.out.print("단어 : ");
		String word=scan.nextLine();
		
		List<Word> templist=wm.getWordList(word);
		
		
		if(templist.isEmpty()) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		
		wm.print(templist);
		
		System.out.println("번호를 입력하세요.");
		int index=scan.nextInt()-1;
		scan.nextLine();
		
		if(index<0||index>=templist.size()) {
			System.out.println("잘못 선택했습니다.");
			return;
		}
		
		System.out.println("--------------");
		System.out.println(templist.get(index));
		System.out.println("--------------");
		
		mm.add(id,templist.get(index));
		
	}

	

	private void printMyWords() {
		mm.print(id);
		
	}

}
