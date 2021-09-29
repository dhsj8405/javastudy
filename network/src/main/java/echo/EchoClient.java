package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));// 개행붙여오는애들 받는것
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);// true 넣으면 자동 fflush 개행 붙여서 보내는것
			
			while(true) {
				System.out.print(">");
				String line = scanner.nextLine();
				
				if("exit".equals(line)){
					break;
				}
				
				pw.println(line); // 스캐너로 입력할때 개행이 입력안되므로 보내주는것
				
				String data = br.readLine();
				if(data == null) {
					log("closed by server");
					break;
				}
				System.out.println("<" + data);
			}
		}catch(SocketException e) {
			log("suddenly closed by server");
		}catch(IOException e) {
			log("error:" + e);
		}finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && socket.isClosed() == false) {
					socket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}
	private static void log(String log) {
		System.out.println("[Echo Client] " + log);
	}

}
