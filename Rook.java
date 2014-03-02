public class Rook extends Piece
{
	public Rook(int x, int y, boolean color)
	{
		super(x, y, 'r',"Rook",color);
	}
	@Override
	public boolean cellIsValid(int x, int y)
	{
		Cell curCell = Board.getCell(this.getX(), this.getY());
		//On Y axis
		if(x == curCell.getX())
		{
			//Above
			if(y < curCell.getY())
			{
				for(int i=1;i<Math.abs(y - curCell.getY());i++)
				{
					Cell temp = Board.getCell(curCell.getX(), curCell.getY()-i);
					if(temp.getPiece()!=null)
					{
						return false;
					}
				}
				return true;
			}
			//below
			else if(y > curCell.getY())
			{
				for(int i=1;i<Math.abs(x - curCell.getX());i++)
				{
					Cell temp = Board.getCell(curCell.getX()+i, curCell.getY());
					if(temp.getPiece()!=null)
					{
						return false;
					}
				}
				return true;
			}
		}
		//On X axis
		else if(y == curCell.getY())
		{
			//Right
			if(x > curCell.getX())
			{
				for(int i=1;i<Math.abs(x - curCell.getX());i++)
				{
					Cell temp = Board.getCell(curCell.getX()+i, curCell.getY());
					if(temp.getPiece()!=null)
					{
						return false;
					}
				}
				return true;
			}
			//Left
			else if(x < curCell.getX())
			{
				for(int i=1;i<Math.abs(x - curCell.getX());i++)
				{
					Cell temp = Board.getCell(curCell.getX()-i, curCell.getY());
					if(temp.getPiece()!=null)
					{
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
