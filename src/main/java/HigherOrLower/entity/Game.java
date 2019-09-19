package HigherOrLower.entity;

import lombok.Data;

@Data
public class Game {

	private boolean gameFinished = false;;
	private int number;
	private int rolledNumber;
//	private Guess guess;
	
	
	
//	public static enum Guess{
//		HIGHER, LOWER
//	}
	
	public int generateRandomNumber() {
		int number = 1 + (int) (Math.random() * 10);
		return number;
	}
	
//	public Guess checkIsNumberHigherOrLower(int checkingNumber) {
//		int number = generateRandomNumber();
//		if(number >= checkingNumber) {
//			return guess.HIGHER;
//		}
//		
//		return guess.LOWER;
//	}
//	
//	public boolean checkPlayersGuess(Guess guess) {
//		
//	}

	public boolean isNumberHigher() {
		setRolledNumber(generateRandomNumber());
		
		if(this.number > rolledNumber) {
			setGameFinished(true);
			setNumber(rolledNumber);
			return false;
		}
		setNumber(rolledNumber);
		return true;
	}
	
	public boolean isNumberLower() {
		setRolledNumber(generateRandomNumber());
		
		if(this.number < rolledNumber) {
			setGameFinished(true);
			setNumber(rolledNumber);
			return false;
		}
		
		setNumber(rolledNumber);
		return true;
	}
	
	
}
