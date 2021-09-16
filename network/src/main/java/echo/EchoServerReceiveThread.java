package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EchoServerReceiveThread extends Thread{
	private Socket socket;
	
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
		
	}
	@Override
	public void run() {
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // ,포트 까지// 필요할때다운캐스팅
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));// 개행붙여오는애들 받는것
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);// true 넣으면 자동 fflush 개행 붙여서 보내는것

			while (true) {
				String data = br.readLine();
				if (data == null) {
					EchoServer.log("closed by client");
					break;
				}

				EchoServer.log("received:" + data);
				pw.println(data);
			}
		} catch (IOException e) {
			EchoServer.log("error:" + e);
		} finally {
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
