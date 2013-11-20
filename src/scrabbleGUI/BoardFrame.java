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

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public BoardFrame() {
		JFrame frame = new JFrame ("New Scrabble");
		frame.setLayout(null);
	}
	
	public JPanel createCharPanel(JFrame frame) {
		JPanel charPanel = new CharacterPanel();
		frame.add(charPanel);
		return charPanel;
	}
	
	public JPanel createGameBoard(JFrame frame) {
		JPanel gameBoard = new GamePanel();
		frame.add(gameBoard);
		return gameBoard;
	}
	
	public JPanel createPlayerPanels(JFrame frame) {
		JPanel playerPanels = new PlayerPanel();
		playerPanels.setBounds(850,600,150,100);
		playerPanels.setBackground(Color.YELLOW);
		frame.add(playerPanels);
		return playerPanels;
	}
	
	public JPanel createPanelButtons(JFrame frame) {
		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(750,600,100,100);
		frame.add(panelButtons);
		return panelButtons;
	}

}
