/*
 * cameron campbell
 * advanced java
 * occc spring 2021
 * palindrome demo
 */

import java.util.Scanner;

public class PalindromeDemo 
{
	/*
	 * the main method handles the user's input, then passes it to the CleanUpString
	 * and SpacelessString methods to create the variants of the string used for testing
	 * whether the input is a palindrome, and, if it is, the type of palindrome. these tests
	 * are conducted by passing each variant of the input string to the PalindromeHandler method.
	 * if the cleaned up string, with spaces intact, is declared a palindrome by the method, then
	 * the input is labeled a strict palindrome. otherwise, the main method moves on, checking if 
	 * the cleaned up string, with spaces removed, is a palindrome. if it is, the input is labeled
	 * an ordinary palindrome. otherwise, the input is not labeled a palindrome at all.
	 */
	   public static void main(String[] args)
	   {
		   Scanner s = new Scanner(System.in);
		   
		   
		   System.out.println("Welcome to the Palindrome Detector! "
		   		+ "\nPlease enter a string you'd like to evaluate: ");
		   String input = s.nextLine();
		   String cleanedString = CleanUpString(input);
		   String spacelessString = SpacelessString(cleanedString);
	       
		   if (PalindromeHandler(cleanedString)) 
		   {
			   System.out.println("'" + input + "' is a strict palindrome!");
		   }
		   else if (PalindromeHandler(spacelessString)) 
		   {
			   System.out.println("'" + input + "' is an ordinary palindrome!");
		   }
		   else 
		   {
			   System.out.println("'" + input + "' is NOT a palindrome!");
		   }
	   }
	   
	   /*
	    * the PalindromeHandler method examines and compares the front and back characters
	    * of the passed string. if they're equal, the front character is incremented and the
	    * back character is decremented. this continues until the front and back characters pass
	    * each other or are equal in position within the string. at any point in the while loop,
	    * the method will return false the front and back characters currently being compared are
	    * NOT equal. otherwise, if the while loop runs the whole way through, the method returns true.
	    */
	   public static boolean PalindromeHandler(String str)
	   {
		       if(str == null) 
		       {
		           return true;
		       }
		       
		       int back= str.length()-1;
		       int front= 0;
		       
		       while(front < back)
		       { 
		           char frontChar = str.charAt(front);
		           char backChar = str.charAt(back);

		           if(Character.isLetter(frontChar) && Character.isLetter(backChar))
		           {
		               if(Character.toLowerCase(frontChar) != Character.toLowerCase(backChar))
		               {
		                   return false;
		               }
		           }
		           else if (frontChar != backChar)
		           {
		        	   return false;
		           }
		           front++;
		           back--;
		       }
		       return true;
	   }
	   
	   /*
	    * the CleanUpString method creates and returns a string that is equivalent to the passed
	    * string, but with any characters that are not a space or alphanumeric removed.
	    */
	   public static String CleanUpString(String input) 
	   {
		   String cleanString = "";
		   
		   for (int i = 0; i < input.length(); i++) 
		   {
			   if (Character.isDigit(input.charAt(i)) || 
					   Character.isLetter(input.charAt(i)) || 
					   (input.charAt(i) == ' '))
			   {
				   cleanString += input.charAt(i);
			   }
		   }
		   return cleanString;
	   }
	   
	   /*
	    * the CleanUpString method creates and returns a string that is equivalent to the passed
	    * string, but with any characters that are not alphanumeric removed.
	    */
	   public static String SpacelessString(String input) 
	   {
		   String spacelessString = "";
		   
		   for (int i = 0; i < input.length(); i++) 
		   {
			   if (Character.isDigit(input.charAt(i)) || 
					   Character.isLetter(input.charAt(i)))
			   {
				   spacelessString += input.charAt(i);
			   }
		   }
		   return spacelessString;
	   }
}