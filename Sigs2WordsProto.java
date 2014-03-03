import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

//having a problem here, unsure as to why. 
//running this program in the command line, it returns a file not found error

public class Sigs2WordsProto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] signatures = new String[args.length];
		//Set<String>[] wordSet = new HashSet[args.length];
		
		for(int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
			
			
			try {
				System.out.println(PredictivePrototype.signatureToWords(args[i]));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
