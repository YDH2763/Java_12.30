package day13;

import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
public class Ex07_Schedule {
	/*다음 기능을 실행하는 프로그램을 작성하세요.
	 * 1.스케쥴 등록
	 * -날짜, 시작시간, 할일 입력하여 등록
	 * 2.스케쥴 수정
	 * -날짜를 입력
	 * -해당 날짜에 등록된 스케쥴을 출력
	 * -수정할 스케쥴을 선택
	 * -날짜, 시작시간, 할일을 입력하여 수정
	 * 3.스케쥴 삭제
	 * 날짜를 입력
	 * -해당 날짜에 등록된 스케쥴을 출력
	 * -삭제할 스케쥴을 선택하여 삭제
	 * 4.스케쥴 조회
	 * -월 조회
	 * 	- 년과 월을 입력받아 스케쥴을 조회
	 * -일 조회
	 * 	-년, 월, 일을 입력받아 스케쥴을 조회
	 * 5.프로그램 종료*/
	static Scanner number = new Scanner(System.in);
	static ArrayList<Schedule> list =new ArrayList<Schedule>();
	
	
	public static void main(String[] args) {
		char s=0;
		final char Exit ='5';
		String fileName="src/day13/schedule.txt";
		
		load(fileName,list);
		
		for(int i=0;;i++) {
			
			theMenu();
			try {
				s =number.next().charAt(0);
				number.nextLine();
				runMenu(s);
			}
			catch(InputMismatchException e) {
				System.out.println("올바른 메뉴를 선택하세요.");
				number.nextLine();
			}
			if(s==Exit) {
				save(fileName,list);
				break;
			}
		}

	}


	private static void load(String fileName, ArrayList<Schedule> list) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				
			 ArrayList<Schedule> temp=(ArrayList<Schedule>) ois.readObject();
			 list.addAll(temp);
				
			} catch (Exception e) {
				System.out.println("[불러오기 실패]");
			}
	}


	private static void save(String fileName, ArrayList<Schedule> list) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(list);
				
			} catch (Exception e) {
				System.out.println("[저장하기 실패]");
			}
	}


	private static void theMenu() {
		System.out.println("-----------------");
		System.out.println("1.스케쥴 등록");
		System.out.println("2.스케쥴 수정");
		System.out.println("3.스케쥴 삭제");
		System.out.println("4.스케쥴 조회");
		System.out.println("5.프로그램 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 입력 : ");
	}


	private static void runMenu(char s) {
		switch(s) {
		case '1':
			insertSchedule();
			return;
		case '2':
			reviseSchedule();
			return;
		case '3':
			deleteSchedule();
			return;
		case '4':
			searchSchedule();
			return;
		case '5':
			System.out.println("프로그램을 종료합니다.");
			return;
		default:
			System.out.println("다시 입력해주세요.");
			return;
		}
		
	}


	private static void insertSchedule() {
		System.out.println("1.스케쥴 등록");
		try {
			//날짜
			System.out.println("시작할 날짜를 입력하세요.");
			System.out.println("yyyy-mm-dd");
			String date =number.nextLine();
			//시간
			System.out.println("시작할 시간를 입력하세요.");
			System.out.println("hh:mm");
			String time =number.nextLine();
			//할일
			System.out.println("할 일을 입력하세요.");
			String schedule =number.nextLine();
			//객체 생성
			Schedule plan =new Schedule(date+""+time,schedule);	
			//객체를 생성했으면 리스트에 추가
			list.add(plan);
			System.out.println("할일을 등록하였습니다.");
		}catch(ParseException e) {
			System.out.println("날짜와 시간을 잘못 입력했습니다.");
		}
		return;
		
	}


	private static void reviseSchedule() {
		// 날짜를 입력
		System.out.println("수정할 날짜를 입력하세요.");
		System.out.println("yyyy-mm-dd");
		String date =number.nextLine();
		//날자와 일치하는 일정들을 가져와서 리스트에 저장
		List<Schedule> tempList=
				list.stream()
					.filter(s->s.checkDate(date))
					.collect(Collectors.toList());
		//출력
		if(tempList.size()==0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for(int i=0;i<tempList.size();i++) {
			System.out.println((i+1)+"."+tempList.get(i));
		}
		//수정할 일정을 선택
		System.out.println("수정할 일정 : ");
		int index =number.nextInt()-1;
		number.nextLine();
		if(index<0||index>=tempList.size()) {
			System.out.println("잘못된 일정을 입력했습니다.");
			return;
		}
		
		//수정할 정보를 입력
		try {
			Schedule plan =inputSchedule();
			//수정
			tempList.get(index).revise(plan);
			System.out.println("일정을 수정했습니다.");
		}catch(ParseException e) {
			System.out.println("날짜와 시간을 잘못 입력했습니다.");
		}
		
	}

	private static Schedule inputSchedule() throws ParseException {
		System.out.println("수정할 날짜를 입력하세요.");
		System.out.println("yyyy-mm-dd");
		String date =number.nextLine();
		//시간
		System.out.println("수정할 시간를 입력하세요.");
		System.out.println("hh:mm");
		String time =number.nextLine();
		//할일
		System.out.println("할 일을 다시 입력하세요.");
		String schedule =number.nextLine();
		
		return new Schedule(date+" "+ time,schedule);
		
	}
	private static void deleteSchedule() {
			// 날짜를 입력
				System.out.println("삭제할 날짜를 입력하세요.");
				System.out.println("yyyy-mm-dd");
				String date =number.nextLine();
				//날자와 일치하는 일정들을 가져와서 리스트에 저장
				List<Schedule> tempList=
						list.stream()
							.filter(s->s.checkDate(date))
							.collect(Collectors.toList());
				//출력
				if(tempList.size()==0) {
					System.out.println("검색 결과가 없습니다.");
					return;
				}
				for(int i=0;i<tempList.size();i++) {
					System.out.println((i+1)+"."+tempList.get(i));
				}
				//삭제할 일정을 선택
				System.out.println("삭제할 일정 : ");
				int index =number.nextInt()-1;
				number.nextLine();
				if(index<0||index>=tempList.size()) {
					System.out.println("잘못된 일정을 입력했습니다.");
					return;
				}
				
				//삭제할 정보를 입력
				Schedule temp=tempList.get(index);
				//리스트에서 삭제
				list.remove(temp);
				
				System.out.println("스케쥴을 삭제했습니다.");
	}


	private static void searchSchedule() {
		printsearchSchedule();
		int n =number.nextInt();
		number.nextLine();
		runsearchSchedule(n);
		return;
		/*for(Schedule plan:list) {
			System.out.println(plan);
		}*/
		
	}


	private static void printsearchSchedule() {
		System.out.println("-----------------------");
		System.out.println("조회할 순을 입력해주세요.");
		System.out.println("1.월");
		System.out.println("2.일");
		System.out.println("-----------------------");
		System.out.print("번호 입력 : ");
		
	}


	private static void runsearchSchedule(int n) {
		switch(n) {
		case 1:
			searchMonth();
			return;
		case 2:
			searchDay();
			return;
		default:
			System.out.println("잘못 입력하였습니다.");
			return;
		}
	}


	private static void searchMonth() {
		//날짜
		System.out.println("조회할 날짜를 입력하세요.");
		System.out.println("yyyy-mm-dd");
		String date =number.nextLine();
		
		List<Schedule> tempList=
				list.stream()
				.filter(s->s.getDateStr().substring(0,7).equals(date))
				.collect(Collectors.toList());
		if(tempList.size()==0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		list.stream()
			.filter(s->s.getDateStr().substring(0,7).equals(date))
			.forEach(s->System.out.println(s));
		
	}


	private static void searchDay() {
		System.out.println("조회할 날짜를 입력하세요.");
		System.out.println("yyyy-mm-dd");
		String date =number.nextLine();
		
		List<Schedule> tempList=
				list.stream()
				.filter(s->s.getDateStr().substring(0,10).equals(date))
				.collect(Collectors.toList());
		if(tempList.size()==0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		list.stream()
			.filter(s->s.getDateStr().substring(0,10).equals(date))
			.forEach(s->System.out.println(s));
	}
	

}

@Data
//@AllArgsConstructor
class Schedule implements Serializable{
	private static final long serialVersionUID = 5104803882544585350L;
	
	private Date date;
	private String schedule;
	//"2025-01-01 12:00"
	public void setDate(String dateTime) throws ParseException {
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		this.date=format.parse(dateTime);
	}
	
	public Schedule(String date, String schedule) throws ParseException {
		this.schedule=schedule;
		setDate(date);
	}
	public boolean checkDate(String date) {
		if(date==null||this.date==null) {
			return false;
		}
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String tempDate=format.format(this.date);
		return tempDate.equals(date);
	}
	public void revise(Schedule schedule1) {
		if(schedule == null) {
			return;
		}
		this.date=date;
		this.schedule=schedule;
	}
	public String getDateStr() {
		if(date ==null) {
			return null;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	@Override
	public String toString() {
		return "["+getDateStr()+"]"+schedule;
	}
	
	
}
