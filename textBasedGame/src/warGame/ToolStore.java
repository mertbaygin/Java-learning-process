package warGame;


public class ToolStore extends NormalLoc {

	
	public ToolStore(Player player) {
		super(2,player,"GameStore");
	
	}
	
	
	@Override
	public boolean onLocation() {
	
		System.out.println("Welcome to GameStore, You can buy weapon or armor ");
		System.out.println();
		boolean showMenu = true;
		while(showMenu) {
			System.out.println("1  - Weapons");
			System.out.println("2  - Armors");
			System.out.println("3  - Exit");
			System.out.print("Please, Selection:");
			int selectCase = Location.input.nextInt();
			while(selectCase < 1 || selectCase > 3) {
				System.out.print("Invalid value, re-enter your value:");
				selectCase = Location.input.nextInt();
			}
			switch(selectCase) {
			case 1:
					displayWeapon();
					buyWeapon();
				break;
			case 2:
					displayArmor();
					buyArmor();
				break;
			case 3:
				System.out.println("We'd like to see you anytime/again");
				showMenu = false;
			}
			
		}
		return true;

	}
	
	public void displayWeapon() {
		System.out.println("----- Weapons -----");
		System.out.println();
		for (Weapon w: Weapon.weapons()) {
			
			System.out.println(w.getId() + "-" +  w.getName() + " <Price: " + w.getPrice() + " ,Damage: " + w.getDamege() + ">" );
			
		}
		System.out.println("0 - Exit");
		
		
	}
	public void buyWeapon() {
		
		System.out.print("Please, select a weapon:");
		int selectWeaponID = Location.input.nextInt();
		while(selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
			System.out.print("Invalid value, re-enter your value:");
			selectWeaponID = Location.input.nextInt();
		}
		
		if(selectWeaponID != 0) {
			
			Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
			
			if(selectedWeapon != null) {
				if(selectedWeapon.getPrice() >this.getPlayer().getMoney()) {
					System.out.println("You don't have enought money");
				}
				else
				{
					System.out.println("You bought, " +selectedWeapon.getName());
					int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Your balance :"+ this.getPlayer().getMoney());
					System.out.println("Your previous weapon:"+ this.getPlayer().getInventory().getWeapon().getName());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
					System.out.println("Your curretly weapon:" + selectedWeapon.getName());
					
				}
				
			}
			
		}
		
		
		
		
	}
	
	public void displayArmor() {
		System.out.println("----- Armors -----");
		System.out.println();
		for (Armor w: Armor.armors()) {
			
			System.out.println(w.getId() + "-" +  w.getName() + " <Price: " + w.getPrice() + " ,Blocking: " + w.getAvoid() + ">" );
			
		}
		System.out.println("0 - Exit");
		
		
	}
	
	public void buyArmor() {
		System.out.print("Please, select a armor:");
		System.out.println();
		int selectArmorID = Location.input.nextInt();
		while(selectArmorID < 0 || selectArmorID > Armor.armors().length) {
			System.out.print("Invalid value, re-enter your value:");
			selectArmorID = Location.input.nextInt();
		}
		
		if (selectArmorID != 0) {
			Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
			
			if(selectedArmor != null) {
				if(selectedArmor.getPrice() >this.getPlayer().getMoney()) {
					System.out.println("You don't have enought money");
				}
				else
				{
					System.out.println("You bought the " + selectedArmor.getName());
					int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Your balance :"+ this.getPlayer().getMoney());
					System.out.println("Your previous armor: "+ this.getPlayer().getInventory().getArmor().getName());
					this.getPlayer().getInventory().setArmor(selectedArmor);
					System.out.println("Your curretly armor: " + selectedArmor.getName());
					
				}
				
			}
			
			
			
			
		}
		
	}

}
