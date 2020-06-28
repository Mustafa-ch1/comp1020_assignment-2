public class Item extends RandomGenerator{
	
	private String itemName;

	public Item(){
		itemName = RandomGenerator.getRandomItemName();
	}

	// An overloaded constructor that accepts a custom item name. 
	// This may be useful in debugging to ensure the ItemList is working as expected.
	public Item(String newName) {
		itemName = newName;
	}

	// returns the itemName. Don’t add additional formatting here.
	public String toString() {
		return itemName;
	}

}
