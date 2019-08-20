package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static Map<Character, Integer> map = new HashMap<Character, Integer>() {
		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};

	public static int romanToInt(String s) {
		char[] roman = s.toCharArray();
		int sum = 0;
		int temp;
		int i = 0;
		for (; i < roman.length; i++) {
			if (i == roman.length - 1) {
				temp = map.get(roman[i]);
			} else {
				switch (roman[i]) {
					case 'I':
						if (roman[i + 1] == 'V') {
							temp = 4;
							i++;
						} else if (roman[i + 1] == 'X') {
							temp = 9;
							i++;
						} else {
							temp = map.get('I');
						}
						break;
					case 'X':
						if (roman[i + 1] == 'L') {
							temp = 40;
							i++;
						} else if (roman[i + 1] == 'C') {
							temp = 90;
							i++;
						} else {
							temp = map.get('X');
						}
						break;
					case 'C':
						if (roman[i + 1] == 'D') {
							temp = 400;
							i++;
						} else if (roman[i + 1] == 'M') {
							temp = 900;
							i++;
						} else {
							temp = map.get('C');
						}
						break;
					default:
						temp = map.get(roman[i]);
				}
			}

			sum += temp;
		}
		return sum;
	}


	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}
}
