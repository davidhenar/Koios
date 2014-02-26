package org.shadoware.koios.dice.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.shadoware.koios.dice.Dice;

public class DiceTest {
	
	private final int MIN_ITERATIONS = 10;

	@Test
	public void positiveRoll() {
		Dice d6 = new Dice(1,6);
		testRoll(d6, 1, 6);
	}
	
	@Test
	public void negativeRoll() {
		Dice d6 = new Dice(-3,-10);
		testRoll(d6, 3, 10);
	}
	
	@Test
	public void inverseRoll() {
		Dice d6 = new Dice(7, 0);
		testRoll(d6, 0, 7);
	}
	
	private void testRoll(Dice dice, int min, int max) {
		int result;
		boolean reachMin = false;
		boolean reachMax = false;
		
		for (int i=0; i<getIterations(min, max); i++) {
			result = dice.roll();
			reachMin = (result == min) || reachMin;
			reachMax = (result == max) || reachMax;
			
			assertTrue(result >= min);
			assertTrue(result <= max);
		}
		assertTrue(reachMax);
		assertTrue(reachMin);
	}
	
	private int getIterations(int min, int max) {
		return MIN_ITERATIONS * (Math.abs(max) - Math.abs(min));
	}
}
