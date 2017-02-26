package coinpurse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.ResourceBundle;


/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 */
public class Main {
	private static int CAPACITY = 10;
    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	
    
    	ConsoleDialog ui = new ConsoleDialog(new Purse(20));
    	ui.run();
		


    }
}
