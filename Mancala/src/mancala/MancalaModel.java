package mancala;

public class MancalaModel {
private int[][] model = new int[7][2];
private boolean isPlayerOne = true;
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
/*
	Idea: Having the first 
*/

}
