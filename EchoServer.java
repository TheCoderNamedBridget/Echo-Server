
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

/*
* Take the input from the client and then look for the string server or client and replace it with client or server
* use the input stream class
*/
public class EchoServer {

	public static void main(String[] args) {
		//System.out.println("Server started");
		try {
			// started lab at 6013 changed to 17
			ServerSocket sock = new ServerSocket(6017);
			Boolean checkSocket = true;
			Socket client = sock.accept();
			byte[] bytesRead = new byte[50];
			/* now listen for connections */
			while (checkSocket) {
				InputStream in = client.getInputStream();
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

				//checks to see if client is still connected, reads next byte of data from the input stream
				if ( in.read(bytesRead) != -1 )
				{
					String s = new String(bytesRead, StandardCharsets.UTF_8);
//					BufferedReader bin = new BufferedReader(new InputStreamReader(in));
//					String line;
					String returnMsg = s;
//					while((line = bin.readLine()) != null) {
////						System.out.println(line);
//						returnMsg += line;
//					}
					//take input from server and return correct output
					returnMsg = returnMsg.replaceAll("client", "server");
					/* Write the date to the socket */
					pout.println( returnMsg);
					System.out.println( returnMsg );
					/* close the socket and resume */
					/* resume listening for connections */
					//client.close();
					// sock.close();
				}
				else
				{
					System.out.println( "here" );
					checkSocket = false;
					client.close();
					sock.close();
				}

			}
			
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		//System.out.println("exit while loop");
	}
}
