package com.kh.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class text3 {
	static List<String> list =new ArrayList<String>();
	
	public static void main(String[] args) {
		output();
	}
	
	public static void output() {
		FileWriter fw=null;
		try (FileReader fr = new FileReader("test.txt");
				BufferedReader br =new BufferedReader(fr)){
			String line;
			while((line = br.readLine())!=null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			fw=new FileWriter("test.txt");
			fw.write(97);
			fw.write(65);
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
