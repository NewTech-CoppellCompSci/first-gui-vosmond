package lab;

public class HousePics {

//instance variables
	private String picSrc;
	
//constructor	
	public HousePics(String picSrc) {
		this.picSrc = picSrc;
		
	}
	
//getter / setter methods
	public String getPicSrc() { return picSrc; }
	
//override toString
	public String toString() {
		return picSrc;
	}
	
}
