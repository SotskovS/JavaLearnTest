package calculate;

import java.util.Iterator;

public class Roman {
	
	enum RomanSign{
		I,
		II,
		III,
		IV,
		V,
		VI,
		VII,
		VIII,
		IX,
		X,
		L,
		C
	}		
		
	public static void print(String input_a, String sign, String input_b, boolean romanCalculateFlag) {
				
		int a = RomanSign.valueOf(input_a).ordinal() + 1;
		int b = RomanSign.valueOf(input_b).ordinal() + 1;
		
		int result = Arabic.calc(a, sign, b, romanCalculateFlag);		
			
		String res = "";		
		
		int dec = result / 10;
		int remainder = result % 10;
		
		if (dec == 10) {
			res += RomanSign.values()[11];
		} else if (dec >= 9 && dec < 10 ) {
			res += RomanSign.values()[9];
			res += RomanSign.values()[11];
		} else if (dec >= 5) {
			res += RomanSign.values()[10];
		}
		
		if (dec > 5 && dec < 9) {
			for (int i = 0; i < (dec - 5); i++) {
				res += RomanSign.values()[9];
			}
		}
		
		if (remainder >= 9) {
			res += RomanSign.values()[0];
			res += RomanSign.values()[9];
		} else if (remainder >= 5) {
			res += RomanSign.values()[4];
			
			for (int i = 0; i < (remainder - 5); i++) {
				res += RomanSign.values()[0];
			}			
		} else if (remainder > 3 && remainder < 5) { 
			res += RomanSign.values()[0];
			res += RomanSign.values()[4];
		} else {
			for (int i = 0; i < remainder; i++) {
				res += RomanSign.values()[0];
			}
		}
		System.out.println(res);
	}	
			
}
