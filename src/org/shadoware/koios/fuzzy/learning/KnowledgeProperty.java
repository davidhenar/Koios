package org.shadoware.koios.fuzzy.learning;

public class KnowledgeProperty {
	
	public final static float LIMIT_MIN = 0.0f;
	public final static float LIMIT_MAX = 1.0f;
	
	private int id;
	private float value;
	
	public KnowledgeProperty(int id, float value) {
		this.id = id;
		limitValue(value);
	}
	
	private void limitValue(float value) {
		this.value = Math.min(value, LIMIT_MAX);
		this.value = Math.max(this.value, LIMIT_MIN);
	}
	
	public int id() {
		return id;
	}
	
	public float value() {
		return value;
	}
}
