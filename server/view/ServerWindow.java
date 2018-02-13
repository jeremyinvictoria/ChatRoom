package com.server.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.server.Server;
import java.io.*;
import java.net.*;
public class ServerWindow extends JFrame implements Runnable{
	JButton start;
	JButton shutdown;
	JPanel button_container;
	Server serv;
	public ServerWindow() {
		button_container = new JPanel();
		start = new JButton("START");
		shutdown = new JButton("SHUTDOWN");
		button_container.add(start);
		button_container.add(shutdown);
		start.addActionListener(new start_button_action());
		shutdown.addActionListener(new shutdown_button_action());
		this.setLayout(new BorderLayout());
		this.add(button_container,BorderLayout.NORTH);
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	class start_button_action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			serv = new Server();
		}
	}
	
	class shutdown_button_action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				serv.close_Server();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	@Override
	public void run() {

	}

	public static void main(String[] args) {
		new ServerWindow();
	}
}	
