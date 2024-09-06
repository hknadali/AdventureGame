
public abstract class GameChar {
	
	private int id;
	private String name;
	private int damage;
	private int hp;
	private int gold;
	
	public GameChar(int id, String name, int damage, int hp, int gold) {
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.hp = hp;
		this.gold = gold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
}
