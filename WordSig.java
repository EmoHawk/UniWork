public class WordSig implements Comparable<WordSig>
{
	private String signature;
	private String words;
	
	public WordSig (String word, String sig) 
	{
		words = word;
		signature = sig;
	}
	
	
	public int compareTo(WordSig ws) 
	{
		int returnValue = 0;
		String tempThis = signature.trim();
		String tempThat = ws.getSignature().trim();
		if(tempThis != "" && tempThat != "")
		{
			int numSig = Integer.parseInt(tempThis);
			System.out.println("<" + tempThat + ">");
			System.out.println("<" + ws.getSignature().trim() + ">");
			int numWS =  Integer.parseInt(tempThat);
			
			
			if( (numSig - numWS) == 0)
			{
				returnValue = 0;
			}
			else if( (numSig - numWS) >= 1)
			{
				returnValue = 1;
			}
			else if( (numSig - numWS) <= -1)
			{
				returnValue = -1;
			}
		}
		return returnValue;
	}
	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	
	
}
