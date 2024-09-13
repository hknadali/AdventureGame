
public class Inventory {
	
	private Weapon weapon;
	private Armor armor;
	private Item[] itemList;

	public Inventory() {
		this.weapon = new Weapon(0, "Punch", 0, 0);
		this.armor = new Armor(0, "Rag", 0, 0);
		this.itemList = new Item[10]; // Player can carry max 10 items in his bag.
	}
	
	public void printInventory() {
		System.out.println("-------------------------------");
		System.out.println("Armed weapon:\t" + this.getWeapon().getName());
		System.out.println("Armor worn:\t" + this.getArmor().getName());
		for(int i = 0; i < this.itemList.length; i++) {
			if(itemList[i] != null)
				System.out.println("Slot " + (i+1) + ":\t" + itemList[i].getName());
		}
		System.out.println("-------------------------------");
	}
	
	public void insertItem(Item item) {
		if(!isInventoryFull()) {
			for(int i = 0; i < this.itemList.length; i++) {
				if(this.itemList[i] == null) {
					this.itemList[i] = item;
					item.setId(i+1);
					break;
				}
			}
		}
	}
	
	public void removeItem(Item item) {
		this.itemList[item.getId()-1] = null;
	}
	
	public boolean checkItemExists(String itemName) {
		for(Item item : this.itemList) {
			if(item != null && item.getName().equals(itemName))
				return true;
		}
		return false;
	}
	
	public boolean isInventoryFull() {
		if(this.itemList[this.itemList.length - 1] != null) {
			System.out.println("Your bag is full. You cannot have more items!");
			return true;
		}
		return false;
	}
	
	public void equipItem(Item item) {
		if(item instanceof Weapon) {
			Weapon temp = this.getWeapon();
			this.setWeapon((Weapon)item);
			removeItem(item);
			this.insertItem(temp);
		}
		else if(item instanceof Armor) {
			Armor temp = this.getArmor();
			this.setArmor((Armor)item);
			removeItem(item);
			this.insertItem(temp);
		}
		else {
			System.out.println("You cannot equip this item!");
		}
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
	
//	public boolean isFood() {
//		return food;
//	}
//	
//	public void setFood(boolean food) {
//		this.food = food;
//	}
//	
//	public boolean isFirewood() {
//		return firewood;
//	}
//	
//	public void setFirewood(boolean firewood) {
//		this.firewood = firewood;
//	}
//	
//	public boolean isWater() {
//		return water;
//	}
//	
//	public void setWater(boolean water) {
//		this.water = water;
//	}
	
	public Item[] getItemList() {
		return this.itemList;
	}
	
	public void setItemList(Item[] itemList) {
		this.itemList = itemList;
	}
}
