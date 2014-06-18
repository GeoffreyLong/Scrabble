package scrabbleGUI;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import actualGame.StartGame;

public class WordButton extends JButton implements ActionListener{
	//Permanently displayed character
	private char character = 0;
	private Point loc;
	
	//TODO getters and setters... a player will set this, if it is valid then 
	//The character will be set to one of these values after the round
	//Points should be calculated after the round is through to maintain secrecy
	private char tempChar = 0;
	
	public WordButton(int x, int y, int size){
		loc = new Point(x, y);
		
		this.character = 0;
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setBounds(size*x, size*y, size, size);
		addActionListener(this);
	}

	public char getCharacter(){
		if (this.tempChar != 0){
			return tempChar;
		}
		return this.character;
	}
	

	public void actionPerformed(ActionEvent arg0) {
		if (this.character == 0){
			this.tempChar = SelectedLabel.getLetter();
			setText(this.tempChar+"");
		}
	}
	
	public Point getLocation(){
		return this.loc;
	}

	public char clearTemp(){
		char temp = 0;
		if (this.tempChar != 0){
			temp = this.tempChar;
			this.tempChar = 0;
		}
		
		setText(this.character+"");

		return temp;
	}
	
	public void save(Character theChar) {
		this.character = theChar;
		setText(this.character+"");
	}
}
