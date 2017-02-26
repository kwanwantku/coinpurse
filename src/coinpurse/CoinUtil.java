package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * @author Kwanwan Tantichartkul
 * @version 1.1
 */
public class CoinUtil {

	/**
	 * Method that examines all the valuables in a List and returns
	 * only the valuables that have a currency that matches the parameter value.
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> valuablelist, String currency) {
		
		List<Valuable> tempcoinlist = new ArrayList<Valuable>();
		for( int i=0;i<valuablelist.size();i++ ){
			if(valuablelist.get(i).getCurrency()==currency){
				tempcoinlist.add(valuablelist.get(i));
			}
		}
		Collections.sort(tempcoinlist);
		return tempcoinlist; // return a list of coin references copied from coinlist
	}
	

	/**
	 * Method to sort a list of valuables by currency.
	 * On return, the list (valuables) will be ordered by currency.
	 * @param valuables is a List of valuables objects we want to sort. 
	 *
	 * TODO:
	 * 1. Write a Comparator<Valuable> (you can write the class at the end of this file.
	 *    Declare it as "class CompareByCurrency" without the "public").
	 *    You can also write Comparator as an anonymous class, if you know how.
	 *    The compare method should order valuables by currency.
	 * 2. Create a comparator instance and use it to sort the valuables.
	 */
	public static void sortByCurrency(List<Valuable> valuable) {
		
		Collections.sort(valuable);
		Collections.sort(valuable, new CompareByCurrency());
		
	}
	
	/**
	 * Sum valuables by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * For example: 
	 * coins = { Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") }
	 * then sumByCurrency(valuables) would print:
	 * 
	 * 11.00 Baht
	 * 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the valuables by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> valuables) {
        if (valuables == null || valuables.size() == 0) 
        	return;
        
        Map<String,Double> moneymap = new HashMap<String,Double>();
        for(Valuable value:valuables){
        	if(!moneymap.containsKey(value.getCurrency())){
        		moneymap.put(value.getCurrency(), value.getValue());
        	}
        	else {
        		double sum = moneymap.get(value.getCurrency());
        		moneymap.put(value.getCurrency(), value.getValue()+sum);
        	}
        }
        
        for(String currencyKey : moneymap.keySet()){
        	System.out.println(moneymap.get(currencyKey)+" "+currencyKey.toString());
        }
	}
	
	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");
		
		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);
		
	}
	
	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeValuables("Baht", 0.25, 1.0, 2.0, 5.0, 20.0, 500.0) );
		money.addAll( makeValuables("Ringgit", 2.0, 50.0, 1.0, 5.0, 50.0) );
		money.addAll( makeValuables("Rupee", 0.5, 0.5, 10.0, 1.0, 100.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Valuable> makeValuables(String currency, double ... values) {
		
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) {
			if(value<20)
				list.add(new Coin(value,currency));
			else
				list.add(new BankNote(value,currency,1000000));
		}
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
			
		}
		System.out.println(); // end the line
	}
}

/**
 * This method compare each Valuable like Banknote and Coin.
 * This is check the object it's same currency or not.
 */
class CompareByCurrency implements Comparator<Valuable> {

	@Override
	public int compare(Valuable o1, Valuable o2) {
		
		return o1.getCurrency().compareTo(o2.getCurrency());
	}
	

}