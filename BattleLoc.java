import java.util.Random;

public abstract class BattleLoc extends Location {

	private Monster monster;
	private String reward;
	private int maxMonster;
	
	public BattleLoc(Player player, String name, Monster monster, String reward, int maxMonster) {
		super(player, name);
		this.monster = monster;
		this.reward = reward;
		this.setMaxMonster(maxMonster);
	}

	@Override
	public boolean onLocation() {
		int mnsNumber = this.randomMonsterNumber();
		System.out.println("You are here: " + this.getName());
		System.out.println("Be careful, you can see " + mnsNumber + " " + this.getMonster().getName() + "(s) here!");
		System.out.println("< A > : Attack | < G > : Go back");
		String selection = input.nextLine();
		selection = selection.toUpperCase();
		if(selection.equals("A") && combat(mnsNumber)) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
			System.out.println("You killed all the monsters!");
			System.out.println("You cleaned up the location, well done!");
			System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
			locationReward();
			return true;
		}
		if(this.getPlayer().getHp() <= 0) {
			System.out.println("You are dead!");
			return false;
		}
		return true;
	}
	
	public boolean combat(int mnsNumber) {
		for(int i = 1; i <= mnsNumber; i++) {
			this.getMonster().setHp(this.getMonster().getDefHp());
			if(this.getMonster().getName().equals("Snake")) {
				this.getMonster().setDamage((int)(Math.random()*(3 + 1)) + 3);
			}
			playerStats();
			monsterStats(i);
			int hitFirst = ((int)(Math.random() * 2 + 1)); // 1 = player hits first, 2 = monster hits first
			while(this.getPlayer().getHp() > 0 && this.getMonster().getHp() > 0) {
				String selection = "";
				if(hitFirst == 2) {
					System.out.println("< H > : Hit | < R > : Run away");
					selection = input.nextLine().toUpperCase();
					if(selection.equals("H")) {
						playerHit();
						afterHit();
						if(this.getMonster().getHp() > 0) {
							monsterHit();
							afterHit();
						}
					}
					else {
						return false;
					}
				}
				else {
					monsterHit();
					if(this.getPlayer().getHp() <= 0)
						return false;
					afterHit();
					System.out.println("< H > : Hit | < R > : Run away");
					selection = input.nextLine().toUpperCase();
					if(selection.equals("H")) {
						playerHit();
						afterHit();
					}
					else {
						return false;
					}
				}
			}
			if(this.getMonster().getHp() <= 0 && this.getPlayer().getHp() > 0) {
				System.out.println();
				System.out.println("You beat the monster!");
				System.out.println("You earned " + this.getMonster().getReward() + " golds!");
				this.getPlayer().setGold(this.getPlayer().getGold() + this.getMonster().getReward());
				System.out.println("Current gold:\t" + this.getPlayer().getGold());
				System.out.println();
			}
			else {
				return false;
			}		
		}
		return true;
	}

	
	public void locationReward() {
        switch (this.getName()) {
            case "Cave":
                this.getPlayer().getInventory().insertItem(new Item(7, this.reward));
                break;
            case "Forest":
                this.getPlayer().getInventory().insertItem(new Item(8, this.reward));
                break;
            case "River":
                this.getPlayer().getInventory().insertItem(new Item(9, this.reward));
                break;
            case "Mine":
                dropRandomMineReward();;
                break;
        }
    }
	
	public void playerStats() {
		System.out.println("#### " + this.getPlayer().getName() + "'s Stats ####");
		System.out.println("HP:\t" + this.getPlayer().getHp());
		System.out.println("Damage:\t" + this.getPlayer().getDamage());
		System.out.println("Armor:\t" + this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Block:\t" + this.getPlayer().getInventory().getArmor().getBlock());
		System.out.println("Weapon:\t" + this.getPlayer().getInventory().getWeapon().getName());
		System.out.println("---------------------------");
	}
	
	public void monsterStats(int i) {
		System.out.println("#### " + i + "." + this.getMonster().getName() + " Stats ####");
		System.out.println("HP:\t" + this.getMonster().getHp());
		System.out.println("Damage:\t" + this.getMonster().getDamage());
		System.out.println("---------------------------");
	}
	
	public void playerHit() {
		System.out.println();
		System.out.println("You hit the monster!");
		this.getMonster().setHp(this.monster.getHp() - this.getPlayer().getDamage());
	}
	
	public void monsterHit() {
		System.out.println();
		System.out.println("Monster hit you!");
		int mnsDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
		if(mnsDamage < 0) {
			mnsDamage = 0;
		}
		this.getPlayer().setHp(this.getPlayer().getHp() - mnsDamage);
	}
	
	public void afterHit() {
		System.out.println("<o><o><o><o><o><o><o><o>");
		System.out.println("Your HP:\t" + this.getPlayer().getHp());
		System.out.println(this.getMonster().getName() + "'s HP:\t" + this.getMonster().getHp());
		System.out.println("<o><o><o><o><o><o><o><o>");
	}

	public int randomMonsterNumber() {
		Random r = new Random();
		return r.nextInt(this.getMaxMonster()) + 1;
	}
	
	public void dropRandomMineReward() {
		double dropRate = Math.random()*(101);
		if(dropRate <= 30 && !this.getPlayer().getInventory().isInventoryFull()) {
			if(dropRate <= 15 && dropRate > 0) {		// Weapon dropRate is %15 => %50 Sword - %30 Pistol - %20 Rifle
				if(dropRate <= 7.5)
					takeItem(new Weapon(1, "Sword", 2, 25));
				else if(dropRate > 7.5 && dropRate <=11.7) {
					takeItem(new Weapon(2, "Pistol", 5, 35));
				}
				else {
					takeItem(new Weapon(3, "Rifle", 7, 45));
				}
			}
			else if(dropRate > 15 && dropRate <= 30) {	// Armor dropRate is %15 => %50 Light - %30 Medium - %20 Heavy
				if(dropRate <= 22.5)
					takeItem(new Armor(1, "Light", 1, 15));
				else if(dropRate > 22.5 && dropRate <=26.7) {
					takeItem(new Armor(2, "Medium", 3, 25));
				}
				else {
					takeItem(new Armor(3, "Heavy", 5, 35));
				}
			}
		}
		else if(dropRate > 30 && dropRate <=55) {		// Gold dropRate is %25 => %50 1 Gold - %30 5 Gold - %20 10 Gold
			if(dropRate <= 42.5)
				this.getPlayer().setGold(this.getPlayer().getGold() + 1);
			else if(dropRate > 42.5 && dropRate <= 49.7) {
				this.getPlayer().setGold(this.getPlayer().getGold() + 5);
			}
			else {
				this.getPlayer().setGold(this.getPlayer().getGold() + 10);
			}
		}
		else {	// The dropRate of getting nothing is %45
			System.out.println("Bad luck :( You earn nothing this time. Next time, fight harder!");;
		}
	}
	
	public boolean takeItem(Item item) {
		this.getPlayer().getInventory().printInventory();
		System.out.println("Do you want to take the item dropped ?\t< Y >: Yes\t< N >: No");
		System.out.println("Item:\t" + item.getName());
		String selection = input.nextLine().toUpperCase();
		while(true) {
			switch(selection) {
			case "Y":
				this.getPlayer().getInventory().insertItem(item);
				return true;
			case "N":
				return false;
			default:
				System.out.println("!!! Invalid input, try again !!!");
				continue;
			}
		}
	}
	
	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public int getMaxMonster() {
		return maxMonster;
	}

	public void setMaxMonster(int maxMonster) {
		this.maxMonster = maxMonster;
	}
}
