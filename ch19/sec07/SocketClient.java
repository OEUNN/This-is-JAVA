package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {

	//필드
	ChatServer chatServer;
	Socket socket;
	String chatName;
	String clientIp;
	DataInputStream dis;
	DataOutputStream dos;
	
	//생성자
	public SocketClient(ChatServer chatServer,Socket socket) {
		try {
			this.chatServer=chatServer;
			this.socket=socket;
			this.dis=new DataInputStream(socket.getInputStream());
			this.dos=new DataOutputStream(socket.getOutputStream());
			//getRemmoteSocketAddress 메소드는 SocketAddress를 리턴값으로 받을수 있다.
			//InetSocketAddress강제 타입변환하는 이유는 밑에줄에 getHostName메소드를 사용하기 위해서이다.
			InetSocketAddress isa=(InetSocketAddress)socket.getRemoteSocketAddress();
			this.clientIp=isa.getHostName();
			receive();
			
			
		} catch (IOException e) {
		}
	}
	
	public void receive() {
		//.execute=작업큐에 작업 저장
		chatServer.threadPool.execute(()->{
			try {
				while(true) {
					//{"command": "incoming", "data":"chatName"}
					//{"command": "message","data":
					//예외처리를하는 이유는 readUTF때문인데, 클라이언트의 종료로 인해 연결이 끊어졌을때 넘어가던 데이터를 room에서 삭제
					String receiveJson=dis.readUTF();
					
					JSONObject jsonObject = new JSONObject(receiveJson);
					//command라는 속성이름의 값을 얻는 것 
					String command = jsonObject.getString("command");
					
					switch(command) {
						case "incoming":
							this.chatName=jsonObject.getString("data");
							chatServer.sendToAll(this, "is welcom");
							//this는 SocketClient를 말한다.
							chatServer.addSocketClient(this);
							//채팅방에 들어감
							break;
						case "message":
							String message=jsonObject.getString("data");
							chatServer.sendToAll(this, message);
							break;
					}
				}
			}catch(Exception e) {
				chatServer.sendToAll(this, "get out.");
				chatServer.removeSocketClient(this);
			}
		});
	}

	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
			System.out.println("213123");
		}
	}
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
	
	
}
