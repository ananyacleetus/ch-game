public class Knight extends Piece
{
	public Knight(int x, int y, boolean color)
	{
		super(x, y, 'n',"Knight",color);
	}
	@Override
	public boolean cellIsValid(int x, int y)
	{
		Cell curCell = Board.getCell(this.getX(), this.getY());
		int deltaX = Math.abs(x - curCell.getX());
		int deltaY = Math.abs(y - curCell.getY());
		if(deltaX > 0 && deltaY > 0)
		{
			if(deltaX + deltaY == 3)
			{
				return true;
			}
		}
		return false;
	}
}
