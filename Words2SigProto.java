public class Words2SigProto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] signatures = new String[args.length];
		for(int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
			signatures[i] = PredictivePrototype.wordToSignature(args[i]);
			System.out.println(signatures[i]);
		}
	}

}
