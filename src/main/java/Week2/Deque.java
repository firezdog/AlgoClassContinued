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
		if (first == last) last = old;
		first = new Node();
		first.item = item;
		first.next = old;
		size++;
	}
	
	public void addLast(Item item) {
		Node old = last;
		if (first == last) first = old;
		last = new Node();
		last.item = item;
		if (old == null);
		else {
			old.next = last;			
		}
		size++;
		if (first == null) first = last;
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
		System.out.println(walker.next == last);
		while (walker.next != last) {
			walker = walker.next;
		}
		last = walker;
		size--;
		return item;
	}
	
//	public Iterator<Item> iterator() {
//		
//	}
	
}
