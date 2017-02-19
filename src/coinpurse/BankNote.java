package coinpurse;
/**
 * a banknote with a monetary value and currency
 * @author Kwanwan Tantichartkul
 * @version 1.1
 */
public class BankNote implements Valuable {
	
	private static long nextSerialNumber = 1000000;
	 /** Value of the coin. */
	private double value;
	 /** The currency, of course. */
	private String currency;
	/** The default currency of the bank note. */
	public static final String DEFAULT_CURRENCY = "Baht";
	 /** The serial number of the bank note. */
	private long Serialnumber;

	/**
     * A bank note with given value using the default currency.
     * @param value
     */
	public BankNote(double value){
		this.value = value;
		this.Serialnumber = nextSerialNumber;
		this.currency = DEFAULT_CURRENCY;
		nextSerialNumber++;
	}
	
    /**
     * A bank note with given value and currency.
     * @param value
     * @param currency
     */
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.Serialnumber = nextSerialNumber;
		nextSerialNumber++;
	}
	
	/**
     * A value of each bank note.
     * @return value of bank note.
     */    
	@Override
	public double getValue() {
		return this.value;
	}

	/**
     * Currency of each bank notes.
     * @return currency of bank notes.
     */    
	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	/**
     * The serial number of each bank note
     * @return serial number of bank notes.
     */    
	public long getserial(){
		return this.Serialnumber;
	}
	
	 /**
     * Check each bank notes that are equal currency and value or not.
     * Check with the other bank notes have same attributes.
     * @return the bank notes have the same currency and value.
     * 		   It's same return true. Not same return false.
     */    

	public boolean equals(Object obj) {
	    	
	    	if(obj == null)
	    		return false;
	    	
	    	if(obj.getClass() != this.getClass()) 
	    		return false;
	    	
	    	Coin other = (Coin)obj;
	    	
	    	if( (this.value == other.getValue()) && (this.currency.equals(other.getCurrency())) )
	    		return true;
	    	
	    	return false;

	    }
	
	/**
     * The detail of each bank notes.
     * @return the attributes of bank notes with their value and currency.
     */  
	 public String toString() { 
	    	
	    	return this.value+"-"+this.currency+" ["+this.Serialnumber+"]";
	 }
	 
	/**
	 * Compare the value of bank notes are more than another bank notes.
	 * It's also compare the value of bank notes are less than another bank notes.
	 * @return the order of bank notes that come before and after.
	 */    
	
	public int compareTo(Valuable o) {
	    	if(this.value<o.getValue())
	    		return -1;
	    	if(this.value>o.getValue())
	     	 	return +1;
	    return 0;
	}


	

}
