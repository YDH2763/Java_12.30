package day12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06_ByteStreamOutput {
	/*OutputStream은 파일이 없어도 폴더만 있으면 파일을 생성해서 작업 */
	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("src/day12/byte_stream2.txt")){
			for(char ch='a';ch<='z';ch++) {
				fos.write(ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		}

	}

}
