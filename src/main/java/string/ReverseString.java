package string;

public class ReverseString {

	public static void reverseString(char[] s) {
		char temp;
		for (int i = 0, j = s.length - 1; i < j; i++, j--) {
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
	}


	public static void main(String[] args) {
		reverseString(new char[]{'h','e','l','l','o'});
		reverseString("Hannah".toCharArray());
		reverseString("a".toCharArray());
	}
}
