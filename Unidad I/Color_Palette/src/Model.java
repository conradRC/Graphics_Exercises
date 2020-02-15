import java.util.regex.Pattern;

public class Model {
	public static int [] converToDecimal(String cadena) {
		int size = cadena.length();
		int[] array = new int[3];
		String hr = cadena.substring(0, 2);
		String hg = cadena.substring(2, 4);
		String hb = cadena.substring(4,size);
		array[0] = Integer.parseInt(hr, 16);
		array[1] = Integer.parseInt(hg, 16);
		array[2] = Integer.parseInt(hb, 16);
		return array;
	}
	
	public static String convertToHex(int r, int g, int b) {
		String hr = Integer.toHexString(r);
		String hg = Integer.toHexString(g);
		String hb = Integer.toHexString(b);

		if (regexLetters(hr)) hr="0"+hr;
		if (regexLetters(hg)) hg="0"+hg;
		if (regexLetters(hb)) hb="0"+hb;
		
		if (r < 10 ) hr = "0" + hr;
		if (g < 10 ) hg = "0" + hg;
		if (b < 10 ) hb = "0" + hb;
		
		String a = (hr + hg + hb).toUpperCase();
		return a;
	}

	public static boolean isValid(int value) {
		return (value <= 255 && value >= 0) ? true : false;
	}

	public static boolean regex(String hex) {
		return Pattern.matches("[a-fA-F0-9]+", hex);
	}
	
	public static boolean regexLetters(String hex) {
		return Pattern.matches("[A-Fa-f]", hex);
	}

}
