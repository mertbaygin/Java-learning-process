package warGame;

import java.util.*;
import java.util.Scanner;


public abstract class BattleLoc extends Location{
	private Obstacle obstacle;
	private String award;
	private int locId;
	private int maxObstacle;
	private Scanner scan = new Scanner(System.in); 
	

	public BattleLoc(int locId,Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
		super(player, name);
		this.obstacle= obstacle;
		this.award = award;
		this.locId = locId;
		this.maxObstacle = maxObstacle;
		
		
	}

	@Override
	public boolean onLocation() {
		int obsNumber = this.randomObtacleNumber();
		System.out.println();
		System.out.println("You are in the "+ this.getName()+ ", now");
		if (obsNumber == 1)
			System.out.println(obsNumber + " " + this.getObstacle().getName() +" lives here. Be careful!");
		else
			System.out.println(obsNumber + " " + this.getObstacle().getName() + "s" + " lives here. Be careful!");
		
		System.out.print("<W>ar or <E>scape :");
		String selectCase = scan.nextLine();
		selectCase = selectCase.toUpperCase();

		if(selectCase.equals("W")) {
			if(combat(obsNumber)){
				System.out.println("in "+this.getName() + " All obstacle are dead !");
				this.getPlayer().getInventory().addAward(this.award);
				return true;
				
			}
		}
		if(this.getPlayer().getHealth() <= 0 ) {
			System.out.println("You are dead !");
			return false;
		}
		return true;
	}
	
	public boolean combat(int obsNumber) {
		
		for(int i = 1; i<=obsNumber; i++) {
			boolean tOrF = whoFirstHit();
			this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());
			playerStats();
			obstacleStats(i);
			while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
				System.out.print("<H>it or <E>scape :");
				System.out.println();
				String selectCombat = scan.nextLine().toUpperCase();
				if(selectCombat.equals("H")) {
					System.out.println();
					
					if(tOrF) {
						
						firstYou();
						if(this.getObstacle().getHealth() > 0) {
							firstObstacle();
							if(this.getPlayer().getHealth() <=0)
								return false;			
						}
						
						
					}
					else
					{
						firstObstacle();
						if(this.getPlayer().getHealth() > 0) {
							firstYou();
						}
						else
							return false;
						
					}
			}
				
			else {
				return false;
			}
			
		}
			if(this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
				System.out.println("You Win!");
				if(this.getObstacle().getName() == "Snake") {
					snakeAward();
				}
				else
				{
				System.out.println( "Award balance:" + this.getObstacle().getAward());
				int addAward = this.getPlayer().getMoney() + this.getObstacle().getAward();
				this.getPlayer().setMoney(addAward);
				System.out.println("Current money:" + this.getPlayer().getMoney());
				}
				
			}
		
	}
		return true;
}
	public void afterHit() {
		System.out.println("Your Health :" + this.getPlayer().getHealth());
		System.out.println(this.getObstacle().getName() + " health:" + this.getObstacle().getHealth());
		System.out.println("----------");
		
	}
	
	public void playerStats() {
		System.out.println();
		System.out.println("Character values");
		System.out.println("-----------------");
		System.out.println("Health:" +this.getPlayer().getHealth());
		System.out.println("Weapon:" + this.getPlayer().getWeapon().getName());
		System.out.println("Armor:"+ this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Blocking:"+ this.getPlayer().getInventory().getArmor().getAvoid());
		System.out.println("Damage:" +this.getPlayer().getTotalDamage());
		System.out.println("Money:" +this.getPlayer().getMoney());
		System.out.println();
	}
	public void obstacleStats(int obstacleNumber) {
		
		System.out.println(obstacleNumber +"."+ this.getObstacle().getName() + " Values");
		System.out.println("-----------------");
		System.out.println("Health:" +this.getObstacle().getHealth());
		System.out.println("Damage:" +this.getObstacle().getDamage());
		System.out.println("Award:" +this.getObstacle().getAward());
	}
	
	
	public void firstObstacle() {
		
		System.out.println("The obstacle hit you !");;
		int obstacleDamage = this.obstacle.getDamage() - this.getPlayer().getInventory().getArmor().getAvoid();
		if(obstacleDamage < 0){
			obstacleDamage = 0;
		}
		this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
		afterHit();
	}
	public void firstYou() {
		
		System.out.println("You hit!");
		this.getObstacle().setHealth(obstacle.getHealth() - this.getPlayer().getTotalDamage());
		afterHit();
		
		
	}
	
	public int randomObtacleNumber() {
		
		Random r = new Random();
		return r.nextInt(this.getMaxObstacle()) + 1;
		
	}
	public  boolean whoFirstHit() {
		Random r = new Random();
		return r.nextBoolean();
	}
	
	public void snakeAward() {
		
		// chance of getting a weapon %15  ""     "4"
			// Gun  %20
			// Sword %30
			// Pistol %50
 		// chance of getting a armor %15;         "3"  
 			// Light Armor %20
			// Medium Armor %30
			// Heavy Armor %50
		// chance of getting a money %25          "2"    
			// sum 10   %20
			// sum 5    %30
			// sum 1    %50
		// nothing %45                            "1"
		int value = whichItem();
		if(value == 1) {
			System.out.println("You didn't win an award");
			}
		
		else if(value == 2) {
			int x = addSum();
			if(x == 0)
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
			else if(x == 1)
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
			else
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
			System.out.println("Extra money added");
		}
		
		else if(value == 3) {
			int x = addSum();
			Armor selectedArmor = Armor.getArmorObjById(x);
			this.getPlayer().getInventory().setArmor(selectedArmor);
			System.out.println("New armor added to your inventory");
		}
		else {
			int x = addSum();
			Weapon selectedWeapon = Weapon.getWeaponObjById(x);
			this.getPlayer().getInventory().setWeapon(selectedWeapon);
			System.out.println("New weapon added to your inventory");
			
		}
	}

	public int oddsRatio() {
		Random r = new Random();
		return r.nextInt(100)+1;
	}
	public int whichItem() {
		int value = oddsRatio();
		if(value >= 55)
			return 1;
		else if(30 < value && value <= 54) 
			return 2;
		else if (16 < value && value <= 29) 
			return 3;
		else
			return 4;
	}
	public int addSum()
	{
		int value = oddsRatio();
		if(value >= 50)
			return 0;
		else if(30 <= value && value >= 49) 
			return 1;
		else
			return 2;
		
	}
	

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public int getMaxObstacle() {
		return maxObstacle;
	}

	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}

	
}
