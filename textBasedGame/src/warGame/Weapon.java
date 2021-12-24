package warGame;

public class Weapon {
	
	private String name;
	private int id;
	private int damege;
	private int price;
	

	
	public Weapon(String name, int id, int damege, int price) {
		super();
		this.name = name;
		this.id = id;
		this.damege = damege;
		this.price = price;
	}
	
	public static Weapon[] weapons() {
		
		Weapon[] weaponList = new Weapon[3];
		
		weaponList[0]  = new Weapon("Gun",1,2,15);
		weaponList[1]  = new Weapon("Sword",2,3,35);
		weaponList[2]  = new Weapon("Pistol",3,7,45);
		return weaponList;
		
		
		
	}
	public static Weapon getWeaponObjById(int id) {

		for(Weapon w: Weapon.weapons()) {
			
			if(w.getId() == id) {
				return w;
			}
		}
		return null;
	}
	



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDamege() {
		return damege;
	}


	public void setDamege(int damege) {
		this.damege = damege;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	

}
