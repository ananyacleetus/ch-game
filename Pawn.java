
public class Pawn extends Piece
{
	boolean hasMoved;
	public Pawn(int x, int y, boolean color)
	{
		super(x, y, 'p',"Pawn",color);
		hasMoved = false;
	}
	@Override
	public boolean cellIsValid(int x, int y)
	{
		Cell curCell = Board.getCell(this.getX(), this.getY());
		if(this.isBlack())
		{
			if(y == curCell.getY()+1)
			{
				if(Board.getCell(x, y).getPiece()==null)
				{
					if(x == curCell.getX())
					{return true;}
				}
				else
					if(curCell.getX()+1 == x || curCell.getX()-1 == x)
					{
						return true;
					}
			}
			else if(y == curCell.getY()+2 && !hasMoved)
			{
				if(x == curCell.getX())
				{
					hasMoved = true;
					return true;
				}
			}
		}
		else
		{
			if(y == curCell.getY()-1)
			{
				if(Board.getCell(x, y).getPiece()==null)
				{
					if(x == curCell.getX())
					{return true;}
				}
				else
					if(curCell.getX()+1 == x || curCell.getX()-1 == x)
					{
						return true;
					}
			}
			else if(y == curCell.getY()-2 && !hasMoved)
			{
				if(x == curCell.getX())
				{
					hasMoved = true;
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public void postMove()
	{
		if(this.isBlack())
		{
			if(this.getY() == 7)
			{
				Queen queen = new Queen(this.getX(),this.getY(),true);
				Board.getCell(this.getX(), this.getY()).insertPeice(queen);
				System.out.println("Yes! Your pawn has gotten to the other side. You now have another Queen!");
			}
		}
		else
		{
			if(this.getY() == 0)
			{
				Queen queen = new Queen(this.getX(),this.getY(),false);
				Board.getCell(this.getX(), this.getY()).insertPeice(queen);
				System.out.println("Yes! Your pawn has gotten to the other side. You now have another Queen!");
			}
		}
	}
}
