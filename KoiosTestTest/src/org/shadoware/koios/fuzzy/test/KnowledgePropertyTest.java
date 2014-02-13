package org.shadoware.koios.fuzzy.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.shadoware.koios.fuzzy.learning.KnowledgeProperty;

public class KnowledgePropertyTest {
	
	private List<KnowledgeProperty> properties;
	
	@Before
	public void init() {
		properties = new ArrayList<KnowledgeProperty>();
		properties.add(new KnowledgeProperty(0, -0.234f));
		properties.add(new KnowledgeProperty(1, 0.234f));
		properties.add(new KnowledgeProperty(-2, -1.0f));
		properties.add(new KnowledgeProperty(3, 1.0f));
		properties.add(new KnowledgeProperty(4, -1.12323f));
		properties.add(new KnowledgeProperty(5, 1.123123f));
	}
	
	@Test
	public void valueLimitsTest() {
		for (KnowledgeProperty property : properties) {
			assertTrue(property.value() >= 0.0f && property.value() <= 1.0f);
		}
	}
	
	@Test
	public void storeTest() {
		KnowledgeProperty property = properties.get(0);
		assertTrue(property.id() == 0);
		System.out.println(property.value());
		assertTrue(property.value() == 0.0f);
	}
}
