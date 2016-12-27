package removeVowels;

import java.util.Scanner;

public class RemoveStringVowels {
	public static String remove(String str) {
		String tmp = "";
		if (str == null || str.equals("")) {
			return "";
		}
		
		char letter = str.charAt(0);
		switch(letter) {
		case 'a':
			tmp = remove(str.substring(1));
			return "" + tmp;
		case 'e':
			tmp = remove(str.substring(1));
			return "" + tmp;
		case 'i':
			tmp = remove(str.substring(1));
			return "" + tmp;
		case 'o':
			tmp = remove(str.substring(1));
			return "" + tmp;
		case 'u':
			tmp = remove(str.substring(1));
			return "" + tmp;
		default:
			tmp = remove(str.substring(1));
			return String.valueOf(str.charAt(0)) + tmp;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input the strings.");
		String str = keyboard.nextLine();
		System.out.println(remove(str));
		keyboard.close();

	}

}
