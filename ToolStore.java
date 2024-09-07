
public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Tool Store");
	}

	@Override
	public boolean onLocation() {
		System.out.println("Welcome to the Tool Store!");
		boolean showMenu = true;
		while(showMenu) {
			System.out.println("1 - Weapons");
			System.out.println("2 - Armors");
			System.out.println("3 - Exit");
			int selection = input.nextInt();
			while(selection < 1 || selection > 5) {
				System.out.println("!!! Invalid input, please try again !!!");
				selection = input.nextInt();
			}
			switch (selection) {
			case 1: 
				printWeapon();
				buyWeapon();
				break;
			case 2: 
				printArmor();
				buyArmor();
				break;
			case 3: 
				System.out.println("Goodbye!");
				showMenu = false;
				break;		
			}
			
		}
		return true;
	}

	public void printArmor() {
		System.out.println("#### Armor ####");
		for(Armor armor : Armor.armors()) {
			System.out.println(armor.getId() + "\s-\s" + armor.getName() + 
							"\s\t< Price: " + armor.getPrice() + 
							"\s|\sBlock: " + armor.getBlock() + " >" );
		}
		System.out.println("0 - Return previous menu");
	}
	
	public void buyArmor() {
		System.out.println("---- Please choose an armor to buy! ----");
		int selection = input.nextInt();
		while(selection < 0 || selection > Armor.armors().length) {
			System.out.println("!!! Invalid input, please try again !!!");
			selection = input.nextInt();
		}
		if(selection != 0) {
			Armor selectedArmor= Armor.getArmorByID(selection);
			if(selectedArmor != null) {
				if(selectedArmor.getPrice() > this.getPlayer().getGold()) {
					System.out.println("You don't have enough gold!");
				}
				else {
					System.out.println("You bought the " + selectedArmor.getName());
					int balance = this.getPlayer().getGold() - selectedArmor.getPrice();
					this.getPlayer().setGold(balance);
					System.out.println("Your remaining gold: " + this.getPlayer().getGold());
					this.getPlayer().getInventory().setArmor(selectedArmor);
					System.out.println("Your new armor: " + this.getPlayer().getInventory().getArmor().getName());
				}
			}
		}
	}
	

	public void printWeapon() {
		System.out.println("#### Weapons ####");
		for(Weapon weapon : Weapon.weapons()) {
			System.out.println(weapon.getId() + "\s-\s" + weapon.getName() + 
							"\s\t< Price: " + weapon.getPrice() + 
							"\s|\sDamage: " + weapon.getDamage() + " >" );
		}
		System.out.println("0 - Return previous menu");
	}
	
	public void buyWeapon() {
		System.out.println("---- Please choose a weapon to buy! ----");
		int selection = input.nextInt();
		while(selection < 0 || selection > Weapon.weapons().length) {
			System.out.println("!!! Invalid input, please try again !!!");
			selection = input.nextInt();
		}
		if (selection != 0) {
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
}
