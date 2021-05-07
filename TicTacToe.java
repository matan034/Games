package game;
//this class plays tictactoe 
public class TicTacToe extends Game{
	public TicTacToe(String player1,String player2) {
		super(3,3,new Player(player1,'X'),new Player(player2,'O'));//creates a 3,3 board with player1 and player 2 giving each player X and O accordingly
	}
	@Override
	protected boolean doesWin(int x, int y){
		if(maxLineContaining(x,y)==3) return true;//if we have a route the size of 3 with the same mark that player wins
		return false;
	}
}
