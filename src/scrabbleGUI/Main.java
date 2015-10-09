package scrabbleGUI;

import java.awt.BorderLayout;
import actualGame.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Main {
	public static FrameDriver frameDriver;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frameDriver = new FrameDriver(frame);
					frameDriver.startPanel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


