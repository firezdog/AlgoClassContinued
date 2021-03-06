package Week2;

import java.util.Iterator;

public class GenericStack<Item> implements Iterable<Item> {
	
	private Node first = null;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	public Item pop() {
		if (isEmpty()) return null;
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public Iterator<Item> iterator() { return new ListIterator(); }
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		
		public boolean hasNext() { return current != null; }
		public void remove() { /* not supported */ }
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
}
