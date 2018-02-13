package com.chatRoom.model;
import java.io.*;
import java.net.*;
import java.util.*;

public class ConnectToServer {
	public Socket socket = null;
	public ConnectToServer() {
		
		try {
			socket = new Socket("127.0.0.1",9990);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void send_msg_to_server(String str) throws IOException {
		Socket s = this.socket;
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println(str);
	}
	public String re_msg_from_server() throws IOException {
		Socket s = this.socket;
		InputStreamReader isr = new InputStreamReader(s.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String msg_from_server = br.readLine();
		return msg_from_server;
	}
	
}
