package nQueens;

import java.util.Scanner;

/*
 * http://algorithms.tutorialhorizon.com/backtracking-n-queens-problem-better-solution/
 * 
 * |x2-x1|==|y2-y1| means they are placed in diagonals.
 */

public class N_Queens2 {
	private int[] result;
	private int recordX;         // Record last used column
	private int recordY;         // Record last used row
	private boolean back;        // Trace back to get anther solution 
	private boolean complete;    // Mark whether we get one of a solution
	
	public N_Queens2(int n) {
		result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = -1;
		}
		recordX = -1;
		recordY = -1;
		//back = false;
		back = true;
		complete = false;
	}
	
	public void placeQueen2(int x, int y, int n) {
		if (y == n) {
			displaySolution2(n);
			complete = true;
			return;
		}
		complete = false;
		for (int i = x; i < n; i++) {
			if (isSafe2(i, y)) {
				result[y] = i;
				recordX = i;
				recordY = y;
				placeQueen2(0, y + 1, n);
				if (complete) {
					return;
				}
			}
		}
		
//		back = false;
//		if ((result[n-1] != -1) && x != 0) {
//			back = true;
//		}
		
		if (back) {
			// Go back to the upper row, column move backwards
			if (y-1 < 0) {
				System.out.println("There are no other solutions.");
				System.exit(0);				
			}
			int back_to_next_col = result[y-1] + 1;
			placeQueen2(back_to_next_col, y-1, n);			
		}
		
	}
	
	public boolean isSafe2 (int x, int y) {
		for (int i = 0; i < y; i++) {
			// Check column
			if (result[i] == x) {
				return false;
			}
			// Check diagonal
			if (Math.abs(i - y) == Math.abs(result[i] - x)) {
				return false;
			}
		}
		return true;
	}
	
	public void displaySolution2(int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == result[count]) {
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
	
	public int getX() {
		return recordX;
	}
	
	public int getY() {
		return recordY;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the number n : ");
		int n = keyboard.nextInt();
		N_Queens2 nq2 = new N_Queens2(n);
		System.out.println("One of answer : ");
		int x = 0, y = 0;
		while (true) {
			nq2.placeQueen2(x, y, n);
			System.out.println("Do you want another answer ? ");
			String want = keyboard.next();
			if (want.equalsIgnoreCase("n")) {				
				break;
			}
			x = nq2.getX() + 1;
			y = nq2.getY();
		}
		
		keyboard.close();
	}
}
