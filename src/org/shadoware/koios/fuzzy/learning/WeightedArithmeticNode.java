package org.shadoware.koios.fuzzy.learning;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;


public class WeightedArithmeticNode implements KnowledgeNode {
	
	private final float STORED_VALUE_WEIGHT = 1.0f;
	private final float LEARNING_SPEED;
	
	@SuppressLint("UseSparseArrays")
	private Map<Integer, KnowledgeProperty> values = new HashMap<Integer, KnowledgeProperty>();
	
	
	public WeightedArithmeticNode(float learningSpeed) {
		LEARNING_SPEED = Math.abs(learningSpeed);
	}
	
	
	public void feed(KnowledgeProperty knowledge) {
		int id = knowledge.id();
		KnowledgeProperty value = new KnowledgeProperty(id, calculateValue(knowledge));
		values.put(id, value);
	}
	
	private float calculateValue(KnowledgeProperty property) {
		float propertyValue = Math.abs(property.value());
		float storedValue = getStoredValue(property.id());
		return WeightedMean(LEARNING_SPEED, propertyValue, STORED_VALUE_WEIGHT, storedValue);
	}
	
	private float WeightedMean(float aw, float a, float bw, float b) {
		return ((aw * a) + (bw * b)) / (aw + bw);
	}
	
	private float getStoredValue(int id) {
		try {
			return values.get(id).value();
		}
		catch (Exception e) {
			return 0;
		} 
	}
	
	
	public float getValueOf(int propertyId) {
		try {
			Integer id = Integer.valueOf(propertyId);
			return values.get(id).value();
		}
		catch (Exception e) {
			return 0;
		}
	}
}
