import java.util.Arrays;
import java.util.*;
public class Split {

	public static void main(String[] args){ 
		System.out.println("Give ingredients to sandwich.");
		//Set up scanner. Ask for ingredients.
		Scanner userInput = new Scanner (System.in);
		String sandwichIngredients = userInput.next();
		//Establish array and set its content to new .split.
		String [] sandwichArray = sandwichIngredients.split("bread");
		
		if (sandwichIngredients.indexOf("bread") == 2){
			System.out.println (sandwichArray[1]);
		}
		else if (sandwichIngredients.indexOf("bread") == 3){
			System.out.print(sandwichArray[1]);
			System.out.print(sandwichArray[2]);
		}
	}
}

		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" "); 
		//		it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		//		it will split at the word "really" and return an array of ["I "," like "," apples!"]
		
		//play around with String.split! what happens if you "I reallyreally like apples".split("really") ?
		
		
		//Your task:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		 * What if it's a fancy sandwich with multiple pieces of bread?
		*/
		
		
		//Your task pt 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		 * Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/

		


