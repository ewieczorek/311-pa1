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
	}
}
