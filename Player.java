package game;
//class representing a player with a name and a mark
public class Player {

	private String name;
	private char mark;
	public Player(String name, char mark) {//initialize variables
		this.name=name;
		this.mark=mark;
	}

	public String getName()
	{
		return name;
	}

	public char getMark() {return mark;}
	public String toString()
	{
		return name+"("+mark+")";
	}


}
