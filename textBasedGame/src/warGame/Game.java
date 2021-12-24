package warGame;

import java.util.Scanner;

public class Game {
	
	private Scanner input = new Scanner(System.in);
	
	public void start() {
		
		
		
		System.out.println("Welcome to Adwanture Game!");
		Player player = new Player("Lord");
		System.out.println(player.getName() + " welcome to game. Please, select a character !");
		player.selectChar();
		
		
		Location location = null;
		while(true) {
			player.printInfo();
			NormalLoc[] locList = {new SafeHouse(player),new ToolStore(player)};
			System.out.println();
			System.out.println("------------------ Locations -----------------");
			for(NormalLoc list : locList ) {
				System.out.println("Locations:" + list.getLocID() + "\tLocation Name:" + list.getName());		
			}
			
			BattleLoc[] battleLocList = {new Cave(player),new Forest(player),new River(player),new Pit(player)};
			System.out.println();
			System.out.println("------------------ Battle Locations -----------------");
			for(BattleLoc bList: battleLocList) {
				
				System.out.println("Locations:" + bList.getLocId() + "\tLocation Name:" + bList.getName() + "\tAward:" + bList.getAward());
			}
			
			
			System.out.println("Exit: 0 -->     GAME OVER.");
			System.out.println("-----------------------------------");
			System.out.print("Please, Select the location, you want to go to:");
			
			int selectionLoc = input.nextInt();
			
			switch(selectionLoc){
			
				case 0:
					location = null;
					break;
				
				case 1:
					if(awardState(player)){
						location = null;
						break;
					}
					else
					{					
						location = new SafeHouse(player);
						break;
					}
					
				case 2:
					location = new ToolStore(player);
					break;
				case 3:
					if(player.getInventory().getAward().contains("Food")) {
						System.out.println("Can not re-enter, All obstacles are dead");
						location = new SafeHouse(player);
						break;
					}
					else
					{
						location = new Cave(player);
						break;
					}
				case 4:
					if(player.getInventory().getAward().contains("FireWood")) {
						System.out.println("Can not re-enter, All obstacles are dead");
						location = new SafeHouse(player);
						break;
					}
					else {
						location = new Forest(player);
						break;
					}

				case 5:
					if(player.getInventory().getAward().contains("Water")) {
						System.out.println("Can not re-enter, All obstacles are dead");
						location = new SafeHouse(player);
						break;
					}
					else
					{
						location = new River(player);
						break;
					}
				case 6:
					location = new Pit(player);
					break;
				default:
					if(awardState(player)){
						location = null;
						break;
					}
					else
					{					
						location = new SafeHouse(player);
					}
			}
			
			if(location == null){
				System.out.println("We'd like to see you anytime/again");
				break;
			}

			//System.out.println(location.getName());
			if (!location.onLocation() ) {
				System.out.println("GAME OVER!");
				break;
				
			}
		}
	}
	public boolean awardState(Player player) {
		Boolean food = player.getInventory().getAward().contains("Food");
		Boolean firewood = player.getInventory().getAward().contains("FireWood");
		Boolean water = player.getInventory().getAward().contains("Water");
		
		if(food && firewood && water) 
			return true;
		else
			return false;
	}
	
}
