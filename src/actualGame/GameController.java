package actualGame;

import scrabbleGUI.FrameDriver;

public class GameController {
	private FrameDriver frameDriver;
	private int numOfPlayers;
	private int numOfTurns;
	private BoardPanel boardPanel = new BoardPanel();
	private ScorePanel scorePanel = new ScorePanel();
	private LetterPanel letterPanel = new LetterPanel();
	
	public GameController(FrameDriver frameDriver){
		this.frameDriver = frameDriver;
		
		initComponents();
		initLayout();
	}
	
	public void initComponents(){
		
	}
	
	public void initLayout(){
		
	}
	
	public void startGame(int numOfPlayers, int numOfTurns){
		this.numOfPlayers = numOfPlayers;
		this.numOfTurns = numOfTurns;
	}
}
