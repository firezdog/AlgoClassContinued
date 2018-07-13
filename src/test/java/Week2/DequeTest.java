package Week2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DequeTest {
	
	private Deque<String> d;
	
	@BeforeEach
	void setup() {
		d = new Deque<String>();
	}
	
	@Test
	void testIsEmpy() {
		assertTrue(d.isEmpty());
		d.addFirst("Hello");
		assertFalse(d.isEmpty());
	}
	
	@Test
	void testAddFirstChangesFirst() {
		d.addFirst("world");
		d.addFirst("hello");
		assertEquals(d.getFirst().item, "hello");
	}
	
	@Test
	void testAddLastChangesLast() {
		d.addLast("hello");
		d.addLast("world");
		assertEquals(d.getLast().item, "world");
	}

}
