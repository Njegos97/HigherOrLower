package HigherOrLower.entity;

import lombok.Data;

@Data
public class Game {

	private boolean GameFinished = false;;
	private int number;
	private int playersGuess;
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
		setPlayersGuess(generateRandomNumber());
		
		if(this.number > playersGuess) {
			setGameFinished(true);
			setNumber(playersGuess);
			return false;
		}
		setNumber(playersGuess);
		return true;
	}
	
	public boolean isNumberLower() {
		setPlayersGuess(generateRandomNumber());
		
		if(this.number < playersGuess) {
			setGameFinished(true);
			setNumber(playersGuess);
			return false;
		}
		
		setNumber(playersGuess);
		return true;
	}
	
	
}
