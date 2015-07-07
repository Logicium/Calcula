import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ComplexClassification {
	
	public static void higherLevelAbstraction(Expression e){
		
		String[] operatorDetection;
		String concatPatternMult="";
		String concatPattenDiv="";
		
		//Check for simple multiplication
		for(int i =0;i<e.fragments.size();i++){
			concatPatternMult = concatPatternMult.concat(e.fragments.get(i).pattern);
			if(!(i+1==e.fragments.size())){
				concatPatternMult =concatPatternMult.concat("\\*");
			}
		}
		Pattern MultiplicationCheck = Pattern.compile(concatPatternMult);
		Matcher MCheck = MultiplicationCheck.matcher(e.abstractForm);
		if(MCheck.find()){
			Rules.ProductRule(e);
		}
	}
}
