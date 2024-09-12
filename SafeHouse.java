
public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "Safe House");
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("You are in the Safe House!");
		System.out.println("Your HP has been restored.");
		this.getPlayer().setHp(this.getPlayer().getDefHp());
		return true;
	}
}
