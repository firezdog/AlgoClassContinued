package Week2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandQTest {
	
	private RandQ<String> q;
	
	@BeforeEach
	void setup() {
		q = new RandQ<String>();		
	}
	
	@Test
	void testIsEmpty() {
		assertTrue(q.isEmpty());
		q.enqueue("hello");
		assertFalse(q.isEmpty());
	}
	
	@Test
	void testEnqueue() {
		q.enqueue("hello");
		q.enqueue("world");
		assertEquals(2,q.size());
	}
	
	@Test
	void testExceptions() {
		assertThrows(IllegalArgumentException.class, () -> {
			q.enqueue(null);
		});
		assertThrows(NoSuchElementException.class, () -> {
			q.dequeue();
		});
		assertThrows(NoSuchElementException.class, () -> {
			q.sample();
		});
	}
	
	@Test
	void testSample() {
		//no way to determine if it's random -- just print the output.
		q.enqueue("hello");
		q.enqueue("world");
		q.enqueue("!");
		System.out.println("=====TEST SAMPLE=======");
		System.out.println(q.sample());
		System.out.println(q.sample());
		System.out.println(q.sample());
	}
	
	@Test
	void testDequeueHead() {
		//test removal for one item
		q.enqueue("hello");
		assertEquals("hello", q.dequeue());
	}
	
	@Test
	void testDequeueMany() {
		System.out.println("=====TEST DEQUEUE=======");
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");
		q.enqueue("5");
		q.enqueue("6");
		q.enqueue("7");
		q.enqueue("8");
		q.enqueue("9");
		q.enqueue("0");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
