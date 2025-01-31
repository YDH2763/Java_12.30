package day19;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Ex03_Student {
	/* 학생들의 출석을 관리하는 프로그램을 작성하세요.
	 * 1.학생등록
	 * -이름만 입력해서 등록
	 * 2.출석체크
	 * -날짜를 입력하면 등록된 학생들의 출석 여부를 체크
	 * 	-2025-01-27
	 * -지각,조퇴는 없다고 가정
	 * -출석이면 o, 결석이면 x 로 관리
	 * 3.출석확인
	 * -등혹된 날짜들을 조회
	 * -조회된 날짜 중에서 선택해서 출석을 확인
	 * 4.종료
	 * */
	private static Scanner number=new Scanner(System.in);
	//여러날 출석 정보를 관리하는 출석부
	private static List<StudentList> list=new ArrayList<StudentList>();
	//학생 목록
	private static List<String> students=new ArrayList<String>();
	
	public static void main(String[] args) {
		
		int s=0;
		final int e=4;
		for(int i=0;;i++) {
			Attendence_And_Absence();
			s=number.nextInt();
			number.nextLine();
			startProgram(s);
			if(s==e) {
				break;
			}
		}

	}
	private static void Attendence_And_Absence() {
		System.out.println("--학생 출석 관리--");
		System.out.println("1.학생 등록");
		System.out.println("2.출석 체크");
		System.out.println("3.출석 확인");
		System.out.println("4.프로그램 종료");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
		
	}
	private static void startProgram(int s) {
		switch(s) {
		case 1:
			System.out.println("1.학생 등록");
			insertStudent();
			break;
		case 2:
			System.out.println("2.출석 체크");
			checkAttendence();
			break;
		case 3:
			System.out.println("3.출석 확인");
			AttendenceAbsence();
			break;
		case 4:
			System.out.println("4.프로그램 종료");
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
		
	}
	private static void insertStudent() {
		System.out.print("학생 : ");
		String student =number.next();
		students.add(student);
		System.out.println("학생을 등록하였습니다.");
		
	}
	private static void checkAttendence() {
		/*System.out.print("학생 : ");
		String student =number.next();
		if(!list.contains(student)) {
			System.out.println("이름을 잘못 입력하여 메인메뉴로 돌아갑니다.");
			return;
		}*/
		System.out.print("날짜 : ");
		String day=number.nextLine();
		if(!dateCheck(day)) {
			System.out.println("잘못 입력하여 메인 메뉴로 돌아갑니다.");
			return;
		}
		if(students.isEmpty()) {
			System.out.println("등록된 학생들이 없습니다.");
			return;
		}
		//학생 이름 출력후 출석 여부를 입력 받음
		System.out.println("--------------------------------------");
		System.out.println("출석여부(출석:'o'입력, 결석:'x'입력)");
		System.out.println("--------------------------------------");
		
		List<Student> students1=new ArrayList<Student>();
		
		for(int i=0;i<students.size();i++) {
			System.out.println((i+1)+". "+students.get(i)+" : ");
			char check=number.next().charAt(0); 
			if(check !='o'||check!='x') {
				System.out.println("잘못 입력하여 메인 메뉴로 돌아갑니다.");
				return;
			}
			Student student2=new Student(students.get(i),check);
			students1.add(student2);
		}
		//출석리스트에 추가
		list.add(new StudentList(day, students1));
		
		
		
	}
	
	private static boolean dateCheck(String day) {
		try {
			String[]datecheck=day.split("-");
			if(datecheck.length==0) {
				return false;
			}
			if(datecheck[0].length()!=4) {
				return false;
			}
			SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
			Date date =format.parse(day);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	private static void AttendenceAbsence() {
		if(!printDate()) {
			return;
		}
		/*System.out.print("날짜 : ");
		String day=number.nextLine();*/
		System.out.print("조회하려는 날짜(정수) : ");
		int index=number.nextInt()-1;
		
		if(index<0||index>=list.size()) {
			System.out.println("입력을 잘못했습니다.");
			return;
		}
		//출석부에서 날짜와 일치하는 출석리스트를 가져옴
		StudentList studentlist =list.get(index);
		studentlist.print();
		/*if(!dateCheck(day)) {
			System.out.println("잘못 입력하여 메인 메뉴로 돌아갑니다.");
			return;
		}*/
		
		
	}
	private static boolean printDate() {
		if(list.isEmpty()) {
			System.out.println("등록된 출석부가 없습니다.");
			return false;
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println((i+1)+". "+list.get(i).getDate());
		}
		return true;
		
	}

}

@AllArgsConstructor
@Data
class StudentList{
	private String date;
	private List<Student> list;
	
	public void print() {
		System.out.println("출석일 : " +date);
		for(Student student : list) {
			System.out.println(student);
		}
		
	}
}
@Data
@AllArgsConstructor
class Student{
	private String name;
	private char attendence;
	
	@Override
	public String toString() {
		return name+" : " + attendence;
	}

	

	
	
	
}