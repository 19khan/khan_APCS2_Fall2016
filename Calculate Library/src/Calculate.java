
// Kevin Han APCS2
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
		return (degrees/180)*3.14159;
	
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
		if (b==0){
			throw new IllegalArgumentException ("Cannot divide by 0");
		}
		if (a%b==0){
			return true;
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
		if(a<0){
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
		boolean answer = false;
		for (int i = 1; i<=input-1; i++){
			if ((Calculate.isDivisibleBy(input, i)) == false){
				answer = true;
			}
			else{
				answer = false;
			}
		}
		return answer;
	}

	public static int gcf (int a, int b){
		int gcf = 1;
		int smallNum = (Calculate.min(a, b));
		for (int i = 2; i < smallNum; i++){
			if (Calculate.isDivisibleBy(a, i) && Calculate.isDivisibleBy(b,i)){
			gcf = i;
			}
		}
		return gcf;
	}

	public static double sqrt (double num) {
		if (num < 0){
			throw new IllegalArgumentException ("Input cannot be negative.");
		}
		double x = 1;
		while (x*x > (num + .1) || x*x < (num - .1)){
			while (x*x > num) {
				x = x + .01;
			}
			if (x*x > num){
				x = x - .01;
			}
		}
		return (Calculate.round2 (x));
	}
				
	public static String quadForm (int num1, int num2, int num3){
		String answer = "";
		double discrim = Calculate.discriminant(num1, num2, num3);
		if (discrim < 0){
			return ("No real roots.");
		}
		double answer1 = ((-num2) + Calculate.sqrt(discrim)) / (2*num1);
		double answer2 = ((-num2) - Calculate.sqrt(discrim)) / (2*num1);
		if (answer1 == answer2){
			answer += answer1;
			return (answer);
		}else{
			answer = "\"" + Calculate.round2(answer1) + " and " + Calculate.round2(answer2) + "\"";
			return (answer);
		}
	}
}

