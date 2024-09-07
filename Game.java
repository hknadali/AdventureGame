import java.util.Scanner;

public class Game {
	
	private Scanner input = new Scanner(System.in);
	
	public void start() {
		System.out.println("Welcome to the Adventure Game!");
		System.out.println("Please enter your name: ");
		Player player = new Player(input.nextLine());
		System.out.println("Dear " + player.getName() + ", welcome to this dark and foggy island!");
		System.out.println("***************************************");
		player.selectChar();
		System.out.println("***************************************");
		
		Location location = null;
		while(true) {
			player.printInfo();
			System.out.println("#### Locations ####");
			System.out.println("1 - Safe House\t=> This is the safe house, there is no monster here.");
			System.out.println("2 - Tool Store\t=> You can buy armors and weapons here.");
			System.out.println("3 - Cave\t=> Be careful, there are zombies living here! Reward: food");
			System.out.println("4 - Forest\t=> Be careful, there are vampires living here! Reward: firewood");
			System.out.println("5 - River\t=> Be careful, there are bears living here! Reward: water");
			System.out.println("0 - Quit\t=> Quit the game.");
			System.out.println("---- Please choose a location to go! ----");
			
			int selection = input.nextInt();
			switch(selection) {
			case 0:
				location = null;
				break;
			case 1: 
				location = new SafeHouse(player);
				break;
			case 2:
				location = new ToolStore(player);
				break;
			case 3:
				location = new Cave(player);
				break;
			case 4:
				location = new Forest(player);
				break;
			case 5:
				location = new River(player);
				break;
			default:
				System.out.println("Please enter a valid location!");
			}	
			if(location == null) {
				System.out.println("You give up very quick!");
				break;
			}
			
			if(!location.onLocation()) {
				System.out.println("GAME OVER!");
				break;
			}
		}
	}
}

