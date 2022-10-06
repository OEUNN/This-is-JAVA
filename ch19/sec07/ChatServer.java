package ch19.sec07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {
	ServerSocket serverSocket;
	ExecutorService threadPool= Executors.newFixedThreadPool(100); //스레드풀 생성
	Map<String, SocketClient> chatRoom=Collections.synchronizedMap(new HashMap<>());
	//Map생성 value가 Client의 각각의 Socket이다.
	
	//메소드
	public void start() throws IOException{
		serverSocket = new ServerSocket(50001);
		System.out.println("[server] start");
		
		Thread thread = new Thread(()->{
			try {
				while(true) {
					Socket socket= serverSocket.accept();
					//SocketClient의 매개갑으로 this=chtServer
					//this는 ChatServer의 객체를 뜯하는 것이다.
					SocketClient sc= new SocketClient(this,socket);
				}
			}catch(Exception e) {
				
			}
		});
		thread.start();
	}
		
	public void addSocketClient(SocketClient socketClient) {
		String key=socketClient.chatName+"@"+socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장: "+key);
		System.out.println("현재 재팅자 수: "+chatRoom.size()+"\n");
	}
	
	public void removeSocketClient(SocketClient socketClient) {
		String key=socketClient.chatName+"@"+socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("퇴장: "+key);
		System.out.println("현재 재팅자 수: "+chatRoom.size()+"\n");
	}
	
	//모든 채팅자에게 메세지를 보냄
	public void sendToAll(SocketClient sender, String message) {
		JSONObject root=new JSONObject();
		root.put("clientIp",sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json=root.toString();
		
		//모든client한테 보내는 코드
		//chatRoom의 값을 Collection에 저장한다.
		Collection<SocketClient> socketClients=chatRoom.values();
		for(SocketClient sc : socketClients) {
			//== : 똑같은 객체이냐?
			if(sc==sender) continue;
			sc.send(json);
		}
	}
	
	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			chatRoom.values().stream().forEach(sc->sc.close());
			System.out.println("[server] close");
		} catch (IOException e) {
			System.out.println("[server] close");
		}
		
	}

	public static void main(String[] args) {
		
		try {
			ChatServer chatServer = new ChatServer();
			chatServer.start();
			
			System.out.println("---------------------------------------------");
			System.out.println("서버를 종료하려면 q or Q를 입력하고 Enter키를 입력하세요.");
			System.out.println("---------------------------------------------");
			
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
			chatServer.stop();
			
			
			
		}catch(IOException e) {
			System.out.println("[server] "+e.getMessage());
		}
	}
}

