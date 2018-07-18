package Week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeAttempt2<Item> implements Iterable<Item> {

	class Node {
		Item item;
		Node next;
		Node prev;
	}
	
	private Node first;
	public Node getFirst() {
		return first;
	}
	
	private Node last;
	public Node getLast() {
		return last;
	}

	private int size;
	public int getSize() {
		return size;
	}
	
	
	public DequeAttempt2() {
		first = null;
		last = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		size++;
		if (first == null) {
			first = new Node();
			first.item = item;
			last = first;
		} else if (first == last) {
			first = new Node();
			first.item = item;
			first.next = last;
			last.prev = first;
		} else {
			Node old = first;
			first = new Node();
			first.item = item;
			first.next = old;
			old.prev = first;
		}
	}
	
	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		size++;
		if (last == null) {
			last = new Node();
			last.item = item;
			first = last;
		} else if (last == first) {
			last = new Node();
			last.item = item;
			first.next = last;
			last.prev = first;
		} else {
			Node old = last;
			last = new Node();
			last.item = item;
			old.next = last;
			last.prev = old;
		}
	}
	
	public Item removeFirst() {
		size--;
		if (first == null) throw new NoSuchElementException();
		else if (first == last) {
			Item item = first.item;
			first = null;
			last = null;
			return item;
		} else {
			Item item = first.item;
			first = first.next;
			return item;
		}
	}
	
	public Item removeLast() {
		size--;
		if (last == null) throw new NoSuchElementException();
		else if (first == last) {
			Item item = last.item;
			first = null;
			last = null;
			return item;
		} else {
			Item item = last.item;
//			Node walker = first;
//			while (walker.next != last) {
//				walker = walker.next;
//			}
//			last = walker;
			last = last.prev;
			last.next = null;
			return item;
		}
	}
	
	@Override
	public Iterator<Item> iterator() { return new DequeIterator(); }
	
	private class DequeIterator implements Iterator<Item>
	{
		private Node current = first;
		
		@Override
		public boolean hasNext() { return current != null; }
		
		@Override
		public void remove() { throw new UnsupportedOperationException(); }
		
		@Override
		public Item next() {
			if (current == null) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

}
