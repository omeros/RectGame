package SquareGame;

import javax.swing.JFrame;

import Restart.Restart;

public class MainSquareGame {

	public static void main(String[] args) {
		SqareGame foc = new SqareGame();
		foc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		foc.setSize(1280, 700);
		foc.setVisible(true);
	}

}
