package actualGame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import scrabbleGUI.*;

public class StartGame {

	GamePanel gamePanel;
	JLabel wordLabel = new JLabel();
	JPanel panelButtons = new JPanel();
	BoardFrame mainPanel = new BoardFrame();
	JLabel playerName = new JLabel();
	PointCounter points = new PointCounter();
	static String theLastChar;
	String importantChar;

	String[] chars = new String [9];
	JLabel playerNameLabel = new JLabel();
	int numberOfTurns;
	int totalTurns;
	JLabel turnsLeft = new JLabel();
	int initialTurns;
	String theTurnsLeft = "";
	
	public Player playerOne;
	public Player playerTwo;
	public Player currentPlayer;
	
	public static String curChar = "";
	
	public String longestString;
	
	public StartGame(int players, int turns) {
		// Is there a design pattern for this (factory?)
		playerOne = new Player(1, turns);
		playerTwo = new Player(2, turns);
		currentPlayer = playerOne;
		
		totalTurns = turns;
		numberOfTurns=0;
		mainPanel.setBounds(0,0,1200,700);
		mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		
		//TODO update on repaint

		
		gamePanel = mainPanel.createGamePanel(mainPanel);
		
		longestString="";
		

		playerNameLabel.setText("Player One");
		playerNameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		playerNameLabel.setBounds(750, 0, 200, 40);
		gamePanel.add(playerNameLabel);
		
		initialTurns = turns;
		theTurnsLeft = "Turns Left = " + Integer.toString(turns);
		turnsLeft.setFont(new Font("Tahoma", Font.BOLD, 30));
		turnsLeft.setText(theTurnsLeft);
		turnsLeft.setBounds(750, 40, 300, 40);
		gamePanel.add(turnsLeft);

		panelButtons = mainPanel.createPanelButtons(mainPanel);
		JButton annul = new JButton ("Annul");
		annul.setBounds(0,0,100,50);
		annul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPlayer.setWordGuess("");
				wordLabel.setText(null);
			}
		});
		panelButtons.add(annul);
		
		JButton createWord = new JButton ("ENTER");
		createWord.setBounds(0,50,100,50);
		createWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PointCounter counts = new PointCounter();
				wordLabel.setText(null);
				int pointValue = gamePanel.checkAndSave(currentPlayer.getPlayerNumber());
				if (pointValue != -1){
					currentPlayer.incrementScore(pointValue);
					
					mainPanel.updatePlayerScore(currentPlayer);
					
					if (currentPlayer.getWordGuess().length() > longestString.length()){
						longestString = currentPlayer.getWordGuess();
					}
					
					advanceGame();
				}
				else{
					
				}
				currentPlayer.setWordGuess("");
			}
		});
		panelButtons.add(createWord);
		
		playerName.setText(String.valueOf(currentPlayer.getPlayerNumber()));
		mainPanel.add(playerName);
	}
	
	public void createString(String arg){
		curChar = arg;
		String theWord = currentPlayer.getWordGuess() + arg;
		currentPlayer.setWordGuess(theWord);
		wordLabel.setText(theWord);
		wordLabel.setBounds(5,0,200,30);
		wordLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		gamePanel.add(wordLabel);
	}
	

	
	public void advanceGame(){
		importantChar = theLastChar;

		if (currentPlayer.getPlayerNumber() == 1){
			currentPlayer = playerTwo;
			playerNameLabel.setText("Player Two");
			gamePanel.repaint();
		}
		else {
			currentPlayer = playerOne;
			playerNameLabel.setText("Player One");
			gamePanel.repaint();
			mainPanel.updateCharPanel();
			longestString="";
			gamePanel.calculateTotalPoints();
		}

		if (currentPlayer.getPlayerNumber()==1){
			numberOfTurns++;
			turnsLeft.removeAll();
			theTurnsLeft = "Turns Left = " + Integer.toString(initialTurns-numberOfTurns);
			turnsLeft.setText(theTurnsLeft);
			gamePanel.add(turnsLeft);
		}

		if (numberOfTurns>=totalTurns){
			gameEndLogic();
		}
	}
	
	public void gameEndLogic(){
		int playerOneScore = Integer.valueOf(playerOne.getCurrentScore());
		int playerTwoScore = Integer.valueOf(playerTwo.getCurrentScore());
		gamePanel.removeAll();
		JLabel finalScore = new JLabel();
		finalScore.setLayout(null);
		if (playerOneScore>playerTwoScore){
			finalScore.setText("Player One Wins");
		}
		else {
			if (playerTwoScore>playerOneScore){
				finalScore.setText("Player Two Wins");
			}
			else {
				finalScore.setText("It's a tie");
			}
		}
		finalScore.setBounds(0,0,600,200);
		finalScore.setFont(new Font("Tahoma", Font.BOLD, 30));
		gamePanel.add(finalScore);
		gamePanel.repaint();
	}
}
