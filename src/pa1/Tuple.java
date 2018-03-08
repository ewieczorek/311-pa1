package pa1;

public class Tuple {
	private int Key;
	private String Value;
	
	public Tuple(int keyP, String valueP){
		this.Key = keyP;
		this.Value = valueP;
	}
	
	public int getKey(){
		if(Key != 0){
			return Key;
		}else{
			return 0;
		}
	}
	
	public String getValue(){
		if(Value != null){
			return Value;
		}else{
			return "";
		}
	}
	
	public boolean equals(Tuple t){
		if(this.Key == t.getKey() && this.Value.equals(t.getValue())){
			return true;
		}else{
			return false; 
		}
	}
}