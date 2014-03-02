import java.util.Scanner;

public class Player
{
	boolean black;
	Scanner scan;
	String name;
	public Player(boolean color, String _name)
	{
		black = color;
		name = _name;
		scan = new Scanner(System.in);
	}
	public String getName()
	{
		return name;
	}
	public void TakeTurn()
	{
		boolean finished = false;
		System.out.println(name +", it is your turn!");
		while(!finished)
		{
			boolean ready = false;
			int x = 0;
			int y = 0;
			String input;
			while(!ready)
			{
				System.out.println("Select a piece:\nType <number 0-7><space><number 0-7>");
				input = scan.nextLine();
				if(input.length() == 3)
				{
					x = Integer.valueOf(input.substring(0, 1));
					y = Integer.valueOf(input.substring(2, 3));
					ready = true;
				}
				else
				{
					System.out.println("Invalid Format! Try again");
				}
			}
			if(x < 8 && y < 8 && x > -1 && y > -1)
			{
				Cell cell = Board.getCell(x, y);
				Piece piece = cell.getPiece();
				if(piece != null)
				{
					if(piece.isBlack() == black)
					{
						System.out.println(piece.getName()+" Selected. Where do you want to move?");
						input = scan.nextLine();
						Cell cell2 = Board.getCell(Integer.valueOf(input.substring(0, 1)), Integer.valueOf(input.substring(2, 3)));
						if(piece.cellIsValid(cell2.getX(), cell2.getY()))
						{
							if(cell2.getPiece() != null)
							{
								if(cell2.getPiece().isBlack() != piece.isBlack())
								{
									piece.move(cell2.getX(), cell2.getY());
									piece.postMove();
									finished = true;
									System.out.println("Yah, you have taken a peice");
									if(piece.isKing())
									{
										System.out.println("That piece is the King, which mean you win "+name+"! Congradulations!");
										Control.endGame();
									}
								}
								else
								{System.out.println("Don't take your own peice!");}
							}
							else
							{
								piece.move(cell2.getX(), cell2.getY());
								piece.postMove();
								finished = true;
								System.out.println("You moved!");
							}
						}
						else
						{System.out.println("Not a valid space!");}
					}
					else
					{
						System.out.println("That is not your peice!");
					}
				}
				else
				{
					System.out.println("There is nothing there!");
				}
			}
			else
			{
				System.out.println("Your number is out of rang!");
			}
		}
	}
}
