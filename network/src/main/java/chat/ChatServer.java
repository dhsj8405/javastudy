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
	private static List<Writer> listWriters ;
	public static void main(String[] args) {
		try {
		System.out.print(">>");
		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket();
		String hostAddress = InetAddress.getLocalHost().getHostAddress();
		serverSocket.bind(new InetSocketAddress(hostAddress, PORT)); 
		log("연결 기다림 " + hostAddress + ":" + PORT);
		while(true) {
			Socket socket = serverSocket.accept();
			listWriters = new ArrayList<Writer>();
			new ChatServerThread(socket,listWriters).start();
			new ChatServerThread(socket).start();
		}
		}catch(IOException e) {
			log("error: " + e);
		}

	}
	public static void log(String log) {
		System.out.println("[ChatServer] " + log);
	}
	
}
