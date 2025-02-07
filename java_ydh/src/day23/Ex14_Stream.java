package day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex14_Stream {

	public static void main(String[] args) {
		List<String> list=Arrays.asList("안녕","이병건","주호민","테스트","이말년");
		/*문자열에 길동이 포함된 문자열을 출력하는 코드를 작성하세요.*/
		String str="이";
		for(String temp:list) {
			if(temp.contains(str)) {
				System.out.println(temp);
			}
		}
		/*스트림을 이용하여 문자열에 길동이 포함된 문자열을 출력하는 코드를 작성하세요.*/
		System.out.println("--------------");
		Stream<String> stream=list.stream();
		list.stream()
			.filter((s)->s.contains(str))
			.forEach(s->System.out.println(s));
		
		/*스트림을 이용하여 3글자 문자열을 출력하는 코드를 작성하세요.*/
		System.out.println("--------------");
		//한번 사용한 스트림은 재사용이 안되기 때문에 다시 만들어야 함
		stream=list.stream();
		stream
		.filter((s)->s.length()==3)
		.forEach(s->System.out.println(s));
	}

}
