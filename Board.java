package game;
//class that creates a board for a game
public class Board {
protected Player[][] board;
protected int m ,n;

	public Board(int n,int m) {
		this.n=n;
		this.m=m;
		board=new Player[n][m];//create a matrix with size n and m for our board
	}
	protected boolean set(int i, int j, Player p){//if boadr position we want to set, is not empty set it.
		if(isEmpty(i,j)==true) 
		{
			board[i][j]=p;
			return true;
		}
		return false;
	}
	public boolean isEmpty(int i, int j){//checks if position in board is empty or not
		if(board[i][j]==null)
			return true;
		return false;	
	}
	public Player get(int i, int j){
		return board[i][j];
	}
	public boolean isFull() //checks if board is full
	{
		for(int i=0;i<n;i++)
			for(int j=0;i<m;i++)
				if(isEmpty(i,j)==true) return false;
		return true;
	}
	public String toString() 
	{
		String str="";
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
				if(isEmpty(i,j)==true) str+=".";
				else str+=get(i, j).getMark();
			str+="\n";
		}
		
		return str;
	}
	//this func counts the length of a route from a given point(route only has same marks)
	private int checkRoute(int i,int j,int direction)
	{
		char temp=get(i,j).getMark();//get the current positions mark
		int cnt=0;
		while(i>=0&&j>=0&&i<n && j<m && get(i,j)!=null&& get(i, j).getMark()==temp ) /* checks that i and j are on the board(0<=i>n 0<=j>m) checks that that point has a mark and then checks if that mark is the same as the mark we recieved in our func*/
		{		
			cnt++;
			switch(direction)
			{
				case 0://"up":
				{
					i--;
					break;
				}
				case 1://"down":
				{
					i++;
					break;
				}
				case 2://"left":
				{
					j--;
					break;
				}
				case 3://"right":
				{
					j++;
					break;
				}
				case 4://"left_up":
				{
					i--;
					j--;
					break;
				}
				case 5://"left_down":
				{
					i++;
					j--;
					break;
				}
				case 6://"right_down":
				{
					i++;
					j++;
					break;
				}
				case 7://"right_up":
				{
					i--;
					j++;
					break;
				}
			}
		}
			return cnt;
	}
	
	protected int maxLineContaining(int i, int j) 
	{
		int []cnt=new int[8];//array size 8 (8 directions) that keeps track of all routes
		int max=0;
		for(int k=0;k<8;k++){//search all directions for route length
			cnt[k]= checkRoute(i, j, k);
		}
			for(int k=0;k<8;k++)//find max 
				if(cnt[k]>max) max=cnt[k];
	
		return max;
	}

}
