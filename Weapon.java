
public class Weapon extends Item {
	
	private int damage;
	private int price;
	
	public Weapon(int id, String name, int damage, int price) {
		super(id, name);
		this.damage = damage;
		this.price = price;
	}
	
	public static Weapon[] weapons() {
		Weapon[] weaponList = new Weapon[3];
		weaponList[0] = new Weapon(1, "Sword", 2, 25);
		weaponList[1] = new Weapon(2, "Pistol", 5, 35);
		weaponList[2] = new Weapon(3, "Rifle", 7, 45);
		return weaponList;
	}
	
	public static Weapon getWeaponByID(int id) {
		for(Weapon w : Weapon.weapons()) {
			if(w.getId() == id)
				return w;
		}
		return null;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
