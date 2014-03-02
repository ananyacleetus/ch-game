
public class Piece
{
	boolean black;
	char rep;
	int x, y;
	String name;
	boolean king;
	public Piece(int _x, int _y, char _rep, String _name, boolean color)
	{
		black = color;
		rep = _rep;
		x = _x;
		y = _y;
		king = false;
		name = _name;
	}
	public String getName()
	{
		return name;
	}
	public void makeKing()
	{
		king = true;
	}
	public boolean isKing()
	{
		return king;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX(int _x)
	{
		x = _x;
	}
	public void setY(int _y)
	{
		y = _y;
	}
	public boolean isBlack()
	{
		return black;
	}
	public char getRep()
	{
		return rep;
	}
	public void move(int x, int y)
	{
		Cell curCell = Board.getCell(this.getX(), this.getY());
		Cell _cell = Board.getCell(x,y);
		_cell.insertPeice(this);
		curCell.removePeice();
		this.setX(_cell.getX());
		this.setY(_cell.getY());
	}
	public boolean cellIsValid(int x, int y)
	{return true;}
	public void postMove()
	{}
}
