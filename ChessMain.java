import java.util.Scanner;


public class ChessMain {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Player 1, What is your name?");
		Player player1 = new Player(false,scan.nextLine());
		System.out.println("Player 2, What is your name?");
		Player player2 = new Player(true,scan.nextLine());
		System.out.println(player1.getName()+" and "+player2.getName()+" you must fight to the death! Now Begin!");
		Board.createBoard();
		Board.drawBourd();
		while(!Control.gameIsOver())
		{
			player1.TakeTurn();
			Board.drawBourd();
			player2.TakeTurn();
			Board.drawBourd();
		}
	}
}