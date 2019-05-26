public class LongPressedName {


	public static boolean isLongPressedName(String name, String typed) {
		if (name.equals(typed))
			return true;
		if (name.length() > typed.length())
			return false;

		int j = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != typed.charAt(j))
				return false;
			// name当前位置与相邻位置的字母不相同，则定位typed中下一个与当前name字母不同的位置
			if (i + 1 == name.length() || name.charAt(i) != name.charAt(i + 1)) {
				while (j < typed.length() && typed.charAt(j) == name.charAt(i))
					j++;
				if (j == typed.length()) {
					return i + 1 == name.length();
				}
			} else if (name.charAt(i) == name.charAt(i + 1)) {  // 当前位置name字母与相邻位置的字母相同，则与typed中的字母逐个比较
				j++;
			}
		}

		return j + 1 >= typed.length();

	}


	public static void main(String[] args) {
		System.out.println(isLongPressedName("alex", "alex"));
		System.out.println(isLongPressedName("alex", "aaleex"));
		System.out.println(isLongPressedName("saeed", "ssaaedd"));
		System.out.println(isLongPressedName("leelee", "lleeelee"));
		System.out.println(isLongPressedName("laiden", "laiden"));
		System.out.println(isLongPressedName("j", "jj"));
		System.out.println(isLongPressedName("ja", "jaa"));
	}

}
