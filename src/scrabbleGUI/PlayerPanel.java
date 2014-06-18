package scrabbleGUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel {
	private JLabel playerOneScoreLabel;
	private JLabel playerTwoScoreLabel;
	
	public PlayerPanel() {
		setBounds(850,600,150,100);
		setBackground(Color.YELLOW);
		setLayout(null);
		
		JLabel playerOneLabel = new JLabel("Player One");
		playerOneLabel.setBounds(5,0,70,20);
		add(playerOneLabel);
		
		JLabel playerTwoLabel = new JLabel("Player Two");
		playerTwoLabel.setBounds(5,30,70,20);
		add(playerTwoLabel);
		
		playerOneScoreLabel = new JLabel();
		playerTwoScoreLabel = new JLabel();
		playerOneScoreLabel.setText("0");
		playerTwoScoreLabel.setText("0");
		playerOneScoreLabel.setBounds(100,0,70,30);
		playerTwoScoreLabel.setBounds(100,30,70,30);
		
		add(playerOneScoreLabel);
		add(playerTwoScoreLabel);
	}

	public void setScoreOne(String score){
		playerOneScoreLabel.setText(score);
	}
	public void setScoreTwo(String score){
		playerTwoScoreLabel.setText(score);
	}
}
