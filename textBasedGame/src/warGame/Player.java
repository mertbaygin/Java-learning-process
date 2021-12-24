package warGame;

import java.util.Scanner;
public class Player {
	
	private int damage;
	private int health;
	private int money;
	private int orijinalHealth;
	private String name;
	private String characterName;
	private Inventory inventory;
	private Scanner input = new Scanner(System.in);
	
	
	public Player(String name) {
		
		this.name = name;
		this.inventory = new Inventory();
	}	
	
	public void selectChar() {
		
		Character[] charList = {new Warrior(), new Ninja(),new Sura()};
		
		System.out.println("-----------------------------------");
		for(Character gameChar: charList) {
			System.out.println("Character " +gameChar.getId() + ":" + 
					"\tName:" + gameChar.getName() + 
					"\t Damage:" + gameChar.getDamage()+ 
					"\t Healht:" + gameChar.getHealth()+
					"\t Money:" + gameChar.getMoney());

			
		}
		System.out.println("-----------------------------------");
		System.out.print("Please, Enter a Character:");
		int selectedId = input.nextInt();
		
		switch(selectedId) {
		case 1:
			initPlayer(new Warrior());
			break;
		case 2:
			initPlayer(new Ninja());
			break;
			
		case 3:
			initPlayer(new Sura());
			break;
			
		default:
			initPlayer(new Warrior());
					
		}
		/*System.out.println("Selected character : " + this.getCharacterName() +
				", Damage:" + this.getDamage() +
				", Health:"+ this.getHealt() +
				", Money:"+ this.getMoney());
		
		*/
	}

	
	
	public void initPlayer(Character character) {
		this.setDamage(character.getDamage());
		this.setHealth(character.getHealth());
		this.setOrijinalHealth(character.getHealth());
		this.setMoney(character.getMoney());
		this.setCharacterName(character.getName());
		
	}
	public void printInfo() {
		System.out.println("Weapon:" + this.getInventory().getWeapon().getName() +
				", Armor:" + this.getInventory().getArmor().getName() +
				", Bloking:" + this.getInventory().getArmor().getAvoid() + 
				", Damage:" + this.getTotalDamage() +
				", Health:"+ this.getHealth() +
				", Money:"+ this.getMoney());
		
		
	}
	public int getTotalDamage() {
		
		return damage + this.getInventory().getWeapon().getDamege();
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		if(health < 0)
			health = 0;
		this.health = health;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCharacterName() {
		return characterName;
	}
	
	public void setCharacterName(String characterName) {
		
		this.characterName = characterName;
	}
	
	public Scanner getInput() {
		return input;
	}
	
	public void setInput(Scanner input) {
		this.input = input;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Weapon getWeapon() {
		
		return this.getInventory().getWeapon();
	}

	public int getOrijinalHealth() {
		return orijinalHealth;
	}

	public void setOrijinalHealth(int orijinalHealth) {
		this.orijinalHealth = orijinalHealth;
	}
	
	

}
