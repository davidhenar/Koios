package org.shadoware.koios.fuzzylogic;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;


@SuppressLint("UseSparseArrays")
public class Knowledge {
	
	private Map<Integer, Float> values = new HashMap<Integer, Float>();
	
	public void input(int propertyId, Levels level) {
		try {
			values.put(propertyId, calculateNewValue(propertyId, level));
		}
		catch (Exception e) {
		}
	}
	
	private Float calculateNewValue(int propertyId, Levels level) {
		float newValue = level.value();
		float storedValue = getStoredValue(propertyId);
		if (storedValue != 0) {
			return geometricMean(newValue, storedValue);
		}
		else {
			return newValue;
		}
	}
	
	private float geometricMean(float a, float b) {
		return (float) Math.sqrt(a * b);
	}
	
	private float getStoredValue(int propertyId) {
		try {
			return values.get(propertyId);
		}
		catch (Exception e) {
			return 0;
		} 
	}
	
	public Levels level(int id) {
		return Levels.decode(values.get(id));
	}
}
