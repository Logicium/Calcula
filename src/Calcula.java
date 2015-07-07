import java.util.Vector;


public class Calcula {

	public static Vector<String> tests = new Vector<String>();

	public static void main(String[] args) {
		tests.add("2x^3"); //Standard form
		tests.add("2x^(3)");  //Standard form
//		tests.add("12x^60"); //Standard form
//		tests.add("x^4"); //Implicit coefficient 
//		tests.add("212x"); //Implicit power
		tests.add("x"); //Implicit coefficient & power
		tests.add("14"); // No variable --> Evaluates to zero
//		tests.add("5^8"); // No variable --> Evaluates to zero
//		tests.add("sin(2x)"); //G0 = sin ; G1 2x;
//		tests.add("sin(x^(3x))"); //G0 = sin;G1=x^ G3 = 3*x
//		tests.add("ln(x)");
		tests.add("2x^(3)*4x^(2)*46x^72");
		tests.add("2x^(2)+3x^(5)+1");
		tests.add("2+5*7/6-2-1");
//		tests.add("2+1");
//		tests.add("2+1-3");
//		tests.add("2+1-9-1");
//		tests.add("2+9+1+1+3");
		
		for (String test : tests) {
			Expression e = new Expression(test);
		}
	}

}
