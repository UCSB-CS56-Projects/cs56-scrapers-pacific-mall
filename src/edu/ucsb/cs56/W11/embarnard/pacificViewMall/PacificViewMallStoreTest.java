package edu.ucsb.cs56.W11.embarnard.pacificViewMall;

//template from TicTacToeGridTest from lab07

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class PacificViewMallStore -- it tests the PacificViewMallStore class
 * @author Emilie Menard Barnard
 * @version For UCSB CS56 W11, Mantis ID 0000021
 * @see pacificViewMallStore
 */
public class PacificViewMallStoreTest
{
    @Test public void testNoArgsConstructor()
    {
        PacificViewMallStore store = new PacificViewMallStore();
		assertEquals(store.getStoreName(), "21 Century Smoking");
		assertEquals(store.getStoreType(), "Other");
		assertEquals(store.getPhoneNumber(), "(805) 280-5221");
    }
	
    @Test public void getStoreName()
    {
        PacificViewMallStore store = new PacificViewMallStore();
		assertEquals(store.getStoreName(), "21 Century Smoking");
    }
	
	@Test public void getStoreType()
    {
        PacificViewMallStore store = new PacificViewMallStore();
		assertEquals(store.getStoreType(), "Other");
    }
	
	@Test public void getPhoneNumber()
    {
        PacificViewMallStore store = new PacificViewMallStore();
		assertEquals(store.getPhoneNumber(), "(805) 280-5221");
    }
	
	@Test public void setStoreName()
    {
        PacificViewMallStore store = new PacificViewMallStore();
		store.setStoreName("Aeropostale");
		assertEquals(store.getStoreName(), "Aeropostale");
    }
	
	@Test public void setStoreType()
    {
        PacificViewMallStore store = new PacificViewMallStore();
		store.setStoreType("(805) 642-1793");
		assertEquals(store.getStoreType(), "(805) 642-1793");
    }
	
	@Test public void setPhoneNumber()
    {
        PacificViewMallStore store = new PacificViewMallStore();
		store.setPhoneNumber("General Apparel");
		assertEquals(store.getPhoneNumber(), "General Apparel");
	}
	
	@Test public void toStringMethod()
	{
		PacificViewMallStore store = new PacificViewMallStore();	
		assertEquals(store.toString(), "21 Century Smoking is a store of type Other, and is located in the Pacific View Mall. \n" + "The store's phone number is (805) 280-5221\n");
	}
	
}