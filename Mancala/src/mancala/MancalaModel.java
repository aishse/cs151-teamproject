package mancala;
import java.util.*; 

public class MancalaModel {
	private int[][] model = new int[2][7];
	private int[][] tempModel = new int[2][7];
	private boolean isPlayerOne = true;
	
	private MancalaView view; 
	private ArrayList<StonePit> playerStones; 
	
	public MancalaModel(MancalaView view) {
		this.view = view; 
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

public void setInitialStones(int initial) {
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 6; j++) {
		
			model[i][j] = initial; 
		}
	}
	model[0][0] = 0;
	model[1][6] = 0;
	
	view.initializeStonePits(initial); 
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

public void printPits() {
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 7; j++) {
			if (i == 0 && j == 0) {
				System.out.println("Player1 mancala: " + model[i][j]);
			}
			else if (i == 1 && j == 6) {
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
public int getValue(int x,int y) {
	return model[x][y];
}

public void move(int x, int y) {
	tempModel=model;
	int stones=getValue(x,y);
	
	model[x][y] = 0; 
	
	while (stones>0) {
		y+=1;
		if (y==7) {
			y=0;
			if(x==2) {
				x=0;
			}
		}
		
		if(isPlayerOne && x==1 && y == 6) {
			x=0;
			y=0;
			
		}
		else if(!isPlayerOne && x==0 && y == 0) {
			x=0;
			y=1;
		}
		model[x][y]+=1;
		
		stones -=1;
		printPits(); 
		
	}
	if (model[x][y] == 1) {
		if (isPlayerOne){
			model[0][0] += model[(x+1)%2][y]; 
		}
		else {
			model[1][6] += model[(x+1)%2][y];
		}
	}
}
	
	
	
	

public void undoMove() {
	int[][]temp=model;
	model=tempModel;
	tempModel=temp;
}
	

}
