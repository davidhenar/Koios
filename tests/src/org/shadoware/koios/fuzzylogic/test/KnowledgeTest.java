/**
 * Koios. Artificial Inteligence library.
 * 
 * @copyright (C) 2014 David Henar Palacin.
 * @license GNU General Public License version 3 or later, see license.txt
 */

package org.shadoware.koios.fuzzylogic.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.shadoware.koios.fuzzylogic.Knowledge;
import org.shadoware.koios.fuzzylogic.Levels;

public class KnowledgeTest {
	
	private final int M_VARIABLE = 1;
	
	private Knowledge node;
	
	@Before
	public void init() {
		node = new Knowledge();
	}
	
	@Test
	public void input() {
		node.input(M_VARIABLE, Levels.VERY_LOW);
		assertTrue(node.level(M_VARIABLE) == Levels.VERY_LOW);
		
		node.input(M_VARIABLE, Levels.LOW);
		node.input(M_VARIABLE, Levels.LOW);
		assertTrue(node.level(M_VARIABLE) == Levels.LOW);
		
		node.input(M_VARIABLE, Levels.HIGH);
		node.input(M_VARIABLE, Levels.HIGH);
		assertTrue(node.level(M_VARIABLE) == Levels.HALF);
		
		node.input(M_VARIABLE, Levels.HIGH);
		assertTrue(node.level(M_VARIABLE) == Levels.HIGH);
		
		node.input(M_VARIABLE, Levels.VERY_HIGH);
		node.input(M_VARIABLE, Levels.VERY_HIGH);
		assertTrue(node.level(M_VARIABLE) == Levels.VERY_HIGH);
	}
}
