package coinpurse;

import java.util.ResourceBundle;

/**
 * The factory can create money to using with purse.
 * Their can control to create each currency.
 * By using the Singleton pattern for produce the money.
 * @author pranger54
 * @version 1.0
 */

public abstract class MoneyFactory {
	
	private static MoneyFactory money = null;
	
	/**
	 * To get the instance of money. 
	 * By setting the default which currency that you want to create it.
	 * You can switch the currency in coinpurse.properties files.
	 * @throws When it's not type of money factory. It will get ClassCastException.
	 * 		   Another Exception that can make the error to creating money.
	 */
	public static MoneyFactory getInstance() {
		if(money == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("coinpurse");
			String factoryclass = bundle.getString("MoneyFactory");
			try {
				money = (MoneyFactory)Class.forName(factoryclass).newInstance();
			} catch(ClassCastException cce) {
				System.out.println(factoryclass+" is not type MoneyFactory");
			} catch(Exception ex) {
				System.out.println("Error creating MoneyFactory "+ex.getMessage());
			}
			if (money == null) {
				System.exit(1);
			}
		}
		return money;
	}
	/**
	 * It's the abstract to control to create each currency.
	 * It's the main that selecting currency to produce.
	 * @param the value of each money from each currency.
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * It's the function that create money from the factory.
	 * It's convert from string to double for their collect money in String version.
	 * @param the value of each money from each currency in the String.
	 * @throws when they found exception that can't create money it's called IllegalArgumentExcpetion.
	 */	
	public Valuable createMoney(String value) {
		try {
			return createMoney(Double.parseDouble(value));
		} catch(Exception e) {
			throw new IllegalArgumentException();
		}

	}
}
