package gr.ntua.image.daemon;

/**
 * User:    Finik
 * Date:    15/12/15
 * Version: 1.0
 */

import java.io.*;
import java.net.Socket;
import java.util.*;

public abstract class Daemon {
	private static Listener listener;
	private boolean listening = true;

	public void startListener(int port) throws IOException {
		listener = new Listener(port);
		listener.start();
	}

	public void stopListener() throws IOException {
		listener.stop();
	}

	public boolean isListening() {
		return listening;
	}

	public Socket accept() throws IOException {
		return listener.accept();
	}

	public abstract String processQuery(String query) throws IOException;

}
