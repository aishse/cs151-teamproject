package mancala;

public interface MancalaListener {
	void onStoneClicked(StonePit pit); 
	void gameStarted(Boolean b); 
	void onPlayer1(); 
	void onPlayer2(); 
}
