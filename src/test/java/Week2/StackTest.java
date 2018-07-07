package Week2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StackTest {
	
	private GenericArrayStack<String> s;
	
	@BeforeEach
	void setup() {
		s = new GenericArrayStack<String>(10);
	}
	
	@DisplayName("isEmpty returns true when empty")
	@Test
	void isEmptyReturnsTrue() {
		assertTrue(s.isEmpty());
	}
	
	@DisplayName("isEmpty returns false when not empty")
	@Test
	void isEmptyReturnsFalse() {
		s.push("Hello");
		assertFalse(s.isEmpty());
	}
	
	@DisplayName("pop returns the latest item")
	@Test
	void popLatest() {
		s.push("Hello");
		s.push("World");
		assertEquals(s.pop(), "World");
	}
	
	@DisplayName("Pop returns void when stack is empty")
	@Test
	void popEmpty() {
		assertEquals(s.pop(), null);
	}

}
