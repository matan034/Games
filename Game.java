package game;
import java.util.Scanner;
//this func handles player turns and winners
public class Game extends Board {

	protected Player[] players;
	protected Scanner s;
	public Game(int n,int m,Player p1,Player p2)//set players and createa board
	{
		super(n,m);
		s=new Scanner(System.in);
		players=new Player[2];
		players[0]=p1;
		players[1]=p2;
	}
	protected boolean doesWin(int i,int j)//checks if a player chose 0,0 if he does he wins(this will get overriden for other games)
	{
		if(i==0&&j==0) return true;
		return false;
	}
	protected boolean onePlay(Player p)//Handles turns and winners
	{
		int x,y;
		System.out.println(p+", please enter x and y:");
		x=s.nextInt();
		y=s.nextInt();
		while(super.set(x, y, p)==false)//if theres a piece already in that spot set returns false
		{	
			System.out.println("There is a piece there already...");
			System.out.println(p+", please enter x and y:");
			x=s.nextInt();
			y=s.nextInt();
			
		}
		if(doesWin(x,y)==true) //if the players win
			{
				s.close();
				return true;
			}
		return false;
	}
	public Player play()
	{
		while(super.isFull()==false)//if the board is not full keep alternating turns between players
		{
			if(onePlay(players[0])==true)
				return players[0];
			if(onePlay(players[1])==true)
				return players[1];
		}
		return null;
	}

}
