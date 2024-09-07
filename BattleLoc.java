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
		System.out.println("< A > : Attack | < R > : Run away");
		String selection = input.nextLine();
		selection = selection.toUpperCase();
		if(selection.equals("A")) {
			System.out.println("attack");
			// attack operations
		}
		else if(selection.equals("R")) {
			System.out.println("run away");
			return true;
			// escape operations
		}
		return false;
	}

	public int randomMonsterNumber() {
		Random r = new Random();
		return r.nextInt(this.getMaxMonster()) + 1;
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
