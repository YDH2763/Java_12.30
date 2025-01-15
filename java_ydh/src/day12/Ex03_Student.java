package day12;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
public class Ex03_Student {
	
	//private static final boolean IsCount = false;
	static Scanner number = new Scanner(System.in);
	static ArrayList<Student> list = new ArrayList<Student>();
	
	
	public static void main(String[] args) {
		/* 다음 기능을 갖는 프로그램을 작성하라
		 * 1.학생 추가
		 * -학년,반,번호 이름입력
		 * 2.학생 조회
		 * 3.종료
		 * 
		 * 2-1.학년 조회: 학년
		 * 2-2.반 조회: 학년, 반
		 * 2-3.번호 조회: 학년, 반, 번호
		 * 2-4.전체 조회:x
		 * 
		 * -학생 클래스 추가
		 * -List를 이용해서 학생들을 관리
		 * -Stream과 람다식을 이용해서 출력을 구현
		 * */
		for(int i=0;;i++) {
			startManu();
			int s=number.nextInt();
			number.nextLine();
			runManu(s);
			if(s==3) {
				break;
			}
		}
	}


	private static void runManu(int s) {
		switch(s) {
		case 1:
			imputStudent();
			return;
		case 2:
			searchStudent();
			return;
		case 3:
			System.out.println("3.프로그램 종료");
			return;
		case 4:
			deleteStudent();
			return;
		default:
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		
	}


	private static void deleteStudent() {
		System.out.println(list);
		System.out.println("삭제할 학생의 이름을 적으세요.");
		String dn=number.next();
		if(!list.contains(dn)) {
			System.out.println("잘못 입력했습니다.");
			return;
		}
		
		List<Student> tmpList=
				list
				.stream()
				.filter(s->s.getName().contains(dn))
				.collect(Collectors.toList());
		print(tmpList,s->true,true);
		
		System.out.println("삭제할 학생의 번호를 입력하세요.");
		int count=number.nextInt();
		Student tmp=tmpList.get(count-1);
		list.remove(tmp);
		//Stream<Student> stream=list.stream();
		/*stream.filter((s)->{
			return s.getName().equals(dn);
		});	//??????????*/
		return;
	}


	private static void searchStudent() {
		System.out.println("2.학생 조회");
		System.out.println("------------");
		System.out.println("1.학년 조회");
		System.out.println("2.반 조회");
		System.out.println("3.번호 조회");
		System.out.println("4.전체 조회");
		System.out.println("메뉴 선택");
		int sss=number.nextInt();
		number.nextLine();
		runsearchStudent(sss);
		return;
		
	}


	private static void runsearchStudent(int sss) {
		switch(sss) {
		case 1:
			searchGrade();
			return;
		case 2:
			searchClassnum();
			return;
		case 3:
			searchNum();
			return;
		case 4:
			System.out.println(list);
			return;
		default:
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		
	}


	private static void searchGrade() {
		System.out.println("1.학년 조회");
		System.out.println("학년을 입력하세요.");
		int sg=number.nextInt();
		Stream<Student> stream=list.stream();
		stream.filter((s)->{
			return s.getGrade()==sg;
		  }).forEach((s)->{
			  System.out.println(s);
		  });
		//print(list,s->s.getGrade()==sg);
		
	}


	private static void searchClassnum() {
		System.out.println("2.반 조회");
		System.out.println("학년을 입력하세요.");
		int sg=number.nextInt();
		System.out.println("반을 입력하세요.");
		int sc=number.nextInt();
		Stream<Student> stream=list.stream();
		stream.filter((s)->{
			return s.getGrade()==sg;
		  	})
			.filter((s)->{
			return s.getClassnum()==sc;
		  }).forEach((s)->{
			  System.out.println(s);
		  });
		//print(list,s->s.getGrade()==sg && s.getClassnum()==sc);
		
	}


	private static void searchNum() {
		System.out.println("3.번호 조회");
		System.out.println("학년을 입력하세요.");
		int sg=number.nextInt();
		System.out.println("반을 입력하세요.");
		int sc=number.nextInt();
		System.out.println("번호를 입력하세요.");
		int sn=number.nextInt();
		Stream<Student> stream=list.stream();
		stream.filter((s)->{
			return s.getGrade()==sg;
	  		}).
			filter((s)->{
			return s.getClassnum()==sc;
		  }).
			filter((s)->{
			return s.getNum()==sn;
		  }).forEach((s)->{
			  System.out.println(s);
		  });
		//print(list, s->s.getGrade()==sg && s.getGrade()==sc && s.getNum()==sn);
	}


	private static void print(ArrayList<Student> list, Consumer<Student> c) {
		for(Student s: list) {
			c.accept(s);
		}
	}


	private static void imputStudent() {
		System.out.println("1.학생 추가");
		System.out.println("이름을 입력하세요.");
		String name =number.next();
		System.out.println("학년을 입력하세요.");
		int grade=number.nextInt();
		System.out.println("반을 입력하세요.");
		int classnum=number.nextInt();
		System.out.println("번호을 입력하세요.");
		int num=number.nextInt();
		Student std=new Student(grade, classnum, num, name);
		list.add(std);
		System.out.println("등록되었습니다.");
		return;
	}


	private static void startManu() {
		System.out.println("1.학생 추가");
		System.out.println("2.학생 조회");
		System.out.println("3.프로그램 종료");
		System.out.println("4.학생 삭제");
		System.out.println("메뉴 선택");
	}
	
	private static void print(List<Student> list, Predicate<Student> s) {
		print(s,false);
	}
	
	private static void print(List<Student> list,Predicate<Student> s,boolean isCount) {
		Stream<Student> stream =list.stream();
		AtomicInteger index=new AtomicInteger(1);
		stream
			.filter(s)
			.forEach(s1->{
			int n=index.getAndIncrement();
			System.out.println((isCount? n+".":"")+s1);
		});
	}

}
@Data
@AllArgsConstructor
class Student{
	private int grade;
	private int classnum;
	private int num;
	private String name;
	
	@Override
	public String toString() {
		return grade+"학년 "+classnum+"반 "+num+"번 "+name;
	}
	
	
	
}