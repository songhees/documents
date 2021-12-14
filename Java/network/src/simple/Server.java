package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// 3000번 port로 클라이언트의 연결요청을 기다리는 서버소켓객체 생성
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(3000);
		System.out.println("### 서버가 실행됨 ...");
		
		while (true) {
			System.out.println("### 클라이언트의 연결 요청을 대기 중 ...");
			Socket socket = serverSocket.accept(); // 클라이언트의 연결요청을 대기
			System.out.println("### 클라이언트의 연결 요청을 수락하고, 해당 클라이언트와 통신하는 소케을 제공함 ...");
			
			// 이 소켓의 반대편 소케(서버측 소켓)과 연결된 입력/출력 스트림 획득
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			// 클라이언트가 보낸 메세지 수신
			String text = in.readLine();
			
			// 클라이언트로 응답 메세지 보내기
			out.println("반갑습니다." + text);
			
			socket.close();
		}
	}
}
