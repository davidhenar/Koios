package org.shadoware.koios.fuzzy.learning;

public interface KnowledgeNode {
	
	void feed(KnowledgeProperty knowledge);
	float getValueOf(int propertyId);
}
