
public class Inventory {
	
	private Weapon weapon;
	private Armor armor;
	private boolean food;
	private boolean firewood;
	private boolean water;

	public Inventory() {
		this.weapon = new Weapon("Punch", 0, 0, 0);
		this.armor = new Armor(0, "Rag", 0, 0);
	}
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public Armor getArmor() {
		return armor;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	public boolean isFood() {
		return food;
	}
	public void setFood(boolean food) {
		this.food = food;
	}
	public boolean isFirewood() {
		return firewood;
	}
	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}
	public boolean isWater() {
		return water;
	}
	public void setWater(boolean water) {
		this.water = water;
	}
	
}
