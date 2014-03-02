
public class Cell
{
	Piece peice;
	int x, y;
	public Cell(Piece _piece)
	{
		peice = _piece;
	}
	public Cell(int _x, int _y)
	{
		peice = null;
		x = _x;
		y = _y;
	}
	public void draw()
	{
		if(peice == null)
		{
			System.out.print('*');
		}
		else
		{
			if(peice.isBlack())
				System.out.print((peice.getRep()+"").toLowerCase());
			else
				System.out.print((peice.getRep()+"").toUpperCase());
		}
	}
	public void insertPeice(Piece _piece)
	{
		peice = _piece;
	}
	public void removePeice()
	{
		peice = null;
	}
	public Piece getPiece()
	{
		return peice;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}
