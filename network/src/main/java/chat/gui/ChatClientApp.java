package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatClient;
import chat.ChatClientThread;

public class ChatClientApp {
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter pw;
		String title_name = null;
		String nickname = null;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			title_name = scanner.nextLine();
			System.out.println("닉네임을 입력하세요.");
			System.out.print(">>> ");
			nickname = scanner.nextLine();

			if ((title_name.isEmpty()  == false) && (nickname.isEmpty() == false)) {
				break;
			}
			
			System.out.println("대화명과 닉네임은 한글자 이상 입력해야 합니다.\n");
		}
		

		//
		scanner.close();
		// 1. create socket
		socket = new Socket();

		try {
			// 2. connect to server
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			socket.connect(new InetSocketAddress(hostAddress, SERVER_PORT));
			// 3. get iostream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			pw.println("join:" + nickname +"\n");
			
			//채팅창 활성화 및 쓰레드 시작
			new ChatWindow(title_name, nickname, socket).show();
		} catch (IOException e) {
			e.printStackTrace();
		}
//
//		// 4. join
//		pw.println("join:" + nickname + "\n");
//		// String line = br.readLine();
//		String line = "JOIN:OK";
//		if ("JOIN:OK".equals(line)) {
//			new ChatWindow(title_name, nickname).show();
//		}
	}
	public static void log(String log) {
		System.out.println("[Chat ClientApp] " + log);
	}
}
