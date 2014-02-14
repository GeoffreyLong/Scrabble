package scrabbleGUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FrameDriver {
	Frame frame;
	StartPanel startPanel = new StartPanel();
	
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
}
