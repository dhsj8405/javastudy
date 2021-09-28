package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private String nickname;
	private Socket socket;
	private String message;
	PrintWriter pw;
	Scanner scanner = null;

	public ChatWindow(String title_name, String nickname, Socket socket) {// gui
																			// 녹음
																			// 6분부터
		frame = new Frame(title_name);
		this.nickname = nickname;
		this.socket = socket;
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 20);
	}

	public void show() {

		/*
		 * 1. UI초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		// 인터페이스이고 메소드가하나일때 추론가능
		// buttonSend.addActionListener( (e)-> System.out.println("click") );
		buttonSend.addActionListener(new ActionListener() { // 어나니머스클래스
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});
		// Textfield
		textField.setColumns(40);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			// 엔터키로 메시지 보내는것
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		/*
		 * 2.IOStream 가져오기
		 */
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		} catch (IOException e1) {
			ChatClientApp.log("IOStream 에러");
		}

		// 3. Chat Client Thread 생성
		new ChatClientThread(socket).start();
		System.out.println(message);
		while (true) {
			pw.println("message:" + message);
		}

	}

	private void sendMessage() {
		message = textField.getText();
		System.out.println("메세지 보내는 프로토콜 구현:" + message);
		textField.setText("");
		textField.requestFocus();
		// Receive Thread에서 서버로 부터 받은 메세지가 있다고 치고~
		updateTextArea(nickname + ":" + message);
		// pw.println("message:" + message);
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		System.out.println("소켓 닫기 or 방나가기 프로토콜 구현하기");
		System.exit(0);
	}

	private class ChatClientThread extends Thread {
		BufferedReader br;
		private Socket socket;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {

			try {
				String line = null;
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				while (true) {
					// 읽고 채팅방에 써주기
					line = br.readLine();
					updateTextArea(line);
				}

			} catch (IOException e) {
				ChatClientApp.log("서버와 연결이 종료되었습니다.");
			}
		}
	}
}
