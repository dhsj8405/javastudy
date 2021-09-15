package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	
	public static void main(String[] args) {
		Socket socket =null;
		try {
			//1. 소켓 생성
			socket = new Socket();
			//2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			
			
		} catch (SocketException e) {
			System.out.println("[client] suddenly close by server : " + e);
		} catch (IOException e) {
			System.out.println("[client] error : " + e);
		}finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
