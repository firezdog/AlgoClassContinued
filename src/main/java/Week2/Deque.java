package Week2;

import java.util.Iterator;

public class Deque<Item> {
	
	private Node first;
	public Node getFirst() {
		return first;
	}

	public Node getLast() {
		return last;
	}

	private Node last;
	private int size;
	
	class Node {
		Item item;
		Node next;
	}
	
	public Deque() {
		first = null;
		last = first;
		size = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
		size++;
	}
	
	public void addLast(Item item) {
		Node old = last;
		last = new Node();
		last.item = item;
		if (old == null);
		else {
			old.next = last;			
		}
		size++;
	}
	
	public Item removeFirst() {
		Item item = first.item;
		first = first.next;
		size--;
		return item;
	}
	
	public Item removeLast() {
		Item item = last.item;
		Node walker = first;
		while (walker != last && walker.next != last) {
			walker = walker.next;
		}
		last = walker;
		last.next = null;
		size--;
		return item;
	}
	
//	public Iterator<Item> iterator() {
//		
//	}
	
}
