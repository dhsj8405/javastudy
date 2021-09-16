package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Scanner;

import echo.EchoServerReceiveThread;

public class ChatClient {
//	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;
	List<Writer> listWriters;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		String nickname;
		String line;
		try {
			//소켓 객체 생성
			socket = new Socket();
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			//connect
			socket.connect(new InetSocketAddress(hostAddress, SERVER_PORT));
			log("연결 성공");
			System.out.print("닉네임>>");
			scanner = new Scanner(System.in);
			nickname = scanner.nextLine();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			pw.println("join:" + nickname );
			pw.flush();
//			System.out.println(br.readLine());
			
//			br.readLine();

			//6. 쓰레드시작 write,read
			new ChatClientThread(socket).start();
			

		

			
			
		} catch (IOException e) {
			log("error:" + e);
		}finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				//close
				if(socket != null && socket.isClosed() == false) {
					socket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void log(String log) {
		System.out.println("[Chat Client] " + log);
	}
}
