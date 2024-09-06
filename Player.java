import java.util.Scanner;

public class Player {
	private int damage;
	private int hp; //health point
	private int gold;
	private String name;
	private String charName;
	private Scanner input = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
	}
	
	public void selectChar() {
		GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
		System.out.println("Characters:");
		for(GameChar gc : charList) {
			System.out.println("ID: " + gc.getId() +
					"\t" + gc.getName() +
					"\t Damage: " + gc.getDamage() +
					"\t HP: " + gc.getHp() +
					"\t Gold: " + gc.getGold());
		}
		System.out.println("---- Please choose your character! ----");
		int selection = input.nextInt();
		switch (selection) {
		case 1: {
			initPlayer(new Samurai());
			break;
		}
		case 2: {
			initPlayer(new Archer());
			break;
		}
		case 3: {
			initPlayer(new Knight());
			break;
		}
		default:
			initPlayer(new Samurai());
		}
		System.out.println("Your character: " + this.getCharName());
	}

	private void initPlayer(GameChar gameChar) {
		this.setDamage(gameChar.getDamage());
		this.setHp(gameChar.getHp());
		this.setGold(gameChar.getGold());
		this.setCharName(gameChar.getName());
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}
}
