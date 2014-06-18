package scrabbleGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actualGame.PointCounter;

public class CharacterPanel extends JPanel {
	private SelectedLabel selectedLabel;
	
	public CharacterPanel() {
		setBackground(Color.GREEN);
		setBounds(0,600,750,100);
		createSelectedLabel();
		newButtons();
		setLayout(null);
		setVisible(true);
	}
	
	private void createSelectedLabel(){
		selectedLabel = new SelectedLabel();
		add(selectedLabel);
	}
	
	public void newButtons (){
		removeAll();
		
		add(selectedLabel);
		
		for (int i=0;i<9;i++){
			add(new CharacterButton(selectedLabel, i));
		}
		repaint();
	}
}
