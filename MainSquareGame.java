package SquareGame;

import java.awt.Color;

import javax.swing.JFrame;

import Restart.Restart;

public class MainSquareGame {

	public static void main(String[] args) {
		SqareGame foc = new SqareGame();
		foc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		foc.setBackground(Color.black);
		foc.setSize(1280, 700);
		foc.setVisible(true);
	}

}
