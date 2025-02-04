package day22;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordsManager {
	
	private List<Word> list;

	public boolean insert(Word word) {
		if(word ==null || word.getWord()==null || word.getPartsOfSpeech()==null || word.getMeaning()==null) {
			return false;
		}
		//품사 체크
		switch(word.getPartsOfSpeech()) {
		case "명사","대명사","동사","형용사","부사","전치사","접속사","관계사":
			break;
		default:
			return false;
		}
		//단어, 뜻 체크
		if(word.getWord().trim().isEmpty() ||
				word.getMeaning().trim().isEmpty()) {
			return false;
		}
		//완전하게 동일한 단어가 있는 경우
		if(list.contains(word)) {
			return false;
		}
		list.add(word);
		return true;
	}

	

	public List<Word> getWordList(String word) {
		
		return list.stream().filter(w->w.getWord().equals(word))
					.collect(Collectors.toList());
	}



	public void print(List<Word> templist) {
		
		if(templist==null||templist.isEmpty()){
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+". "+templist.get(i));
		}
		
	}



	public boolean update(Word word, Word wordObj) {
		if(word==null||wordObj==null) {
			return false;
		}
		word.update(wordObj);
		return true;
	}



	public boolean delete(Word word) {
		return list.remove(word);
	}



	public void print() {
		System.out.println(list);
		
	}
	public void sort() {
		
		list.sort((o1,o2)->{
				return o1.getWord().compareTo(o2.getWord());
		});
	}



	public void print(String word) {
		List<Word> templist=list.stream()
								.filter(w->w.getWord()
								.contains(word))
								.collect(Collectors.toList());
		if(templist.isEmpty()) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		templist.stream().forEach(w->System.out.println(w));
	}

}
