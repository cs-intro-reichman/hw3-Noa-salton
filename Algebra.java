// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int c = x1;
		if (x2 >=0){
		for (int i=0; i<x2; i++){
			c ++;
		}}
		else{
			for (int i=x2; i<0; i++){
				c--;
			}
		}
		return c;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int c = x1;
		if (x2>=0){
			for (int i=0; i<x2; i++){c --;}}
		else{for (int i=x2; i<0; i++){c++;}}
		return c;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int c = 0;
		if (x2>0){
			c += x1;
		for (int i=1; i<x2; i++){
			c = plus(c, x1);
		}}
		else if (x2<0){
			for (int i=x2; i<0; i++)
			{c = minus(c, x1);}
		}
		return c;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 1;
		for (int i=0; i<n; i++){pow = times(pow, x);}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int c = 0;
		int r = 0;
		int start = 0;
		if (x1 >= 0 && x2 >= 0){
		while (x1>=x2){r = minus(x1, x2);c++; x1 = minus(x1, x2);}}
		else if (x1<0 && x2>0){while (-x1>=x2){r = minus(-x1, x2);c--; x1 = plus(x1, x2);}}
		else if (x2<0 && x1>0){while (x1>=-x2){r = minus(x1, -x2);c--; x1 = plus(x1, x2);}}
		else{while (x1<=x2){r = minus(-x1, -x2);c++; x1 = plus(x1, -x2);}}
		return c;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divide = div(x1, x2);
		if (x1>0 && x2>0){return minus(x1, times(x2, divide));}
		else if (x1<0 && x2>0){return minus(times(x2, -(divide-1)), -x1);}
		else if (x1>0 && x2<0){return minus(x1, times(x2, divide));}
		else{return plus(plus(x1, times(divide,-x2)), -x2);}
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int r = 0;
		while(times(r, r)<x){r++;}
		if(times(r, r)>x){r--;}
		return r;
	}	  	  
}
