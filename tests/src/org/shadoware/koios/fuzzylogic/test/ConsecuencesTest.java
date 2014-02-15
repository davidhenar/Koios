package org.shadoware.koios.fuzzylogic.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.shadoware.koios.fuzzylogic.Consecuence;
import org.shadoware.koios.fuzzylogic.Consecuences;
import org.shadoware.koios.fuzzylogic.Levels;

public class ConsecuencesTest {

	@Test
	public void consecuences() {
		Consecuences consecuences = new Consecuences();
		
		Consecuence veryLowConsecuence = new DummyConsecuence(Levels.VERY_LOW);
		Consecuence lowConsecuence = new DummyConsecuence(Levels.LOW);
		Consecuence halfConsecuence = new DummyConsecuence(Levels.HALF);
		Consecuence highConsecuence = new DummyConsecuence(Levels.HIGH);
		Consecuence veryHighConsecuence = new DummyConsecuence(Levels.VERY_HIGH);
		
		consecuences.add(veryHighConsecuence);
		consecuences.add(lowConsecuence);
		consecuences.add(halfConsecuence);
		consecuences.add(highConsecuence);
		consecuences.add(veryLowConsecuence);
		
		int countVeryLow = 0;
		int countLow = 0;
		int countHalf = 0;
		int countHigh = 0;
		int countVeryHigh = 0;
		
		int iterations = 1000;
		for (int i=0; i<iterations; i++) {
			Consecuence c = consecuences.guess();
			if (c == veryLowConsecuence) { countVeryLow++; }
			else if (c == lowConsecuence) { countLow++; }
			else if (c == halfConsecuence) { countHalf++; }
			else if (c == highConsecuence) { countHigh++; }
			else if (c == veryHighConsecuence) { countVeryHigh++; }
		}
	
		int summ = countVeryLow + countLow + countHalf + countHigh + countVeryHigh;
		assertTrue(summ == iterations);
		assertTrue(countVeryLow < countLow);
		assertTrue(countLow < countHalf);
		assertTrue(countHalf < countHigh);
		assertTrue(countHigh < countVeryHigh);
		
		System.out.println("vlow: \t" + countVeryLow);
		System.out.println("low: \t" + countLow);
		System.out.println("half: \t" + countHalf);
		System.out.println("high: \t" + countHigh);
		System.out.println("vhigh: \t" + countVeryHigh);
		System.out.println("total: \t" + summ);
	}
	
}

class DummyConsecuence implements Consecuence {
	
	private Levels value;
	
	public DummyConsecuence(Levels value) {
		this.value = value;
	}

	public void setProbability(Levels value) {
		this.value = value;
	}

	public Levels getProbability() {
		return value;
	}
}
