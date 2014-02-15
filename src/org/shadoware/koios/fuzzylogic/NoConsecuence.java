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
