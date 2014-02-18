/**
 * Koios. Artificial Inteligence library.
 * 
 * @copyright (C) 2014 David Henar Palacin.
 * @license GNU General Public License version 3 or later, see license.txt
 */

package org.shadoware.koios.fuzzylogic;

public enum Levels {
	VERY_LOW,
	LOW,
	HALF,
	HIGH,
	VERY_HIGH,
	NO_LEVEL;
	
	public float value() {
		switch (this) {
		case VERY_LOW 	: return 0.1f;
		case LOW 		: return 0.3f;
		case HALF 		: return 0.5f;
		case HIGH 		: return 0.7f;
		case VERY_HIGH 	: return 0.9f;
		default 		: return Float.NaN;
		}
	}
	
	public boolean isHigherThan(Levels level) {
		return this.value() > level.value();
	}
	
	public static Levels decode(float value) {
		if (value > 1.0f) {
			return NO_LEVEL;
		}
		if ( value > 0.8f) {
			return VERY_HIGH;
		}
		if ( value > 0.6f ) {
			return HIGH;
		}
		if ( value > 0.4f ) {
			return HALF;
		}
		if ( value > 0.2f ) {
			return LOW;
		}
		if ( value >= 0.0f ) {
			return VERY_LOW;
		}
		return NO_LEVEL;
	}
}