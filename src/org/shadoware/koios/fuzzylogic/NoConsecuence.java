/**
 * Koios. Artificial Inteligence library.
 * 
 * @copyright (C) 2014 David Henar Palacin.
 * @license GNU General Public License version 3 or later, see license.txt
 */

package org.shadoware.koios.fuzzylogic;


public class NoConsecuence implements Consecuence {
	
	Levels level = Levels.NO_LEVEL;

	public void setProbability(Levels value) {
		this.level = value;
	}

	public Levels getProbability() {
		return level;
	}
}
