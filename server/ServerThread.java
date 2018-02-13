package com.server;
import java.net.*;
import java.util.*;
import java.io.*;
public class ServerThread implements Runnable{
	public static Vector<Socket> vector = new Vector<>();
	Socket s=null;
	PrintWriter pw = null;
	public ServerThread(Socket s) {
		this.s = s;
		vector.add(this.s);
	}
	@Override
	public void run() {//add synchronize here later;
		try {
			while(true) {
				InputStreamReader isr = new InputStreamReader(s.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				String msg_to_display = br.readLine();
				if(msg_to_display == null) {
					synchronized(new Object()){
						for(int i=0;i<vector.size();i++) {
							Socket socket_to_delete = vector.get(i);
							if(socket_to_delete == this.s) {
								vector.remove(i);
							}
						}
					}
					s.close();
					break;
				}
				
				for(int i=0;i<vector.size();i++) {
					Socket socket_in_vector = vector.get(i);
					pw = new PrintWriter(socket_in_vector.getOutputStream(),true);
					String ip_addr = s.getInetAddress().toString().replace("/", "");
					pw.println(ip_addr+":"+msg_to_display);
				}
			}	
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
