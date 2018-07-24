package Week2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandQ<Item> implements Iterable<Item> {
	
	private class Node {
		Item item;
		Node next;
		
		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
		
	}
	
	private Node head;
	private int size;
	
	public RandQ() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(Item item) {
		if (item == null) throw new IllegalArgumentException();
		Node old = head;
		head = new Node(item,old);
		size++;
	}
	
	public Item dequeue() {
		if (head == null) throw new NoSuchElementException();
		Random ayn = new Random();
		if (size == 1) {
			Item item = head.item;
			head = null;
			size--;
			return item;
		} else {
			int chosen = ayn.nextInt(size);
			Node walker = head;
			for (int i = 0; i < chosen -1; i++) {
				walker = walker.next;
			}
			Item item = walker.next.item;
			walker.next = walker.next.next;
			size--;
			return item;
		}
	}
	
	public Item sample() {
		if (head == null) throw new NoSuchElementException();
		Random ayn = new Random();
		int chosen = ayn.nextInt(size);
		Node walker = head;
		for (int i = 0; i < chosen; i++) {
			walker = walker.next;
		}
		return walker.item;
	}
	
	public Iterator<Item> iterator() {
		return new RandIterator();
	}
	
	private class RandIterator implements Iterator<Item>
	{

		private DequeAttempt2<Item> d; 
		
		Random ayn = new Random();
		private Iterator<Item> i;
		
		public RandIterator() {
			d = new DequeAttempt2<Item>();
			Node walker = head;
			while (walker != null) {
				int bool = ayn.nextInt(2);
				if (bool == 0) {
					d.addFirst(walker.item);
				} else {
					d.addLast(walker.item);
				}
				walker = walker.next;
			}
			i = d.iterator();
		}
		
		@Override
		public boolean hasNext() {
			return i.hasNext();
		}
		
		@Override
		public void remove() { throw new UnsupportedOperationException(); }
		
		@Override
		public Item next() {
			return i.next();
		}
	
	}
	
}
