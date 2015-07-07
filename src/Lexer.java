
public class Lexer {

	public static char[] abstractor(String s){
		char[] abstraction = new char[s.length()];
		for(int i =0; i<s.length();i++){
			if(Character.isDigit(s.charAt(i))){
				abstraction[i] = 'd';
			}
			else if(Character.isWhitespace(s.charAt(i))){
				abstraction[i] = 'w';
			}
			else if(Character.isAlphabetic(s.charAt(i))){
				abstraction[i] = 'l';
			}
			else if(s.charAt(i) == '^'){
				abstraction[i] = '^';
			}
			else if(s.charAt(i) == '('){
				abstraction[i] = '(';
			}
			else if(s.charAt(i) == ')'){
				abstraction[i] = ')';
			}
			else if(s.charAt(i) == '*'){
				abstraction[i] = '*';
			}
			else if(s.charAt(i) == '/'){
				abstraction[i] = '/';
			}			
			else if(s.charAt(i) == '-'){
				abstraction[i] = '-';
			}			
			else if(s.charAt(i) == '+'){
				abstraction[i] = '+';
			}
			else{
				abstraction[i] = '?';
			}	
		}
		return abstraction;	
	}
	
}
