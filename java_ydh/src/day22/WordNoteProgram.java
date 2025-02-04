package day22;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class WordNoteProgram implements ConsoleProgram {
	
	private Scanner scan = new Scanner(System.in);
	private String id;
	private List<Word> words;
	private Map<String, List<Word>> myWords;
	
	public void run(){
		
		
		
		String wordFileName="src/day22/words.txt";
		String myWordFileName="src/day22/myWords.txt";
		
		//불러오기
		words=(List<Word>) load(wordFileName);
		myWords=(Map<String,List<Word>>)load(myWordFileName);
		//불러오기 실패 처리
				if(words == null) {
					words = new ArrayList<Word>();
				}
				if(myWords == null) {
					myWords = new HashMap<String, List<Word>>();
				}
				
				System.out.println(words);
				System.out.println(myWords);
				
				//아이디 입력
				System.out.print("아이디 : ");
				id = scan.next();

				if("admin".equals(id)) {
					WordNoteAdminProgram adminProgram = new WordNoteAdminProgram(scan,words);
					adminProgram.run();
				}else {
					WordNoteUserProgram userProgram = new WordNoteUserProgram(scan,words,myWords,id);
					userProgram.run();
				}
				
				//저장하기
				save(wordFileName,words);
				save(myWordFileName,myWords);
	}

}
