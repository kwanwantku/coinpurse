package coinpurse;
 

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Purse.
 * This is a JUnit 4 test.  
 * To run these tests, right click on this file (in Navigator pane)
 * and choose Run As -> JUnit test
 * @author  Resident Evil
 * @version 2017.02.01
 */
public class PurseTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /** Easy test that the Purse constructor is working. */
    @Test
    public void testConstructor()
    {
        Purse purse = new Purse(3);
        assertEquals(3, purse.getCapacity());
        assertEquals(false, purse.isFull());
        assertEquals(0, purse.count());
    }

    

    /** Insert some coins. Easy test. */
    @Test
    public void testInsert()
    {
        Purse purse = new Purse(3);
        Coin coin1 = new Coin(5,"Baht");
        Coin coin2 = new Coin(10,"Baht");
        Coin coin3 = new Coin(1,"Baht");
        assertTrue( purse.insert(coin1));
        assertTrue( purse.insert(coin3));
        assertTrue( purse.insert(coin2));
        assertEquals( 3, purse.count() );
        
        // purse is full so insert should fail
        assertFalse( purse.insert(new Coin(1,"Baht")) );
    }
    
    @Test
    public void testInsert2()
    {
    	Purse purse = new Purse(5);
    	BankNote banknote1 = new BankNote(1000,"Baht",1000000);
    	BankNote banknote2 = new BankNote(500,"Baht",1000000);
    	BankNote banknote3 = new BankNote(20,"Baht",1000000);
    	Coin coin4 = new Coin(5,"Baht");
        Coin coin5 = new Coin(1,"Baht");
    	assertTrue(purse.insert(banknote1));
    	assertTrue(purse.insert(banknote2));
    	assertTrue(purse.insert(banknote3));
    	assertTrue(purse.insert(coin4));
    	assertTrue(purse.insert(coin5));
    	
    	// purse is full so insert should fail
        assertFalse( purse.insert(new Coin(2,"Baht")) );
    	
    }
    

    /** Insert should reject coin with no value. */
    @Test
    public void testInsertNoValue()
    {
        Purse purse = new Purse(3);
        Coin fakeCoin = new Coin(0,"Baht");
        assertFalse( purse.insert(fakeCoin));
    }
    /** Insert should reject bank notes with no value. */
    @Test
    public void testInsertNoValue2()
    {
    	Purse purse = new Purse(2);
    	BankNote fakeBanknote = new BankNote(0,"Baht",1000000);
    	assertFalse( purse.insert(fakeBanknote));
    }


    @Test
    public void testIsFull()
    {   // borderline case (capacity 1)
        Purse purse = new Purse(1);
        assertFalse( purse.isFull() );
        purse.insert( new Coin(10,"Baht") );
        assertTrue( purse.isFull() );
        // real test
        int capacity = 4;
        purse = new Purse(capacity);
        for(int k=1; k<=capacity; k++) {
            assertFalse(purse.isFull());
            purse.insert( new Coin(k,"Baht") );
        }
        // full now
        assertTrue( purse.isFull() );
        assertFalse( purse.insert( new Coin(5,"Baht") ) );
    }

	/** Should be able to insert same coin many times,
	 *  since spec doesn't say anything about this.
	 */
	@Test
	public void testInsertSameCoin()
	{
		Purse purse = new Purse(5);
		Coin coin = new Coin(10,"Baht");
		assertTrue( purse.insert(coin) );
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(coin) ); // should be allowed
	}
	

	@Test
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		int [] values = {1, 10, 1000};
		for(int value : values){
			Valuable valuable = new Coin(value,"Baht");
			assertTrue(purse.insert(valuable));
			assertEquals(value,  purse.getBalance(), TOL);
			Valuable [] result = purse.withdraw(value);
			assertTrue( result != null );
			assertEquals( 1, result.length );
			assertSame(  valuable, result[0] );
			assertEquals( 0, purse.getBalance(), TOL );
		}
	}
	
	@Test
	public void testEasyWithdraw2() {
		Purse purse = new Purse(10);
		int [] values = {50, 100, 1000};
		for(int value : values){
			Valuable valuable = new BankNote(value,"Baht",1000000);
			assertTrue(purse.insert(valuable));
			assertEquals(value,  purse.getBalance(), TOL);
			Valuable [] result = purse.withdraw(value);
			assertTrue( result != null );
			assertEquals( 1, result.length );
			assertSame(  valuable, result[0] );
			assertEquals( 0, purse.getBalance(), TOL );
		}
		
	}

	@Test
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		int value = 1;
		double amount1 = 0;
		double amount2 = 0;
		for(int k=1; k<10; k=k+2)  {
			assertTrue( purse.insert( new Coin(value,"Baht")) );
			amount1 += value;
			value = 2*value;
			assertTrue( purse.insert( new Coin(value,"Baht")) );
			amount2 += value;
			value = 2*value;
		}
		assertEquals(amount1+amount2, purse.getBalance(), TOL );
		assertEquals(10, purse.count() );
		Valuable [] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sumValue(wd1), 0.0000001 );
		assertEquals(amount2, purse.getBalance(), TOL );
		Valuable [] wd2 = purse.withdraw(amount2);
		assertEquals(0, purse.getBalance(), TOL );
	}

	@Test
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull( purse.withdraw(1) );
		purse.insert( new Coin(20,"Baht") );
		assertNull( purse.withdraw(1) );
		assertNull( purse.withdraw(19) );
		assertNull( purse.withdraw(21) );
		purse.insert( new Coin(20,"Baht") );
		assertNull( purse.withdraw(30) );
	}
	
	@Test
	public void testGetBalance() {
		Purse purse = new Purse(3);
    	BankNote banknote2 = new BankNote(500,"Baht",1000000);
    	BankNote banknote3 = new BankNote(20,"Baht",1000000);
    	Coin coin4 = new Coin(5,"Baht");
        assertTrue(purse.insert(banknote2));
    	assertTrue(purse.insert(banknote3));
    	assertTrue(purse.insert(coin4));
    	
    	assertEquals(banknote2.getValue()+banknote3.getValue()+coin4.getValue(), purse.getBalance(), TOL );
		
	}
	
	/**
	 * Sum the value of some coins.
	 * @param wd1 array of coins
	 * @return sum of values of the coins
	 */
	private double sumValue(Valuable[] wd1)  {
		if (wd1 == null) return 0;
		double sum = 0;
		for(Valuable c: wd1) if (c != null) sum += c.getValue();
		return sum;
	}
	
}


