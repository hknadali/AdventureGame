
public class Monster {
	
	private int id;
	private String name;
	private int damage;
	private int hp;
	private int reward;
	private int defHp; // default health point
	
	public Monster(int id, String name, int damage, int hp, int reward) {
		this.id = id;
		this.setName(name);
		this.damage = damage;
		this.hp = hp;
		this.setDefHp(hp);
		this.setReward(reward);
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
		if(hp < 0) {
			hp = 0;
		}
		this.hp = hp;
	}

	public int getDefHp() {
		return defHp;
	}

	public void setDefHp(int defHp) {
		this.defHp = defHp;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}
}
