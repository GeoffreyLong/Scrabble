package scrabbleGUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel {

	
	public PlayerPanel() {
		JLabel playerOneLabel = new JLabel("Player One");
		playerOneLabel.setBounds(5,0,70,20);
		add(playerOneLabel);
		
		
		
		JLabel playerTwoLabel = new JLabel("Player Two");
		playerTwoLabel.setBounds(5,30,70,20);
		add(playerTwoLabel);
		
	}

}
