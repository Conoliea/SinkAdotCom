package SinkAdotCom1;

import java.util.ArrayList;


public class DotCom 
{
	private ArrayList<String> locationCells;
	private String name = "";
	
	//dot com name constructor
	public DotCom(String name)
	{
		setName(name);
	}
	//end of dot come name constructor
	
	
	//Start of setter methods
	
	public void setLocationCells(ArrayList<String>locations)
	{
		locationCells = locations;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	// end of setter methods
	
	
	//Start of check your guess method
	public String checkYourself(String userInput)
	{
		String result = "miss";
		
		//retrieves the users guess index if it exists?
		int index = locationCells.indexOf(userInput);
		
		
		
		//to check if users guess is in the list
		if (index >= 0)
		{
			locationCells.remove(index);
			
			
			//Once the index is removed due to the users guess, the dot com name is destroyed
			if (locationCells.isEmpty())
			{
				result = "kill";
				System.out.println("You managed to correctly guess the location of " + name);
			}
			
			else
			{
				result = "hit";
			}
		}
		//end of users guess index check
		
		return (result);
		
	}
	//end of check your guess method
}
