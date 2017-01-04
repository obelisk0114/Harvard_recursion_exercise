package nQueens;

import java.util.Scanner;

/*
 * http://blog.csdn.net/hackbuteer1/article/details/6657109
 * Loop Code 2
 * 
 * |x2-x1|==|y2-y1| means they are placed in diagonals.
 * 
 */

public class N_Queens_loop2 {
	private int[] result5;      // this array will store the result
	
	public N_Queens_loop2(int n) {
		result5 = new int[n];
		for (int i = 0; i < n; i++) {     // Initialize all elements are 0.
			result5[i] = 0;
		}
	}
	
	public boolean check (int y) {        // First put it into y row and check
		for (int i = 0; i < y; i++) {     // Compare y with 0 ~ (y-1)
			// Check column
			if (result5[i] == result5[y]) {
				return false;
			}
			// Check diagonal
			if (Math.abs(i - y) == Math.abs(result5[i] - result5[y])) {
				return false;
			}
		}
		return true;
	}
	
	public void placeQueen5(int n) {
		int num5 = 0, k = 0;
		System.out.print("The possible configuration of N queens are :\n");
		while (k >= 0) {
			if (k < n && result5[k] < n) {  // (k) row (result5[k]) column
				if (check(k)) {
					k++;                    // Go to next row
					if (k < n) {
						result5[k] = 0;     // Move to first column
					}
				}
				else {
					result5[k]++;           // Next column
				}
			}
			else {
				if (k == n) {               // Complete one of a solution sets
					num5++;
					System.out.printf("[%d]:  ",num5);
					displaySolution5(n);
				}
				else if (k == 0) {
					break;         // If it is the first row, we find all solutions.
				}
				
				/*
* k = n, we move to next column in the last row for finding other solutions.
* result5[k] = n, we can't find a position to place queen, go back to the previous row
				 */
				k--;          // Move queen's position to next column in previous row
				result5[k]++; // Next column
			}
		}
		System.out.println("The count is : " + num5 + " \n");
	}
	
	public void displaySolution5(int n) {
		for (int i1 = 0; i1 < n; i1++) {
			System.out.print("(" + i1 + ", " + result5[i1] + ")  ");
		}
		System.out.println();
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == result5[count]) {
					System.out.print("¡´ ");
				}
				else {
					System.out.print("¡³ ");
				}
			}
			count++;
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.print("*********   N Queen's problem   **********\n");
			System.out.print("              1. N Queen                \n");
			System.out.print("              2. Exit                   \n");
			System.out.print("**************************************\n");
			System.out.print("\n    Choose from 1 and 2\n\n");
			System.out.print("    Please input the function number : __\n");
			int choose = keyboard.nextInt();
			switch(choose) {
			case 1:
				System.out.println("Input the number n : ");
				int n = keyboard.nextInt();
				if (n > 0) {
					N_Queens_loop2 nq5 = new N_Queens_loop2(n);
					nq5.placeQueen5(n);
					break;
				}
				else {
					System.out.println("Input error. You must input an integer > 0 ");
					break;
				}
			case 2:
				System.out.println("Bye");
				keyboard.close();
				System.exit(0);
			default:
				System.out.println("Error. You must enter 1 or 2.\n");
				break;
			}
			
		}
		while(true);
		
	}

}
