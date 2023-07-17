package myPackage;

import java.util.HashMap;
import java.util.Stack;

public class Operation {

	public double evalRPN(String[] tokens, HashMap<String, Double> funcHelp) throws Exception {
        if (tokens.length == 0 || tokens == null)
            return -1;
        Stack<Double> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if(token.equals("x")){
            	//String a = ;
            	stack.push(Double.valueOf(funcHelp.get("x")));
            }
            else if(token.equals("-x")){
            	stack.push(Double.valueOf(funcHelp.get("-x")));
            }
            else if(token.equals("pi")){
            	//String a = ;
            	stack.push(Double.valueOf(funcHelp.get("pi")));
            }
            else if(token.equals("-pi")){
            	stack.push(Double.valueOf(funcHelp.get("-pi")));
            }
            else if(token.equals("e")){
            	//String a = ;
            	stack.push(Double.valueOf(funcHelp.get("e")));
            }
            else if(token.equals("-e")){
            	stack.push(Double.valueOf(funcHelp.get("-e")));
            }
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (token.equals("-")) {
            	double b = stack.pop();
                double a = stack.pop();
                stack.push(a - b);
            }
            else if (token.equals("/")) {
            	double b = stack.pop();
                double a = stack.pop();
//                if(Math.abs(a / b) == Double.POSITIVE_INFINITY) 
//                	throw new Exception("Division by zero");
                stack.push(a / b);
            }
            else if (token.equals("cos")) {
            	double b = stack.pop();
            	
//            	double realB = (double)Math.round(b*1000)/1000;
//        		int special;
//        		double closeToPI = 0;
//    			if(realB*1000%785 == 0) {
//    				//System.out.println(realX);
//    				//System.out.println(realX*1000);
//    				int specialrealX = (int) (realB * 1000);
//    				special = specialrealX / 785;
//    				closeToPI = (Math.PI * special *1/4);
//    			}
    			
            	if(Math.cos(b) < 0.000000000000001 && Math.cos(b) > -0.000000000000001)
            		stack.push(0.0);
            	else
            		stack.push( Math.cos(b));
            }
            else if (token.equals("-cos")) {
            	double b = stack.pop();
            	if(Math.cos(b) < 0.000000000000001 && Math.cos(b) > -0.000000000000001)
            		stack.push(0.0);
            	else
            		stack.push( -Math.cos(b));
            }
            else if (token.equals("sin")) {
            	double b = stack.pop();
  
  				if(Math.sin(b) < 0.00000000000001 && Math.sin(b) > - 0.00000000000001)
            		stack.push(0.0);
            	else
            		stack.push( Math.sin(b));
            }
            else if (token.equals("-sin")) {
            	double b = stack.pop();
  				if(Math.sin(b) < 0.00000000000001 && Math.sin(b) > - 0.00000000000001)
            		stack.push(0.0);
            	else
            		stack.push( -Math.sin(b));
            }
            // fix tan to sin(x)/cos(x)
            else if (token.equals("tan")) {
            	double b = stack.pop();
            	double calcSin, calcCos;
  				if(Math.sin(b) < 0.00000000000001 && Math.sin(b) > - 0.00000000000001)
  	            	calcSin = 0.0;
            	else
            		calcSin = Math.sin(b);
  				
  				if(Math.cos(b) < 0.00000000000001 && Math.cos(b) > - 0.00000000000001)
  					calcCos = 0.0;
            	else
            		calcCos = Math.cos(b);
  				
  				stack.push(calcSin/calcCos);
            }
            else if (token.equals("-tan")) {
            	double b = stack.pop();
            	double calcSin, calcCos;
            	
//            	double result;
//  				if(Math.sin(b) < 0.00000000000001 && Math.sin(b) > - 0.00000000000001)
//  	            	calcSin = 0.0;
//            	else
//            		calcSin = Math.sin(b);
//  				
//  				if(Math.cos(b) < 0.00000000000001 && Math.cos(b) > - 0.00000000000001)
//  					calcCos = 0.0;
//            	else
//            		calcCos = Math.cos(b);
//  				
//  				result = -(calcSin/calcCos);
//  				
//  				if(result > 1000000000000.0)
//  					result = Double.POSITIVE_INFINITY ;
            	
            	if(Math.tan(b) < 0.00000000000001 && Math.tan(b) > - 0.00000000000001)
        			stack.push(0.0);
            	else if(Math.tan(b)> 1000000000000.0)
            		stack.push(Double.POSITIVE_INFINITY);
            	else
            		stack.push(-Math.tan(b));

  				
  				//stack.push(result);
            }
            
            else if (token.equals("acos")) {
            	double b = stack.pop();
            	stack.push( Math.acos(b));
            }
            else if (token.equals("-acos")) {
            	double b = stack.pop();
            	stack.push( -Math.acos(b));
            }
            
            else if (token.equals("asin")) {
            	double b = stack.pop();
            	stack.push( Math.asin(b));
            }
            else if (token.equals("-asin")) {
            	double b = stack.pop();
            	stack.push( -Math.asin(b));
            }
            
            else if (token.equals("atan")) {
            	double b = stack.pop();
            	stack.push( Math.atan(b));
            }
            else if (token.equals("-atan")) {
            	double b = stack.pop();
            	stack.push( -Math.atan(b));
            }
            
            else if (token.equals("sinh")) {
            	double b = stack.pop();
            	stack.push( Math.sinh(b));
            }
            else if (token.equals("-sinh")) {
            	double b = stack.pop();
            	stack.push( -Math.sinh(b));
            }
            
            else if (token.equals("cosh")) {
            	double b = stack.pop();
            	stack.push( Math.cosh(b));
            }
            else if (token.equals("-cosh")) {
            	double b = stack.pop();
            	stack.push( -Math.cosh(b));
            }
            
            else if (token.equals("tanh")) {
            	double b = stack.pop();
            	stack.push( Math.tanh(b));
            }
            else if (token.equals("-tanh")) {
            	double b = stack.pop();
            	stack.push( -Math.tanh(b));
            }
            else if (token.equals("log")) {
            	double b = stack.pop();
            	stack.push( Math.log10(b));
            }
            else if (token.equals("-log")) {
            	double b = stack.pop();
            	stack.push( -Math.log10(b));
            }
            
            else if (token.equals("ln")) {
            	double b = stack.pop();
            	stack.push( Math.log(b));
            }
            else if (token.equals("-ln")) {
            	double b = stack.pop();
            	stack.push( -Math.log(b));
            }


            else if (token.equals("^")) {
            	double b = stack.pop();
            	double a = stack.pop();
            	stack.push( Math.pow(a,b));
            }
            else {
                stack.push(Double.valueOf(token));
            }
        }
        return stack.pop();
    }
}

