package scrabbleGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

import actualGame.PointCounter;

public class CharacterButton extends JButton implements ActionListener{
	private char character = 0;
	private SelectedLabel select;
	PointCounter points = new PointCounter();
	
	public CharacterButton(SelectedLabel select, int i){
		setLayout(null);
		this.select = select;
		setBounds(3+83*i, 10, 80, 30);
		
		this.character = randomChar();
		
		setText(""+this.character);
		
		labelMaker();
		
		addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		select.setSelectionLetter(this.character);
	}
	
	public void labelMaker(){
		JLabel pointLabel = new JLabel();
		pointLabel.setText("(" + points.valueOfCharacter(this.character+"") + ")");
		pointLabel.setBounds(5, 5, 40, 10);
		add(pointLabel);	
	}
	
	//Gets a character based on frequency
	private char randomChar(){
		Random generator = new Random();
		int r = generator.nextInt(172871);
		int character=0;
		
		if (r<=13385){
			character = 65;
		}
		else if (r<=16801){
			character = 66;
		}
		else if (r<=23656){
			character = 67;
		}
		else if (r<=29712){
			character = 68;
		}
		else if (r<=49786){
			character = 69;
		}
		else if (r<=52002){
			character = 70;
		}
		else if (r<=56781){
			character = 71;
		}
		else if (r<=60831){
			character = 72;
		}
		else if (r<=76134){
			character = 73;
		}
		else if (r<=76445){
			character = 74;
		}
		else if(r<=78108){
			character = 75;
		}
		else if(r<=87467){
			character = 76;
		}
		else if(r<92286){
			character = 77;
		}
		else if(r<=103743){
			character = 78;
		}
		else if(r<=114834){
			character = 79;
		}
		else if(r<=119742){
			character = 80;
		}
		else if(r<=120027){
			character = 81;
		}
		else if(r<=132072){
			character = 82;
		}
		else if(r<=148775){
			character = 83;
		}
		else if(r<=159996){
			character = 84;
		}
		else if(r<=165693){
			character = 85;
		}
		else if(r<=167335){
			character = 86;
		}
		else if(r<=168738){
			character = 87;
		}
		else if(r<=169219){
			character = 88;
		}
		else if(r<=172020){
			character = 89;
		}
		else if(r<=172871){
			character = 90;
		}
		return Character.toChars(character)[0];
	}
}
