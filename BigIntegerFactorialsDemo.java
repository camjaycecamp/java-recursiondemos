/*
 * cameron campbell
 * advanced java
 * occc spring 2021
 * big integer factorials demo
 */

import java.util.Scanner;
import java.math.BigInteger;

public class BigIntegerFactorialsDemo
{
	/*
	 * practically everything in this program is identical to the FactorialsDemo program.
	 * the only major difference is that the values handled are all replaced with BigInt
	 * values, allowing the program to calculate to MUCH higher factorials for both looping
	 * and recursion.
	 */
	public static void main (String [] args)
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

	public static BigInteger Factorial_Loop(BigInteger n)
	{
	    BigInteger result = new BigInteger("1");
	    
	    if (n.longValue() > 1)
	    {
	      for(int i = 1; i <= n.longValue(); i++)
	      {
	    	 BigInteger b = new BigInteger(String.valueOf(i));
	         result = result.multiply(b);
	      }
	    }
	    return result;
	  }
	
	public static BigInteger Factorial_Recursive(BigInteger n)
	 {
		  	BigInteger result = new BigInteger("1");
		    if (n.longValue() > 1)
		    {
		    	BigInteger b = new BigInteger("1");
		    	result = n.multiply(Factorial_Recursive(n.subtract(b)));
		    }
		    return result;
	 }
}
