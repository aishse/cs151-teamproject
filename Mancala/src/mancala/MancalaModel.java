package mancala;
import java.util.*; 

public class MancalaModel {
	private int[][] model = new int[2][7];
	private int[][] tempModel = new int[2][7];
	private boolean isPlayerOne = true;
	private ArrayList<StonePit> playerStones; 
/**
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
	}
}
public void undoMove() {
	int[][]temp=model;
	model=tempModel;
	tempModel=temp;
}
	

}
