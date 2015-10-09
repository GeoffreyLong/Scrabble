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
	
	JPanel panelButtons = new JPanel();
	JLabel playerName = new JLabel();

	JLabel playerNameLabel = new JLabel();
	int numberOfTurns;
	int totalTurns;
	JLabel turnsLeft = new JLabel();
	int initialTurns;
	String theTurnsLeft = "";
	
	public Player playerOne;
	public Player playerTwo;
	public Player currentPlayer;

	private CharacterPanel charPanel;

	private PlayerPanel playerPanel;
	
	public StartGame(int players, int turns, GamePanel gamePanel, CharacterPanel charPanel, PlayerPanel playerPanel, JPanel panelButtons) {
		this.gamePanel = gamePanel;
		this.charPanel = charPanel;
		this.playerPanel = playerPanel;
		this.panelButtons = panelButtons;
		
		playerOne = new Player(1, turns);
		playerTwo = new Player(2, turns);
		currentPlayer = playerOne;
		
		totalTurns = turns;
		numberOfTurns=0;
		
		//TODO update on repaint
		
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
		
		
		// TODO remove from here and encapsulate
		JButton annul = new JButton ("Annul");
		annul.setBounds(0,0,100,50);
		annul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gamePanel.clear();
			}
		});
		panelButtons.add(annul);
		
		JButton createWord = new JButton ("ENTER");
		createWord.setBounds(0,50,100,50);
		createWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pointValue = gamePanel.checkAndSave(currentPlayer.getPlayerNumber());
				if (pointValue != -1){
					currentPlayer.incrementScore(pointValue);
					
					updatePlayerScore(currentPlayer);
					
					advanceGame();
				}
				else{
					//TODO some sort of warning alert
				}
			}
		});
		panelButtons.add(createWord);
		
		// playerName.setText(String.valueOf(currentPlayer.getPlayerNumber()));
		// mainPanel.add(playerName);
	}
	
	public void advanceGame(){
		if (currentPlayer.getPlayerNumber() == 1){
			currentPlayer = playerTwo;
			playerNameLabel.setText("Player Two");
			gamePanel.repaint();
		}
		else {
			currentPlayer = playerOne;
			playerNameLabel.setText("Player One");
			gamePanel.repaint();
			charPanel.newButtons();
			charPanel.repaint();
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
	
	public void updatePlayerScore(Player curPlayer){
		if (curPlayer.getPlayerNumber() == 1){
			playerPanel.setScoreOne(curPlayer.getCurrentScore());
		}
		else{
			playerPanel.setScoreTwo(curPlayer.getCurrentScore());
		}
	}
}
