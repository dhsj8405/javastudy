package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {// 서버소켓에대한 익셉션
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			// 2. 바인딩(binding)
			//	  Socket에 InetSocketAddress(IPAddress + port가 있음)
			// IPAdress : 0.0.0.0 : 모든 IP로 부터의 연결을 허용 ( 호스트 IP가 바뀔 수 있기때문에 특정IP바인딩하기보단 0.0.0.0 
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000));
			
			//3. accept
			//   클라이언트로 부터 연결 요청을 기다린다.
			Socket socket = serverSocket.accept();// blocking 돼어서 연결안됨 xshell에서 telnet 127.0.0.1 포트번호(5000) 입력
			//연결된 클라이언트 IP주소 얻기
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); //,포트 까지 필요할때 다운캐스팅
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remoteHostPort +"]");

			try { // 데이터통신 IO에대한 익셉션
			// 4. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			while(true) {
				//5. 데이터 읽기
				byte[] buffer = new byte[256];
				int readByteCount = is.read(buffer); //blocking
				if(readByteCount == -1) {
					//반대편(클라이언트)가 정상적으로 종료(close() 호출)
					System.out.println("[server] closed by Client");
					break;
				}
				
				String data = new String(buffer, 0, readByteCount, "utf-8");
				System.out.println("[server] received:" + data);
			}
			}catch(SocketException e) {
				System.out.println("[server] suddenly closed by client" + e);
			}catch(IOException e) { //데이터통신 io 익셉션
				System.out.println("[server] error" + e);
			}finally {
				try {
					if(socket != null && socket.isClosed() == false) {
						socket.close();	
					}
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		} catch (IOException e) { // 서보소켓관련 io익셉션
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
