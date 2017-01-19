package removeVowels;

import java.util.Scanner;

public class removeVowel2 {
	private static String remove2(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			String tmp = Character.toString(str.charAt(i));
			if (!tmp.equals("a") && !tmp.equals("A") && 
				!tmp.equals("e") && !tmp.equals("E") && 
				!tmp.equals("i") && !tmp.equals("I") &&
				!tmp.equals("o") && !tmp.equals("O") &&
				!tmp.equals("u") && !tmp.equals("U")) {
				result += tmp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input the strings.");
		String str = keyboard.nextLine();
		System.out.println(remove2(str));
		keyboard.close();

	}

}
