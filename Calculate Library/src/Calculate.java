
public class Calculate {
	// Part 1
	public static int square (int number){
		return (number*number);
	}
	
	public static int cube (int number){
		return (number*number*number);
	}
	
	public static double average (double number1, double number2){
		return (number1+number2)/2;
	}
	
	public static double average (double number1, double number2, double number3){
		return (number1+number2+number3)/3;
	}
	
	public static double toDegrees (double radians){
		return (radians * 3.14159)/180;
	
	}
	public static double toRadians (double degrees){
		return (degrees * 180)/3.14159;
	
	}
	public static double discriminant (double a, double b, double c){
		return (b*b)-(4*a*c);
	
	}
	public static String toImproperFrac (int a, int b, int c){
		return (""+a*b+c+"/"+c+"");
	
	}
	public static String toMixedNum (int a, int b){
		return (""+a/b+"_"+a%b+"/"+b+"");
	
	}
	public static String foil (int a, int b, int c, int d, char x){
		return (""+a*c*x+"^2+"+((b+d)*x)+"+"+b*d+"");
	
	}
	// Part 2
	public static boolean isDivisibleBy (int a, int b){
		if (a%b==0){
			return true;
		}
		if (b==0){
			throw new IllegalArgumentException ("Demoninator cannot be 0");
		}
		else{
			return false;
		}
	}
	public static double absValue (double a){
		if (a<=0){
			return -1.0*a;
		}
		else{
			return a;
		}
	}
	public static int max (int a, int b){
		if (a > b){
			return a;
		}
		else{
			return b;
		}
	}
	public static double max (double a, double b, double c){
		if (a>b){
			return a;
		}
		else{
			return b;
		}
	}
	public static int min (int a, int b){
		if (a>b){
			return a;
		}
		else{
			return b;
		}
	}
	public static double round2 (double a){
		double times100 = a*100;
		int number = (int)(times100);
		double subtracted = times100-number;
		
		if (subtracted >= 0.5){
			return (++number/100.0);
		}
		else{
			return (number/100.0);
		}
	}
	//Part 3
	public static double exponent (double base, int exponent){
		double answer = base;
		int loopVar = exponent;
		if (exponent < 0){
			throw new IllegalArgumentException ("Exponent cannot be less than 0");
		}
		else{
			for (int i = 1;i < loopVar ; i++){
				answer = answer * base;
			}
		}
		return answer;
	}
	
	public static int factorial (int a){
		int answer = a;
		int loopVar = a;
		if(a>0){
			throw new IllegalArgumentException ("Input cannot be less than zero.");
		}
		else{
			for (int i = 1; i < loopVar; i++){
				answer = answer * i;
			}
		}
		return answer;

	}
	
	public static boolean isPrime (int input){
		boolean check;
		for (int i = 1; i>input-1; i--){
			check = (Calculate.isDivisibleBy(input, i));
			if (check == true){
				return false;
			}
		}
		return true;
	}
	/*
	public static int gcf (int a, int b){
		int output = 1;
		int bigNum = (Calculate.max(a, b));
		if (a == bigNum){
			for (int i = a; i>= 1; i--){
				if (a%i == 0 && b%i ==0){
					return i;
				}
			}
		}
		if (b == bigNum){
			for (int j = b; j>= 1; j--){
				if (a%j == 0 && b%j == 0){
					return j;
				}
			}
			return output;
		}
	}
	
	public static double sqrt (int input){
		
	}
	*/
}	
	

