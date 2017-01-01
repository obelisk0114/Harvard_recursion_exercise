package nQueens;

import java.util.Scanner;

/*
 * http://algorithms.tutorialhorizon.com/backtracking-n-queens-problem-better-solution/
 * 
 * |x2-x1|==|y2-y1| means they are placed in diagonals.
 */

public class N_Queens3 {
	private int[] result3;      // this array will store the result
	private int num = 0;        // this number will tell us how many solutions
	
	public N_Queens3(int n) {
		result3 = new int[n];
	}
	
	public void placeQueen3(int y, int n) {
		if (y == n) {
			displaySolution3(n);
			num++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isSafe3(i, y)) {
				result3[y] = i;
				placeQueen3(y + 1, n);
			}
		}
	}
	
	public boolean isSafe3 (int x, int y) {
		for (int i = 0; i < y; i++) {
			// Check column
			if (result3[i] == x) {
				return false;
			}
			// Check diagonal
			if (Math.abs(i - y) == Math.abs(result3[i] - x)) {
				return false;
			}
		}
		return true;
	}
	
	public void displaySolution3(int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == result3[count]) {
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
	
	public int getNum() {
		return num;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the number n : ");
		int n = keyboard.nextInt();
		N_Queens3 nq3 = new N_Queens3(n);
		System.out.println("All answer : ");
		nq3.placeQueen3(0, n);
		System.out.println("Total solution : " + nq3.getNum());
		
		keyboard.close();
	}

}
