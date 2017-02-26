package coinpurse;
/**
 * The factory that create Malaysia money.
 * They can create own serial number and initialize the value of money.
 * @author pranger54
 * @version 1.0
 */
public class MalayMoneyFactory extends MoneyFactory{
	 
	private long serialnumber;
	
	/**
	 * The constructor for Malaysia money factory.
	 * It's initialize the serialnumber.
	 */
	protected MalayMoneyFactory(){
		this.serialnumber = 1000000;
	}
	/**
	 * Create the Malaysia money to made in factory with each value and currency.
	 * It's can create their own serial number for bnaknote.
	 * @param the value of money in the real money.
	 * @throws IllegalException if their can't create money.
	 */
	public Valuable createMoney(double value) {
		
		
		if(value == 0.05) return new Coin(0.05,"Ringgit");
		else if (value == 0.1) return new Coin(0.1,"Ringgit");
		else if (value == 0.2) return new Coin(0.2,"Ringgit");
		else if (value == 0.5) return new Coin(0.5,"Ringgit");
		else if (value == 1) return new BankNote(1,"Ringgit",serialnumber++);
		else if (value == 2) return new BankNote(2,"Ringgit",serialnumber++);
		else if (value == 5) return new BankNote(5,"Ringgit",serialnumber++);
		else if (value == 10) return new BankNote(10,"Ringgit",serialnumber++);
		else if (value == 20) return new BankNote(20,"Ringgit",serialnumber++);
		else if (value == 50) return new BankNote(50,"Ringgit",serialnumber++);
		else if(value == 100) return new BankNote(100,"Ringgit",serialnumber++);
		throw new IllegalArgumentException();
		
		
	}
}
