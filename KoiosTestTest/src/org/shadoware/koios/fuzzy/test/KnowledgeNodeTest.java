package org.shadoware.koios.fuzzy.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.shadoware.koios.fuzzy.learning.KnowledgeProperty;
import org.shadoware.koios.fuzzy.learning.WeightedArithmeticNode;

public class KnowledgeNodeTest {
	
	private final int PROPERTY_NAME = 1;
	private final float LEARNING_SPEED = 0.3f;
	
	private WeightedArithmeticNode node;

	@Before
	public void init() {
		node = new WeightedArithmeticNode(-LEARNING_SPEED);
	}
	
	@Test
	public void feedPositives() {
		node.feed(new KnowledgeProperty(PROPERTY_NAME, 0.5f));
		assertTrue(node.getValueOf(PROPERTY_NAME) > 0);
	}
		
	@Test
	public void feedNegatives() {
		node.feed(new KnowledgeProperty(PROPERTY_NAME, 0.8f));
		node.feed(new KnowledgeProperty(PROPERTY_NAME, -0.9f));
		assertTrue(node.getValueOf(PROPERTY_NAME) < 0.8f);
	}
	
	@Test
	public void feedNeutral() {
		node.feed(new KnowledgeProperty(PROPERTY_NAME, 0.8f));
		node.feed(new KnowledgeProperty(PROPERTY_NAME, 0.0f));
		assertTrue(node.getValueOf(PROPERTY_NAME) < 0.8f);
	}
	
}
