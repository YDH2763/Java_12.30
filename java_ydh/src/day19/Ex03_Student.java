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
	private static List<Student> list=new ArrayList<Student>();
	public static void main(String[] args) {
		
		int c;
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
		System.out.println(list);
		System.out.println("--학생 출석 관리--");
		System.out.println("1.학생 등록");
		System.out.println("2.출석 체크");
		System.out.println("3.출석 확인");
		System.out.println("4.프로그램 종료");
		System.out.println("--------------");
		
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
		Student list =new Student(student,'x',"");
		
	}
	private static void checkAttendence() {
		System.out.print("학생 : ");
		String student =number.next();
		if(!list.contains(student)) {
			System.out.println("이름을 잘못 입력하여 메인메뉴로 돌아갑니다.");
			return;
		}
		System.out.print("날짜 : ");
		String day=number.nextLine();
		if(!dateCheck(day)) {
			System.out.println("잘못 입력하여 메인 메뉴로 돌아갑니다.");
			return;
		}
		System.out.print("출석여부(출석:'o'입력, 결석:'x'입력) : ");
		char attendence=number.next().charAt(0);
		if(attendence !='o'||attendence!='x') {
			System.out.println("잘못 입력하여 메인 메뉴로 돌아갑니다.");
			return;
		}
		int index=list.indexOf(student);
		list.remove(index);
		Student list =new Student(student,attendence,day);
		
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
		System.out.print("날짜 : ");
		String day=number.nextLine();
		if(!dateCheck(day)) {
			System.out.println("잘못 입력하여 메인 메뉴로 돌아갑니다.");
			return;
		}
		int index=list.indexOf(day);
		for(Student s: list) {
			
		}
	}

}

@AllArgsConstructor
@Data
class Student{
	private String student;
	private char attendence;
	private Date date;
	
	public Student(String student, char attendence, String date) {
		this.student=student;
		this.attendence=attendence;
	}

	@Override
	public String toString() {
		return "학생 : "+student+" 날짜: "+date+" 출석 여부 : "+attendence;
	}
	
	
	
}