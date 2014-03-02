import java.util.Arrays;


public class Board
{
	static Cell[][] cells;
	private final static int SIZE = 8;
	public static void createBoard()
	{
		cells = new Cell[SIZE][SIZE];
		for(int y=0;y<SIZE;y++)
			for(int x=0;x<SIZE;x++)
				cells[x][y] = new Cell(x,y);
		setPeices();
	}
	public static void drawBourd()
	{
		System.out.print("  ");
		for(int i=0;i<SIZE;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		for(int y=0;y<SIZE;y++)
		{
			System.out.print(y+" ");
			for(int x=0;x<SIZE;x++)
			{
				
				cells[x][y].draw();
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	private static void setPeices()
	{
		//Pawns
		Pawn[] bPawns = new Pawn[8];
		/*for(int i=0;i<8;i++)
		{
			bPawns[i] = new Pawn(i,1, true);
			placePeice(bPawns[i]);
		}*/
		bPawns = new Pawn[8];
		for(int i=0;i<8;i++)
		{
			bPawns[i] = new Pawn(i,6, false);
			placePeice(bPawns[i]);
		}
		//Kings
		King[] kings = new King[2];
		kings[0] = new King(4,0,true);
		kings[1] = new King(4,7,false);
		placePeice(kings[0]);
		placePeice(kings[1]);
		//Queens
		Queen[] queens = new Queen[2];
		queens[0] = new Queen(3,0,true);
		queens[1] = new Queen(3,7,false);
		placePeice(queens[0]);
		placePeice(queens[1]);
		//Bishops
		Bishop[] bishops = new Bishop[2];
		for(int i=0;i<2;i++)
		{
			bishops[i] = new Bishop(i*3+2,0,true);
			placePeice(bishops[i]);
		}
		bishops = new Bishop[2];
		for(int i=0;i<2;i++)
		{
			bishops[i] = new Bishop(i*3+2,7,false);
			placePeice(bishops[i]);
		}
		//Knights
		Knight[] knights = new Knight[2];
		for(int i=0;i<2;i++)
		{
			knights[i] = new Knight(i*5+1,0,true);
			placePeice(knights[i]);
		}
		knights = new Knight[2];
		for(int i=0;i<2;i++)
		{
			knights[i] = new Knight(i*5+1,7,false);
			placePeice(knights[i]);
		}
		Rook[] rooks = new Rook[2];
		for(int i=0;i<2;i++)
		{
			rooks[i] = new Rook(i*7,0,true);
			placePeice(rooks[i]);
		}
		rooks = new Rook[2];
		for(int i=0;i<2;i++)
		{
			rooks[i] = new Rook(i*7,7,false);
			placePeice(rooks[i]);
		}
	}
	public static Cell getCell(int x, int y)
	{
		return cells[x][y];
	}
	public static void placePeice(Piece piece)
	{
		cells[piece.getX()][piece.getY()].insertPeice(piece);
	}
}
