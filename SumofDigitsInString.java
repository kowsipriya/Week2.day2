package Week2.day2;

public class SumofDigitsInString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Ha999P65p32y32Le23r86ni32n5g";
		int variable = 0;
		char[] strText = text.toCharArray();
		for (int i = 0; i < strText.length; i++) {
			char charValue = strText[i];
			if (Character.isDigit(charValue)) {
				int intValue = Character.getNumericValue(charValue);
				variable = variable + intValue;
			}
		}
		System.out.println("The total sum of Digits in a given string is : " + variable);
	}

}
