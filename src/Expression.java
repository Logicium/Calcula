import java.util.Vector;

public class Expression {

	public String originalForm;
	public String abstractForm;
	public Vector<String> abstractGroups = new Vector<String>();
	public Vector<String> groupPattern = new Vector<String>();
	public Vector<String> derivatives = new Vector<String>();
	public Vector<String> originalGroups = new Vector<String>();
	public Vector<Integer> classifications = new Vector<Integer>();
	public Vector<Fragment> fragments = new Vector<Fragment>();

	public Expression(String s) {
		this.originalForm = s;
		char[] abstractFormCA = Lexer.abstractor(originalForm);
		this.abstractForm = new String(abstractFormCA);
		Classify.classifyForm(this);
	}

	public String getDerivative(String originalString, String abstractString, int form){
		return (Rules.PowerRule(originalString, abstractString, form));
	}
	
	public void runRules() {
		for (int i = 0;i<abstractGroups.size();i++) {
			//Input the start and finish index of each group
			Rules.PowerRule(originalGroups.get(i), abstractGroups.get(i), classifications.get(i));
		}
	}
}
