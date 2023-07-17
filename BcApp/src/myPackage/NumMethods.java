package myPackage;

import java.util.HashMap;

public class NumMethods {
	static HashMap<String, Double> funcX = new HashMap<>();

	
	public NumMethods () {
		funcX.put("x", 5.0);
		funcX.put("-x", -1 * 5.0);
		funcX.put("pi", Math.PI);
		funcX.put("-pi", Math.PI);
		funcX.put("e", Math.E);
		funcX.put("-e", Math.E);
	}
	

	// good to go
    static double rectangleMethod (double a, double b, int n, String inputFunc) throws Exception {
		funcX.put("x", 5.0);
		funcX.put("-x", -1 * 5.0);
		funcX.put("pi", Math.PI);
		funcX.put("-pi", Math.PI);
		funcX.put("e", Math.E);
		funcX.put("-e", Math.E);
		
    	double result = 0;
		double h = (b-a)/n;
		double x , x1;
		
    	Operation strOp = new Operation();
    	String[] inputRPN = ReversePolish.rnp(ReversePolish.splitter(inputFunc).toArray(new String[0])).toArray(new String[0]);
//    	System.out.println("new method");
		for(double i = 0; i < n; i++) {
			
			x1 = (a + (i * h));

			x = (a + (i+1) * h + x1)/2;
    		funcX.replace("x", x);
    		funcX.replace("-x", -1 * x);
			result += h * strOp.evalRPN(inputRPN, funcX);
		}
    	

//		System.out.println("old method");
//		for(double i = a; i <= b; i+=h) {
//			
//			x1 = i+h;
//
//			x = (i+x1)/2;
//			System.out.println(x);
//    		funcX.replace("x", x);
//    		funcX.replace("-x", -1 * x);
//			result += h * strOp.evalRPN(inputRPN, funcX);
//		}
		
		return result;
	}
    
    static double trapezoidMethod (double a, double b, int n, String inputFunc) throws Exception {
		funcX.put("x", 5.0);
		funcX.put("-x", -1 * 5.0);
		funcX.put("pi", Math.PI);
		funcX.put("-pi", Math.PI);
		funcX.put("e", Math.E);
		funcX.put("-e", Math.E);
    	
    	double result = 0;
		double h = (b-a)/n;
		
		Operation strOp = new Operation();
    	String[] inputRPN = ReversePolish.rnp(ReversePolish.splitter(inputFunc).toArray(new String[0])).toArray(new String[0]);
		
		funcX.replace("x", a);
		funcX.replace("-x", -1 * a);
		result += strOp.evalRPN(inputRPN, funcX) / 2;
		
		funcX.replace("x", b);
		funcX.replace("-x", -1 * b);
		result += strOp.evalRPN(inputRPN, funcX) / 2;

//		for(double i = a + h  ; i < b - h ; i+=h) {
//			x1 = (a + (i * h));
//			
//			funcX.replace("x", i);
//			funcX.replace("-x", -1 * i);
//			result += strOp.evalRPN(inputRPN, funcX);
//			
//		}
		
		double x;
		
		for(double i = 1; i < n; i++) {
			x = (a + (i * h));
			funcX.replace("x", x);
			funcX.replace("-x", -1 * x);
			result += strOp.evalRPN(inputRPN, funcX);
		}
		
    	return h * result;
    }
	
    static double simpsons13Method(double a, double b, int n, String inputFunc) throws Exception {
		funcX.put("x", 5.0);
		funcX.put("-x", -1 * 5.0);
		funcX.put("pi", Math.PI);
		funcX.put("-pi", Math.PI);
		funcX.put("e", Math.E);
		funcX.put("-e", Math.E);
		
    	double result = 0;
    	double h = (b - a) / n;
    	
		Operation strOp = new Operation();
    	String[] inputRPN = ReversePolish.rnp(ReversePolish.splitter(inputFunc).toArray(new String[0])).toArray(new String[0]);
    	
		funcX.replace("x", a);
		funcX.replace("-x", -1 * a);
		result += strOp.evalRPN(inputRPN, funcX) / 3;
		
		funcX.replace("x", b);
		funcX.replace("-x", -1 * b);
		result += strOp.evalRPN(inputRPN, funcX) / 3;
    	
		for(double i = 1; i <= n/2; i++) {
    		double x =  a + (2 * i - 1) * h;
    		funcX.replace("x", x);
    		funcX.replace("-x", -1 * x);
    		result += 4.0/3.0 * strOp.evalRPN(inputRPN, funcX);
    		//System.out.println(x*h);
    	}
    	
		for(double i = 1; i <= n/2-1; i++) {
    		double x =  a+(2 * i)*h;
    		funcX.replace("x", x);
    		funcX.replace("-x", -1 * x);

    		result += 2.0/3.0 * strOp.evalRPN(inputRPN, funcX);

    	}
    	
    	return h * result;
    }
    
    static double simpsons38thV3(double a, double b, int n, String inputFunc) throws Exception {
		funcX.put("x", 5.0);
		funcX.put("-x", -1 * 5.0);
		funcX.put("pi", Math.PI);
		funcX.put("-pi", Math.PI);
		funcX.put("e", Math.E);
		funcX.put("-e", Math.E);
    	
        double result = 0;
        double h = (b-a); // step

		Operation strOp = new Operation();
    	String[] inputRPN = ReversePolish.rnp(ReversePolish.splitter(inputFunc).toArray(new String[0])).toArray(new String[0]);
    	
		funcX.replace("x", a);
		funcX.replace("-x", -1 * a);
		result += strOp.evalRPN(inputRPN, funcX);
		
		funcX.replace("x", b);
		funcX.replace("-x", -1 * b);
		result += strOp.evalRPN(inputRPN, funcX);
        
        double result1 = 0;
        for(int i = 1; i <= n - 1; i++) {
            double x;
            if(i%3 != 0) {
                x = (a + (i * h) / n);
        		funcX.replace("x", x);
        		funcX.replace("-x", -1 * x);
                result1 += 3.0 * strOp.evalRPN(inputRPN, funcX);
                //System.out.println(i);
            }   
        }

        double result2 = 0;
        for(int i = 1; i <= n/3 - 1; i++) {
            double x = (a + (i * h * 3) / n);
    		funcX.replace("x", x);
    		funcX.replace("-x", -1 * x);
            result2 += 2.0 * strOp.evalRPN(inputRPN, funcX);
            //System.out.println(i*3);
        }

        result += result1 + result2;

        return (3.0 * h * result) / (8.0 * n);
    }
	
    static double boole1(double a, double b, int n, String inputFunc) throws Exception {
		funcX.put("x", 5.0);
		funcX.put("-x", -1 * 5.0);
		funcX.put("pi", Math.PI);
		funcX.put("-pi", Math.PI);
		funcX.put("e", Math.E);
		funcX.put("-e", Math.E);
    	
    	double result = 0;
    	double h = (b - a) / n;

		Operation strOp = new Operation();
    	String[] inputRPN = ReversePolish.rnp(ReversePolish.splitter(inputFunc).toArray(new String[0])).toArray(new String[0]);
    	
		funcX.replace("x", a);
		funcX.replace("-x", -1 * a);
		result += 2.0*h/45.0 * 7*strOp.evalRPN(inputRPN, funcX);
		
		funcX.replace("x", b);
		funcX.replace("-x", -1 * b);
		result += 2.0*h/45.0 * 7*strOp.evalRPN(inputRPN, funcX);

    	for(double i = 1; i <= n-1; i+=2) {
    		double x =  a + i * h;
    		funcX.replace("x", x);
    		funcX.replace("-x", -1 * x);
    		result += 2.0*h/45.0 * 32*strOp.evalRPN(inputRPN, funcX);
    		//System.out.println(i);
    	}
    	//System.out.println(result);
    	for(double i = 2; i <= n-2; i+=4) {
    		double x =  a + i * h;
    		funcX.replace("x", x);
    		funcX.replace("-x", -1 * x);
    		result += 2.0*h/45.0 * 12*strOp.evalRPN(inputRPN, funcX);

    	}
    	for(double i = 4; i <= n-4; i+=4) {
    		double x =  a + i * h;
    		funcX.replace("x", x);
    		funcX.replace("-x", -1 * x);
    		result += 2.0*h/45.0 * 14*strOp.evalRPN(inputRPN, funcX);
    	}
    	
    	return   result;
    }
	
}
