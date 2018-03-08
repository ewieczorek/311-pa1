package pa1;

import java.util.ArrayList;

public class HashStringSimilarity {
	String s1, s2;
	int sLength;
	ArrayList<Tuple> UnionList;
	HashTable S, T, UnionTable;
	
	HashStringSimilarity(String s1, String s2, int sLength){
		this.s1 = s1;
		this.s2 = s2;
		this.sLength = sLength;	
		S = new HashTable(s1.length());
		T = new HashTable(s2.length());
		if(s1.length() > s2.length()){
			UnionTable = new HashTable(s2.length());
		}else{
			UnionTable = new HashTable(s1.length());
		}
		populate();
		System.out.println("Populated");
	}
	
	public float lengthOfS1(){
	/*	float tempTotal = 0;
		float toReturn = 0;
		for(Tuple sub1: UnionList){
			float tempToSquare = 0;
			for(Tuple sub2: S){
				if(sub1.equals(sub2)){
					tempToSquare++;
				}
			}
			tempTotal += (float) tempToSquare * tempToSquare;
		}
		toReturn = (float) Math.sqrt(tempTotal);
		return toReturn;*/
		return 0;
	}
	
	public float lengthOfS2(){
	/*	float tempTotal = 0;
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
		return toReturn;*/
		return 0;
	}
	
	private void populate(){
		System.out.println("S:");
		for(int i = 0; i <= (this.s1.length() - this.sLength); i++){
			String temp = s1.substring(i, i + this.sLength);
			int power = temp.length() - 1;
			int hash = 0;
			for(char ch: temp.toCharArray()){
				hash += Math.pow(31, power) * (int) ch;
				power--;
			}
			Tuple addToS = new Tuple(hash, temp);
			System.out.println("Hash: " + hash + ", String: " + temp);
			S.add(addToS);
		}
		
		System.out.println("T:");
		for(int i = 0; i <= (this.s2.length() - this.sLength); i++){
			String temp = s2.substring(i, i + this.sLength);
			int power = temp.length() - 1;
			int hash = 0;
			for(char ch: temp.toCharArray()){
				hash += Math.pow(31, power) * (int) ch;
				power--;
			}
			Tuple addToT = new Tuple(hash, temp);
			System.out.println("Hash: " + hash + ", String: " + temp);
			T.add(addToT);
		}
	}
	
	public float similarity(){
		float numerator = 0;
		for(Tuple uSub: UnionList){
			int sim1 = 0, sim2 = 0;
		/*	for(String sSub: S){
				if(uSub.equals(sSub)){
					sim1++;
				}
			}
			for(String tSub: T){
				if(uSub.equals(tSub)){
					sim2++;
				}				
			}*/
			numerator += (float) (sim1 * sim2);
		}
		float toReturn = (float) (numerator / (lengthOfS1()* lengthOfS2()));
		return toReturn;
	}
	
}
