package nQueens;

/*
 * https://en.wikipedia.org/wiki/Eight_queens_puzzle
 * http://algorithms.tutorialhorizon.com/backtracking-n-queens-problem/
 * 
 * O(n^2)
 * Place the chess from top to bottom, so we only need to deal with column.
 * Try all the columns in the current row.
 * Check if queen can be placed here safely.
 * If placing the queen in above step leads to the solution return true.
 * If placing the queen in above step does not lead to the solution, return false
 * 
 */

import java.util.Scanner;

public class N_Queens {
	private int[][] solution;
	
	public N_Queens (int n) {
		solution = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				solution[i][j] = 0;
			}
		}
	}
	
	public boolean placeQueen(int row, int n) {
		// Last row is completed.
		if (row == n) {
			displaySolution(n);
			return true;
		}
		for (int col = 0; col < n; col++) {
			if (isSafe(solution, row, col)) {
				solution[row][col] = 1;
				if (placeQueen(row + 1, n)) {
					return true;
				}
				// if we are here that means above placement didn't work
				// BACKTRACK
				solution[row][col] = 0;
			}
		}
		
		// if we are here that means we haven't found solution
		return false;
	}
	
	public boolean isSafe(int[][] matrix, int row, int col) {
		// Check column
		for (int i = 0; i < row; i++) {
			if (matrix[i][col] == 1)
				return false;
		}
		// Check left diagonal
		for (int j1 = row, j2 = col; j1 >= 0 && j2 >= 0; j1--, j2--) {
			if (matrix[j1][j2] == 1) {
				return false;
			}
		}
		// Check right diagonal
		for (int k1 = row, k2 = col; k1 >= 0 && k2 < matrix[0].length; k1--, k2++) {
			if (matrix[k1][k2] == 1) {
				return false;
			}
		}
		return true;
	}
	
	public void displaySolution(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the number n : ");
		int n1 = keyboard.nextInt();
		N_Queens nq = new N_Queens(n1);
		System.out.println("One of answer : ");
		nq.placeQueen(0, n1);
		
		keyboard.close();

	}

}
