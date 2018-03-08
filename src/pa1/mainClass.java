package pa1;

public class mainClass {
	public static void main(String args[]){
		BruteForceSimilarity newBrute = new BruteForceSimilarity("aroseisaroseisarose", "aroseisaflowerwhichisarose", 4);
		System.out.println(newBrute.lengthOfS1());
		System.out.println(newBrute.lengthOfS2());
		System.out.println("Similarity: " + newBrute.similarity());
		
		BruteForceSimilarity newBrute2 = new BruteForceSimilarity("1268264612", "251188438", 1);
		System.out.println(newBrute2.lengthOfS1());
		System.out.println(newBrute2.lengthOfS2());
		System.out.println("Similarity: " + newBrute2.similarity());
		
		HashStringSimilarity newSCode = new HashStringSimilarity("aroseisaroseisarose", "aroseisaflowerwhichisarose", 4);
		//System.out.println(newSCode.lengthOfS1());
		//System.out.println(newSCode.lengthOfS2());
		//System.out.println("Similarity: " + newSCode.similarity());
		
		HashStringSimilarity newSCode2 = new HashStringSimilarity("1268264612", "251188438", 1);
		//System.out.println(newSCode2.lengthOfS1());
		//System.out.println(newSCode2.lengthOfS2());
		//System.out.println("Similarity: " + newSCode2.similarity());
		
		HashCodeSimilarity newHCode = new HashCodeSimilarity("aroseisaroseisarose", "aroseisaflowerwhichisarose", 4);
		//System.out.println(newHCode.lengthOfS1());
		//System.out.println(newHCode.lengthOfS2());
		//System.out.println("Similarity: " + newHCode.similarity());
		
		HashCodeSimilarity newHCode2 = new HashCodeSimilarity("1268264612", "251188438", 1);
		//System.out.println(newHCode2.lengthOfS1());
		//System.out.println(newHCode2.lengthOfS2());
		//System.out.println("Similarity: " + newHCode2.similarity());
		
		System.out.println("Done");
	}
}
