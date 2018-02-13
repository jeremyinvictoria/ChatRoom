package com.server;
import java.net.*;
import java.io.*;
import java.util.*;
public class Server {
	Vector<Socket> socket_vector = new Vector<>();
	ServerSocket ss;
	public Server(){
		try {
			ss = new ServerSocket(9990);
			System.out.println("waiting for connection...");
			int count = 0;
			while(true) {
				Socket s =ss.accept();
				ServerThread st = new ServerThread(s);
				System.out.println(st.vector.size()+" clients connected to server now");
				Thread t = new Thread(st);
				t.start();
			}
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
	public void close_Server() throws IOException {
		System.out.println("Server shut down!");
		ss.close();
	}
	public static void main(String[] args) {
		Server s = new Server();
	}
}
