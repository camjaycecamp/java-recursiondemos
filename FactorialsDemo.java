/*
 * cameron campbell
 * advanced java
 * occc spring 2021
 * Factorials Demo
 */

import java.util.Scanner;

public class FactorialsDemo 
{
	
	public static void main (String [] args)
	{
	    long val = 0;
	    Scanner s = new Scanner(System.in);
	    
	    if ( args.length == 1 )
	    {
	       val = Integer.parseInt(args[0]);
	    }
	    else
	    {
	       System.out.print("Please enter value: ");
	       val = s.nextInt();
	    }
	    
	    System.out.println("Do you want your answer computed using a loop or recursion?"
	    		+ "\n ype '1' for a loop and '2' for recursion.");
	    int method = s.nextInt();
	    
	    if (method == 1) 
	    {
	    	long t1 = System.currentTimeMillis();
		    System.out.println(val + "! = " + Factorial_Loop(val) );
		    long t2 = System.currentTimeMillis();
		    System.out.println("The elapsed time is " + ( t2 - t1 ) / 1000.  + " seconds.");
	    }
	    else if (method == 2) 
	    {
	    	long t1 = System.currentTimeMillis();
		    System.out.println(val + "! = " + Factorial_Recursive(val) );
		    long t2 = System.currentTimeMillis();
		    System.out.println("The elapsed time is " + ( t2 - t1 ) / 1000.  + " seconds.");
	    }
	  }

	public static long Factorial_Loop(long n)
	{
	    long result = 1;
	    if (n > 1)
	    {
	      for(int i = 1; i <= n; i++)
	      {
	         result *= i;
	      }
	    }
	    return result;
	  }
	
	public static long Factorial_Recursive(long n)
	 {
		    long result = 1;
		    if (n > 1)
		    {
		      result = n * Factorial_Recursive(n-1);
		    }
		    return result;
	 }
}
