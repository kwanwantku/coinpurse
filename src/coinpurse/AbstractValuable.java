package coinpurse;


/**
 * The class abstract the type of money with the same attributes of each type.
 * It's can tell the character of each banknote and coin.
 * It's contain value and currency of each type of money.
 * It's can sort and compare the money too.
 * @author pranger54
 * @version 1.0
 */
public class AbstractValuable implements Valuable {
	
	/** Value of the coin. */
    private double value;
    /** The currency, of course. */
    private String currency;
    
    public AbstractValuable(double value,String currency){
    	this.value = value;
    	this.currency = currency;
    }
    /**
	 * The value of each banknotes and coins.
	 * @return the value of each banknotes or coins.
	 */
	public double getValue() {
		return this.value;
	}
    /**
	 * The currency of each banknotes and coins.
	 * @return the currency of each banknotes or coins.
	 */
	
	public String getCurrency() {
		return this.currency;
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
		
		Valuable other = (Valuable)obj;
		
		if( (this.value == other.getValue()) && (this.currency.equals(other.getCurrency())) )
			return true;
		
		return false;
	
	}

	/**
	 * Compare the value of bank notes are more than another bank notes.
	 * It's also compare the value of bank notes are less than another bank notes.
	 * @return the order of bank notes that come before and after.
	 */
	public int compareTo(Valuable o) {
		
		if(this.getCurrency().equals(o.getCurrency())) {
	    	if(this.value<o.getValue())
	    		return -1;
	    	if(this.value>o.getValue())
	     	 	return +1;
		}
		else 
			return this.currency.compareToIgnoreCase(o.getCurrency());
		
	    return 0;
	}

}