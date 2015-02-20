package edu.ucsb.cs56.W11.embarnard.pacificViewMall;
import java.util.ArrayList;

//the main class, prints out the entire directory

public class pacificViewMall
{
	public static void main(String[] argv)
	{
		PacificViewMallDirectory directory = new PacificViewMallDirectory("http://www.shoppacificview.com/Map/");
		ArrayList<PacificViewMallStore> stores = directory.allStores();
		
		for (int x=0; x<stores.size(); x++)
		{
			System.out.println(stores.get(x).toString());
		}
	}
}