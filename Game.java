import java.util.Scanner;

public class Game {
	
	private Scanner input = new Scanner(System.in);
	
	public void start() {
		System.out.println("Welcome to the Adventure Game!");
		System.out.println("Please enter your name: ");
		Player player = new Player(input.nextLine());
		System.out.println("Dear " + player.getName() + ", welcome to this dark and foggy island!");
		System.out.println("##################################");
		player.selectChar();
	}
	
}
