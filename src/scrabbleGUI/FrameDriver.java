package scrabbleGUI;

import java.awt.Dimension;

import javax.swing.JFrame;

import actualGame.StartGame;

public class FrameDriver {
	Frame frame;
	StartPanel startPanel = new StartPanel(this);
	
	public FrameDriver(Frame frame){
		this.frame = frame;
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
		new StartGame(numOfPlayers, numOfTurns);
	}
}
