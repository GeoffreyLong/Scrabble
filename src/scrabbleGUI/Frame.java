package scrabbleGUI;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame{
	private static int xSize;
	private static int ySize;

	public Frame(){
		setTitle("Light Cycles");
		
		//These size variables allow for certain positioning benefits
		Toolkit tk = Toolkit.getDefaultToolkit();  
		xSize =  ((int) tk.getScreenSize().getWidth());
		ySize =  ((int) tk.getScreenSize().getHeight());
		
		setBounds(0,0,xSize,ySize);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}
	
	public static int getXSize(){
		return xSize;
	}

	public static int getYSize(){
		return ySize;
	}
}
