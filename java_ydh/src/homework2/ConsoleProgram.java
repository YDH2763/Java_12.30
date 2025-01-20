package homework2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import homework.Student;

public interface ConsoleProgram {

	void run();
	
	void printMenu();
	
	void runMenu(int menu);
	
	default Object load(String studentManager) {
		try(FileInputStream fis = new FileInputStream(studentManager);
			ObjectInputStream ois = new ObjectInputStream(fis)){
					
				 
			 return ois.readObject();
				 
			} catch (Exception e) {
				System.out.println("[불러오기 실패]");
			}
			return null;
	}
	
	default void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(obj);
				
			} catch (Exception e) {
				System.out.println("-----------------");
				System.out.println("저장하기 실패");
				System.out.println("-----------------");
			}
	}
	
}
