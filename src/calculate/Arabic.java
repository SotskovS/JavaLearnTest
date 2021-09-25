package calculate;

import calculate.Main;

public class Arabic {
	

	
	
	
	public static int calc(int a, String sign, int b, boolean romanCalculateFlag) {
			
		int result = 0;
		
		switch (sign) {
		case "+": 
			result = a + b;
			break;
		case "-":
			result = a - b;
			try {
				if (romanCalculateFlag && a < b) {
					throw new Exception();
				}				
			} catch (Exception e) {
				System.out.println("В римской системе исчисления нет отрицательных чисел!");
			}
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			try {
				if (b == 0) {
					throw new Exception("На ноль делить нельзя!");
				}
				result = a / b;
			} catch (Exception e) {
				e.printStackTrace();						
			}
			break;		
		}
		return result;
	}
}
