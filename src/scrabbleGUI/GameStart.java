package scrabbleGUI;

import java.awt.BorderLayout;
import actualGame.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GameStart extends JFrame implements ActionListener {

	private JPanel contentPane;
	private int players;
	private JTextField txtEnterHere;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameStart frame = new GameStart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameStart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel title = new JLabel("Welcome to my Game");
		title.setBounds(70, 0, 400, 30);
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		getContentPane().add(title);
		
	//	radioButtons();
		
		JButton startGame = new JButton("Start Game");
		startGame.addActionListener(this);
		startGame.setFont(new Font("Tahoma", Font.BOLD, 24));
		startGame.setBounds(100,200,200,50);
		getContentPane().add(startGame);
		
		txtEnterHere = new JTextField();
		txtEnterHere.setText("10");
		txtEnterHere.setBounds(320, 57, 86, 20);
		contentPane.add(txtEnterHere);
		txtEnterHere.setColumns(10);
		
		JLabel lblHowManyTurns = new JLabel("How Many Turns?");
		lblHowManyTurns.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHowManyTurns.setBounds(140, 50, 170, 30);
		contentPane.add(lblHowManyTurns);
		
		
		
	}
	
	private void radioButtons(){
		JRadioButton twoPlayer = new JRadioButton("Two Player");
		twoPlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		twoPlayer.setBounds(0,50,115,30);
		twoPlayer.addActionListener(this);
		getContentPane().add(twoPlayer);
		
		JRadioButton threePlayer = new JRadioButton("Three Player");
		threePlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		threePlayer.setBounds(0,80,200,30);
		threePlayer.addActionListener(this);
		getContentPane().add(threePlayer);
		
		JRadioButton fourPlayer = new JRadioButton("Four Player");
		fourPlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		fourPlayer.setBounds(0,110,200,30);
		fourPlayer.addActionListener(this);
		getContentPane().add(fourPlayer);
		
		ButtonGroup radio = new ButtonGroup();
		radio.add(twoPlayer);
		radio.add(threePlayer);
		radio.add(fourPlayer);
	}
	
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
			int turnNumber = Integer.valueOf(txtEnterHere.getText());
			StartGame game = new StartGame(players, turnNumber);
		}
	}
}


