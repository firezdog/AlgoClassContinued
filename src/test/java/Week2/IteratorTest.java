package Week2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class IteratorTest {
	
	Bag<String> s = new Bag<String>();
	
	@Test
	void testIteratorWorks() {
		assertNotNull(s.iterator());
	}
	
	@Test
	void testIteratorHasNext() {
		assertFalse(s.iterator().hasNext());
		s.push("Hello");
		assertTrue(s.iterator().hasNext());
	}
	
	@Test
	void testIteratorIterates() {
		s.push("Hello");
		s.push("World");
		s.push("!");
		Iterator<String> i = s.iterator();
		assertEquals(i.next(), "!");
		assertEquals(i.next(),"World");
	}

}
