
import java.net.*;
import java.io.*;

/*
* Take the input from the client and then look for the string server or client and replace it with client or server
* use the input stream class
*/
public class QuoteServer {

	public static void main(String[] args) {
		System.out.println("Server started");
		try {
			// started lab at 6013 changed to 17
			ServerSocket sock = new ServerSocket(6017);
			Boolean checkSocket = true;
			Socket client = sock.accept();
			/* now listen for connections */
			while (checkSocket) {
				System.out.println("in loop");
				
				System.out.println("in loop here");
				InputStream in = client.getInputStream();
				
				System.out.println("in loop2");
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				System.out.println("in loop3");
				System.out.println("in = " + in.read());
				if ( in.read() != -1)
				{
					//System.out.println("byte data " + in.read());
					BufferedReader bin = new BufferedReader(new InputStreamReader(in));
					String line;
					String returnMsg = "";
					while((line = bin.readLine()) != null) {
						//System.out.println(line);
						returnMsg += line;
					}
					//take input from server and return correct output
					returnMsg = returnMsg.replaceAll("client", "server");
					/* Write the date to the socket */
					pout.println("return string: " + returnMsg);
					System.out.println("return string: " + returnMsg);
					/* close the socket and resume */
					/* resume listening for connections */
					client.close();
					// sock.close();
				}
				else
				{
					checkSocket = false;
					client.close();
					sock.close();
				}

			}
			
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		System.out.println("exit while loop");
	}
}
