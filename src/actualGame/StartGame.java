package actualGame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import scrabbleGUI.*;

public class StartGame {

	int playerNumber;
	JPanel gameBoard = new JPanel();
	private String theWord ="";
	public int pointScore;
	JPanel playerPanel = new JPanel();
	JLabel wordLabel = new JLabel();
	int wordGuess;
	JPanel panelButtons = new JPanel();
	JPanel charPane = new JPanel();
	BoardFrame mainPanel = new BoardFrame();
	JLabel guessNumber = new JLabel();
	JLabel playerName = new JLabel();
	JLabel playerOneScoreLabel = new JLabel();
	JLabel playerTwoScoreLabel = new JLabel();
	String buttonName;
	PointCounter points = new PointCounter();
	int playerOneScore;
	int playerTwoScore;
	String theLastChar;
	String importantChar;
	int mysteryBoundsX;
	int mysteryBoundsY;
	int theBoundsX;
	int theBoundsY;
	int moreBoundsX;
	int moreBoundsY;
	int existingStringCount;
	int necessitateExistingString;
	int vert;
	int finalVert;
	int charBoundsX;
	int charBoundsY;
	String[] chars = new String [9];
	JLabel playerNameLabel = new JLabel();
	int numberOfTurns;
	int totalTurns;
	JLabel turnsLeft = new JLabel();
	int initialTurns;
	String theTurnsLeft = "";
	
	public String longestString;
	
	public StartGame(int players, int turns) {
		totalTurns = turns;
		numberOfTurns=0;
		mainPanel.setBounds(0,0,1200,700);
		mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		
		
		charPane = mainPanel.createCharPanel(mainPanel);
		
		playerPanel = mainPanel.createPlayerPanels(mainPanel);
		playerPanel.setLayout(null);
		playerOneScoreLabel.setText("0");
		playerTwoScoreLabel.setText("0");
		playerOneScoreLabel.setBounds(100,0,70,30);
		playerTwoScoreLabel.setBounds(100,30,70,30);
		playerPanel.add(playerOneScoreLabel);
		playerPanel.add(playerTwoScoreLabel);
		
		gameBoard = mainPanel.createGameBoard(mainPanel);
		
		playerNumber = 1;
		wordGuess=1;
		existingStringCount=0;
		necessitateExistingString=0;
		vert=0;
		longestString="";
		

		playerNameLabel.setText("Player One");
		playerNameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		playerNameLabel.setBounds(750, 0, 200, 40);
		gameBoard.add(playerNameLabel);
		
		initialTurns = turns;
		theTurnsLeft = "Turns Left = " + Integer.toString(turns);
		turnsLeft.setFont(new Font("Tahoma", Font.BOLD, 30));
		turnsLeft.setText(theTurnsLeft);
		turnsLeft.setBounds(750, 40, 300, 40);
		gameBoard.add(turnsLeft);
		
		panelButtons = mainPanel.createPanelButtons(mainPanel);
		JButton annul = new JButton ("Annul");
		annul.setBounds(0,0,100,50);
		annul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theWord="";
				wordLabel.setText(null);
			}
		});
		panelButtons.add(annul);
		JButton createWord = new JButton ("ENTER");
		createWord.setBounds(0,50,100,50);
		createWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PointCounter counts= new PointCounter();
				wordLabel.setText(null);
				boolean otherBoolean = counts.checkValidity(theWord);
				if (otherBoolean==false){
//					gameBoard.setBackground(Color.RED);
				}
				if (existingStringCount>1){
					existingStringCount=0;
				}
				else{
				if (otherBoolean==true){
					if (theWord.length()==longestString.length()){
						if (playerOneScore>playerTwoScore && playerNumber==2){
							
						}
						if (playerOneScore>playerTwoScore && playerNumber==1){
							longestString = theWord;
							importantChar = theLastChar;
							theBoundsX = mysteryBoundsX;
							theBoundsY = mysteryBoundsY;
							finalVert = vert;
						}
						if (playerTwoScore>playerOneScore && playerNumber ==1){
							
						}
						if (playerTwoScore>playerOneScore && playerNumber ==2){
							longestString = theWord;
							importantChar = theLastChar;
							theBoundsX = mysteryBoundsX;
							theBoundsY = mysteryBoundsY;
							finalVert = vert;
						}
					}
					if (theWord.length()>longestString.length()){
						longestString = theWord;
						importantChar = theLastChar;
						theBoundsX = mysteryBoundsX;
						theBoundsY = mysteryBoundsY;
						finalVert = vert;
					}
//					gameBoard.setBackground(Color.GREEN);
					pointScore = counts.thePoints(theWord, playerNumber);
					if (playerNumber==1){
						playerOneScore = playerOneScore + pointScore;
						String oneScore = Integer.toString(playerOneScore);
						playerOneScoreLabel.setText(oneScore);
					}
					if (playerNumber==2){
						playerTwoScore = playerTwoScore + pointScore;
						String twoScore = Integer.toString(playerTwoScore);
						playerTwoScoreLabel.setText(twoScore);
					}
				}
				existingStringCount=0;
				}
				theWord="";
				if (wordGuess >= 1){
					if (playerNumber == 1){
						playerNumber = 2;
						playerNameLabel.setText("Player Two");
						gameBoard.repaint();
					}
					else {
						playerNumber = 1;
						playerNameLabel.setText("Player One");
						gameBoard.repaint();
						newButtons();
						int m=0;
						if (necessitateExistingString>=1){
							m = importantCharIndex(longestString);
						}
						final String delimS = "";
						String[] getLastChar = longestString.split(delimS);
						int n = 1;
//						if (necessitateExistingString<=0){
//							n=1;
//						}
						while (n<getLastChar.length){
							if (getLastChar[n]!=""){
								gameBoard.add(createButtons(m, n, getLastChar));
							}
							gameBoard.repaint();
							n++;
						}
						longestString="";
						necessitateExistingString=1;
					}
					wordGuess = 1;
				}
				else{
					wordGuess++;
				}
				if (playerNumber==1){
					numberOfTurns++;
					turnsLeft.removeAll();
					theTurnsLeft = "Turns Left = " + Integer.toString(initialTurns-numberOfTurns);
					turnsLeft.setText(theTurnsLeft);
					gameBoard.add(turnsLeft);
				}
/*				
				String wordGuessString = String.valueOf(wordGuess);
				guessNumber.setText(wordGuessString);
				mainPanel.add(guessNumber);
				
				String playerNumber = String.valueOf(playerName);
				playerName.setText(playerNumber);
				mainPanel.add(playerName);
				*/
				if (numberOfTurns>=totalTurns){
					gameBoard.removeAll();
					JLabel finalScore = new JLabel();
					finalScore.setLayout(null);
					if (playerOneScore>playerTwoScore){
						finalScore.setText("Player One Wins");
					}
					else {
						if (playerTwoScore>playerOneScore){
							finalScore.setText("Player Two Wins");
						}
						else {
							finalScore.setText("It's a tie");
						}
					}
					finalScore.setBounds(0,0,600,200);
					finalScore.setFont(new Font("Tahoma", Font.BOLD, 30));
					gameBoard.add(finalScore);
					gameBoard.repaint();
				}
			}
		});
		panelButtons.add(createWord);
		
		charPane.setLayout(null);
		newButtons();
		
		String wordGuessString = String.valueOf(wordGuess);
		guessNumber.setText(wordGuessString);
		mainPanel.add(guessNumber);
		
		String playerNumber = String.valueOf(playerName);
		playerName.setText(playerNumber);
		mainPanel.add(playerName);
		
	}
	
	public void newButtons (){
		charPane.removeAll();
		for (int i=0;i<9;i++){
			
			charPane.add(buttonMaker(i));
			charPane.add(labelMaker(i));
		}
		charPane.repaint();
		mainPanel.add(charPane);
	}
	
	public JLabel labelMaker(int i){
		JLabel label2 = new JLabel();
		label2.setText("(" + points.valueOfCharacter(buttonName) + ")");
		label2.setBounds(36+83*i, 30, 80 , 20);
		return label2;	
	}
	
	public JButton buttonMaker(int i){
		final JButton sample = new JButton();
		
		int character = getChars();
		
		buttonName = ""+(char)character;
		chars[i] = buttonName;
		for (int u = 0; u<chars.length; u++){
			if (buttonName.equals(chars[u])){
				character = getChars();
				buttonName = ""+(char)character;
				u=0;
			}
		}
		chars[i] = buttonName;
		sample.setBounds(3+83*i, 10, 80 , 20);
		sample.setText(buttonName);
		sample.setLayout(new BorderLayout());
		sample.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createString(arg0.getActionCommand());
				if (vert==0){
					sample.setFont(new Font("Tahoma", Font.BOLD, 12));
				}
				if (vert==1){
					sample.setFont(new Font("Tahoma", Font.BOLD, 11));
				}
				moreBoundsX = sample.getX();
				moreBoundsY = sample.getY();
			}
		});
		return sample;
	}
	
	public JButton createButtons(int c, int y, String[] getLastChar){
		int a = 400;
		int b = 400;
		
		
		final JButton wordButtons = new JButton();
		
		
			a = theBoundsX;
			b = theBoundsY;


		if (theBoundsX==0 || theBoundsY==0){
				a=400;
				b=400;
		}
		if (finalVert==0){
			while (c>=0){
				a = a-50;
				c--;
			}
			wordButtons.setFont(new Font("Tahoma", Font.BOLD, 12));
			wordButtons.setBounds(a+50*y,b,50,50);
		}
		if (finalVert == 1){
			while (c>=0){
				b = b-50;
				c--;
			}
			wordButtons.setBounds(a,b+50*y,50,50);
			wordButtons.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		wordButtons.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					createString(arg0.getActionCommand());
					existingStringCount++;
					theLastChar = arg0.getActionCommand();
					mysteryBoundsX = wordButtons.getX();
					mysteryBoundsY = wordButtons.getY();
					Font theFont = wordButtons.getFont();
					Font testFont = new Font("Tahoma", Font.BOLD, 11);
					if (theFont.equals(testFont)){
						vert=0;
					}
					else {
						vert=1;
					}
				}
			});
		wordButtons.setText(getLastChar[y]);
		necessitateExistingString=1;
		wordButtons.setVisible(true);
		return wordButtons;
	}

	
	public int importantCharIndex (String daWord){
		final String delimS = "";
		int y=0;
		String theArray[] = longestString.split(delimS);
		if (theBoundsX!=0 && theBoundsY!=0){
		if (necessitateExistingString>=1){
			while (!theArray[y].equals(importantChar)){
				y++;
			}
		}
		}
		y--;
		return y;
	}
	
	public void createString(String arg){
		theWord = theWord + arg;
		wordLabel.setText(theWord);
		wordLabel.setBounds(5,0,200,30);
		wordLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		gameBoard.add(wordLabel);
	}
	
	
	public int getChars(){
		Random generator = new Random();
		int r = generator.nextInt(172871);
		int character=0;
		if (r<=13385){
			character = 65;
		}
		else{
			if (r<=16801){
				character = 66;
			}
			else{
				if (r<=23656){
					character = 67;
				}
				else{
					if (r<=29712){
						character = 68;
					}
					else {
						if (r<=49786){
							character = 69;
						}
						else{
							if (r<=52002){
								character = 70;
							}
							else{
								if (r<=56781){
									character = 71;
								}
								else{
									if (r<=60831){
										character = 72;
									}
									else{
										if (r<=76134){
											character = 73;
										}
										else{
											if (r<=76445){
												character = 74;
											}
											else{
												if(r<=78108){
													character = 75;
												}
												else{
													if(r<=87467){
														character = 76;
													}
													else{
														if(r<92286){
															character = 77;
														}
														else{
															if(r<=103743){
																character = 78;
															}
															else{
																if(r<=114834){
																	character = 79;
																}
																else{
																	if(r<=119742){
																		character = 80;
																	}
																	else{
																		if(r<=120027){
																			character = 81;
																		}
																		else{
																			if(r<=132072){
																				character = 82;
																			}
																			else{
																				if(r<=148775){
																					character = 83;
																				}
																				else{
																					if(r<=159996){
																						character = 84;
																					}
																					else{
																						if(r<=165693){
																							character = 85;
																						}
																						else{
																							if(r<=167335){
																								character = 86;
																							}
																							else{
																								if(r<=168738){
																									character = 87;
																								}
																								else{
																									if(r<=169219){
																										character = 88;
																									}
																									else{
																										if(r<=172020){
																											character = 89;
																										}
																										else{
																											if(r<=172871){
																												character = 90;
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return character;
	}
}
