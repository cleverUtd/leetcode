package string;

public class ToLowerCase {

	public static String toLowerCase(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				sb.append((char) (c - 'A' + 'a'));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		System.out.println(toLowerCase("Hello"));
		System.out.println(toLowerCase("here"));
		System.out.println(toLowerCase("LOVELY"));
		System.out.println(toLowerCase("al&phaBET"));
	}
}
