
public class King extends Piece
{
	public King(int x, int y, boolean color)
	{
		super(x, y, 'k',"King",color);
		super.makeKing();
	}
	@Override
	public boolean cellIsValid(int x, int y)
	{
		Cell curCell = Board.getCell(this.getX(), this.getY());
		int deltaX = Math.abs(x - curCell.getX());
		int deltaY = Math.abs(y - curCell.getY());
		if(deltaX < 2 && deltaY < 2)
		{
			if(deltaX + deltaY<= 2)
			{
				return true;
			}
		}
		return false;
	}
}
