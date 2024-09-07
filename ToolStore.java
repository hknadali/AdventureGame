
public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Tool Store");
	}

	@Override
	public boolean onLocation() {
		System.out.println("Welcome to the Tool Store!");
		System.out.println("1 - Weapons");
		System.out.println("2 - Armors");
		System.out.println("3 - Exit");
		int selection = input.nextInt();
		while(selection < 1 || selection > 5) {
			System.out.println("!!! Invalid input, please try again !!!");
			selection = input.nextInt();
		}
		switch (selection) {
		case 1: {
			printWeapon();
			buyWeapon();
			break;
		}
		case 2: {
			printArmor();
			break;
		}
		case 3: {
			System.out.println("Goodbye!");
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + selection);
		}
		return true;
	}

	public void printArmor() {
		
	}

	public void printWeapon() {
		System.out.println("---- Weapons ----");
		for(Weapon weapon : Weapon.weapons()) {
			System.out.println(weapon.getId() + "\s-\s" + weapon.getName() + 
							"\s\t< Price: " + weapon.getPrice() + 
							"\s|\sDamage: " + weapon.getDamage() + " >" );
		}
	}
	
	public void buyWeapon() {
		System.out.println("---- Please choose a weapon to buy! ----");
		int selection = input.nextInt();
		while(selection < 1 || selection > Weapon.weapons().length) {
			System.out.println("!!! Invalid input, please try again !!!");
			selection = input.nextInt();
		}
		Weapon selectedWeapon = Weapon.getWeaponByID(selection);
		if(selectedWeapon != null) {
			if(selectedWeapon.getPrice() > this.getPlayer().getGold()) {
				System.out.println("You don't have enough gold!");
			}
			else {
				System.out.println("You bought the " + selectedWeapon.getName());
				int balance = this.getPlayer().getGold() - selectedWeapon.getPrice();
				this.getPlayer().setGold(balance);
				System.out.println("Your remaining gold: " + this.getPlayer().getGold());
				this.getPlayer().getInventory().setWeapon(selectedWeapon);
				System.out.println("Your new weapon: " + this.getPlayer().getInventory().getWeapon().getName());
			}
		}
	}
}
