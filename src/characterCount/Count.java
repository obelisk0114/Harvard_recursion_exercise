package characterCount;

import java.util.Scanner;

public class Count {
	public static int count(char ch, String str, int num) {
		int tmp;
		if (str == null || str.equals("")) {
			return num;
		}
		if (str.charAt(0) == ch) {
			tmp = count(ch, str.substring(1), ++num);
		}
		else {			
			tmp = count(ch, str.substring(1), num);
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the string : ");
		String str = keyboard.nextLine();
		System.out.println("Input the character : ");
		char ch = keyboard.next().charAt(0);
		int ans = count(ch, str, 0);
		System.out.println(ans);
		
		keyboard.close();
	}

}
