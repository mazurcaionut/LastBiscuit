/*I attempted Level 3*/
import java.util.Scanner;

public class LastBiscuit
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int barrel1=6,barrel2=8; 
		int playerCounter=1; //variable that counts the player's turn
		int biscuitsTaken=0; //variable that counts the biscuits taken at a specific moment in the game
		String chosenBarrel="";
		boolean positiveInteger=false; // variable needed to check the validity of the numbers entered
		boolean game=true; // boolean variable which is true as long as the game is running 
		boolean barrelChoice=true; // variable needed to check the validity of the barrel chosen by the player
		final String WINNER_ONE="Winner is player 1";
		final String WINNER_TWO="Winner is player 2";
		while(game) // this while loop is running as long as none of the players have won the game
		{
			System.out.println("Biscuits Left - Barrel 1: "+barrel1);
			System.out.println("Biscuits Left - Barrel 2: "+barrel2);
			positiveInteger=false; barrelChoice=true; //the initial value of the checking variables at the beggining of each stage of the game
			System.out.print("Biscuits taken by player "+playerCounter+": ");
			while(positiveInteger==false) // while loop needed to check the validity of the numbers entered
			{
				positiveInteger=true;
				while(!in.hasNextInt()) // while loop needed to check if the numbers that are entered are integers or not
				{
					System.out.print("The value that you enter must be an integer.Please try again: ");
					in.next();
				}
				biscuitsTaken=in.nextInt();
				if(biscuitsTaken<0 || (biscuitsTaken>barrel1 && biscuitsTaken>barrel2)) // if structure needed to check the ranges of the numbers entered by the player
				{
					System.out.print("The value that you enter must be an integer, positive and also less than the number of biscuits in the barrel .Please try again: ");
					positiveInteger=false;
				}
			}
			in.nextLine(); // we use the "in.nextLine" structure in order to be able to read between integers and strings
			System.out.print("From barrel1 (one), barrel2 (two), or both (both)? ");
			chosenBarrel=in.nextLine();
			while(barrelChoice) // while loop needed to check if the numbers that are entered are integers or not
			{
				if(chosenBarrel.equals("one") && barrel1-biscuitsTaken>=0) 
				{
					/* if structure which is true when the player chooses the first barrel and the number of biscuits taken
					by the player is less than the number of biscuits available in the first barrel at that moment*/
					barrel1=barrel1-biscuitsTaken;
					barrelChoice=false;
				}
				else if(chosenBarrel.equals("two") && barrel2-biscuitsTaken>=0)
				{
					/* if structure which is true when the player chooses the second barrel and the number of biscuits taken
					by the player is less than the number of biscuits available in the second barrel at that specific moment*/
					barrel2=barrel2-biscuitsTaken;
					barrelChoice=false;
				}
				else if(chosenBarrel.equals("both") && (barrel1-biscuitsTaken>=0 && barrel2-biscuitsTaken>=0)) 
				{
					/* if structure which is true when the player chooses both barrels and the number of biscuits taken
					by the player is less than the number of biscuits available both in the first and the second barrel at that specific moment*/
					barrel1=barrel1-biscuitsTaken;
					barrel2=barrel2-biscuitsTaken;
					barrelChoice=false;
				}
				else
				{
					//else structure in case the player doesn't enter any available option of barrel
					System.out.print("Please enter the barrel choice again. ");
					chosenBarrel=in.nextLine();
				}
			}
			if(barrel1==0 && barrel2==0) //if structure meant to end the game by changing the variable value
			{
				System.out.println("Biscuits Left - Barrel 1: "+barrel1);
				System.out.println("Biscuits Left - Barrel 2: "+barrel2);
				game=false;
			}	
			else //else structure meant to change the player turn by constantly updating the "playerCounter" value
 			{
				playerCounter++;
				if(playerCounter>2) playerCounter=1;
			}
		}
		if(playerCounter==1) System.out.print(WINNER_ONE); // If instruction meant to display the winner of the game
		else System.out.print(WINNER_TWO);
	}
}