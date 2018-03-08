package pa1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ethan Wieczorek
 * @author Michael Scholl
 *
 * Hashtable class to implement a hash table holding tuples
 */
public class HashTable {

    private int maxSize;
    private int size;
    private int numberOfElements;
    private HashFunction hFunction; 
    private ArrayList<Tuple>[] tupleTable; 
    //private Tuple[] tupleTable; 
    //TODO private LinkedList<Tuple>[] hashTable;

    /*
     * Finds the smallest prime integer p whose value is at least size. 
     * Creates	a hash table of size p where each cell initially is NULL.
     *  It will determine the hash function to be used in the hash table 
     *  by creating the object new HashFunction(p)
     * 
     */
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
    	this.size = size; 
    	this.maxSize = findNextPrime(size);
    	
    	//creating the object new HashFunction(p)
    	hFunction = new HashFunction(this.maxSize);
    	
    	//Instantiate tupleTable to the maxSize determined by the next prime number after size. 
    	tupleTable = new ArrayList[maxSize];
    	for(int i = 0; i < maxSize; i++){
    		tupleTable[i] = new ArrayList<Tuple>(); //create each cell initially as null;
    		tupleTable[i].add(new Tuple(i, null));
    	}
    }

    /**
     * Return max load of the hash table
     * @return the max load of the hash table
     */
    public int maxLoad() {
    	//length of list with the most tuples?
        return this.maxSize;
    }

    /**
     * The average load of the hash table
     * @return the average load of the hash table
     */
    public float averageLoad() {
    	//number of distinct elements in hash table divided by the size, with nulls ignored.  
        float average = maxSize / 2;
        return average;
    }

    /**
     * The current size of the hash table
     * @return the current size of the hash table
     */
    public int size() {
        return this.size;
    }

    /**
     * The number of elements in the hash table
     * @return the number of elements in the hash table
     */
    public int numElements() {
        return this.numberOfElements;
    }

    /**
     * The load factor
     * @return the load factor
     */
    public float loadFactor() {
        return (float) numElements() / size();
    }

    /**
     * @param t the tuple to add
     */
    public void add(Tuple t) {
    	//TODO this doesn't allow multiples. 
    	int hash = hFunction.hash(t.getKey());
    	if(tupleTable[hash].get(0).getValue() == null){
    		tupleTable[hash].set(0, t);
    	}else{
    		tupleTable[hash].add(t);
    	}
    }

    /**
     * The list of Tuples in the hash table with a key equalling k
     *
     * @param k the key to find
     * @return the list of tuples at whose key is equal to k
     */
    public ArrayList<Tuple> search(int k) {
    	int hash = hFunction.hash(k);
    	return tupleTable[hash];
    }

    public int search(Tuple t) {
    	int hash = hFunction.hash(t.getKey());
    	return tupleTable[hash].size();
    }
    
    /**
     * Removes the Tuple t from the hash table
     * @param t the tuple to remove
     */
    public Tuple remove(Tuple t) {
    	int hash = hFunction.hash(t.getKey());
    	for(Tuple object: tupleTable[hash]){
    		if(t.equals(object)) tupleTable[hash].remove(object);
    	}
    	
        return null;
    }

	private int findNextPrime(int startingNum) {
		boolean found = false;
		int tempNum = startingNum;
		while(!found) {
			if (isPrime(tempNum)){
				return tempNum;
			}else{
				tempNum++;
			}
		}
		return -1;
		
	}
	
	private boolean isPrime(int n) {
		for(int i= 2; i<=Math.sqrt(n); i++)
			if (n%i==0)
				return false;
		return true;
	}
}