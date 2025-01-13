package day10;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
public class Ex07_ListSort {

	public static void main(String[] args) {
		ArrayList<Student1> list1= new ArrayList<Student1>();
		list1.add(new Student1(1,1,3,"이병권"));
		list1.add(new Student1(1,1,1,"주호민"));
		list1.add(new Student1(1,1,2,"김단군"));
		
		System.out.println(list1);
		Collections.sort(list1);
		System.out.println(list1);
		System.out.println("----------------------");
		ArrayList<Student2> list2= new ArrayList<Student2>();
		list2.add(new Student2(1,1,3,"이병권"));
		list2.add(new Student2(1,1,1,"주호민"));
		list2.add(new Student2(1,1,2,"김단군"));

		//list2.sort(new Student2(1,1,1, null"a"));
		list2.sort(new Comparator<Student2>());
		
		System.out.println(list2);
	}

}

@Data
@AllArgsConstructor
class Student1 implements Comparable<Student1>{
	private int grade, classNum, num;
	private String name;
	
	public String toString() {
		return grade +"학년"+classNum+"반"+num+"번"+name;
	}

	@Override
	public int compareTo(Student1 o) {
		if(grade !=o.grade) {
			return grade-o.grade;
		}
		if(classNum !=o.classNum) {
			return classNum-o.classNum;
		}
		if(num !=o.num) {
			return num-o.num;
		}
		return 0;
	}
}
@Data
@AllArgsConstructor

class Student2 implements Comparable<Student2>{
	public int grade, classNum, num;
	public String name;
	
	public String toString() {
		return grade +"학년"+classNum+"반"+num+"번"+name;
	}

	public int compare(Student2 o1, Student2 o2 ) {
		if(o1.grade !=o2.grade) {
			return o1.grade-o2.grade;
		}
		if(o1.classNum !=o2.classNum) {
			return o1.classNum-o2.classNum;
		}
		if(o1.num !=o2.num) {
			return o1.num-o2.num;
		}
		return 0;
	}
	
}
