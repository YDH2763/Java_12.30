package com.kh.test;

import java.io.ObjectOutputStream;
import java.net.InterfaceAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		int port = 3000;
		String serverIP="192.168.20.34";
		Thread t=new Thread(()->{
			try {
				
				Socket socket =new Socket(serverIP,port);
				
				ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
				oos.writeUTF("");
				oos.flush();
				Thread.sleep(1000);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		});
		t.start();
		
	

}
}
