package printReverse;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PrintReverseFile {
	public static void printRecursive(Scanner input) {
		// base case
		if (!input.hasNextLine()) {
			return;
		}
		// recursive case
		String line = input.nextLine();
		printRecursive(input); // print the rest
		System.out.println(line);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//creating File instance to reference text file in Java
		File text = new File("C:/Users/15T-J000/Documents/GitHub/Harvard_recursion_exercise/src/printReverse/inputTxt.txt");
		
		Scanner keyboard = new Scanner(text);
		printRecursive(keyboard);
		keyboard.close();
	}

}
