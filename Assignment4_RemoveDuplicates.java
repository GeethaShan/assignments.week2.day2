package assignments.week2.day2;

public class Assignment4_RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//a) Use the declared String text as input
	    String text = "We learn java basics as part of java sessions in java week1";
	    String outputText = "" ;
	    
	    int count = 0;
	    //Split the String into array and iterate over it
	    String[] splitArray = text.split(" ");
	    for (int x=0; x<splitArray.length; x++) {
	    	count = 0;
	    	for (int i=x+1; i<splitArray.length; i++) {
	    		if (splitArray[x].equals(splitArray[i])) {
	    			count=count+1;
	    		}
	    	}
	    	if (count > 0) {
	    		outputText = outputText + "";
	    	}
	    	else
	    		outputText = outputText + " " + splitArray[x];
	    }
	    //Display the String without duplicate words
	    System.out.println(outputText);
	}

}
