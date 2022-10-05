package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {

	private static ServerSocket serverSocket;
	
	public static void main(String[] args) {
		System.out.println("---------------------------------------------");
		System.out.println("서버를 종료하려면 q or Q를 입력하고 Enter키를 입력하세요.");
		System.out.println("---------------------------------------------");
		
		//TCP server start
		startServer();
		
		//키보드 입력
		Scanner sc=new Scanner(System.in);
		while(true) {
			String key=sc.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		sc.close();
		
		//TCP 서버 종료
		stopServer();
		

	}
	
	public static void startServer() {
		//작업 스레드 정의
		//thread의 자식을 만들어 객체 만들기
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					//ServerSocket 생성 및 Port 바인딩
					serverSocket=new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					//여러 클라이언트의 서비스요청을 받기위해 while 사용
					while(true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						//연결수락
						Socket socket=serverSocket.accept();
						//연결된 클라이언트 정보 얻기
						InetSocketAddress isa=(InetSocketAddress)socket.getRemoteSocketAddress();
						String clientIP=isa.getHostString();
						System.out.println("[서버]"+clientIP+"의 연결 요철을 수락함");
						//연결 끊기
						socket.close();
						System.out.println("[서버]"+clientIP+"의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버]"+e.toString());
//					e.printStackTrace();//예외처리 메세지 확인
				}
			}
		};
		thread.start();
	}
	
	public static void stopServer() {
		//ServerSocket을 닫고 Port 언바인딩
		try {
			serverSocket.close(); 
			//대기하고 있던 .accept가 SocketException 예외가 나오는데 이것을 처리하는데
			//ScoketException은 IOException의 자식이기 때문에 예외처리를 해야한다.
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {}
	}

}
