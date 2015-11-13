import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ZoomedIn {

	private static int nColumbs = 0;
	private static int mRows = 0;
	private static int numCharactersToTranslate = 0;
	private static int xNumWordsToTranslate = 0;
	private static charAndTranslation transCharacters[];
	private static String wordsToTranslate[];
	
	
    public static void main(String[] args) {
    
    	Scanner scan = new Scanner(System.in);
    	
    	while(scan.hasNext()) {
    	
    		nColumbs = scan.nextInt();
    		mRows = scan.nextInt();
    		numCharactersToTranslate = scan.nextInt();
    		transCharacters = new charAndTranslation[numCharactersToTranslate];
    		scan.nextLine();
    		for(int i=0; i<numCharactersToTranslate; i++) {
    			charAndTranslation hi = new charAndTranslation();
    			transCharacters[i] = hi;
    			String s = scan.nextLine();
    			transCharacters[i].setOriginalChar(s.charAt(0));
    			
    			for (int j=0; j<mRows; j++) {
    				String str = scan.nextLine();
    				transCharacters[i].setTranslation(str,j);
    			}
    		}
    		
    		
    		//Read in words to translate into zoomed words
    		xNumWordsToTranslate = scan.nextInt();
    		scan.nextLine();
    		wordsToTranslate = new String[xNumWordsToTranslate];
    		for (int i=0; i<xNumWordsToTranslate; i++) {
    			wordsToTranslate[i] = scan.nextLine();
    		}
    		
    		
    		//Loop x total times for number of words to translate first
    		for(int i=0; i<xNumWordsToTranslate; i++) {
    			charAndTranslation transCharacters2[] = new charAndTranslation[wordsToTranslate[i].length()];
    			
    			// Then loop for each letter in each word, create new array that equates to word to translate  
    			for(int j=0; j<wordsToTranslate[i].length(); j++) {
    				int index = findChar(wordsToTranslate[i].charAt(j));
    				transCharacters2[j] = transCharacters[index];
    			}
    			
    			// Output new array
    			for(int k=0; k<mRows; k++) {
        			for(int j=0; j<transCharacters2.length; j++) {
        				System.out.print(transCharacters2[j].getTranslation(k) + "");
        			}
        			System.out.println();
        		}
    			
    		}
    			
    		break;
    	}
    	scan.close();
    	
    	return;
    }
    
    //Find index of given char in the array of translated characters
    public static int findChar(char ch) {
    	
    	if (transCharacters.length==1) {
    		return 0;
    	}
    	
    	for (int i=0; i<numCharactersToTranslate; i++) {
    		if (transCharacters[i].getOriginalChar() == ch) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    //Subclass
    public static class charAndTranslation {
    	
    	private char originalChar;
    	private String translation[] = new String[mRows];
    	
    	charAndTranslation() {
    	}
    	
    	public void setOriginalChar(char original) {
    		originalChar = original;
    	}
    	public char getOriginalChar() {
    		return originalChar;
    	}
    	
    	public void setTranslation(String trans, int index) {
    		translation[index] = trans;
    	}
    	public String getTranslation(int index) {
    		return translation[index];
    	}
    	
    	public void toMyString() {
    		System.out.println("Original character to translate: " + originalChar);
    		System.out.println("Translation:");
    		for(int i=0; i<mRows; i++) {
    			System.out.println(translation[i]);
    		}
    	}
    }
    
}