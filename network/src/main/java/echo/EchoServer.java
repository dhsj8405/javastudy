package echo;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int PORT = 8000;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT)); // 소켓에다 소켓어드레스(ip어드레스 + 포트번호) 바인딩
			log("starts... [port:" + PORT + "]");

			while(true) {
				Socket socket = serverSocket.accept();
				new EchoServerReceiveThread(socket).start();
			}
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}
}
