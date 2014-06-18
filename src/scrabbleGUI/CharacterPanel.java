package scrabbleGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actualGame.PointCounter;

public class CharacterPanel extends JPanel {
	private SelectedLabel selectedLabel;
	private CharacterButton[] buttons = new CharacterButton[9];
	private LinkedList<Character> characters = new LinkedList<Character>();
	
	public CharacterPanel() {
		setBackground(Color.GREEN);
		setBounds(0,600,750,100);
		createSelectedLabel();
		createButtons();
		setLayout(null);
		setVisible(true);
	}
	
	private void createSelectedLabel(){
		selectedLabel = new SelectedLabel();
		add(selectedLabel);
	}
	
	private void createButtons(){
		for (int i=0;i<9;i++){
			CharacterButton button = new CharacterButton(selectedLabel, i);
			add(button);
			buttons[i] = button;
		}
		
		makeSet();
		
		revalidate();
		repaint();
	}
	
	private void makeSet(){
		characters.clear();
		for (int i=0; i<9; i++){
			if (characters.contains(buttons[i].getCharacter())){
				buttons[i].setButton();
				i--;
			}
			else{
				characters.add(buttons[i].getCharacter());
			}
		}
	}
	
	public void newButtons (){
		selectedLabel.clear();
		for (CharacterButton button : buttons){
			button.setButton();
		}
		makeSet();
	}
}
