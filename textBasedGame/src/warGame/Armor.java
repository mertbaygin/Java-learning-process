package warGame;

public class Armor {
	
	private int id;
	private String name;
	private int avoid;
	private int price;
	
	
	
	public Armor(int id, String name, int avoid, int price) {
		super();
		this.id = id;
		this.name = name;
		this.avoid = avoid;
		this.price = price;
	}
	
	public static Armor[] armors() {
	
		Armor[] armorList = new Armor[3];
		
		armorList[0] = new Armor(1,"Light Armor",1,15);
		armorList[1] = new Armor(2,"Medium Armor",3,25);
		armorList[2] = new Armor(3,"Heavy Armor",5,40);
		
		return armorList;
		
	}
	public static Armor getArmorObjById(int id) {

		for(Armor w: Armor.armors()) {
			
			if(w.getId() == id) {
				return w;
			}
		}
		return null;
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



	public int getAvoid() {
		return avoid;
	}



	public void setAvoid(int avoid) {
		this.avoid = avoid;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}
	

	
}
