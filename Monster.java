
public class Monster {
	
	private int id;
	private String name;
	private int damage;
	private int hp;
	
	public Monster(int id, String name, int damage, int hp) {
		this.id = id;
		this.setName(name);
		this.damage = damage;
		this.hp = hp;
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
}
