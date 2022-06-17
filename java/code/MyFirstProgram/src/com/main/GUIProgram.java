package com.main;

import javax.swing.JOptionPane;

public class GUIProgram {

	public static void main(String[] args) {
		
		String nameMessage = "Enter your name ?";
		String ageMessage = "Enter your age ?";
		String name = JOptionPane.showInputDialog(nameMessage);
		int age = Integer.parseInt(JOptionPane.showInputDialog(ageMessage));
		
		JOptionPane.showMessageDialog(null, ("Hello "+ name)+("\nYour age is "+ age));
		
		

	}

}
