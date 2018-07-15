package Week2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Week2.Deque.Node;

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
	
	@Test
	void testFirstLastInteraction() {
		d.addFirst("Hello");
		d.addLast("world");
		assertEquals(d.getFirst().next.item, "world");
		assertEquals(d.getFirst().item,"Hello");
		assertEquals(d.getLast().item, "world");
		d.addFirst("Well");
		d.addLast("!");
		assertEquals(d.getFirst().item,"Well");
		assertEquals(d.getLast().item, "!");
	}
	
	@Test
	void testRemoveFirst() {
		d.addFirst("hello");
		d.addFirst("well");
		assertEquals(d.removeFirst(),"well");
		assertEquals(d.removeFirst(), "hello");
	}
	
	@Test
	void testRemoveLast() {
		d.addLast("well");
		d.addLast("hello");
		assertEquals(d.removeLast(),"hello");
		assertEquals(d.removeLast(),"well");
	}
	
	@Test
	void testSizeIncreases() {
		d.addFirst("well");
		assertEquals(d.size(),1);
		d.addLast("hello");
		assertEquals(d.size(),2);
	}
	
	@Test
	void testSizeDecreases() {
		d.addFirst("well");
		d.addLast("hello");
		d.removeLast();
		assertEquals(d.size(),1);
		d.removeFirst();
		assertEquals(d.size(), 0);
	}
	
	@Test
	void testIterator() {
		d.addFirst("well");
		d.addFirst("world");
		d.addFirst(",");
		d.addLast("hello");
		String s = "";
		for(String n : d) {
			s += n + " ";
		}
		System.out.println(s);
	}

}
