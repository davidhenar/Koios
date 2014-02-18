/**
 * Koios. Artificial Inteligence library.
 * 
 * @copyright (C) 2014 David Henar Palacin.
 * @license GNU General Public License version 3 or later, see license.txt
 */

package org.shadoware.koios.fuzzylogic.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.shadoware.koios.fuzzylogic.Levels;

public class LevelsTest {

	@Test
	public void decode() {
		assertTrue(Levels.decode(0.0f) == Levels.VERY_LOW);
		assertTrue(Levels.decode(0.08f) == Levels.VERY_LOW);
		assertTrue(Levels.decode(0.15f) == Levels.VERY_LOW);
		
		assertTrue(Levels.decode(0.28f) == Levels.LOW);
		assertTrue(Levels.decode(0.35f) == Levels.LOW);
		
		assertTrue(Levels.decode(0.43f) == Levels.HALF);
		assertTrue(Levels.decode(0.55f) == Levels.HALF);
		
		assertTrue(Levels.decode(0.67f) == Levels.HIGH);
		assertTrue(Levels.decode(0.77f) == Levels.HIGH);
		
		assertTrue(Levels.decode(0.81f) == Levels.VERY_HIGH);
		assertTrue(Levels.decode(0.95f) == Levels.VERY_HIGH);
		
		assertTrue(Levels.decode(-0.5f) == Levels.NO_LEVEL);
		assertTrue(Levels.decode(15.5f) == Levels.NO_LEVEL);
	}
	
	@Test
	public void values() {
		assertTrue(Levels.VERY_LOW.value() == 0.1f );
		assertTrue(Levels.LOW.value() == 0.3f );
		assertTrue(Levels.HALF.value() == 0.5f );
		assertTrue(Levels.HIGH.value() == 0.7f );
		assertTrue(Levels.VERY_HIGH.value() == 0.9f );
	}
	
	@Test
	public void comparing() {
		assertTrue(Levels.LOW.isHigherThan(Levels.VERY_LOW));
		assertTrue(Levels.HALF.isHigherThan(Levels.LOW));
		assertTrue(Levels.HIGH.isHigherThan(Levels.HALF));
		assertTrue(Levels.VERY_HIGH.isHigherThan(Levels.HIGH));
	}
}
