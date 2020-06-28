 
// This will handle the 2d array of art types for us. 
public class Map{

  	public static boolean DEBUG_MODE = false;


  	private char[][] currentMap; // encoded as char

  	// Added later to allow the hero to be stored in the map. 
  	private int heroRow = 0;
  	private int heroCol = 0;

  	

  	// Create a new blank map with all fields set to '.'
  	public Map(int rows, int cols){
  		currentMap = new char[rows][cols];

  		for(int r = 0; r < rows; r++){
  			for(int c =0 ; c < cols; c++){
  				currentMap[r][c] = '.';
  			}
  		}
  	}

  	// Generate the map based on the template
  	public Map(char[][] mapTemplate){
		currentMap = mapTemplate;

	}

		
  // Set every tile on the edge of the map (top/bottom and sides) to = 'X'
	
	public void addWalls(){
		for(int r = 0; r < currentMap.length; r++){
			currentMap[r][0] = 'X';
			currentMap[r][currentMap[r].length-1] = 'X';
		}
		for(int c = 1; c < currentMap[0].length-1; c++){
			currentMap[0][c] = 'X';
			currentMap[currentMap.length-1][c] = 'X';
		}
	}

	//checks if entry is null or not and checks if rows and columns are valid returns true otherwise returns false with output message. 
	public boolean setTile(int row, int col, char value){
		if(currentMap == null){
			System.out.println("Warning, no map was found (map is null)");
			return false;
		}

		if( row < 0 || row >= currentMap.length || col < 0 || col >= currentMap[0].length){
			System.out.println("Invalid row or column given: [" + row +"," + col + "] map is " + currentMap.length + "x" + currentMap[0].length);
			return false;
		}

		currentMap[row][col] = value;

		return true;
	}

  
	//Prints out the 2d array as Chars
	public String toString(){
		String retStr = "";
		for(int row = 0; row <currentMap.length; row++ ){
			for(int col = 0; col < currentMap[row].length; col++){

				if( heroRow == row && heroCol == col){
					retStr += 'H';
				}else{
					retStr += currentMap[row][col];
				}
		
			}
			retStr += '\n';
		}
		return retStr;
	}


	
	// Updates the Map variables keeping track of the hero pos
	public void initHeroLocation(){
		for(int i = 0; i < currentMap.length; i++ ){
			for(int j = 0; j < currentMap[i].length;j++){
				if(currentMap[i][j] == 'H'){
					// set the hero position
					heroRow = i;
					heroCol = j;
					return; // quit the loop. This is sort of hacky technique. 
				}
			}
		}
	}

	// Movement
	// Accept the map reference and a direction.
	// 0 = up, 1 = right, 2 = down, 3 = left 
	// return the char of the tile we moved onto 
	//z(if it is valid it should be a number)	
	public char processInput(int direction){
		
		int newMoveRow = heroRow;
		int newMoveCol = heroCol;
		// Move up if we can. 
		if(direction == 0){
			newMoveRow--;
		}else if(direction == 1){
			newMoveCol++;
		}else if(direction == 2){
			newMoveRow++;
		}else if(direction == 3){
			newMoveCol--;
		}

		char code = '.';

		if( isValidMove(newMoveRow, newMoveCol) ){
			code = applyMove(heroRow, heroCol, newMoveRow, newMoveCol);
		}

		return code;

	}

	// checks if the tile has anything on it. In this case it is open if it is not 'X'
	private boolean isValidMove(int row, int col){
		if(currentMap[row][col] != 'X'){
			return true;			
		}else{
			return false;
		}
	}


	// Applies the hero move, updates the row and col of the Hero. 
	// returns the char that is at the target position (moved onto)
	// This is useful for identifying when we move onto an Encounter. 
	private char applyMove(int startRow, int startCol, int endRow, int endCol){
		// move H from startRow/startCol to endRow/endCol
		char returnVal = currentMap[endRow][endCol];

		currentMap[startRow][startCol] = '.';
		currentMap[endRow][endCol] = 'H';

		

		return returnVal;
	}



	
