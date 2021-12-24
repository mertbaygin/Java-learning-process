package warGame;
import java.util.ArrayList;
public class Inventory  {
	
	private Weapon weapon;
	private Armor armor;
	private ArrayList<String> award = new ArrayList<String>();
	
	public Inventory() {
		super();
		this.weapon = new Weapon("Punch",0,0,0);
		this.armor = new Armor(0,"Null",0,0);
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




	public ArrayList<String> getAward() {
		return award;
	}


	public void setAward(ArrayList<String> award) {
		this.award = award;
	}


	public void addAward(String award) {
		this.award.add(award);
		
	}
	

}
