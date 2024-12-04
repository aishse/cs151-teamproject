package mancala;
import java.util.*;

/**
 * This code represents the model for the Mancala game which maintains the game state, manages player turns,
 * tracks the number of stones in pits, and notifies listeners of state changes.
 * Implements the Model-View-Controller (MVC) design pattern.
 *
 */
public class MancalaModel {
	private int[][] model = new int[2][7];
	private int[][] tempModel = new int[2][7];
	private boolean isPlayerOne = true;
	private boolean gamestart = false;
	private MancalaView view; 
	private int undoCount = 0; 
	
	private final List<MancalaListener> listeners;

	/**
	 * Constructs a MancalaModel with the specified view.
	 * @param view the view to be associated with the model
	 */
	public MancalaModel(MancalaView view) {
		this.listeners = new ArrayList<>();
		this.view = view; 
		
		
	}
/**
 * Adds a Mancala listener
 * @param listener
 */
public void addMancalaListener(MancalaListener listener) {
    listeners.add(listener);
}

/**
 * Removes a Mancala listener
 * @param listener
 */
public void removeMancalaListener(MancalaListener listener) {
    listeners.remove(listener);
}

/**
 * Notifies listeners when the game state changes
 */
public void notifyGameStateChanged() {
    for (MancalaListener listener : listeners) {
        listener.gameStarted(gamestart);
    }
}
/**
 * 
 * @return the model
 */
public int[][] getModel() {
	return model;
}

/**
 * @param model the model to set
 */
public void setModel(int[][] model) {
	this.model = model;
}
/**
 * Starts and stops the mancala game. 
 * @param b
 */
public void setGameState(Boolean b) {
	gamestart = b; 
	notifyGameStateChanged(); 
}

/**
* Starts and stops the mancala game. 
* @param b
*/
public boolean isStarted() {
	return gamestart;  
}


public void setInitialStones(int initial) {
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 7; j++) {
		
			model[i][j] = initial; 
			
		}
	}
	model[1][0] = 0;
	model[0][6] = 0;
	
	view.initializeStonePits(initial); 
	saveModel(); 
}
public void setStones(int initial) {
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 7; j++) {
		
			model[i][j] = initial; 
		}
	}
	model[1][0] = 0;
	model[0][6] = 0;
	saveModel(); 
	//view.initializeStonePits(initial); 
}
/**
 * @return the isPlayerOne
 */
public boolean isPlayerOne() {
	return isPlayerOne;
}
/**
 * @param isPlayerOne the isPlayerOne to set
 */
public void setPlayerOne(boolean isPlayerOne) {
	this.isPlayerOne = isPlayerOne;
}
public void setViewLayout(BoardStyle l) {
	view.setBoardStyle(l); 
}

public void printPits() {
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 7; j++) {
			if (i == 0 && j == 6) {
				System.out.println("Player1 mancala: " + model[i][j]);
			}
			else if (i == 1 && j == 0) {
				System.out.println("Player2 mancala: " + model[i][j]);
			}
			else {
				System.out.print(model[i][j] + " "); 
			}
		}
		System.out.println(); 
	}
	System.out.println(); 
	
}
public int oneScore() {
	return model[0][0];
}
public int twoScore() {
	return model[1][6];
}

/**
 * Saves current state of the model
 */
public void saveModel() {
	for (int i =0; i < 2; i++) {
		for (int j = 0; j < 7; j++) {
			tempModel[i][j] = model[i][j]; 
		}
	}
}
	/**
	 * Retrieves the value at a specific pit.
	 * @param x the row of the pit
	 * @param y the column of the pit
	 * @return the number of stones in the pit
	 */
public int getValue(int x,int y) {
	return model[x][y];
}

	/**
	 * Executes a move starting at the specified pit.
	 * @param x the row of the starting pit
	 * @param y the column of the starting pit
	 */
public void move(int x, int y) {
	printPits(); 
	saveModel(); 

	int stones=model[x][y];
	
	model[x][y] = 0; 
	
	
	while (stones>0) {
	
		if(x==0) {
			y+=1;
			if (y>5 && !isPlayerOne) {
				x=1; y=6;
			}
			if(y>6) {
				x=1;y=6;
			}
		}
		else {
			y--;
			if(y<1 && isPlayerOne) {
				x=0;y=0;
			}
			if(y<0) {
				x=0;y=0;
			}
		}
		
		
		model[x][y]+=1;
		stones -=1 ;
		printPits();
		
		
	}
	
	boolean edge = (x==1 && y == 0) || (x==0 && y == 6) ;
	System.out.println(edge);
	if (model[x][y] == 1 && !edge) {
		if (x==0){
			if(isPlayerOne) {
			model[0][6] += model[(x+1)%2][y+1]; 
			model[(x+1)%2][y+1]=0;
			}
			else {
				model[1][0] += model[(x+1)%2][y+1]; 
				model[(x+1)%2][y+1]=0;
			}
		}
		else {
			if(isPlayerOne) {
				model[0][6] += model[(x+1)%2][y-1]; 
				model[(x+1)%2][y-1]=0;
				}
				else {
					model[1][0] += model[(x+1)%2][y-1]; 
					model[(x+1)%2][y-1]=0;
				}
		}
	}
	
	System.out.println("----------------------------------------------");
	printPits();
	System.out.println("----------------------------------------------");
	
	boolean game = false;
	for(int i=0; i < 6;i++) {
		if(model[0][i] != 0) {
			game = true;
		}
	}
	for(int i=0; i < 6;i++) {
		if(model[1][i+1] != 0) {
			game = true;
		}
	}
	if(!game) {
		setGameState(game);
	}
	isPlayerOne = !isPlayerOne;

	
	System.out.println("Next player's turn"); 
}


	/**
	 * Reverts the last move using the temporary model.
	 */
	

public void undoMove() {
	if (undoCount < 3) {
		undoCount++; 
		System.out.println("UNDOING MOVE"); 
	
		for (int i = 0; i < 2; i++) {
	        for (int j = 0; j < 7; j++) {
	            model[i][j] = tempModel[i][j];
	        }
	    }
	
		
		printPits(); 
		view.undoMancalaPits(model);
		view.repaint(); 
		
	
	}
	else {
		System.out.println("Exceeded undo moves."); 
		
	}
}
	

}
