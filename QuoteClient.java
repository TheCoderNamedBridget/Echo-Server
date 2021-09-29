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
public class QuoteClient {
	
	public static void main(String[] args) 
	{
		System.out.println("Client started");
		try {
			/*Make connection to server socket*/
			Socket sock = new Socket("127.0.0.1", 6017);
			
			PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
			pout.println(1111);
			System.out.println(1111);
			/*close the socket connection*/
			sock.close();
//			pout.close();
		}
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
	}
}
