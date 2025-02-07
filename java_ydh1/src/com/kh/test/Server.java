package com.kh.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		int port =3000;
		ServerSocket server;
		try {
			server=new ServerSocket(port);
			Socket client =server.accept();
			System.out.println("연결 완료");
			Thread t=new Thread(()->{
				while(true) {
					ObjectInputStream ois;
					try {
						ois = new ObjectInputStream(client.getInputStream());
						String str=ois.readUTF();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t.start();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
