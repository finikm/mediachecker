package gr.ntua.image;

/**
 * User:    Finik
 * Date:    15/12/15
 * Version: 1.0
 */

import gr.ntua.image.daemon.Daemon;
import gr.ntua.image.daemon.Connection;
import gr.ntua.image.mediachecker.MediaChecker;

import java.io.*;

public class MediaCheckerDaemon extends Daemon {

	public String processQuery(String query) {

		try {
			String mime = MediaChecker.getMimeType(query);
			switch (mime) {
				case "image/jpeg":
				case "image/png":
				case "image/x-ms-bmp":
				case "image/gif":
				case "image/tiff":
					return MediaChecker.getImageInfo(query, "colormap.png").toJSON().toString();
				case "video/mp4":
				case "video/quicktime":
				case "video/avi":
				case "video/x-msvideo":
				case "video/x-m4v":
				case "video/x-flv":
				case "video/x-oggyuv":
				case "video/x-dirac":
				case "video/x-ogm":
				case "video/x-ogguvs":
				case "video/theora":
				case "video/x-oggrgb":
				case "video/ogg":
					return MediaChecker.getVideoInfo(query).toJSON().toString();
				case "audio/x-wav":
				case "audio/x-aiff":
				case "audio/basic":
				case "audio/midi":
				case "audio/mpeg":
				case "audio/mp4":
				case "audio/x-oggflac":
				case "audio/x-flac":
				case "audio/x-oggpcm":
				case "audio/ogg":
				case "audio/opus":
				case "audio/ogg; codecs=opus":
				case "audio/speex":
				case "audio/ogg; codecs=speex":
				case "audio/vorbis":
					return MediaChecker.getAudioInfo(query).toJSON().toString();
				default:
					return "{ \"error\": \"Unsupported file type: " + mime + "\" }";
			}
		}
		catch (IOException e) {
			return "{ \"error\": \"File not found!\" }";
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			return "{ \"error\": \"Unknown exception!\" }";
		}
	}

	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Missing port number");
			System.exit(1);
		}

		MediaCheckerDaemon daemon = new MediaCheckerDaemon();
		try {
			int listenPort = Integer.parseInt(args[0]);
			daemon.startListener(listenPort);
			System.out.println("Daemon is now listening for connections on port " + listenPort);

			while (daemon.isListening()) {
				new Connection(daemon.accept(), daemon).start();
			}

			daemon.stopListener();
		}
		catch (IOException e) {
			System.err.println("Port " + args[0] + " already in use. Change port in config/daemon.conf and try again.");
			System.exit(1);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

}
