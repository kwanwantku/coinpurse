package coinpurse;

import java.util.ResourceBundle;

public abstract class MoneyFactory {
	
	private static MoneyFactory money = null;

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
	
	public abstract Valuable createMoney(double value);
	
	public Valuable createMoney(String value) {
		try {
			return createMoney(Double.parseDouble(value));
		} catch(Exception e) {
			throw new IllegalArgumentException();
		}

	}
}
