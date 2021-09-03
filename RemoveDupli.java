package Week2.day2;

public class RemoveDupli {

	public static void main(String[] args) {
		String text = "Fuzzy Wuzzy was a bear. Fuzzy Wuzzy had no hair. Fuzzy Wuzzy wasn’t fuzzy";
		int int_value = 0;
		String[] splittext = text.split(" ");
		for (int i = 0; i < splittext.length; i++) {
			int_value++;
			for (int j = i + 1; j < splittext.length; j++) {
				if (splittext[i].equals(splittext[j])) {
					int_value++;
					splittext[j] = "";
				}
			}
			if (int_value >= 1) {
				System.out.print(splittext[i] + " ");
			}
		}
	}

}
