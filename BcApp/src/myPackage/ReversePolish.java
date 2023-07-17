package myPackage;


import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class ReversePolish {

	public static Stack<String> splitter(String exp) {

		String str = exp.replaceAll("\\s", "");
		
		Stack<String> stack = new Stack<String>();
		Stack<String> ReverseStack = new Stack<String>();
		char[] cArr = str.toCharArray();
		
		Stack<String> stackOutput = new Stack<String>();
		String helper = "";
		char lastChar = ' ';


		for(int i = 0; i<str.length(); i++) {
			
            if (str.charAt(i) == ('-') && lastChar == '(') {
            	if(!stack.empty()) {
					while(!stack.empty())
						ReverseStack.push(stack.pop());
				
					while(!ReverseStack.empty())
						helper += ReverseStack.pop();
					
					stackOutput.push(helper);
					helper = "";
				}
				stack.push(String.valueOf(str.charAt(i)));
				
//				if(!stack.empty()) {
//					while(!stack.empty())
//						ReverseStack.push(stack.pop());
//				
//					while(!ReverseStack.empty())
//						helper += ReverseStack.pop();
//					
//					stackOutput.push(helper);
//					helper = "";
//				}
            }
		else if(str.charAt(i)  == ('(') ||  str.charAt(i) == ('+') ||  str.charAt(i) == (')')
				||str.charAt(i) == ('*') ||str.charAt(i) == ('/') ||str.charAt(i) == ('^') || str.charAt(i) == ('-') && i != 0 ){
				
				if(!stack.empty()) {
					while(!stack.empty())
						ReverseStack.push(stack.pop());
				
					while(!ReverseStack.empty())
						helper += ReverseStack.pop();
					
					stackOutput.push(helper);
					helper = "";
				}
				stack.push(String.valueOf(str.charAt(i)));
				
				if(!stack.empty()) {
					while(!stack.empty())
						ReverseStack.push(stack.pop());
				
					while(!ReverseStack.empty())
						helper += ReverseStack.pop();
					
					stackOutput.push(helper);
					helper = "";
				}
			}

            else
            	stack.push(String.valueOf(str.charAt(i)));

            lastChar = str.charAt(i);
			
		}
		
		if(!stack.empty()) {
		while(!stack.empty())
				ReverseStack.push(stack.pop());
		
			
			while(!ReverseStack.empty())
				helper += ReverseStack.pop();
			
			stackOutput.push(helper);
			helper = "";
		}
		// Splits the string in a way where it also keeps the elements, except for spaces " " 
//		String[] arrOfStr = exp.split("((?<=cos)|(?=cos)|"
//				+ "(?<=sin)|(?=sin)|"
//				+ "(?<=tan)|(?=tan)|"
//				+ "(?<=\\()|(?=\\()|"
//				+ "(?<=\\))|(?=\\))|"
//				+ "(?<=[\\+\\-\\^\\/\\*\\)])|(?=[\\+\\-\\^\\/\\*\\)]))|"
//				+ " ");

		return stackOutput;
	}
	
	public static ArrayList<String> rnp(String[] exp) throws Exception {
	
		String[] tokens = exp;
	
		Stack<String> stack = new Stack<String>();
		ArrayList<String> output = new ArrayList<>();
	
	
		for (int i = 0; i < tokens.length; i++)
		{
			String currToken = tokens[i];
	
			// Current token is a number,
			// push it to stack for numbers
			if (isDouble(currToken) || currToken.equals("x") || currToken.equals("-x") 
					|| currToken.equals("e") || currToken.equals("-e")
					|| currToken.equals("pi") || currToken.equals("-pi"))
				output.add(currToken);
	
			// If the scanned Token is an '('
			// push it to the stack
			else if (currToken.equals("("))
				stack.push(currToken);
	
			// If the scanned Token is an ')' pop and append
			// it to output from the stack until an '(' is
			// encountered
			else if (currToken.equals(")")) {
				while (!stack.isEmpty() && !stack.peek().equals("("))
					output.add(stack.pop());
	
				stack.pop();
			}
	
			// If an operator is encountered then taken the
			// further action based on the precedence of the
			// operator
	
			else {
				while (
						!stack.isEmpty() && getPrecedence(currToken) 
						<= getPrecedence(stack.peek()) && hasLeftAssociativity(currToken)) {
					// peek() inbuilt stack function to
					// fetch the top element(token)
	
					output.add(stack.pop());
				}
				stack.push(currToken);
			}
		}
	
		// pop all the remaining operators from
		// the stack and append them to output
		while (!stack.isEmpty()) {
			if (stack.peek().equals("(")) {
				throw new Exception("This expression is invalid");
			}
			output.add(stack.pop());
		}

		return output;
	}

	static int getPrecedence(String ch)
	{
	
		if (ch.equals("+") || ch.equals("-"))
			return 1;
		else if (ch.equals("*") || ch.equals("/"))
			return 2;
		
		else if (ch.equals("^"))
			return 3;

		else if (ch.equals("cos") || ch.equals("sin") || ch.equals("tan") || ch.equals("-cos") || ch.equals("-sin") || ch.equals("-tan")
				|| ch.equals("acos") || ch.equals("-acos") || ch.equals("asin") || ch.equals("-asin") || ch.equals("atan") || ch.equals("-atan")  
				|| ch.equals("sinh") || ch.equals("-sinh") || ch.equals("cosh") || ch.equals("-cosh") || ch.equals("tanh") || ch.equals("-tanh") 
				|| ch.equals("ln") || ch.equals("log"))
			return 4;
		

		else if(ch.equals("x") || ch.equals("-x")|| ch.equals("e")|| ch.equals("-e"))
			return -1;
		else
			return -1;
	}
	
	// Operator has Left --> Right associativity
	static boolean hasLeftAssociativity(String ch) {
		if (ch.equals("+") || ch.equals("-")|| ch.equals("/") || ch.equals("*") || ch.equals("^")  ) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean isDouble (String number) {
		try {
			Double.parseDouble(number);
			return true;
		}catch (Exception ex) {
			return false;
		}
	}
	
//	public static boolean errorCheck() {
//		boolean val = false;
//		
//		
//	}
}
