package assignments.week2.day2;

public class Assignment4_SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declare a String text with the following value
		String text = "Tes12Le79af65";
		//Take only the digits
		String onlyDigits = text.replaceAll("[^0-9]", "");
		System.out.println(onlyDigits);
		//Converts to character array
		char[] charArray = onlyDigits.toCharArray();
		int sum =0;
		//Covert each character to numeric value and get the total
		for (int i=0; i<charArray.length; i++) {
			sum = sum + Character.getNumericValue(charArray[i]);
			
		}
		System.out.println(sum);

	}

}
