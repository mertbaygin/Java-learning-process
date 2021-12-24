package warGame;

public abstract class NormalLoc extends Location {
	
	private int locId;


	public NormalLoc(int locId,Player player,String name) {
		super(player,name);
		this.locId = locId;

		
	}

	@Override
	public boolean onLocation() {

		return true;
	}
	
	public int getLocID() {
		return this.locId;
	}
	public void setLocID(int locId) {
		
		this.locId = locId;
	}
	

}
