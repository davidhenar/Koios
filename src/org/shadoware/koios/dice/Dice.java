package org.shadoware.koios.dice;

public class Dice {
	
	private int min;
	private int max;
	
	public Dice(int a, int b) {
		this.min = Math.min(Math.abs(a), Math.abs(b));
		this.max = Math.max(Math.abs(a), Math.abs(b));
	}

	public int roll() {
		return (int) (Math.random() * getRange(min, max)) + min;
	}
	
	private int getRange(int min, int max) {
		return max - min + 1;
	}
}
