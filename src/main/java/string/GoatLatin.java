package string;

public class GoatLatin {


	public static String toGoatLatin(String S) {
		if (S.length() == 1) {
			return S + "maa";
		}
		StringBuilder sb = new StringBuilder();
		int words = 0;
		int index = 0;
		boolean vowel = false;
		char appendedLetter = ' ';
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == ' ' || i==S.length() - 1) { // 单词结尾或字符串结束
				words++;
				index = 0;
				if (i==S.length() - 1) { // 字符串结束，先拼凑上最后一个字母，再拼goat latin
					sb.append(c);
				}
				if (!vowel && appendedLetter != ' ') {
					sb.append(appendedLetter);
					appendedLetter = ' ';
				}
				sb.append('m');
				sb.append('a');
				for (int j = 0; j < words; j++) {
					sb.append('a');
				}
				if (c == ' ') { // 单词结尾，先拼goat latin，再拼' '
					sb.append(c);
				}
			} else if (index == 0) { // 每个单词的起始位置
				index++;
				vowel = false;
				if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O'
						|| c == 'u' || c == 'U') {
					sb.append(c);
					vowel = true;
				} else {
					appendedLetter = c;
				}
			} else {
				sb.append(c);
				index++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(toGoatLatin("I speak Goat Latin").equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
		System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog").equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
		System.out.println(toGoatLatin("I"));
		System.out.println(toGoatLatin("t"));
		System.out.println(toGoatLatin("HZ sg L"));
		System.out.println(toGoatLatin("HZ sg na"));
	}
}
