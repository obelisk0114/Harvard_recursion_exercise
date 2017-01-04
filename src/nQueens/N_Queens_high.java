package nQueens;

import java.util.Scanner;

/*
 * http://blog.csdn.net/hackbuteer1/article/details/6657109
 * Last code
 */

public class N_Queens_high {
	private static long upperlim = 1, sum = 0;
	
	public void test(long row, long ld, long rd) {
		if (row != upperlim)  
	    {  
	        // 
	        long pos = upperlim & ~(row | ld | rd);   
	        while (pos != 0)    //  
	        {  
	            //  
	            long p = pos & -pos;                                                
	 
	            // 
	            pos -= p;                             
	 
	            //
	            test(row + p, (ld + p) << 1, (rd + p) >> 1);                                
	        }  
	    }  
	    else     
	    {  
	        //  
	        sum++;  
	    } 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the number n : ");
		int n = keyboard.nextInt();
		// Integer can't deal with number which is larger than 32 bits. 
		if ((n < 1) || (n > 32)) {
			System.out.println("It can only calculate 1-32.");
			System.exit(-1);
		}
		System.out.printf("%d Queens\n", n);
		N_Queens_high nq6 = new N_Queens_high();
		long preTime = System.currentTimeMillis();
		// N queens only use n bits to store.
		// When there is a queen on a certain column, its bit is 1.  
	    upperlim = (upperlim << n) - 1;
		nq6.test(0, 0, 0);
		long aftTime = System.currentTimeMillis();
		long useTime = aftTime - preTime;
		System.out.print("Total solution : " + sum + " , Time : " + useTime + " ms\n");
		
		keyboard.close();
	}

}
