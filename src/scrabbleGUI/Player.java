package scrabbleGUI;

public class Player {
	private int playerNum;
	private int currentScore;
	private int turnsLeft;

	public Player(int playerNum, int turnsLeft){
		this.playerNum = playerNum;
		this.currentScore = 0;
		this.turnsLeft = turnsLeft;
	}
	
	public String getCurrentScore(){
		return Integer.toString(this.currentScore);
	}

	public int getPlayerNumber(){
		return this.playerNum;
	}
	
	public void incrementScore(int score){
		this.currentScore += score;
	}
}
