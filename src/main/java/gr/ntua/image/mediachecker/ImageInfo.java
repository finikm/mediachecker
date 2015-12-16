package gr.ntua.image.mediachecker;

import java.util.Arrays;
import org.json.JSONObject;
import org.json.JSONArray;

public final class ImageInfo {

	protected final int _Width, _Height;
	protected final String _MimeType, _FileFormat, _ColorSpace;
	protected final String[] _Palette;

	public ImageInfo(int width, int height, String mimeType, String fileFormat, String colorSpace, String[] palette) {
		_Width      = width;
		_Height     = height;
		_MimeType   = mimeType;
		_FileFormat = fileFormat;
		_ColorSpace = colorSpace;
		_Palette    = palette;
	}

	public int getWidth() {
		return _Width;
	}

	public int getHeight() {
		return _Height;
	}

	public String getMimeType() {
		return _MimeType;
	}

	public String getFileFormat() {
		return _FileFormat;
	}

	public String getColorSpace() {
		return _ColorSpace;
	}

	public String[] getPalette() {
		return _Palette;
	}

	public String toString() {
		String out = "Mime Type: " + _MimeType + "\n" +
			"File Format: " + _FileFormat + "\n" +
			"Width: " + _Width + "\n" +
			"Height: " + _Height + "\n" +
			"Colorspace: " + _ColorSpace + "\n" +
			"Color Palette: " + Arrays.toString(_Palette);

		return out;
	}

	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();

		jo.put("mimetype", _MimeType);
		jo.put("format", _FileFormat);
		jo.put("width", _Width);
		jo.put("height", _Height);
		jo.put("colorspace", _ColorSpace);

		JSONArray ja = new JSONArray();
		for (String c : _Palette) {
			ja.put(c);
		}
		jo.put("palette", ja);

		return jo;
	}

}