package coinpurse;
/**
 * a banknote with a monetary value and currency
 * @author Kwanwan Tantichartkul
 * @version 1.1
 */
public class BankNote extends AbstractValuable  {

	 /** The serial number of the bank note. */
	private long Serialnumber;

	
    /**
     * A bank note with given value and currency.
     * It can't to create fake banknote.
     * @param value
     * @param currency
     */
	protected BankNote(double value, String currency, long serialnumber){
		super(value,currency);
		this.Serialnumber = serialnumber;
	}
	
	/**
     * The serial number of each bank note
     * @return serial number of bank notes.
     */    
	public long getserial(){
		return this.Serialnumber;
	}
	
	 /**
     * The detail of each bank notes.
     * @return the attributes of bank notes with their value and currency.
     */  
	 public String toString() { 
	    	
	    	return this.getValue()+"-"+this.getCurrency()+" ["+this.Serialnumber+"]";
	 }


	

}
