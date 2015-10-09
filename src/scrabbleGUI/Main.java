package scrabbleGUI;

import java.awt.BorderLayout;
import actualGame.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

// TODO 
// Implement the observer pattern or something to separate out the logics
//		Right now it is a twisted mess... See this link for the observer pattern
//		https://www.caveofprogramming.com/java/java-swing-tutorial-for-beginners.html

public class Main {
	public static FrameDriver frameDriver;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameDriver = new FrameDriver();
					frameDriver.startPanel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}