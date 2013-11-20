package scrabbleGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	public GamePanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0,0,1000,600);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")){
			
		}
		
	}

}
