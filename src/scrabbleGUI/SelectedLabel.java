package scrabbleGUI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectedLabel extends JLabel{
	private static char selectionLetter = 0;
	
	public SelectedLabel(){
		setBounds(200,35,300,40);
		setVisible(true);
		setLayout(null);

		newSet();
	}
	
	public void setSelectionLetter(char letter){
		this.selectionLetter = letter;
		newSet();
	}

	private void newSet(){
		setText("The current Selection is : " + selectionLetter);
	}
	
	public char getSelectionLetter(){
		return this.selectionLetter;
	}
	
	public static char getLetter(){
		return selectionLetter;
	}
}
