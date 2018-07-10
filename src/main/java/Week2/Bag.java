package Week2;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

	private Node first = null;
	public int size = 0;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public Iterator<Item> iterator() { return new BagIterator(); }
	
	private class BagIterator implements Iterator<Item> {
		
		Node iterator = first;
		
		public boolean hasNext() {
			return size > 0;
		}

		public Item next() {
			Item item = iterator.item;
			iterator = iterator.next;
			return item;
		}
		
	}

}
