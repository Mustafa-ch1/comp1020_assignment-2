/*
This class will be our main gameplay loop. 
It will later include a turn counter (turn based) and listen for input from the player. 
Think of simulation type games such as the Sims. This is a very simple version. 
We will increase the complexity later.
*/

public class GameController{

	// Its a party, only simulated. Generate some guests, assign them to mingle, then print them out in the end (including who they talked to). 
	public static void main(String[] args){

		// P3
		// What kind of game? 
		// What is the point? 
		// what are the rules? 
		Hero theHero = new Hero("Dylan", "The Instructor", 0,12);
		theHero.setSkills(3,5,4);

		System.out.println("New Hero Created!");
		System.out.println(theHero.fullToString());

		// P4
		// array of encounters
		Encounter[] events = new Encounter[3];
		events[0] = new Encounter("mental",7,new Item(), 2);
		events[0].setDescriptions("Chess","A chess game."," takes the opponents King.", " loses terribly");

		events[1] = new Encounter("physical",5, new Item(), 3);
		events[1].setDescriptions("Space Jam", "Aliens challenge you to a game of Basketball."," dunks on the aliens to win and save the galaxy.", " don't Quit your day job.");

		events[2] = new Encounter("social",3, new Item(), 3);
		events[2].setDescriptions("A Dinner Party","You have been invited to a fancy dinner party"," tells many funny jokes and people have a good time.", " spills dessert on the hostesses new rug.");


		int i = 0;

		while(i < events.length && theHero.checkStatus()){
			nextEncounter(theHero, events[i]);
			// Debugging
			//System.out.println(theHero.fullToString());

			i++;
		}	

		endGame(theHero);

		
	}

	// True means the player won. Apply the damage or reward within this method as well. 
	private static void nextEncounter(Hero hero, Encounter event){
		System.out.println("--------------------------------------");
		System.out.println(event.getDescription());

		boolean heroPassed = hero.skillCheck(event.getStatToCheck(), event.getDifficulty());
	
		if(heroPassed){

			System.out.println(hero.getName() + event.getWinning());

			// Hero Succeeds
			Item temp = event.removeReward();
			System.out.println(hero.getName() + " found a " + temp.toString() + " in the " + event.getName());
			hero.addItem(temp);
			

		}else{

			System.out.println(hero.getName() + event.getLosing());
			// Hero fails. 
			hero.addStress(event.getRisk());
			System.out.println("Our Hero " + hero.getName() + " gained " + event.getRisk() + " stress from their loss at " + event.getName());

		}

		//return heroPassed;
	}

	private static void endGame(Hero finalHero){
		System.out.println("--------------------------------------");
		if(finalHero.checkStatus()){
			System.out.println(finalHero.getName() + " was successful!");
		}else{
			System.out.println(finalHero.getName() + " passed out from stress!");
		}

		System.out.println(" === Final Output === ");
		System.out.println(finalHero.fullToString());
		System.out.println("Thank you for playing. The End");
	}
	//input is taken from the user and checked which key is pressed.
	public static int Getinput(){
	int VK_UP=38;
	int VK_Right=39;
	int VK_Left=37;
	int VK_Down=40;
	int i=0;
	if(StdDraw.isKeyPressed(VK_UP)){
	i=0;    
	    
	   }
	else if(StdDraw.isKeyPressed(VK_Down)){    
	    i=2;}
	   
	else if(StdDraw.isKeyPressed(VK_Left)){
	    i=3;
	   }
	else if(StdDraw.isKeyPressed(VK_Right)){
	     i=1;
	   }
	   
else { i=-1;}
return i;}













}
