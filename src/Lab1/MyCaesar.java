package Lab1;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public static final char[] DIGIT = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private int n;

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		if (Character.isDigit(c)) {
			for (int i = 0; i < DIGIT.length; i++) {
				if (c == DIGIT[i]) {
					return DIGIT[(i + n) % DIGIT.length];
				}
			}
		} else {
			for (int i = 0; i < ALPHABET.length; i++) {
				if (Character.isUpperCase(c)) {
					if (c == ALPHABET[i]) {
						return ALPHABET[(i + n) % ALPHABET.length];
					}
				} else {
					if (Character.toUpperCase(c) == ALPHABET[i]) {
						return Character.toLowerCase(ALPHABET[(i + n) % ALPHABET.length]);
					}
				}

			}
		}
		return ' ';
	}

	public char decryptChar(char c) {
		if (Character.isDigit(c)) {
			for (int i = 0; i < DIGIT.length; i++) {
				if (c == DIGIT[i]) {
					if (i >= n) {
						return DIGIT[(i - n) % DIGIT.length];
					} else {
						return DIGIT[DIGIT.length - (n - i)];
					}
				}
			}
		} else {
			for (int i = 0; i < ALPHABET.length; i++) {
				if (Character.isUpperCase(c)) {
					if (c == ALPHABET[i]) {
						if (i >= n) {
							return ALPHABET[(i - n) % ALPHABET.length];
						} else {
							return ALPHABET[ALPHABET.length - (n - i)];
						}
					}
				} else {
					if (Character.toUpperCase(c) == ALPHABET[i]) {
						if (i >= n) {
							return Character.toLowerCase(ALPHABET[(i - n) % ALPHABET.length]);
						} else {
							return Character.toLowerCase(ALPHABET[ALPHABET.length - (n - i)]);
						}
					}
				}

			}
		}

		return ' ';
	}

	public String encrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += encryptChar(input.charAt(i));
		}
		return result;
	}

	public String decrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += decryptChar(input.charAt(i));
		}
		return result;
	}

	public static void main(String[] args) {
		MyCaesar myCaesar = new MyCaesar(4);

		System.out.println(myCaesar.encryptChar('z'));
		System.out.println(myCaesar.encryptChar('4'));
		System.out.println(myCaesar.encrypt("I am student1"));

		System.out.println(myCaesar.decryptChar('I'));
		System.out.println(myCaesar.decryptChar('1'));
		System.out.println(myCaesar.decrypt("I am student2"));
	}
}
