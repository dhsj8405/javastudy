package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			// 2. 바인딩(binding)
			//	  Socket에 InetSocketAddress(IPAddress + port가 있음)
			// IPAdress : 0.0.0.0 : 모든 IP로 부터의 연결을 허용
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000));
			
			//3. accept
			//   클라이언트로 부터 연결 요청을 기다린다.
			Socket socket = serverSocket.accept();// blocking 돼어서 연결안됨 xshell에서 telnet 127.0.0.1 포트번호(5000) 입력
			
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); //포트 까지 필요할때 다운캐스팅
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remoteHostPort +"]");
			
		} catch (IOException e) {
			System.out.println("[server] error : " + e);
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

}
