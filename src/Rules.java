public class Rules {

	/*
	 * Constant c --> 0 x --> 1 Square x2 --> 2x Square Root √x --> (½)x-½
	 * Exponential ex --> ex 
	 * 
	 * ax --> ax(ln a) 
	 * 
	 * Logarithms ln(x) --> 1/x loga(x)
	 * --> 1 / (x ln(a)) Trigonometry sin(x) --> cos(x) cos(x) --> −sin(x)
	 * tan(x) --> sec2(x) sin-1(x) --> 1/√(1−x2) tan-1(x) --> 1/(1+x2)
	 */

	
	public static void ProductRule(Expression e){
		
		String finalDerivative="";
		String subDerivative="";
		for(int superset=0;superset<e.fragments.size();superset++){
			for(int subset =0;subset<e.fragments.size();subset++){
				if(superset == subset){
					subDerivative = subDerivative.concat(e.fragments.get(subset).derivative);
					if((e.fragments.size()>subset+1)){
						subDerivative = subDerivative.concat(" * ");
					}
				}
				else{
					subDerivative = subDerivative.concat(e.fragments.get(subset).originalString);
					if((e.fragments.size()>subset+1)){
						subDerivative = subDerivative.concat(" * ");
					}
				}
			}
			if(!(superset+1==e.fragments.size())){
				subDerivative = subDerivative.concat(" + ");
			}
		}
		System.out.println("Product Rule: "+subDerivative);
		
	}

	public static String PowerRule(String original, String abstractString, int form) {
		
		if (form == 1) {
			String coefficient = "";
			String variable = "";
			String power = "";
			boolean foundVariable = false;
			for (int i = 0; i < abstractString.length(); i++) {
				if (abstractString.charAt(i) == 'd' && !foundVariable) {
					coefficient = coefficient.concat(Character.toString(original.charAt(i)));
				} else if (abstractString.charAt(i) == 'l') {
					variable = Character.toString(original.charAt(i));
					foundVariable = true;
				} else if (abstractString.charAt(i) == 'd' && foundVariable) {
					power = power.concat(Character.toString(original.charAt(i)));
				}
			}
			return computePowerRule(coefficient, variable, power);
		}
		
		else if(form == 2){
			String coefficient = "";
			String variable = "";
			String power = "";
			coefficient = "1";
			variable = Character.toString(original.charAt(0));
			for (int i = 0; i < abstractString.length(); i++){
				if(abstractString.charAt(i)=='d'){
					power = power.concat(Character.toString(original.charAt(i)));
				}
			}
			return computePowerRule(coefficient, variable, power);
		}

		else if(form == 3){
			String coefficient = "";
			String variable = "";
			String power = "";
			
			power = "1";
			for (int i = 0; i < abstractString.length(); i++){
				if(abstractString.charAt(i)=='d'){
					coefficient = coefficient.concat(Character.toString(original.charAt(i)));
				}
				else if (abstractString.charAt(i) == 'l') {
					variable = Character.toString(original.charAt(i));
				}
			}
			return computePowerRule(coefficient, variable, power);
		}
		
		else if(form == 4){
			String coefficient = "";
			String variable = "";
			String power = "";
			coefficient = "1";
			variable = Character.toString(original.charAt(0));
			power = "1";
			return computePowerRule(coefficient, variable, power);
		}
		
		else if(form == 5){
			System.out.println("Derivative: 0");
		}
		else if(form == 5){
			System.out.println("Derivative: 0");
		}
		else if(form == 5){
			System.out.println("Derivative: 0");
		}
		else if(form == 5){
			System.out.println("Derivative: 0");
		}
		
		
		else{
			System.out.println("Derivative: Incomplete");
		}
		return "0";	
	}

	public static String computePowerRule(String coefficient, String variable,String power) {
		String derivative = "";
		System.out.println("Coefficient: " + coefficient);
		System.out.println("Variable: " + variable);
		System.out.println("Power: " + power);
		int c = Integer.parseInt(coefficient);
		int p = Integer.parseInt(power);
		int finalC = c * p;
		int finalP = p - 1;
		derivative = derivative.concat(Double.toString(finalC))
				.concat(variable).concat("^").concat(Double.toString(finalP));
		System.out.println("Derivative:" + (derivative));
		return derivative;
	}

}
