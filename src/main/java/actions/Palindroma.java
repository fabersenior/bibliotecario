package actions;

import java.util.Calendar;
import java.util.Date;

public class Palindroma {
	
	public static boolean IsPalindroma(String word){
		//clean word of empty space
		String word_space=word.replace(" ", "");
		//new object StringBuffer with arg word_space
		StringBuffer buffer_word = new StringBuffer(word_space);
		//reverse word,
		buffer_word = buffer_word.reverse();
		//equal without uppercase and lowercase
		if (word_space.equalsIgnoreCase(buffer_word.toString())){
			// return if the answer is correct
			return true;
		}else {
			return false;}
	}

	public static Date getDateMax(String isbn) {
		//initialize var
		Date fechaEntregaMaxima=null;
		int suma=0;
		
		//string to array char
		char[] arreglo = isbn.toCharArray();
		
		//run into array char
		for (int i=0;i<arreglo.length;i++) {
			if (Character.isDigit(arreglo[i])) { //find digite
				suma+= Integer.valueOf(arreglo[i]); //add digite
			}
			
		}
		
	    if(suma>30){ //digit is up 30
	    	
	    	// create new calendar
	    	Calendar calendario = Calendar.getInstance();
	    	//star day of calendar, today
	    	calendario.add(Calendar.DAY_OF_YEAR, -1);
	    	
	    	int i=1;
	    	while (i <= 15) {
	    		//if day is diferent of sunday , add + 1 to the days
	    		if(calendario.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
	    			i++;
	    		}
    			//add 1 day, to today
	    		calendario.add(Calendar.DAY_OF_YEAR, 1);
			}
	    	//get date later of 15 days
	    	fechaEntregaMaxima= calendario.getTime();
	    	
	    }
		//return fechaMaxima 
		return fechaEntregaMaxima;
	}

}
