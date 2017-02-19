package coinpurse;

/**
 * a coin with a monetary value and currency
 * @author Kwanwan Tantichartkul
 * @version 1.0
 */
public class Coin implements Valuable {
	/** The default currency of the coin. */
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value ) {
    	 this.value = value;
         this.currency = DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	
    	this.value = value;
    	this.currency = currency;
 
    }
    
    /**
     * A value of each coins.
     * @return value of coins.
     */    

    public double getValue( ) {
    	
    	return this.value;
    } 
    
    /**
     * Currency of each coins.
     * @return currency of coins.
     */    

    public String getCurrency() { 
    	
    	return this.currency;
    }
    
    /**
     * Check each coins that are equal currency and value or not.
     * Check with the other coins have same attributes.
     * @return the coin have the same currency and value.
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
     * The detail of each coins.
     * @return the attributes of coins with their value and currency.
     */    
    
    public String toString() { 
    	
    	return this.value+"-"+this.currency;
    }

    /**
     * Compare the value of coins are more than another coins.
     * It's also compare the value of coins are less than another coins.
     * @return the order of coins that come before and after.
     */    

    public int compareTo(Valuable o) {
    	
    	if(this.value<o.getValue())
    		return -1;
    	if(this.value>o.getValue())
    		return +1;
    	return 0;
    }

    
}
