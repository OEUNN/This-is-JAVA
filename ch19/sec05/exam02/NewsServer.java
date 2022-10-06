package ch19.sec05.exam02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer {

	private static DatagramSocket datagramSocket;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
	public static void main(String[] args) {
		System.out.println("---------------------------------------------");
		System.out.println("server of exits is q or Q를 입력하고 Enter키를 입력하세요.");
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
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					//DatagramSocket 생성 및 Port 바인딩
					datagramSocket=new DatagramSocket(50001);
					System.out.println("[server] start");
					
					while(true) {
						//클라이언트가 구독하고 싶은 뉴스 주제 얻기
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
						System.out.println("client's get favorite News kinds");
						datagramSocket.receive(receivePacket);
						executorService.execute(()->{
							try {
								String newsKind=new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
								
								//클라이언트의 IP와 Port 정보가 있는 SocketAddress 얻기
								SocketAddress socketAddress = receivePacket.getSocketAddress();
							
								//10개의 뉴스를 클라이언트로 전송
								for(int i=1;i<=10;i++) {
									String data = newsKind + ": News" + i;
									byte[] bytes=data.getBytes("UTF-8");
									DatagramPacket sendPacket = new DatagramPacket(bytes,0,bytes.length,socketAddress);
									datagramSocket.send(sendPacket);
									Thread.sleep(1000);
								}
							}catch(Exception e) {}
						});
						
					}
				} catch (Exception e) {
					System.out.println("[server]"+e.getMessage());
				}
			}
		};
		
		//작업 스레드 시작
		thread.start();
	}
	
	public static void stopServer() {
		//DatagramSocket을 닫고 Port 언바인딩
		datagramSocket.close();
		executorService.shutdownNow();
		System.out.println("[server] close");
	}

}
