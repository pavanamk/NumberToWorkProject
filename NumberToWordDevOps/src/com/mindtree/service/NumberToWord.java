package com.mindtree.service;

public class NumberToWord {
	
	private static final String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" ,"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

	private static String tensPlace[]= {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	
	public static String getNumberToWord(int number) throws Exception {
		String word="";
		if(number>999 || number<0) {
			throw new Exception("Invalid Number");
		}
		if(number==0) {
			return digits[0];
		}
		int temp=number/100;
		if(temp>0) {
			word+=digits[temp]+" hundred";
		}
		temp=number%100;
		if(temp<20 && temp>0) {
			word+=" " +digits[temp];
		}else {
			word +=" " + tensPlace[temp / 10];
			if ((number % 10) > 0) {
				word += " " + digits[temp % 10];
			}
		} 

		return word;
	}
	public static void main(String[] args) {
		if(args.length<1) {
			System.out.println("Please enter the Number:");
			return;

	}
		try {
			System.out.println("Number to word conversion program");
			for (int i = 0; i < args.length; i++) {
				int number= Integer.parseInt(args[i]);
				System.out.println(args[i]+"- "+getNumberToWord(number));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.err.println("Invalid argument passed. Please verify the arguments!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error while converting number to word!!");
		}
	}

}
