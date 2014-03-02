
public class Control
{
	private static boolean gameOver = false;
	public static void endGame()
	{
		gameOver = true;
	}
	public static boolean gameIsOver()
	{
		return gameOver;
	}
	
}