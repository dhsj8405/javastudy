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
import java.util.List;
import java.util.Scanner;

public class ChatClient {
//	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;
	List<Writer> listWriters;
	public static void main(String[] args) {
		BufferedReader br;
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
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			pw.println("join:" + nickname +"\n");
//			pw.flush();
		
//			br.readLine();
		
			//6. 쓰레드시작 :읽기
			new ChatClientThread(socket).start();
	
			//쓰기
			while(true){
				System.out.print(">");
				scanner = new Scanner(System.in);
				line = scanner.nextLine();
//				line = br.readLine();
				// 8. quit 프로토콜 처리
				if("quit".equals(line)) {
					break;
				
				}else {
					pw.println("message:"+line); // 스캐너로 입력할때 개행이 입력안되므로 보내주는것
					pw.flush();

					String data = br.readLine();
					if(data == null) {
						ChatClient.log("closed by server");
						break;
					}
					System.out.println("<" + data);
				}
				
			}
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
