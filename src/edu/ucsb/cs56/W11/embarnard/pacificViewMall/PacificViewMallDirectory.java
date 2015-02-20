package edu.ucsb.cs56.W11.embarnard.pacificViewMall;

import java.net.*;
import java.io.*;
import java.util.*;

public class PacificViewMallDirectory 
{	
	
	/**
	 * PacificViewMallDirectory gives the user the ability to find the name, store type, and phone number of a store in the Pacific View Mall
	 *
	 * @author Emilie Menard Barnard
	 * @version For UCSB CS56 W11, Mantis ID 0000021
	 */
	
	ArrayList<PacificViewMallStore> stores;
	
	/**
	 Constructs a directory of stores based on the data in a provided URL
	 @param urlFile A URL or file of the Pacific View Mall Store Directory
	 used code from  http://download.oracle.com/javase/tutorial/networking/urls/readingWriting.html as template
	 */
	public PacificViewMallDirectory(String urlFile)
	{
		//this first parts grabs the contents of the URL and puts it in a String called "contents"
		stores=new ArrayList<PacificViewMallStore>();
		String contents="";
		try{
		URL htmlcode = new URL(urlFile);
        URLConnection hc = htmlcode.openConnection();
        BufferedReader in = new BufferedReader(
											   new InputStreamReader(
																	 hc.getInputStream()));
        String inputLine;
		
        while ((inputLine = in.readLine()) != null) 
            contents=contents+inputLine;
        in.close();
		}
		catch (MalformedURLException e) {
			System.out.println("MalformedURLException occured");
			System.exit(1);
		}
		catch (IOException e) {
			System.out.println("IOException occured");
			System.exit(1);
		}
	
	parseUrl(contents);
		
		
	}
	
	/**
	 Compiles a list of every Pacfic View Mall store
	 @return An ArrayList of every store and it's name, store type, and phone number
	 */
	public ArrayList<PacificViewMallStore> allStores()
	{
		return stores;
	}
	
	
	/**
	 Finds a given store in the Pacific View Mall via name search
	 @param name The name of the store
	 @return An ArrayList of the PacificViewMallStore object with the given name
	 */
	public ArrayList<PacificViewMallStore> getStoresOfName(String name)
	{
		ArrayList<PacificViewMallStore> storeWithName= new ArrayList<PacificViewMallStore>();		
		for (int x = 0; x < stores.size(); x++)
		{
			if (stores.get(x).getStoreName().equals(name))
				storeWithName.add(stores.get(x));
		}
		
		return storeWithName;
	}
	
	/**
	 Creates a list of stores in the Pacific View Mall with a given store type
	 @param type The store type to search for 
	 @return An ArrayList of PacificViewMallStore objects with the given store type
	 */
	public ArrayList<PacificViewMallStore> getStoresOfType(String type)
	{
		ArrayList<PacificViewMallStore> storesOfAType= new ArrayList<PacificViewMallStore>();	
		for (int x = 0; x < stores.size(); x++)
		{
			if (stores.get(x).getStoreType().equals(type))
				storesOfAType.add(stores.get(x));
		}
		
		return storesOfAType;
	}
	
	/**
	 Finds a given store in the Pacific View Mall via reverse phone number search
	 @param phoneNum The phone number of the store of format (###) ###-#### (can also search "coming soon" for currently unlisted numbers
	 @return An ArrayList of the PacificViewMallStore object(s) with the given phone number
	 */
	public ArrayList<PacificViewMallStore> getStoresOfPhone(String phoneNum)
	{
		ArrayList<PacificViewMallStore> storeWithNum= new ArrayList<PacificViewMallStore>();	
		for (int x = 0; x < stores.size(); x++)
		{
			if (stores.get(x).getPhoneNumber().equals(phoneNum))
				storeWithNum.add(stores.get(x));
		}
		
		return storeWithNum;
	}
	
	
	
	
	/**
	 Retrieves and parses the html code for our needs
	 @param source A URL or file of the Pacific View Mall Store Directory
	 */
	public void parseUrl(String contents){
		
		//this part actually does the parsing of the URL now that we have "contents"
		
        String[] splitContents=contents.split("<div class=\"left\">"); //creates an array of strings that are separated by "<div class="left">"
		String thisPart;
		
		//we don't care about the first or last element in this array, as that's extraneous html code
		
		for (int x=1; x<(splitContents.length-1); x++) {
			thisPart=splitContents[x];
			
			int indexIfNewInString=thisPart.indexOf("\"tenantStatus\">New");  //checkes to see if the store is "New", returns -1 if it's not
			int indexIfUnderConstructionInString=thisPart.indexOf("\"tenantStatus\">Under Construction");//checks to see if the store is "Under Construction", returns -1 if it's not
			
			//case for "normal" stores (store is not New, nor Under Construction)
			if (indexIfNewInString==(-1) && indexIfUnderConstructionInString==(-1)){
				//edit this part of splitContents so that we can access the store name, type, and phone number
				thisPart=thisPart.replaceAll("<div class=\"retailerName\">", "");
				thisPart=thisPart.replaceAll("\\|", "break");
				thisPart=thisPart.replaceAll("<span>Business Type: </span>", "break");
				thisPart=thisPart.replaceAll("<span>", "break");
				thisPart=thisPart.replaceAll("Phone: </span>", "break");
				thisPart=thisPart.replaceAll("</div>", "break");
				
				 /*after all of those replaceAll functions, our thisPart string now looks something like this:
				 
				  21 Century Smoking								 break <span class="pad_2" style='background-color:#'>
				  <span id="MainContentRoot_MainContent_tenantList_dlTenantSearchResults_lblZoneName_0">
				  Cart or Kiosk</span></span>	                            break	                           
				  <div>	                                breakOther breakbreak</span> break
				  break(805) 280-5221	                            break	                        
				  break	                        <div class="right">	                            
				 				 
				 */ 
				
				
				//now we can spilt this again by instances of the word "break" to identify the store name, type, and phone number
				
				String[] splitThisPart=thisPart.split("break"); //creates an array of strings that are separated by "break"
				
				String storeName=(splitThisPart[0].trim());
				String storeType=(splitThisPart[3].trim());
				String phoneNumber=(splitThisPart[7].trim());
			
				
				PacificViewMallStore newStore=new PacificViewMallStore(storeName, storeType, phoneNumber);
				stores.add(newStore);
				
				
			}
			
			//case for stores that have a status such as "new" or "under construction" (we have one more index in the array in this case)
			else {
				//edit this part of splitContents so that we can access the store name, type, and phone number
				thisPart=thisPart.replaceAll("<div class=\"retailerName\">", "");
				thisPart=thisPart.replaceAll("\\|", "break");
				thisPart=thisPart.replaceAll("<span>Business Type: </span>", "break");
				thisPart=thisPart.replaceAll("<span>", "break");
				thisPart=thisPart.replaceAll("Phone: </span>", "break");
				thisPart=thisPart.replaceAll("</div>", "break");
				
			
				 /* after all of those replaceAll functions, our thisPart string now looks something like this:
				 
				Brow Shaping Salon								 break <span id="MainContentRoot_MainContent_tena
				  ntList_dlTenantSearchResults_lblStatus_14" class="tenantStatus">New</span>	
				  break <span class="pad_2" style='background-color:#FF882B'><span id="MainContentRoot
				  _MainContent_tenantList_dlTenantSearchResults_lblZoneName_14">2A</span></span>	       
				  break	                            <div>	                               
				  breakCosmetics breakbreak</span> breakbreak(805) 644-0008	                           
				  break	                        break	                        <div class="right">
				 
				 */ 
			
				
				//now we can spilt this again by instances of the word "break" to identify the store name, type, and phone number
				
				String[] splitThisPart=thisPart.split("break"); //creates an array of strings that are separated by "break"
				
				String storeName=(splitThisPart[0].trim());
				String storeType=(splitThisPart[4].trim());//increments 1 from last function because of extra "break"
				String phoneNumber=(splitThisPart[8].trim());//increments 1 from last function because of extra "break"
				
				
				PacificViewMallStore newStore=new PacificViewMallStore(storeName, storeType, phoneNumber);
				stores.add(newStore);
				
				
			}
			
			
		}
    }
}