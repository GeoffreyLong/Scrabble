package scrabbleGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class BoardFrame extends JFrame {
	private PlayerPanel playerPanel;
	private CharacterPanel charPanel;

	/**
	 * Create the frame.
	 */
	public BoardFrame() {
		JFrame frame = new JFrame ("New Scrabble");
		frame.setLayout(null);
		createPlayerPanels(this);
		createCharPanel(this);
	}
	
	public JPanel createCharPanel(JFrame frame) {
		charPanel = new CharacterPanel();
		frame.add(charPanel);
		return charPanel;
	}
	
	public void updateCharPanel(){
		charPanel.newButtons();
	}
	
	public GamePanel createGamePanel(JFrame frame) {
		GamePanel gamePanel = new GamePanel();
		frame.add(gamePanel);
		return gamePanel;
	}
	
	private void createPlayerPanels(JFrame frame) {
		playerPanel = new PlayerPanel();
		frame.add(playerPanel);
	}
	
	public JPanel createPanelButtons(JFrame frame) {
		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(750,600,100,100);
		frame.add(panelButtons);
		return panelButtons;
	}

	//Should avoid these calls through other classes (law of Demter)
	public void updatePlayerScore(Player curPlayer){
		if (curPlayer.getPlayerNumber() == 1){
			playerPanel.setScoreOne(curPlayer.getCurrentScore());
		}
		else{
			playerPanel.setScoreTwo(curPlayer.getCurrentScore());
		}
	}
	
	public void updateGameState(){
		
	}
}
