package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 6000;
	static List<Writer> listWriters;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();

		try {
			System.out.print(">>");
			// 서버소켓 객체 생성
			serverSocket = new ServerSocket();
			// bind
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림 " + hostAddress + ":" + PORT);
			// 요청대기
			while (true) {
				// accept
				Socket socket = serverSocket.accept();
				// read,write
				new ChatServerThread(socket, listWriters).start();
			}
		} catch (IOException e) {
			log("ChatServer 대기중에러: " + e);
		} finally {
			try {
				// close
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				log("ChatServer 소켓종료시 에러");
			}
		}
	}

	public static void log(String log) {
		System.out.println("[ChatServer] " + log);
	}

}
