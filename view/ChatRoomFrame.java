package com.chatRoom.view;
import javax.swing.*;
import com.chatRoom.model.ConnectToServer;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
public class ChatRoomFrame extends JFrame{
	ConnectToServer cts= null;
	JScrollPane jsp = null;
	JPanel jp = null;
	JButton jb = null;
	JTextField jtf = null;
	JTextArea jta = null;
	public ChatRoomFrame() {
		cts = new ConnectToServer();
		this.setLayout(new BorderLayout());
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jb = new JButton("Send");
		jb.addActionListener(new action_listener());
		jp = new JPanel();
		jtf = new JTextField(15);
		jp.add(jtf);
		jp.add(jb);
		this.setTitle("Chat Room");
		this.add(jp,BorderLayout.SOUTH);
		this.add(jsp, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300,200);
		this.setVisible(true);
		while(true) {
			try {
				String msg_from_other = cts.re_msg_from_server();
				if(msg_from_other == null) {
					cts.socket.close();
					break;
				}
				jta.append(msg_from_other+'\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class action_listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String msg_to_send = jtf.getText();
			System.out.println(msg_to_send);
			try {
				cts.send_msg_to_server(msg_to_send);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jtf.setText("");
		}
		
	}
	public static void main(String[] args) {
		ChatRoomFrame chatroom = new ChatRoomFrame();
	}
}
