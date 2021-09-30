import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
//netstat -na | find "6017"
//netstat -a -n -o | find "6017"
//taskkill /pid 18264 /f
public class EchoClient {
	
	public static void main(String[] args) throws InterruptedException 
	{
		//System.out.println("Client started");
		try {
			/*Make connection to server socket*/
			Socket sock = new Socket("127.0.0.1", 6017);
			
			PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
			pout.println("hello I am the client. I was busy doing client things yesterday when my client doctor called. he says I have client itis");
			System.out.println("hello I am the client. I was busy doing client things yesterday when my client doctor called. he says I have client itis");
			/*close the socket connection*/
			System.out.println( "here1" );
			Thread.sleep(10);
			sock.close();
			System.out.println( "here2" );
//			pout.close();
		}
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
	}
}
