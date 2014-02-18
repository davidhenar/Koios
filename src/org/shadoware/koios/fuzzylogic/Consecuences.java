/**
 * Koios. Artificial Inteligence library.
 * 
 * @copyright (C) 2014 David Henar Palacin.
 * @license GNU General Public License version 3 or later, see license.txt
 */

package org.shadoware.koios.fuzzylogic;

import java.util.ArrayList;
import java.util.List;

public class Consecuences {
	
	private List<Consecuence> consecuences = new ArrayList<Consecuence>();
	
	public Consecuence guess() {
		float summ = calculateSum();
		float randomValue = calculateRandom(summ);
		return getConsecuence(randomValue);
	}
	
	private float calculateSum() {
		float summ = 0;
		for (Consecuence consecuence : consecuences) {
			summ += consecuence.getProbability().value();
		}
		return summ;
	}
	
	private float calculateRandom(float max) {
		return (float) (Math.random() * max);
	}
	
	private Consecuence getConsecuence(float probability) {
		float summ = 0;
		for (Consecuence consecuence : consecuences) {
			summ += consecuence.getProbability().value();
			if (summ > probability ) {
				return consecuence;
			}
		}
		return new NoConsecuence();
	}
	
	public void add(Consecuence consecuence) {
		consecuences.add(consecuence);
	}
	
	public void remove(Consecuence consecuence) {
		consecuences.remove(consecuence);
	}
}
