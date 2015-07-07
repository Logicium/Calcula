import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Classify {
		
	public static int classifyForm(Expression e) {
		
		int form = 0;
		String s = e.abstractForm;
		System.out.println("\nOriginal: " + e.originalForm);
		System.out.println("Abstract form: " + s);		
		String standardForm = "(d+l\\^\\(?d+\\)?)|(d+l\\^\\(?d+/?d*\\)?)";
		String implicitCoefficient = "^l\\^\\(?d+\\)?$";
		String implicitPower = "^d+l$";
		String implicitCoAndPow = "^l$";
		String constant = "((^d+(\\+|-|\\*|/)d+(\\+|-|\\*|/)d+$)|"
				+ "((^d+(\\+|-|\\*|/)d+$)|((\\+|-|\\*|/)d+$)|"
				+ "(^d+(\\+|-|\\*|/))|((\\+|-|\\*|/)d+(\\+|-|\\*|/))d+|"
			+ "(d+(\\+|-|\\*|/)d+(\\+|-|\\*|/)d+)))";
		
		Pattern Form1 = Pattern.compile(standardForm);
		Matcher M1 = Form1.matcher(s);
		Pattern Form2 = Pattern.compile(implicitCoefficient);
		Matcher M2 = Form2.matcher(s);
		Pattern Form3 = Pattern.compile(implicitPower);
		Matcher M3 = Form3.matcher(s);
		Pattern Form4 = Pattern.compile(implicitCoAndPow);
		Matcher M4 = Form4.matcher(s);
		Pattern Form5 = Pattern.compile(constant);
		Matcher M5 = Form5.matcher(s);
		Pattern Form7 = Pattern.compile("ln\\(?l\\)?");
		Matcher M7 = Form7.matcher(s);
		Pattern Form8 = Pattern.compile("sin\\(?l\\)?");
		Matcher M8 = Form8.matcher(s);	
		Pattern Form9 = Pattern.compile("cos\\(?l\\)?");
		Matcher M9 = Form9.matcher(s);
		Pattern Form10 = Pattern.compile("tan\\(?l\\)?");
		Matcher M10 = Form10.matcher(s);
		
		while (M1.find()) {
			System.out.println("Classification: Standard Form");
			Matcher M = M1;
			form = 1;
			generateFragments(e,M,form);
		}

		while (M2.find()) {
			System.out.println("Classification: Implicit Coefficient");
			Matcher M =M2;
			form = 2;
			generateFragments(e,M,form);
		}
		while (M3.find()) {
			System.out.println("Classification: Implicit Power");
			Matcher M =M3;
			form = 3;
			generateFragments(e,M,form);
		}
		while (M4.find()) {
			System.out.println("Classification: Implicit Coefficient & Power");
			Matcher M =M4;
			form = 4;
			generateFragments(e,M,form);
		}
		while (M5.find()) {
			System.out.println("Classification: Constant");
			Matcher M = M5;
			form = 5;
			generateFragments(e,M,form);
		}
		while (M7.find()) {
			System.out.println("Classification: Natural Log");
			Matcher M = M7;
			form = 7;
			generateFragments(e,M,form);
		}
		while (M8.find()) {
			System.out.println("Classification: Sine");
			Matcher M =M8;
			form = 8;
			generateFragments(e,M,form);
		}
		while (M9.find()) {
			System.out.println("Classification: Cosine");
			Matcher M =M9;
			form = 9;
			generateFragments(e,M,form);
		}
		while (M10.find()) {
			System.out.println("Classification: Tangent");
			Matcher M =M10;
			form = 10;
			generateFragments(e,M,form);
		}
		
		if(e.abstractGroups.size()>1){
			ComplexClassification.higherLevelAbstraction(e);
		}
		
		return form;
	}
	
	public static void generateFragments(Expression e, Matcher M, int form){
		e.abstractGroups.add(M.group());
		int start = M.start();
		int end = M.end();
		String originalSubstring = e.originalForm.substring(start,end);
		String abstractSubstring = e.abstractForm.substring(start,end);
		String derivative = e.getDerivative(originalSubstring, abstractSubstring, form);
		String pattern = M.pattern().toString();
		Fragment f = new Fragment(originalSubstring,derivative, abstractSubstring, pattern, form);
		e.fragments.add(f);
	}

}
