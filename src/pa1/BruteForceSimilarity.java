package pa1;

import java.util.ArrayList;

public class BruteForceSimilarity {
	String s1, s2;
	int sLength;
	ArrayList<String> S;
	ArrayList<String> T;
	ArrayList<String> UnionList;
	
	BruteForceSimilarity(String s1, String s2, int sLength){
		this.s1 = s1;
		this.s2 = s2;
		this.sLength = sLength;
		S = populate(s1, sLength);
		T = populate(s2, sLength);
		UnionList = new ArrayList<String>();
		for(String string1: S){
			if(UnionList.contains(string1)){
				//do nothing
			}else{
				UnionList.add(string1);
			}
		}
		for(String string2: T){
			if(UnionList.contains(string2)){
				//do nothing
			}else{
				UnionList.add(string2);
			}
		}
	}
	
	public float lengthOfS1(){
		float tempTotal = 0;
		float toReturn = 0;
		//For each string in the union list
		for(String sub1: UnionList){
			float tempToSquare = 0;
			//for each string in the S list
			for(String sub2: S){
				//If the strings are equal add one to the length
				if(sub1.equals(sub2)){
					tempToSquare++;
				}
			}
			//Square the length of all equal strings
			tempTotal += (float) tempToSquare * tempToSquare;
		}
		toReturn = (float) Math.sqrt(tempTotal);
		return toReturn;
	}
	
	public float lengthOfS2(){
		float tempTotal = 0;
		float toReturn = 0;
		for(String sub1: UnionList){
			float tempToSquare = 0;
			for(String sub2: T){
				if(sub1.equals(sub2)){
					tempToSquare++;
				}
			}
			tempTotal += (float) tempToSquare * tempToSquare;
		}
		toReturn = (float) Math.sqrt(tempTotal);
		return toReturn;
	}
	
	private ArrayList<String> populate(String s, int shingle){
		ArrayList<String> tempList = new ArrayList<String>();
		for(int i = 0; i <= (s.length() - shingle); i++){
			String temp = s.substring(i, i + shingle);
			tempList.add(temp);
			
		}
		return tempList;
	}
	
	public float similarity(){
		float numerator = 0;
		for(String uSub: UnionList){
			int sim1 = 0, sim2 = 0;
			for(String sSub: S){
				if(uSub.equals(sSub)){
					sim1++;
				}
			}
			for(String tSub: T){
				if(uSub.equals(tSub)){
					sim2++;
				}				
			}
			numerator += (float) (sim1 * sim2);
		}
		float toReturn = (float) (numerator / (lengthOfS1()* lengthOfS2()));
		return toReturn;
	}
}

