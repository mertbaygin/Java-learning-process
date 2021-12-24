package warGame;

public  class SafeHouse extends NormalLoc {
	
	

	public SafeHouse(Player player) {
		super(1,player, "Safe House");
		
		
		
	}
	
	@Override
	public boolean onLocation() {
		
		System.out.println("You are in the safe location, there are no enemies here!");
		System.out.println("Your health is renewed");
		this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
		return true;
	}

}
