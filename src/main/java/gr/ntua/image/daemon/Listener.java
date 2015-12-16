package gr.ntua.image.daemon;

/**
 * User:    Finik
 * Date:    15/12/15
 * Version: 1.0
 */

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Listener {
	private int port;
	private ServerSocket sock;

	public Listener(int port) {
		this.port = port;
	}

	public void start() throws IOException {
		sock = new ServerSocket(port);
	}

	public void stop() throws IOException {
		sock.close();
	}

	public Socket accept() throws IOException {
		return sock.accept();
	}

}
