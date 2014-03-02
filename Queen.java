public class Queen extends Piece
{
	public Queen(int x, int y, boolean color)
	{
		super(x, y, 'q',"Queen",color);
	}
	@Override
	public boolean cellIsValid(int x, int y)
	{
		/*The Queen is a combination of the rook
		 * and the Bishop so the implementation for
		 * this method would also be a combination
		 * of the two.*/
		Cell curCell = Board.getCell(this.getX(), this.getY());
		//Rook////////////////////////////////////////////////////////////////////////////////////////////
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
		////////////////////////Bishop//////////////////////////////////////////////////////////////////////
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
