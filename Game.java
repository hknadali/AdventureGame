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
			player.getInventory().printInventory();
			System.out.println("#### Locations ####");
			System.out.println("1 - Safe House\t=> This is the safe house, there is no monster here.");
			System.out.println("2 - Tool Store\t=> You can buy armors and weapons here.");
			System.out.println("3 - Cave\t=> Be careful, there are zombies living here! Reward: Food");
			System.out.println("4 - Forest\t=> Be careful, there are vampires living here! Reward: Firewood");
			System.out.println("5 - River\t=> Be careful, there are bears living here! Reward: Water");
			System.out.println("6 - Mine\t=> Be careful, there are snakes living here! Reward: Random item/gold");
			System.out.println("7 - Inventory\t=> To see and equip items");
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
				if(!player.getInventory().checkItemExists("Food")) {
					location = new Cave(player);
					break;
				}
				else {
					System.out.println("You cleaned up the Cave, discover other locations!");
					continue;
				}
			case 4:
				if(!player.getInventory().checkItemExists("Firewood")) {
					location = new Forest(player);
					break;
				}
				else {
					System.out.println("You cleaned up the Forest, discover other locations!");
					continue;
				}
			case 5:
				if(!player.getInventory().checkItemExists("Water")) {
					location = new River(player);
					break;
				}
				else {
					System.out.println("You cleaned up the River, discover other locations!");
					continue;
				}
			case 6:
				// If player cannot enter mine if he has max 200 gold or his inventory is full.
				if(!player.getInventory().isInventoryFull() || player.getGold() > 200) { 
					location = new Mine(player);
					break;
				}
				else {
					System.out.println("You cleaned up the Mine, discover other locations!");
					continue;
				}
			case 7:
				while(true) {
					player.getInventory().printInventory();
					if(player.getInventory().getItemList()[0] != null) {
						System.out.println("Please choose item to equip or press 0 to go back!");
						int choice = input.nextInt();
						if(choice > 0 && choice < 10) {
							if(player.getInventory().getItemList()[choice-1] == null) {
								System.out.println("You have no item in that spot! Please choose items that are in your bag.");
							}
							else if(!((player.getInventory().getItemList()[choice-1] instanceof Weapon) || player.getInventory().getItemList()[choice-1] instanceof Armor)) {
								System.out.println("You cannot equip this item!");
							}
							else {
								System.out.println("You are using " + player.getInventory().getItemList()[choice-1].getName() + " now!");
								player.getInventory().equipItem(player.getInventory().getItemList()[choice-1]);
							}
						}
						else if(choice == 0) {
							break;
						}
						else {
							System.out.println("!!! Invalid input, try again !!!");
						}
					}
					else {
						System.out.println("You have no item to equip!");
						break;
					}
				}
				continue;
			default:
				System.out.println("Please enter a valid location!");
				continue;
			}	
			if(location == null) {
				System.out.println("You give up very quick!");
				break;
			}
			
			if(!location.onLocation()) {
				System.out.println("GAME OVER!");
				break;
			}
			
			if(player.checkWin()) {
				System.out.println("#########################");
				System.out.println("  C O N G R A T S ! ");
				System.out.println("\tYou win!");
				System.out.println("\tCredits:");
				System.out.println("Hakan ADALI - Patika.dev");
				System.out.println("#########################");
				break;
			}
		}
	}
}

