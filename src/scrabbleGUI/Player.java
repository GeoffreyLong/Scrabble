package scrabbleGUI;

public class Player {
	private int playerNum;
	private int currentScore;
	private int turnsLeft;
	private String wordGuess = "";

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
	
	public void setWordGuess(String wordGuess){
		this.wordGuess = wordGuess;
	}
	
	public String getWordGuess(){
		return this.wordGuess;
	}
}
