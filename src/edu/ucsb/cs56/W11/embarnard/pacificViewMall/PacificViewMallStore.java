package edu.ucsb.cs56.W11.embarnard.pacificViewMall;

public class PacificViewMallStore
{
	/**
	 * PacificViewMallStore provides the store type and phone number of a store in the Pacific View Mall (located in Ventura, CA)
	 *
	 * @author Emilie Menard Barnard
	 * @version For UCSB CS56 W11, Mantis ID 0000021
	 */
	
	String storeName;
	String storeType;
	String phoneNumber;
	
	/**
	 Constructs a default PacificViewMallStoreTypeAndPhone initialized to the name, location, and phone number of "21 Century Smoking" (the first store in the directory as of 2/23/2011)
	 *
	 */
	public PacificViewMallStore()
	{
		storeName="21 Century Smoking";
		storeType="Other";
		phoneNumber="(805) 280-5221";
	}
	
	/**
	 Constructs a PacificViewMallStore initialized to a specified location
	 *
	 * @param givenName The name of the store
	 * @param givenStoreType The type of the store
	 * @param givenPhoneNumber The phone number of the store
	 */
	public PacificViewMallStore(String givenName, String givenStoreType, String givenPhoneNumber)
	{
		storeName=givenName;
		storeType=givenStoreType;
		phoneNumber=givenPhoneNumber;
	}
	
	/**
	 Gets the name for the store
	 *
	 *@return The name of the store
	 */	
	public String getStoreName()
	{
		return storeName;
	}
	
	/**
	 Gets the store type of the store
	 *
	 *@return The type of the store
	 */	
	public String getStoreType()
	{
		return storeType;
	}
	
	/**
	 Gets the phone number for the store
	 *
	 *@return The phone number of the store
	 */	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	
	/**
	 Sets the name for the store
	 *
	 * @param givenName The name of the store
	 */
	public void setStoreName(String givenName)
	{
		storeName=givenName;
	}
	
	/**
	 Sets the store type of the store
	 *
	 * @param givenStoreType The type of the store
	 */
	public void setStoreType(String givenStoreType)
	{
		storeType = givenStoreType;
	}
	
	/**
	 Sets the phone number for the store
	 *
	 * @param givenPhoneNumber The phone number of the store
	 */
	public void setPhoneNumber(String givenPhoneNumber)
	{
		phoneNumber = givenPhoneNumber;
	}
	
	
	
	
	/**
	 Returns the name, location, and phone number of the store in the Pacific View Mall
	 *
	 * @return The name, location, and phone number of a given store
	 */	
	public String toString()
	{
		String stringToPrint = (storeName + " is a store of type " + storeType + ", and is located in the Pacific View Mall. \n" + "The store's phone number is " + phoneNumber + "\n");
		
		return stringToPrint;
	}
}