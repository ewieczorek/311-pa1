package pa1;

import java.util.ArrayList;

public class HashCodeSimilarity {
	String s1, s2;
	int sLength;
	ArrayList<Tuple> UnionList;
	HashTable S, T, UnionTable;
	
	HashCodeSimilarity(String s1, String s2, int sLength){
		this.s1 = s1;
		this.s2 = s2;
		this.sLength = sLength;	
		S = new HashTable(s1.length());
		T = new HashTable(s2.length());
		UnionTable = new HashTable(3);
		populate();
	}
	
	public float lengthOfS1(){
		//The total length we will be returning
		float totalLength = 0;
		for(ArrayList<Tuple> al: UnionTable.tupleTable){
			//The temporary total after each row of union table
			//ArrayList<Tuple> UnionList = new ArrayList<Tuple>();
			//UnionList = UnionTable.tupleTable[i];
			
			//If the row is empty don't search it
			if(al.get(0).getValue() == null && al.size() == 1){
				//do nothing
			}else{
				//For each item in the current row on union table
				for(Tuple uT: al){
					int searchTotal = S.search(uT.getKey()).size(); 
					
					//After counting how many times one appears we then square it
					float squared = (float) searchTotal * (float) searchTotal;
					//System.out.println("Old total: " + totalLength + " + " + squared);
					totalLength += squared;
					//System.out.println("New total: " + totalLength);
				}
			}

		}
		//System.out.println("vector length 1 before square: " + totalLength);
		float sqrtValue = 0;
		//The square root of the vector length a^2 + b^2 + c^2 etc.
		sqrtValue = (float) Math.sqrt(totalLength);
		
		return sqrtValue;
	}
	
	public float lengthOfS2(){
		//The total length we will be returning
		float totalLength = 0;
		for(ArrayList<Tuple> al: UnionTable.tupleTable){
			//The temporary total after each row of union table
			//ArrayList<Tuple> UnionList = new ArrayList<Tuple>();
			//UnionList = UnionTable.tupleTable[i];
			
			//If the row is empty don't search it
			if(al.get(0).getValue() == null && al.size() == 1){
				//do nothing
			}else{
				//For each item in the current row on union table
				for(Tuple uT: al){
					int searchTotal = T.search(uT.getKey()).size(); 
					
					//After counting how many times one appears we then square it
					float squared = (float) searchTotal * (float) searchTotal;
					//System.out.println("Old total: " + totalLength + " + " + squared);
					totalLength += squared;
					//System.out.println("New total: " + totalLength);
				}
			}

		}
		//System.out.println("vector length 1 before square: " + totalLength);
		float sqrtValue = 0;
		//The square root of the vector length a^2 + b^2 + c^2 etc.
		sqrtValue = (float) Math.sqrt(totalLength);
		
		return sqrtValue;
	}
	
	private void populate(){
		//System.out.println("S:");
		for(int i = 0; i <= (this.s1.length() - this.sLength); i++){
			String temp = s1.substring(i, i + this.sLength);
			int power = temp.length() - 1;
			int hash = 0;
			for(char ch: temp.toCharArray()){
				hash += Math.pow(31, power) * (int) ch;
				power--;
			}
			Tuple addToS = new Tuple(hash, temp);
			//System.out.println("Hash: " + hash + ", String: " + temp);
			S.add(addToS);
			//if it doesn't exist in the union table, add it.
			if(UnionTable.search(addToS) == 0){
				UnionTable.add(addToS);
			}
		}
		
		//System.out.println("T:");
		for(int i = 0; i <= (this.s2.length() - this.sLength); i++){
			String temp = s2.substring(i, i + this.sLength);
			int power = temp.length() - 1;
			int hash = 0;
			for(char ch: temp.toCharArray()){
				hash += Math.pow(31, power) * (int) ch;
				power--;
			}
			Tuple addToT = new Tuple(hash, temp);
			//System.out.println("Hash: " + hash + ", String: " + temp);
			T.add(addToT);
			if(UnionTable.search(addToT) == 0){
				UnionTable.add(addToT);
			}
		}
	}
	
	public float similarity(){
		float numerator = 0;
		//For each arrayList in the union table
		for(ArrayList<Tuple> ul: UnionTable.tupleTable){
			if(ul.get(0).getValue() == null){
				//do nothing if the row is empty
			}else{
				for(Tuple uSub: ul){
					int sim1 = 0, sim2 = 0;
					sim1 = S.search(uSub);
					sim2 = T.search(uSub);
					numerator += (float) (sim1 * sim2);
				}
			}
		}
		float toReturn = (float) (numerator / (lengthOfS1()* lengthOfS2()));
		return toReturn;
	}
	
	public void printAll(){
		System.out.println("S:");
		for(ArrayList<Tuple> al: S.tupleTable){
			for(Tuple t: al){
				System.out.println("Key: " + t.getKey() + ", Value: " + t.getValue());
			}
		}
		System.out.println("T:");
		for(ArrayList<Tuple> al: T.tupleTable){
			for(Tuple t: al){
				System.out.println("Key: " + t.getKey() + ", Value: " + t.getValue());
			}
		}
		System.out.println("Union:");
		for(ArrayList<Tuple> al: UnionTable.tupleTable){
			for(Tuple t: al){
				System.out.println("Key: " + t.getKey() + ", Value: " + t.getValue());
			}
		}
		
	}
}
