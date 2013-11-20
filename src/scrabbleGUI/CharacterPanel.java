package scrabbleGUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class CharacterPanel extends JPanel {

	public CharacterPanel() {
		setSize(new Dimension(100,100));
		setBackground(Color.GREEN);
		setBounds(0,600,750,100);
		setLayout(null);
		setVisible(true);
	}

}
