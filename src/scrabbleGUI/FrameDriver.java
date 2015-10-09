package scrabbleGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import actualGame.StartGame;

public class FrameDriver {
	public Frame frame;
	StartPanel startPanel = new StartPanel(this);
	private PlayerPanel playerPanel;
	private CharacterPanel charPanel;
	
	public FrameDriver(){
		this.frame = new Frame();
		initComponents();
		initLayout();
	}
	
	public void initComponents(){
		startPanel.setVisible(false);
		//startPanel.setPreferredSize(new Dimension(400,400));
	}
	
	public void initLayout(){
		frame.add(startPanel);
	}
	
	public void startPanel(){
		startPanel.setVisible(true);
		//frame.pack();
	}
	public void startGame(int numOfPlayers, int numOfTurns){
		startPanel.setVisible(false);
		GamePanel gamePanel = new GamePanel();
		frame.add(gamePanel);
		
		/*
		JPanel panelButtons = new JPanel();
		frame.add(panelButtons);
		frame.add(panelButtons, BorderLayout.SOUTH);
		*/
		charPanel = new CharacterPanel();
		frame.add(charPanel);
		
		playerPanel = new PlayerPanel();
		frame.add(playerPanel);
		
		gamePanel.setVisible(true);
		frame.validate();
		frame.repaint();
		new StartGame(numOfPlayers, numOfTurns);
	}
}
