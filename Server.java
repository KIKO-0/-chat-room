package tPC;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Server {
	
	public static Map<String, Socket> map = new HashMap<>();
	public static List<Socket> list = new ArrayList<>();

	public static void main(String[] args) {
		try {
//			1、创建  服务器ServerSocket对象  和  系统要指定的端口号
			ServerSocket server = new ServerSocket(8888);
			while (true) {
//				2、使用ServerSocket对象中的accept方法获取请求的客户端对象Socket
				Socket client = server.accept();
/*	 
 *                1. socket.getInetAddress()返回InetAddress对象包含远程计算机的IP地址。
 *                	 InetAddress.getHostAddress()返回String对象与该地址的文本表示。（就是让你得到一个用字符串表示的IP地址）
 *                2. 采用链式编程法
*/	  
				String ip = client.getInetAddress().getHostAddress();
				map.put(ip, client);
				list.add(client);
				
				Thread t1 = new MyInputStreamListener(client);
				t1.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
class MyInputStreamListener extends Thread {
	
	public MyInputStreamListener(Socket client) {
		super();
		this.client = client;
	}
	Socket client;
	@Override
	public void run() {
		try {
			String ip = client.getInetAddress().getHostAddress();
			while (true) {
				
				InputStreamReader in = new InputStreamReader(client.getInputStream());
				char[] buffer = new char[1024];
				int len = -1;
				if ((len = in.read(buffer)) != -1) {
					// 设置谁谁谁说什么什么
					String message = ip + "@say@:" + new String(buffer, 0, len);

					for (int i = 0; i < Server.list.size(); i++) {
						Socket v = Server.list.get(i);
						try {
//							使用Socket对象中的getOutputStream()方法获取网络字节输出流OutputStream对象
							OutputStreamWriter out = new OutputStreamWriter(v.getOutputStream());
							out.write(message);
							out.flush();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
