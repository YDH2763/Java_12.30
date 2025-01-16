package day12;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex09_ObjectStream2 {
	/* 다음 기능을 갖는 프로그램을 작성하세요.
	 * 단, 저장기능과 불러오기 기능을 추가
	 * -저장은 프로그램 종료하기 전
	 * -불러오기는 프로그램 시작 전
	 * 
	 * 1.자동차 추가
	 * 2.자동차 조회(전체)
	 * 3.종료
	 * 
	 * 힌트
	 * ArrayList 클래스도 Serializable 인터페이스를 구현한 구현 클래스
	 * */
	
	static Scanner number = new Scanner(System.in);
	static ArrayList<Car> list = new ArrayList<Car>();
	static String fileName="src/day12/car_list.txt";
	
	public static void main(String[] args) {
		
		load(fileName,list);
		final char Exit='3';
		for(int i=0;;i++) {
			mainMenu();
			char s=number.next().charAt(0);
			number.nextLine();
			startMenu(s);
			if(s==Exit) {
				break;
			}
			
			
		}
		

	}

	private static void load(String fileName, ArrayList<Car> list) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				
			 ArrayList<Car> temp=(ArrayList<Car>) ois.readObject();
			 list.addAll(temp);
				
			} catch (FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IO 예외 발생!");
			} catch (ClassNotFoundException e) {
				System.out.println("클래스를 찾을 수 없습니다.");
				e.printStackTrace();
			}
	}

	private static void save(String fileName, ArrayList<Car> list) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생!");
		}
		
	}



	private static void mainMenu() {
		System.out.println("메뉴");
		System.out.println("1.자동차 등록");
		System.out.println("2.자동차 조회");
		System.out.println("3.프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void startMenu(char s) {
		switch(s) {
		case '1':
			inputCar();
			return;
		case '2':
			searchCar();
			return;
		case '3':
			downProgram();
			return;
		default:
			System.out.println("다시 입력해주세요.");
			return;
		}
		
	}


	private static void inputCar() {
		System.out.println("자동차 이름을 입력하세요.");
		String name=number.next();
		System.out.println("회사 이름을 입력하세요.");
		String brand=number.next();
		if(list.contains(brand) || list.contains(name)) {
			System.out.println("이미 등록된 차량입니다.");
			return;
		}
		//객체 생성과 추가
		Car car= new Car(name,brand);
		list.add(car);
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(list);
			} catch (FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IO 예외 발생");
				e.printStackTrace();
			}
		
		System.out.println("차량을 등록하였습니다.");
		return;
	}

	private static void searchCar() {
		list.sort((o1,o2)->{
			//브랜드를 비교하여 다르면 사전순으로 정렬
			if(o1.getBrand().equals(o2.getBrand())) {
				return o1.getBrand().compareTo(o2.getBrand());
			}
				//이름을 사전순으로 정렬
				return o1.getName().compareTo(o2.getName());
		});
		
		for(Car car:list) {
			System.out.println(car);
		}
	}
	
	private static void downProgram() {
		
		System.out.println("프로그램을 종료합니다.");
		save(fileName,list);
		return;
	}

}
@Data
@AllArgsConstructor
class Car implements Serializable{
	
	private static final long serialVersionUID = 0;
	
	private String name;
	private String brand;
	
	@Override
	public String toString() {
		return "이름 : "+name+"\r\n"+"회사이름 : "+brand+"\r\n";
	}

	
}