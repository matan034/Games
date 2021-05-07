package game;
//func to play fourinarow
public class FourInARow extends Game {

	private int []x;//this array keeps track of the current row we are on for each column (on board (6,7) with no disks we are on row 6, if column 2 has 1 disk we are on row 5 for that column and so on)
	public FourInARow(String player1,String player2) {
		super(6,7,new Player(player1,'W'),new Player(player2,'B'));//sets a board with players
		x=new int[m];
		for(int i=0;i<x.length;i++) x[i]=n;//initalize x values to be size of our columns
	}
	protected boolean doesWin(int x, int y){//checks if we got 4 in a row
		if(maxLineContaining(x,y)==4) return true;
		return false;
	}
	protected boolean onePlay(Player p)
	{
		int y;
		System.out.println(p.getName()+", please enter column:");
		y=s.nextInt();
		while(x[y]==0)//if column is full
		{
			System.out.println(p.getName()+", Column is full please enter a new column:");
			y=s.nextInt();
		}
		set(x[y]-1,y,p);//set the disks position
		if(doesWin(x[y]-1,y)==true) //returns winner
			return true;
		else
		{
			x[y]--;//updates the row we are on
			return false;
		}
	}	
		
}
