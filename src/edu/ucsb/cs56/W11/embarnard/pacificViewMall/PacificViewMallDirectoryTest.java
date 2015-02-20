package edu.ucsb.cs56.W11.embarnard.pacificViewMall;

//template from TicTacToeGridTest from lab07

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;

/**
 * The test class PacificViewMallDirectory -- it tests the PacificViewMallDirectory class
 * @author Emilie Menard Barnard
 * @version For UCSB CS56 W11, Mantis ID 0000021
 * @see pacificViewMallDirectory
 */
public class PacificViewMallDirectoryTest
{
    @Test public void getStoresOfNameAeropostale()
    {
        PacificViewMallDirectory directory = new PacificViewMallDirectory("http://www.shoppacificview.com/Map/");
		ArrayList<PacificViewMallStore> storesByName =directory.getStoresOfName("Aeropostale");
		
		PacificViewMallStore store=storesByName.get(0);
		assertEquals(store.getStoreName(), "Aeropostale");
		assertEquals(store.getStoreType(), "General Apparel");
		assertEquals(store.getPhoneNumber(), "(805) 642-1793");
		
    }
	
	@Test public void getStoresOfTypeDepartmentStores()
    {
        PacificViewMallDirectory directory = new PacificViewMallDirectory("http://www.shoppacificview.com/Map/");
		ArrayList<PacificViewMallStore> storesByType =directory.getStoresOfType("Department Stores");
		
		PacificViewMallStore store1=storesByType.get(0);
		assertEquals(store1.getStoreName(), "JCPenney");
		assertEquals(store1.getStoreType(), "Department Stores");
		assertEquals(store1.getPhoneNumber(), "(805) 642-7592");
		
		PacificViewMallStore store2=storesByType.get(1);
		assertEquals(store2.getStoreName(), "Macy's");
		assertEquals(store2.getStoreType(), "Department Stores");
		assertEquals(store2.getPhoneNumber(), "(805) 642-7511");
		
		PacificViewMallStore store3=storesByType.get(2);
		assertEquals(store3.getStoreName(), "Sears");
		assertEquals(store3.getStoreType(), "Department Stores");
		assertEquals(store3.getPhoneNumber(), "(805) 477-3200");
		
    }
	
	@Test public void getStoresOfPhoneAeropostale()
    {
        PacificViewMallDirectory directory = new PacificViewMallDirectory("http://www.shoppacificview.com/Map/");
		ArrayList<PacificViewMallStore> storesByPhone =directory.getStoresOfPhone("(805) 642-1793");
		
		PacificViewMallStore store=storesByPhone.get(0);
		assertEquals(store.getStoreName(), "Aeropostale");
		assertEquals(store.getStoreType(), "General Apparel");
		assertEquals(store.getPhoneNumber(), "(805) 642-1793");
		
    }
		
}