import java.util.*;
public class Hourglass {
	public static void main (String[] args) {
	Scanner userInput = new Scanner (System.in);
	System.out.println ("How wide is your hourglass?");
	int width = userInput.nextInt();
	if (width%2 != 0 || width <= 4){
		System.out.println("Only even integers greater than 4 allowed.");
		width = userInput.nextInt();
		if (width %2 != 0 || width <= 4){
			System.out.println("Integer still does not meet requirement.");
			width = userInput.nextInt();
		}
	}
		printBase(width);
		topHalf(width);
		middle(width);
		bottomHalf(width);
		printBase(width);		
	}
	
	public static void topHalf(int width){
		for (int i =1; i <= width/2-2; i++){
			for (int j = 1; j <=i; j++){
				System.out.print (" ");
			}
			System.out.print("\\");
			for (int j = (width/2)-1; j>i; j--){
				System.out.print("::");
			}
			System.out.println("/");
		}
	}
	
	public static void bottomHalf (int width){
		for (int i = (width/2)-1; i > 1; i--){
			for (int j = 1; j < i; j++){
				System.out.print(" ");
			}
			System.out.print("/");
			for (int j = (width/2); j>i; j--){
				System.out.print("::");
			}
			System.out.println("\\");
		}
	}
	
	public static void printBase(int width){
		System.out.print("|");
		for (int i = 1; i <= width-2; i++){
			System.out.print("\"");
		}
		System.out.println("|");
	}
	
	public static void middle(int width){
		int var = width/2-2;
		for (int i = 0; i < var+1; i++){
			System.out.print(" ");
		}
		System.out.println("||");
	}
}
