//APCS 2 Kevin Han
import java.util.Arrays;
import java.util.*;
public class Split {

	public static void main(String[] args){
		System.out.println("Give ingredients to sandwich.");
		//Set up/prompt for scanner.
		Scanner userInput = new Scanner (System.in);
		String sandwichIngredients = userInput.nextLine();
		
		String ingredients = "";
		
		String [] tempArray = sandwichIngredients.split(" ");
		for (int i = 0; i < tempArray.length; i++){
			ingredients += tempArray[i];
		}
		
		//Establish array and set its content to .split array.
		
		System.out.println(ingredients);
		
		String [] sandwichArray = ingredients.split("bread");
		
		System.out.println(Arrays.toString(sandwichArray));
		
		//Check if sandwich is actually sandwich.
		boolean check = checkSandwich(ingredients, sandwichArray);
		if (check == false){ //when it isn't a sandwich
			System.out.println ("This is not a sandwich.");
		}else{ //when it is a sandwich.
			giveIngredients(ingredients, sandwichArray);
		}
	}
	
	public static boolean checkSandwich (String ingredients, String [] sandwichArray){
		//all instances when the given ingredients do not make a sandwich.
		
		//Checking how many times the word "bread" occurs in ingredients.
		String findStr = "bread";
		int lastIndex = 0;
		int count = 0;
		while (lastIndex != -1){
			lastIndex = ingredients.indexOf(findStr, lastIndex);
			
			if (lastIndex!= -1){
				count ++;
				lastIndex += findStr.length();
			}
		}
		
		if (sandwichArray.length <= 1
			|| ingredients.indexOf("bread") < 0) {
			return false;
		}else if (count <2){
			return false;
		}else{
			return true;
		}
	}
	
	public static void giveIngredients (String ingredients, String [] ingredientsArray){
		//converting given ingredients to ingredients in the middle of breads.		
		if (ingredientsArray.length <= 2){
			System.out.println(ingredientsArray[ingredientsArray.length-1]);
		}else{
			for (int i = 0; i < ingredientsArray.length-2; i++){
			System.out.print(ingredientsArray[i + 1] + " ");
			}
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
