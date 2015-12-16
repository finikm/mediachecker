package gr.ntua.image.mediachecker;

public final class Color {

	public final int R, G, B;

	public Color(int red, int green, int blue) {
		R = red;
		G = green;
		B = blue;
	}

	public Color(String hex) {
		R = Integer.parseInt(hex.substring(0, 2), 16);
		G = Integer.parseInt(hex.substring(2, 4), 16);
		B = Integer.parseInt(hex.substring(4), 16);
	}

	public String toHex() {
		return Integer.toHexString(R) + Integer.toHexString(G) + Integer.toHexString(B);
	}

	public int toRGB() {
		int rgb = R;
		rgb = (rgb << 8) + G;
		rgb = (rgb << 8) + B;

		return rgb;
	}

}