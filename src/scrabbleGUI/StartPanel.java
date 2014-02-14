package scrabbleGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import actualGame.StartGame;

public class StartPanel extends JPanel implements ActionListener{
	private JPanel contentPane;
	private int players;
	private JTextField txtEnterHere;
	private JLabel title;
	private JButton startGame;
	private JLabel lblHowManyTurns;
	private FrameDriver frameDriver;
	
	
	public StartPanel(FrameDriver frameDriver){
		setBounds(0,0,400,400);
		this.frameDriver = frameDriver;
		initComponents();
		initLayout();
	}
	public void initComponents(){		
		title = new JLabel("Welcome to my Game");
		title.setBounds(70, 0, 400, 30);
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		
	//	radioButtons();
		
		startGame = new JButton("Start Game");
		startGame.addActionListener(this);
		startGame.setFont(new Font("Tahoma", Font.BOLD, 24));
		startGame.setBounds(100,200,200,50);
		
		txtEnterHere = new JTextField();
		txtEnterHere.setText("10");
		txtEnterHere.setBounds(320, 57, 86, 20);
		txtEnterHere.setColumns(10);
		
		lblHowManyTurns = new JLabel("How Many Turns?");
		lblHowManyTurns.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHowManyTurns.setBounds(140, 50, 170, 30);
	}
	
	public void initLayout(){
		add(title);
		add(startGame);
		add(txtEnterHere);
		add(lblHowManyTurns);
	}	
	
	private void radioButtons(){
		JRadioButton twoPlayer = new JRadioButton("Two Player");
		twoPlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		twoPlayer.setBounds(0,50,115,30);
		twoPlayer.addActionListener(this);
		add(twoPlayer);
		
		JRadioButton threePlayer = new JRadioButton("Three Player");
		threePlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		threePlayer.setBounds(0,80,200,30);
		threePlayer.addActionListener(this);
		add(threePlayer);
		
		JRadioButton fourPlayer = new JRadioButton("Four Player");
		fourPlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		fourPlayer.setBounds(0,110,200,30);
		fourPlayer.addActionListener(this);
		add(fourPlayer);
		
		ButtonGroup radio = new ButtonGroup();
		radio.add(twoPlayer);
		radio.add(threePlayer);
		radio.add(fourPlayer);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Two Player")){
			players = 2;
		}
		
		if (e.getActionCommand().equals("Three Player")){
			players = 3;
		}
		
		if (e.getActionCommand().equals("Four Player")){
			players = 4;
		}
		
		if (e.getActionCommand().equals("Start Game")){
			int numberOfTurns = Integer.valueOf(txtEnterHere.getText());
			frameDriver.startGame(players, numberOfTurns);
		}
	}
}
