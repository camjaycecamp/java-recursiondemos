import java.util.Scanner;

public class FibonacciTimeCalculator
{

     public static void main(String []args)
     {
        Scanner s = new Scanner(System.in);
        double timeMult = 1.62298718;
        
        System.out.println("n: ");
        int input = s.nextInt();
        double times[] = new double[input];
        
        //starts at t(50)
        double lastTime = 36.587 * timeMult;
        
        //then increments on from t(50), starting at t(51)
        for (int i = 51; i < times.length; i++) 
        {
        	double currentTime = lastTime * timeMult;
        	lastTime = currentTime;
        	times[i] = currentTime;
        	System.out.println("time at " + (i+1) + ": " + currentTime);
        }
     }
}