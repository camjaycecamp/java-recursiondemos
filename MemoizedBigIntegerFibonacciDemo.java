/*
 * cameron campbell
 * advanced java
 * occc spring 2021
 * memoized big integer fibonacci demo
 */

import java.math.BigInteger;
import java.util.Scanner;

public class MemoizedBigIntegerFibonacciDemo 
{
	// including memoization for greater efficiency than the program's exponential default processing cost
	public static BigInteger[] theMemo;
	
	/*
	 * the main method takes the user's inputs (either through runtime or command args) and then finds the fibonacci
	 * sequence at that increment using the chosen method before displaying the value at said increment and the time
	 * required to compute that value. this program was based upon the methods outlined in the PowerPoint.
	 */
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		BigInteger val = new BigInteger("0");
	    
	    if ( args.length == 1 )
	    {
	    	val = new BigInteger(args[0]);
	    }
	    else
	    {
	        System.out.print("Please enter value: ");
	        val = new BigInteger(s.nextLine());
	    }
	    
	    
	    System.out.println("Do you want your answer computed using a loop or recursion?"
	    		+ "\n Type '1' for a loop and '2' for recursion.");
	    int method = s.nextInt();
	    
	    if (method == 1) 
	    {
	    	long t1 = System.currentTimeMillis();
		    System.out.println("Fib(" + val + ") = " + Fib_Loop(val) );
		    long t2 = System.currentTimeMillis();
		    System.out.println("Elapsed time: " + ( t2 - t1 ) / 1000. + " seconds");
		    System.out.println("Number of digits in Fibonacci increment: " + Fib_Loop(val).toString().length());
	    }
	    else if (method == 2) 
	    {
	    	long t1 = System.currentTimeMillis();
		    theMemo = new BigInteger[val.intValue() + 1];
		    System.out.println("Fib(" + val + ") = " + Fib_Recursive(val) );
		    long t2 = System.currentTimeMillis();
		    System.out.println("Elapsed time: " + ( t2 - t1 ) / 1000. + " seconds");
		    System.out.println("Number of digits in Fibonacci increment: " + Fib_Recursive(val).toString().length());
	    }
	}
	
	/*
	 * the Fib_Loop method finds the value of the fibonacci sequence at the passed value using
	 * a for-loop, then returns the value to the main method to be displayed.
	 */
	public static BigInteger Fib_Loop(BigInteger n)
	{
		
	    BigInteger result = new BigInteger("1");
	    if (n.longValue() > 2)
	    {
	       long a = 1;
	       long b = 1;
	       for(int count = 3; count <= n.longValue(); count++)
	       {
	    	 long sum = a + b;
	    	 BigInteger c = new BigInteger(String.valueOf(sum));
	         result = c;
	         a = b;
	         b = result.longValue();
	       }
	    }
	    return result;
	}
	
	/*
	 * the Fib_Recursive method finds the value of the fibonacci sequence at the passed value using
	 * recursion, then returns the value to the main method to be displayed.
	 */
	public static BigInteger Fib_Recursive(BigInteger n)
	{
	    BigInteger result = new BigInteger("1");
	    if (n.longValue() > 2)
	    {
	       if ( theMemo[n.intValue()] != null )
	       {
	          result = theMemo[n.intValue()];  
	       }
	       else
	       {
	    	  BigInteger a = new BigInteger("1");
	    	  BigInteger b = new BigInteger("2");
	    	  BigInteger f1 = new BigInteger(Fib_Recursive(n.subtract(a)).toString());
	    	  BigInteger f2 = new BigInteger(Fib_Recursive(n.subtract(b)).toString());
	    	  
	    	  result = f1.add(f2);
	          theMemo[n.intValue()] = result;  
	       }
	    }
	    return result;
	  }
}
