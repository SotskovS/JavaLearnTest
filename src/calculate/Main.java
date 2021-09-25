package calculate;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Введите 2 числа и знак операции - (+, -, *, /), в данном формате: a + b ");
		
		Scanner scanner = new Scanner(System.in);
		
		String userInput = scanner.nextLine();
		String[] array = userInput.split(" ");

		String romanSign[] = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
		
		boolean romanCalculateFlag = false;
		
		for (String sign : romanSign) {
			if (array[0].equals(sign)) {				
				romanCalculateFlag = true;			
			}			
		}
		
		try {
			if (array.length != 3 ) {
				throw new Exception();
			} else {
				for (String sign : romanSign) {
					try {
						if (array[0].equals(sign) && array[2].matches("^([0-9]|1[0])") || 
								array[2].equals(sign) && array[0].matches("^([0-9]|1[0])")) {
							throw new Exception();
						}
					} catch (Exception e) {
						System.out.println("Нельзя использовать одновременно разные системы счисления!");
						break;
					}			
				}				
			}
		} catch (Exception e) {
			System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)!");
			return;
		}
					
		if (romanCalculateFlag) {
			Roman.print(array[0], array[1], array[2], romanCalculateFlag);
		} else {
			int printResult = Arabic.calc(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), romanCalculateFlag);
			System.out.println(printResult);
		}	
	}
}
