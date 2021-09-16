package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientThread extends Thread {
		private Socket socket;
		private String nickname;
		private BufferedReader br;
		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {

			Scanner scanner = null;
			try {
				br = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream(), "UTF-8"), true);
				System.out.println("ㅂㅇ");

			while(true) {
				

				System.out.println(">");
				String line = scanner.nextLine();
				if("quit".equals(line)) {
					break;
				}else {
					pw.println(line); // 스캐너로 입력할때 개행이 입력안되므로 보내주는것

					String data = br.readLine();
					if(data == null) {
						ChatClient.log("closed by server");
						break;
					}
					System.out.println("<" + data);
				}
			
			}
		}catch(IOException e) {
			ChatClient.log("error" +e);
		}finally {
			try {
				if (this.socket != null && this.socket.isClosed() == false) {
					this.socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		}
	
}
