package day10;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Ex06_ListSet {

	public static void main(String[] args) {
		/*리스트 정렬*/
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(1);
		list.add(3);
		
		System.out.println(list);
		
		Collections.sort(list);	//오름차순
		System.out.println(list);
		
		Collections.sort(list, Collections.reverseOrder());	//내림차순
		System.out.println(list);
		
		/* sort 메소드는 Comparator 인터페이스의 구현 클래스의 객체가 필요
		 * =>구현 클래스의 메소드를 이용해서 정려하기 때문에
		 * 매개변수로 넘겨줌
		 * */
		/*list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});*/
		list.sort((o1,o2)->o2-o1);
		System.out.println(list);
		
	}

}
