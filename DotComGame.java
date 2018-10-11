package SinkAdotCom1;

import java.util.ArrayList;

public class DotComGame 
{
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom>dotComArray=new ArrayList<DotCom>();
	private int playerGuessCount = 0;
	
	
	// start of setter methods

	private void setupGame()
	{
		DotCom one = new DotCom("google.com");
		DotCom two = new DotCom("yahoo.com");
		DotCom three = new DotCom("AskJeeves.com");
		
		dotComArray.add(one);
		dotComArray.add(two);
		dotComArray.add(three);
		
		System.out.println("Welcome to SinkAdotCom");
		System.out.println("Your Obj is to sink the three dotComs");
		System.out.println("To do so, correctly guess the locations");
	
		
		//sets a location for each dot com name in the array list
		for(DotCom dotComSet:dotComArray)
		{
			ArrayList<String> newLocation=helper.placeDotCom(3);
            dotComSet.setLocationCells(newLocation);
		}
		
	}
	//end of setter methods
	
	
	//need to create the game helper class first.
	public void GameStartup()
	{
		while (!dotComArray.isEmpty())
		{
			String userGuess = helper.getUserInput("Enter your location guess please");// utilises getUserinput getter from the game helper class
			checkUserGuess(userGuess); // checks the users guess
		}
		
		finishGame();
	}
	
	private void checkUserGuess(String userGuess)
	{
		playerGuessCount++;
		String result = "miss";
		
		for (DotCom dotComToTest : dotComArray)
		{
			result = dotComToTest.checkYourself(userGuess);
			
			if(result.equals("hit"))
			{
				break;
			}
			
			if(result.equals("kill"))
			{
				dotComArray.remove(dotComToTest);
				break;
			}
		}
	}
	
	private void finishGame()
	{
		System.out.println("you have successfully guessed where all the dot coms are. congrats");
	}
	
	public static void main(String[] args)
	{
		DotComGame game = new DotComGame();
		game.setupGame();
		game.GameStartup();
	}
	
}
