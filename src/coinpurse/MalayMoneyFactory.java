package coinpurse;

public class MalayMoneyFactory extends MoneyFactory{
	 
	private long serialnumber;
	
	protected MalayMoneyFactory(){
		this.serialnumber = 1000000;
	}
	
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
