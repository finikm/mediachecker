package gr.ntua.image.mediachecker;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.lang.Math;
import java.util.Comparator;
import java.util.Collections;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class ColorPalette {

	public static final HashMap<String, Color> colors;
	static {
		colors = new HashMap<String, Color>();
		colors.put("aliceblue", new Color("F0F8FF"));
		colors.put("antiquewhite", new Color("FAEBD7"));
		colors.put("aqua", new Color("00FFFF"));
		colors.put("aquamarine", new Color("7FFFD4"));
		colors.put("azure", new Color("F0FFFF"));
		colors.put("beige", new Color("F5F5DC"));
		colors.put("bisque", new Color("FFE4C4"));
		colors.put("black", new Color("000000"));
		colors.put("blanchedalmond", new Color("FFEBCD"));
		colors.put("blue", new Color("0000FF"));
		colors.put("blueviolet", new Color("8A2BE2"));
		colors.put("brown", new Color("A52A2A"));
		colors.put("burlywood", new Color("DEB887"));
		colors.put("cadetblue", new Color("5F9EA0"));
		colors.put("chartreuse", new Color("7FFF00"));
		colors.put("chocolate", new Color("D2691E"));
		colors.put("coral", new Color("FF7F50"));
		colors.put("cornflowerblue", new Color("6495ED"));
		colors.put("cornsilk", new Color("FFF8DC"));
		colors.put("crimson", new Color("DC143C"));
		colors.put("cyan", new Color("00FFFF"));
		colors.put("darkblue", new Color("00008B"));
		colors.put("darkcyan", new Color("008B8B"));
		colors.put("darkgoldenrod", new Color("B8860B"));
		colors.put("darkgray", new Color("A9A9A9"));
		colors.put("darkgreen", new Color("006400"));
		colors.put("darkgrey", new Color("A9A9A9"));
		colors.put("darkkhaki", new Color("BDB76B"));
		colors.put("darkmagenta", new Color("8B008B"));
		colors.put("darkolivegreen", new Color("556B2F"));
		colors.put("darkorange", new Color("FF8C00"));
		colors.put("darkorchid", new Color("9932CC"));
		colors.put("darkred", new Color("8B0000"));
		colors.put("darksalmon", new Color("E9967A"));
		colors.put("darkseagreen", new Color("8FBC8F"));
		colors.put("darkslateblue", new Color("483D8B"));
		colors.put("darkslategray", new Color("2F4F4F"));
		colors.put("darkslategrey", new Color("2F4F4F"));
		colors.put("darkturquoise", new Color("00CED1"));
		colors.put("darkviolet", new Color("9400D3"));
		colors.put("deeppink", new Color("FF1493"));
		colors.put("deepskyblue", new Color("00BFFF"));
		colors.put("dimgray", new Color("696969"));
		colors.put("dimgrey", new Color("696969"));
		colors.put("dodgerblue", new Color("1E90FF"));
		colors.put("firebrick", new Color("B22222"));
		colors.put("floralwhite", new Color("FFFAF0"));
		colors.put("forestgreen", new Color("228B22"));
		colors.put("fuchsia", new Color("FF00FF"));
		colors.put("gainsboro", new Color("DCDCDC"));
		colors.put("ghostwhite", new Color("F8F8FF"));
		colors.put("gold", new Color("FFD700"));
		colors.put("goldenrod", new Color("DAA520"));
		colors.put("gray", new Color("808080"));
		colors.put("green", new Color("008000"));
		colors.put("greenyellow", new Color("ADFF2F"));
		colors.put("grey", new Color("808080"));
		colors.put("honeydew", new Color("F0FFF0"));
		colors.put("hotpink", new Color("FF69B4"));
		colors.put("indianred", new Color("CD5C5C"));
		colors.put("indigo", new Color("4B0082"));
		colors.put("ivory", new Color("FFFFF0"));
		colors.put("khaki", new Color("F0E68C"));
		colors.put("lavender", new Color("E6E6FA"));
		colors.put("lavenderblush", new Color("FFF0F5"));
		colors.put("lawngreen", new Color("7CFC00"));
		colors.put("lemonchiffon", new Color("FFFACD"));
		colors.put("lightblue", new Color("ADD8E6"));
		colors.put("lightcoral", new Color("F08080"));
		colors.put("lightcyan", new Color("E0FFFF"));
		colors.put("lightgoldenrodyellow", new Color("FAFAD2"));
		colors.put("lightgray", new Color("D3D3D3"));
		colors.put("lightgreen", new Color("90EE90"));
		colors.put("lightgrey", new Color("D3D3D3"));
		colors.put("lightpink", new Color("FFB6C1"));
		colors.put("lightsalmon", new Color("FFA07A"));
		colors.put("lightseagreen", new Color("20B2AA"));
		colors.put("lightskyblue", new Color("87CEFA"));
		colors.put("lightslategray", new Color("778899"));
		colors.put("lightslategrey", new Color("778899"));
		colors.put("lightsteelblue", new Color("B0C4DE"));
		colors.put("lightyellow", new Color("FFFFE0"));
		colors.put("lime", new Color("00FF00"));
		colors.put("limegreen", new Color("32CD32"));
		colors.put("linen", new Color("FAF0E6"));
		colors.put("magenta", new Color("FF00FF"));
		colors.put("maroon", new Color("800000"));
		colors.put("mediumaquamarine", new Color("66CDAA"));
		colors.put("mediumblue", new Color("0000CD"));
		colors.put("mediumorchid", new Color("BA55D3"));
		colors.put("mediumpurple", new Color("9370DB"));
		colors.put("mediumseagreen", new Color("3CB371"));
		colors.put("mediumslateblue", new Color("7B68EE"));
		colors.put("mediumspringgreen", new Color("00FA9A"));
		colors.put("mediumturquoise", new Color("48D1CC"));
		colors.put("mediumvioletred", new Color("C71585"));
		colors.put("midnightblue", new Color("191970"));
		colors.put("mintcream", new Color("F5FFFA"));
		colors.put("mistyrose", new Color("FFE4E1"));
		colors.put("moccasin", new Color("FFE4B5"));
		colors.put("navajowhite", new Color("FFDEAD"));
		colors.put("navy", new Color("000080"));
		colors.put("oldlace", new Color("FDF5E6"));
		colors.put("olive", new Color("808000"));
		colors.put("olivedrab", new Color("6B8E23"));
		colors.put("orange", new Color("FFA500"));
		colors.put("orangered", new Color("FF4500"));
		colors.put("orchid", new Color("DA70D6"));
		colors.put("palegoldenrod", new Color("EEE8AA"));
		colors.put("palegreen", new Color("98FB98"));
		colors.put("paleturquoise", new Color("AFEEEE"));
		colors.put("palevioletred", new Color("DB7093"));
		colors.put("papayawhip", new Color("FFEFD5"));
		colors.put("peachpuff", new Color("FFDAB9"));
		colors.put("peru", new Color("CD853F"));
		colors.put("pink", new Color("FFC0CB"));
		colors.put("plum", new Color("DDA0DD"));
		colors.put("powderblue", new Color("B0E0E6"));
		colors.put("purple", new Color("800080"));
		colors.put("red", new Color("FF0000"));
		colors.put("rosybrown", new Color("BC8F8F"));
		colors.put("royalblue", new Color("4169E1"));
		colors.put("saddlebrown", new Color("8B4513"));
		colors.put("salmon", new Color("FA8072"));
		colors.put("sandybrown", new Color("F4A460"));
		colors.put("seagreen", new Color("2E8B57"));
		colors.put("seashell", new Color("FFF5EE"));
		colors.put("sienna", new Color("A0522D"));
		colors.put("silver", new Color("C0C0C0"));
		colors.put("skyblue", new Color("87CEEB"));
		colors.put("slateblue", new Color("6A5ACD"));
		colors.put("slategray", new Color("708090"));
		colors.put("slategrey", new Color("708090"));
		colors.put("snow", new Color("FFFAFA"));
		colors.put("springgreen", new Color("00FF7F"));
		colors.put("steelblue", new Color("4682B4"));
		colors.put("tan", new Color("D2B48C"));
		colors.put("teal", new Color("008080"));
		colors.put("thistle", new Color("D8BFD8"));
		colors.put("tomato", new Color("FF6347"));
		colors.put("turquoise", new Color("40E0D0"));
		colors.put("violet", new Color("EE82EE"));
		colors.put("wheat", new Color("F5DEB3"));
		colors.put("white", new Color("FFFFFF"));
		colors.put("whitesmoke", new Color("F5F5F5"));
		colors.put("yellow", new Color("FFFF00"));
		colors.put("yellowgreen", new Color("9ACD32"));
	}

	public static Color getIndexedColor(Color sample) {
		Color similarColor = null;
		double minDistance = Double.MAX_VALUE;

		for (Map.Entry<String, Color> entry : colors.entrySet()) {
			double distance = getColorDistance(sample, entry.getValue());
			if (minDistance > distance) {
				minDistance = distance;
				similarColor = entry.getValue();
			}
		}

		return similarColor;
	}

	private static double getColorDistance(Color c1, Color c2) {
		return Math.sqrt(Math.pow(c2.R - c1.R, 2) + Math.pow(c2.G - c1.G, 2) + Math.pow(c2.B - c1.B, 2));
	}

	public static void saveColorMap(String filename) throws IOException {
		BufferedImage img = new BufferedImage(colors.size(), 1, BufferedImage.TYPE_INT_RGB);

		int x = 0;
		for (Map.Entry<String, Color> entry : colors.entrySet()) {
			img.setRGB(x++, 0, entry.getValue().toRGB());
		}

		File outFile = new File(filename);
		ImageIO.write(img, "png", outFile);
	}
}