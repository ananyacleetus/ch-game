public class Bishop extends Piece
{
	public Bishop(int x, int y, boolean color)
	{
		super(x, y, 'b',"Bishop",color);
	}
	@Override
	public boolean cellIsValid(int x, int y)
	{
		Cell curCell = Board.getCell(this.getX(), this.getY());
		if(Math.abs(x - curCell.getX()) == Math.abs(y - curCell.getY()))
		{
			//right side
			if(x > curCell.getX())
			{
				//below
				if(y > curCell.getY())
				{
					for(int i=1; i<Math.abs(x-curCell.getX());i++)
					{
						Cell temp = Board.getCell(curCell.getX()+i, curCell.getY()+i);
						if(temp.getPiece()!=null)
						{
							return false;
						}
					}
					return true;
				}
				//above
				else if(y < curCell.getY())
				{
					for(int i=1; i<Math.abs(x-curCell.getX());i++)
					{
						Cell temp = Board.getCell(curCell.getX()+i, curCell.getY()-i);
						if(temp.getPiece()!=null)
						{
							return false;
						}
					}
					return true;
					
				}
			}
			//left side
			else if(x < curCell.getX())
			{
				//below
				if(y > curCell.getY())
				{
					for(int i=1; i<Math.abs(x-curCell.getX());i++)
					{
						Cell temp = Board.getCell(curCell.getX()-i, curCell.getY()+i);
						if(temp.getPiece()!=null)
						{
							return false;
						}
					}
					return true;
				}
				//above
				else if(y < curCell.getY())
				{
					for(int i=1; i<Math.abs(x-curCell.getX());i++)
					{
						Cell temp = Board.getCell(curCell.getX()-i, curCell.getY()-i);
						if(temp.getPiece()!=null)
						{
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
}
