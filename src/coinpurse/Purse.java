package coinpurse;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;


/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 *  @author Kwanwan Tantichartkul
 *  @version 1.0
 */

public class Purse {
	
    /** Collection of objects in the purse. */
	 private List<Valuable> money;
    
    /** Capacity is maximum number of coins the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {

    	this.capacity = capacity;
    	this.money = new ArrayList<Valuable>();
    	
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() { 
    	return money.size();  
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	
    	double balance = 0;
    	for(int i =0;i<money.size();i++){
    		balance += money.get(i).getValue();
    	}
    	return balance; 
    }

    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() {
    	
    	return this.capacity; 
    }
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
 
    	if(money.size()==this.getCapacity())
    		return true;
    	else
    		return false;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Valuable valuable) {
    	if(isFull() || valuable.getValue() == 0)
    		return false;
    	money.add(valuable);
    	return true;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *          or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {

		if (this.getBalance() < amount) {
			return null;
		}
		
		ArrayList<Valuable> tempmoney = new ArrayList<Valuable>();
		Collections.sort(money);
		Collections.reverse(money);
		int i = 0;
		
		while(amount>0) {
			if( i>=money.size() ) {
				break;
			}

			else {
				if( money.get(i).getValue() <= amount ) {
					amount-=money.get(i).getValue();
					tempmoney.add(money.get(i));
					money.remove(i);
				}
				else i++;
			}
		}

		if(amount>0)
			return null;

		Valuable [] array = new Valuable[ tempmoney.size() ];
		tempmoney.toArray(array);
		return array;
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     * @return return the number of remain coin and balance.
     */
    public String toString() {
    	
    	return count()+" coins with value "+getBalance();
    }

}

