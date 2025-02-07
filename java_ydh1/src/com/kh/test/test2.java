package com.kh.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import com.kh.test.shape.model.vo.Food;

public class test2 {
	
	private static Scanner scan=new Scanner(System.in);
	static List<Food> list=new ArrayList<Food>();
	private static String fileName="foodlist.txt";
	public static void main(String[] args) {
		fileload(fileName,list);
		System.out.println("음식 : ");
		String food=scan.next();
		System.out.println("칼로리 : ");
		int kcal=scan.nextInt();
		insertfood(food, kcal);
		filesave(fileName,list);

	}

	private static void fileload(String fileName, List<Food> list) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			ArrayList<Food> temp=(ArrayList<Food>)ois.readObject();
			list.addAll(temp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void filesave(String fileName, List<Food> list) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void insertfood(String food, int kcal) {
		Food food1=new Food(food,kcal);
		list.add(food1);
		Stream<Food> stream=list.stream();
		stream.forEach(f->System.out.println(f));
		
	}

}
