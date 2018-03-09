package pa1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class mainClass {
	public static void main(String args[]){
		
		File file = new File("shak1");
		File file2 = new File("shak2");
		
		String string1 = readFile(file);;
		String string2 = readFile(file2);
		
		System.out.println(string1);
		System.out.println(string2);

		
		long startTime;
		long endTime;
		
		System.out.println("Brute Force Similarity");
		BruteForceSimilarity newBrute = new BruteForceSimilarity(string1, string2, 6);
		//System.out.println("Length s1: " + newBrute.lengthOfS1());
		//System.out.println("Length s2: " + newBrute.lengthOfS2());
		startTime = System.currentTimeMillis();
		System.out.println("Similarity: " + newBrute.similarity());
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + "\n\n");
		
		System.out.println("Hash String Similarity");
		HashStringSimilarity newSCode = new HashStringSimilarity(string1, string2, 6);
		//System.out.println("Length s1: " + newSCode.lengthOfS1());
		//System.out.println("Length s2: " + newSCode.lengthOfS2());
		startTime = System.currentTimeMillis();
		System.out.println("Similarity: " + newSCode.similarity());
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + "\n\n");
		
		System.out.println("Hash Code Similarity");
		HashCodeSimilarity newHCode = new HashCodeSimilarity(string1, string2, 6);
		//System.out.println("Length s2: " + newHCode.lengthOfS1());
		//System.out.println("Length s2: " + newHCode.lengthOfS2());
		startTime = System.currentTimeMillis();
		System.out.println("Similarity: " + newHCode.similarity());
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
		
		/*
		BruteForceSimilarity newBrute = new BruteForceSimilarity("aroseisaroseisarose", "aroseisaflowerwhichisarose", 4);
		System.out.println("Length s1: " + newBrute.lengthOfS1());
		System.out.println("Length s2: " + newBrute.lengthOfS2());
		System.out.println("Similarity: " + newBrute.similarity());
		
		BruteForceSimilarity newBrute2 = new BruteForceSimilarity("1268264612", "251188438", 1);
		System.out.println("Length s1: " + newBrute2.lengthOfS1());
		System.out.println("Length s2: " + newBrute2.lengthOfS2());
		System.out.println("Similarity: " + newBrute2.similarity() + "\n");
		
		System.out.println("Hash String Similarity");
		HashStringSimilarity newSCode = new HashStringSimilarity("aroseisaroseisarose", "aroseisaflowerwhichisarose", 4);
		//newSCode.printAll();
		System.out.println("Length s1: " + newSCode.lengthOfS1());
		System.out.println("Length s2: " + newSCode.lengthOfS2());
		System.out.println("Similarity: " + newSCode.similarity());
		
		HashStringSimilarity newSCode2 = new HashStringSimilarity("1268264612", "251188438", 1);
		//newSCode2.printAll();
		System.out.println("Length s1: " + newSCode2.lengthOfS1());
		System.out.println("Length s2: " + newSCode2.lengthOfS2());
		System.out.println("Similarity: " + newSCode2.similarity() + "\n");
		
		System.out.println("Hash Code Similarity");
		HashCodeSimilarity newHCode = new HashCodeSimilarity("aroseisaroseisarose", "aroseisaflowerwhichisarose", 4);
		System.out.println("Length s2: " + newHCode.lengthOfS1());
		System.out.println("Length s2: " + newHCode.lengthOfS2());
		System.out.println("Similarity: " + newHCode.similarity());
		
		HashCodeSimilarity newHCode2 = new HashCodeSimilarity("1268264612", "251188438", 1);
		System.out.println("Length s2: " + newHCode2.lengthOfS1());
		System.out.println("Length s2: " + newHCode2.lengthOfS2());
		System.out.println("Similarity: " + newHCode2.similarity());
		*/
	}
	
	public static String readFile(File file) {
		String string = "";
		String line;
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				
				for (char c : line.toCharArray()) {
					int value = (int) c;
					// Checking for numbers
					if (48 <= value && value <= 57) {
						string += c;
					}
					// Checking for lowercase letters
					if (97 <= value && value <= 122) {
						string += c;
					}
					// Checking for uppercase letters
					if (65 <= value && value <= 90) {
						string += Character.toLowerCase(c);
					}
				}
				
			}
			fileReader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return string;
	}
}
