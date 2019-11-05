import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws JsonProcessingException {
		String string = args[0];
		String splitterStr = args[1];
		char splitterChar = splitterStr.charAt(0);

		boolean isPalindrome = true;
		for (int i = 0; i < string.length() / 2 - 1; i++) {
			if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
				isPalindrome = false;
			}
		}

		if (isPalindrome) {
			System.out.println("String is palindrome");
		}

		System.out.println(Arrays.toString(string.split(String.valueOf(splitterChar))));

		if (string.length() >= 5) {
			System.out.println("Fifth char is " + string.charAt(4));
		}

		char[] reversedChars = new char[string.length()];
		for (int i = string.length() - 1; i >= 0; i--) {
			reversedChars[string.length() - i - 1] = string.charAt(i);
		}
		System.out.println("Reversed: " + Arrays.toString(reversedChars));

		System.out.println(new ObjectMapper().writeValueAsString(new TwoPropObject("asdf", 42)));

		// Crash
		main(args);
	}

	private static class TwoPropObject {
		String prop1;
		int prop2;

		public TwoPropObject(final String prop1, final int prop2) {
			this.prop1 = prop1;
			this.prop2 = prop2;
		}

		public String getProp1() {
			return prop1;
		}

		public int getProp2() {
			return prop2;
		}
	}
}
