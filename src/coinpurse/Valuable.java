package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Kwanwan Tantichartkul
 * @version 1.1
 */

public interface Valuable extends Comparable<Valuable> {
	
	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of this object.
	 */
	
	 public double getValue();
	 public String getCurrency();
	 public String toString();
	 public boolean equals(Object obj);
	
}
