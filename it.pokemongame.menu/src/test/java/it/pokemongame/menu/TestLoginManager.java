package it.pokemongame.menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import interfaces.Model;
import model.battle.ModelImpl;

public class TestLoginManager {

	/**
	 *  1. Account non trovato
	 *  2. Profilo occupato
	 *  3. Account  già in uso
	 */
	private Model model;
	
    @Test
    public void testLogin() {
    	model = new ModelImpl();
    	System.out.println("---- TEST LOGIN ----");
    	model.initLoginManager();
    	assertTrue(model.getLogger().registerNoWrite("andypedoz", "0000"));
    	assertTrue(model.getLogger().registerNoWrite("a", "1"));
    	assertTrue(model.getLogger().registerNoWrite("b", "2"));
    	assertTrue(model.getLogger().registerNoWrite("giammo", "1234"));
    	assertEquals(model.getLogger().login("andypedoz", "0000", 0),0);
    	assertEquals(model.getLogger().login("a","1", 1),0);
    	assertEquals(model.getLogger().login("andypedoz", "0000", 0),2);
    	assertEquals(model.getLogger().login("aaaa", "1111", 0),1);
    }
    
    @Test
    public void testReady() {
    	model = new ModelImpl();
    	System.out.println("---- TEST READY ----");
    	model.initLoginManager();
    	assertTrue(model.getLogger().ready());
    	assertTrue(model.getLogger().ready());
    	model.getLogger().disconnect(0);
    	assertFalse(model.getLogger().ready());
    }
    
    @Test
    public void testDisconnect() {
    	model = new ModelImpl();
    	System.out.println("---- TEST DISCONNECT ----");
    	model.initLoginManager();
    	model.getLogger().login("andypedoz","0000", 0);
    	assertTrue(model.getLogger().disconnect(0));
    	assertFalse(model.getLogger().disconnect(0));
    	assertTrue(model.getLogger().disconnect(1));
    	assertFalse(model.getLogger().disconnect(1));
    }
	
	@Test
    public void testRegister() {
    	model = new ModelImpl();
    	System.out.println("---- TEST REGISTER ----");
    	model.initLoginManager();
    	assertFalse(model.getLogger().registerNoWrite("andypedoz", "0000"));
    	assertFalse(model.getLogger().registerNoWrite("a", "1"));
    	assertFalse(model.getLogger().registerNoWrite("b", "2"));
    	assertTrue(model.getLogger().registerNoWrite("c", "3"));
    }
}
