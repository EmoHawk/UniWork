import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
 * Class which contains methods that are used for predictive text
 * Two methods, wordToSignature, which takes a word and returns the numerical equivalent from a 9 digit phone keypad
 * and signatureToWords, which takes a string of numbers and returns the possible words the string can be equal to
 *
 *The main method is used for testing the two methods
 */

public class PredictivePrototype {
		
	public static void main(String[] args)  
	{
		System.out.println(wordToSignature("home"));
		System.out.println(isValidWord("home"));
		System.out.println(isValidWord("ho me"));
		
		System.out.println("");
		
		Set<String> words = new HashSet<String>();
		
			try {
				words = signatureToWords("4663");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		System.out.println("");
		System.out.println("Selected words:");
		for (String string : words) {
			System.out.println(string);
		}
		
		
	}
	
	/** Method which takes a word in a string and returns a string of the equivalent numbers
	 * 
	 * @param word The word taken in to be converted to equivalents string of numbers
	 * @return sig.toString() The string of numbers is constructed and stored in a StringBuffer, 
	 * which is converted to a string before being returned
	 */
	public static String wordToSignature(String word)
	{
		StringBuffer sig = new StringBuffer();
		//String buffer is used rather than string as it is more efficient, as string is immutable and strign buffer is not
		//This means string buffer is faster when doing concatenations, which is all that this method does 
		char character;
		
		//takes each letter in the word and appends the equivalent number to the string buffer
//		  1        2 (abc)  3 (def)
//		  4 (ghi)  5 (jkl)  6 (mno)
//		  7 (pqrs) 8 (tuv)  9 (wxyz)
		
		for(int i = 0; i < word.length(); i++)
		{
			character = word.charAt(i);
			character = Character.toLowerCase(character);
			if(character == 'a' || character == 'b' || character == 'c')
			{
				sig.append(2);
			}
			else if(character == 'd' || character == 'e' || character == 'f')
			{
				sig.append(3);
			}
			else if(character == 'g' || character == 'h' || character == 'i')
			{
				sig.append(4);
			}
			else if(character == 'j' || character == 'k' || character == 'l')
			{
				sig.append(5);
			}
			else if(character == 'm' || character == 'n' || character == 'o')
			{
				sig.append(6);
			}
			else if(character == 'p' || character == 'q' || character == 'r'|| character == 's')
			{
				sig.append(7);
			}
			else if(character == 't' || character == 'u' || character == 'v')
			{
				sig.append(8);
			}
			else if(character == 'w' || character == 'x' || character == 'y'|| character == 'z')
			{
				sig.append(9);
			}
			else
			{
				sig.append(" ");
			}
			
		}
		return sig.toString();
		//returns a string created from the string buffer
	}
	
	/** Method which takes a string of numbers and returns a set of the possible words that the string could be
	 * 
	 * @param signature The string of numbers to be checked
	 * @return wordSet The set of possible words that the string could be
	 * @throws FileNotFoundException
	 */
	public static Set<String> signatureToWords(String signature) throws FileNotFoundException
	{
		Set<String> wordSet = new HashSet<String>();
		
		//try catch is used in case the file cannot be found
		try {
			for (Scanner scanner = new Scanner(new File("/usr/share/dict/words")); scanner.hasNext();) 
			//creates a scanner object using the words file
			//loops until scanner.hasNext() is false, meaning that there are not more files in words
			{
				String word = scanner.nextLine();
				//System.out.println(word);
				String numSig = wordToSignature(word);
				if( isValidWord(numSig) && numSig.equals(signature) )
				{
					wordSet.add(word);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wordSet;
	}
	
	/** Method which checks whether a word in the words file is valid
	 * 
	 * @param word The word to be checked
	 * @return boolean True if the word is valid
	 */
	private static boolean isValidWord(String word)
	{
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == ' ')
			{
				return false;
			}
		}
		return true;
	}
	
}
