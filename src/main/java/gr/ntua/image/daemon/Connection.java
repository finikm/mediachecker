package gr.ntua.image.daemon;

/**
 * User:    Finik
 * Date:    15/12/15
 * Version: 1.0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection extends Thread {
	private Socket socket = null;
	private Daemon daemon;

	public Connection(Socket socket, Daemon daemon) {
		super("Connection");
		this.socket = socket;
		this.daemon = daemon;
	}

	@Override
	public void run() {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				String result = result = daemon.processQuery(inputLine);
				out.println(result);
				break;	// Only one command is used for this connection
			}

			out.close();
			in.close();
			socket.close();
		}
		catch (IOException e) {
			System.err.println("Error opening Connection.");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.err.println("General error in connection.");
		}
	}
}