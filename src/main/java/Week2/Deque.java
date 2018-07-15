package Week2;

import java.util.Iterator;

//First attempt -- end and beginning chains not connecting properly

public class Deque<Item> implements Iterable<Item> {
	
	private Node<Item> first;
	public Node<Item> getFirst() {
		return first;
	}

	public Node<Item> getLast() {
		return last;
	}

	private Node<Item> last;
	private int size;
	
	class Node<Item> {
		Item item;
		Node<Item> next;
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
		Node<Item> old = first;
		if (first == last) last = old;
		first = new Node<Item>();
		if (last == old) {
			first.next = last;
		}
		first.item = item;
		first.next = old;
		size++;
	}
	
	public void addLast(Item item) {
		Node<Item> old = last;
		last = new Node<Item>();
		last.item = item;
		if (old == null);
		else if (first == old) {
			first.next = last;
		}
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
		Node<Item> walker = first;
		for (int i = 0; i < this.size()-2; i++) {
			walker = walker.next;
		}
		last = walker;
		size--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() { return new DequeIterator(); }
	
	private class DequeIterator implements Iterator<Item>
	{
		private Node<Item> current = first;
		
		@Override
		public boolean hasNext() { return current != null; }
		
		@Override
		public void remove() { /* not supported */ }
		
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
}
