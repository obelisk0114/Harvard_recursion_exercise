package nQueens;

import java.util.Scanner;

/*
 * http://blog.csdn.net/hackbuteer1/article/details/6657109
 * Loop Code 1
 * 
 * |x2-x1|==|y2-y1| means they are placed in diagonals.
 * 
 */

public class N_Queens_loop {
	private int[] result4;      // this array will store the result
	private int num4 = 0;        // this number will tell us how many solutions
	
	public N_Queens_loop(int n) {
		result4 = new int[n];
		for (int i = 0; i < n; i++) {
			result4[i] = -1;
		}
	}
	
	public void placeQueen4(int n) {
		int x = 0, y = 0;
		while (y < n) {
			while (x < n) {
				if (isSafe4(x, y)) {
					result4[y] = x; // Place queen
					x = 0;          // Reset
					break;          // Next row
				}
				else {
					++x;            // Next column
				}
			}
			
			if (result4[y] == -1) { // We can't find position to place queen in x
				if (y == 0) {       // If it is the first row, we find all solutions.
					break;
				}
				else {              // Go back to the previous row
					--y;
					x = result4[y] + 1; // Move queen's position to next column in previous row
					result4[y] = -1;    // Reset the answer
					continue;
				}
			}
			
			if (y == n-1) {        // We find a solution
				displaySolution4(n);
				num4++;
				x = result4[y] + 1; // Move to next column which is in the last row.
				result4[y] = -1;    // Reset the answer
				continue;
			}
			
			++y;                    // Move to next row
		}
	}
	
	public boolean isSafe4 (int x, int y) {
		for (int i = 0; i < y; i++) {
			// Check column
			if (result4[i] == x) {
				return false;
			}
			// Check diagonal
			if (Math.abs(i - y) == Math.abs(result4[i] - x)) {
				return false;
			}
		}
		return true;
	}
	
	public void displaySolution4(int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == result4[count]) {
					System.out.print("1 ");
				}
				else {
					System.out.print("0 ");
				}
			}
			count++;
			System.out.println();
		}
		System.out.println();
	}
	
	public int getNum4() {
		return num4;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the number n : ");
		int n = keyboard.nextInt();
		N_Queens_loop nq4 = new N_Queens_loop(n);
		System.out.println("All answer : ");
		nq4.placeQueen4(n);
		System.out.println("Total solution : " + nq4.getNum4());
		
		keyboard.close();
	}

}
