package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		String line = "www.douzone.com";
		InetAddress[] inetAddresses = null;
		Scanner scanner = null;

		try {
			inetAddresses = InetAddress.getAllByName(line);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} // 이름으로 ip 모두 가져오는 것
		System.out.print(">");

		scanner = new Scanner(System.in);
		String scannerLine = scanner.nextLine();
		if ("nslookup".equals(scannerLine)) {
			for (int i = 0; i < inetAddresses.length; i++) {
				System.out.println("기본 서버: \t" + inetAddresses[i].getHostName());
				System.out.println("Address: \t" + inetAddresses[i].getHostAddress());
			}
		}
		scanner.close();
	}

}
