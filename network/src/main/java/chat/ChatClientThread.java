package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ChatClientThread extends Thread {
		private Socket socket;
		private String nickname;
		List<Writer> listWriters;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			Scanner scanner = null;
			try {
				// 9.메시지 처리

				BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream(), "UTF-8"), true);
				while(true){
					System.out.print(">");
					scanner = new Scanner(System.in);
					String line = scanner.nextLine();
//					pw.println(line);
//					System.out.println(br.readLine());
					while(true){
						line = br.readLine();
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
				}
				
		}catch(IOException e) {
			ChatClient.log("error" +e);
		}
			
		}
	
}
