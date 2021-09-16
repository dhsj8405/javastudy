package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int PORT = 6000;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT)); // 소켓에다 소켓어드레스(ip어드레스 + 포트번호) 바인딩
			log("starts... [port:" + PORT + "]");

			Socket socket = serverSocket.accept();
			
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // ,포트 까지// 필요할때다운캐스팅
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));// 개행붙여오는애들 받는것
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);// true 넣으면 자동 fflush 개행 붙여서 보내는것

				while (true) {
					String data = br.readLine();
					if (data == null) {
						log("closed by client");
						break;
					}

					log("received:" + data);
					pw.println(data);
				}
			} catch (IOException e) {
				log("error:" + e);
			} finally {
				try {
					if (socket != null && socket.isClosed() == false) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
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
