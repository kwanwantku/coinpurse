package coinpurse;

/**
 * a coin with a monetary value and currency
 * @author Kwanwan Tantichartkul
 * @version 1.0
 */
public class Coin extends AbstractValuable  {

    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	
    	super(value,currency);
 
    }
    
    /**
     * The detail of each coins.
     * @return the attributes of coins with their value and currency.
     */    
    
    public String toString() { 
    	if(this.getCurrency().equals("Ringgit")&&this.getValue()<1)
    		return (this.getValue()*100)+"-Sen coin";
    	else if(this.getCurrency().equals("Baht")&&this.getValue()<1)
    		return (this.getValue()*100)+"-Satang Coin";
    	return this.getValue()+"-"+this.getCurrency()+" coin";
    }

    
}
