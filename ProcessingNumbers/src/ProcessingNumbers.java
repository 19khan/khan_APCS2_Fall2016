//APCS2 Kevin Han
import java.util.*;
public class ProcessingNumbers {
	public static void main (String [] args){
		Scanner userInput = new Scanner (System.in);
		System.out.print("How many integers?");
		int numberOfInts = userInput.nextInt();
		int min = userInput.nextInt();
		int max = min;
		int evenSum = 0;
			for (int i = 1; i <= numberOfInts; i++){
				System.out.print("#" + i + "?");
				int loopVar = userInput.nextInt();
				if (loopVar < min){
					min = loopVar;
				}
				if (loopVar > max){
					max = loopVar;
				}
				if (loopVar % 2 == 0){
					evenSum += loopVar;
				}
			}
		System.out.println("Minimum value is " + min);
		System.out.println("Maximum value is " + max);
		System.out.println("The sum of all the even integers is " + evenSum);
	}
}