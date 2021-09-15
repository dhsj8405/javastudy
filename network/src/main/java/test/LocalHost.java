package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		//InectAddress는 ipaddress를 매핑하고있음
	//  ipaddress "000.000.000.000" 매핑하고있음 , InetSocketAddress : IpAddress와 port다루고있음
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();//호스트네임=컴퓨터이름
			String hostAddress =  inetAddress.getHostAddress();
			System.out.println(hostName);
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address: addresses) {
//				System.out.println((int)address);
				System.out.print(address & 0x000000ff); // address는 마지막 바이트가 의미 있기때문에 마지막에만 ff해줌
				System.out.print('.');
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
