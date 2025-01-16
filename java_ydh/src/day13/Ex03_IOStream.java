package day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Ex03_IOStream {

	public static void main(String[] args) {
		
		List<String> list =new ArrayList<String>();
		//불러오기
		try(FileReader fr = new FileReader("src/day13/string/txt");
				BufferedReader br = new BufferedReader(fr)){
			String line;
			while((line = br.readLine())!=null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("불러오기 도중 IO 예외 발생");
			e.printStackTrace();
		}
		
		//저장하기
		/*FileWriter에서 이어쓰기를 하려면 생성자애 파일명과 'true'를 순서대로 넣어주면 됨
		 * */
		try(FileWriter fw = new FileWriter("src/day13/string/txt")){
			fw.write("안녕하세요.\n");
			fw.write("제 이름은 홍길동 입니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


