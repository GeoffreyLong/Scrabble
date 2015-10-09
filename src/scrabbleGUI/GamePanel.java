package scrabbleGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actualGame.PointCounter;

public class GamePanel extends JPanel implements ActionListener {
	private final int X_SIZE = 1000;
	private final int Y_SIZE = 600;
	private int x_max = 0;
	private int y_max = 0;
	private final int BUTTON_SIZE = 50;
	private WordButton[][] buttons;
	private PointCounter point = new PointCounter();
	private int currentTotalPoints = 0;
	
	private HashMap<WordButton, Character> playerOne = new HashMap<WordButton, Character>();
	private HashMap<WordButton, Character> playerTwo = new HashMap<WordButton, Character>();
	
	public GamePanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0,0,Y_SIZE,X_SIZE);
		setVisible(true);
		
		createButtons();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")){
			
		}
		
	}

	//Also saves the word to the board
	public void calculateTotalPoints(){
		HashMap<WordButton, Character> temp = new HashMap<WordButton, Character>();

		if (playerOne.size() > playerTwo.size()){
			temp.putAll(playerOne);
		}
		else if (playerOne.size() == playerTwo.size()){
			if (assessPoints(playerOne) > assessPoints(playerTwo)){
				temp.putAll(playerOne);
			}
			else{
				temp.putAll(playerTwo);
			}
		}
		else{
			temp.putAll(playerTwo);
		}
		for (WordButton word : temp.keySet()){
			word.save(temp.get(word));
		}
		
		this.currentTotalPoints = checkValid();
		
		playerOne.clear();
		playerTwo.clear();
	}
	
	private int assessPoints(HashMap<WordButton, Character> temp){
		String string = "";
		for (WordButton word : temp.keySet()){
			string += temp.get(word);
		}
		return point.getPointVal(string);
	}
	
	private void createButtons(){
		// x_max and y_max have to be the same for the checking algorithm to work currently
		// Easy rework if I need that changed
		x_max = (Y_SIZE-50) / BUTTON_SIZE;
		y_max = (Y_SIZE-50) / BUTTON_SIZE;
		buttons = new WordButton[x_max][y_max];
		
		for (int i = 0; i < x_max; i++){
			for (int j = 0; j < y_max; j++){
				WordButton cur = new WordButton(i, 1+j, BUTTON_SIZE);
				add(cur);
				buttons[i][j] = cur;
			}
		}
	}

	public int checkAndSave(int playerNumber){
		int score = checkValid();
		if (score != -1){
			clearAndSave(playerNumber);
		}
		else{
			clear();
		}
		return score;
	}
	
	public int checkValid(){
		String vertWord = "";
		String horizWord = "";
		int totalPoints = 0;
		int tempVal = 0;
		
		for (int i = 0; i < x_max; i++){
			for (int j = 0; j < y_max; j++){
				char horizChar = buttons[i][j].getCharacter();
				char vertChar = buttons[j][i].getCharacter();
				if (horizChar != 0){
					horizWord += String.valueOf(horizChar);
				}
				else{
					tempVal = point.getPointVal(horizWord);
					if (tempVal == -1) return -1;
					totalPoints += tempVal;
					horizWord = "";
				}
				if (vertChar != 0){
					vertWord += String.valueOf(vertChar);
				}
				else{
					tempVal = point.getPointVal(vertWord);
					if (tempVal == -1) return -1;
					totalPoints += tempVal;
					vertWord = "";
				}
			}
			tempVal = point.getPointVal(horizWord);
			if (tempVal == -1) return -1;
			totalPoints += tempVal;
			tempVal = point.getPointVal(vertWord);
			if (tempVal == -1) return -1;
			totalPoints += tempVal;
			
			horizWord = "";
			vertWord = "";
		}
		
		return totalPoints - currentTotalPoints;
	}
	
	private void clearAndSave(int playerNumber){
		HashMap<WordButton, Character> temp = new HashMap<WordButton, Character>();

		for (int i = 0; i < x_max; i++){
			for (int j = 0; j < y_max; j++){
				char tempChar = buttons[i][j].clearTemp();
				if (tempChar != 0) temp.put(buttons[i][j], tempChar);
			}
		}
		if (playerNumber == 1){
			playerOne.putAll(temp);
		}
		else{
			playerTwo.putAll(temp);
		}
	}
	
	public void clear(){
		for (int i = 0; i < x_max; i++){
			for (int j = 0; j < y_max; j++){
				buttons[i][j].clearTemp();
			}
		}
	}
}
