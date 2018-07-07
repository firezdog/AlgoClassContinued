package Week2;

import java.util.Iterator;

public class GenericArrayStack<Item> {
	private Item[] s;
	private int last = 0;
	
	public GenericArrayStack(int capacity) 
	{	s = (Item[]) new Object[capacity]; }
	
	public boolean isEmpty() 
	{	return last == 0; }
	
	public void push(Item item) 
	{	s[last++] = item; }
	
	public Item pop() 	{	
		if (last == 0) { return null; }
		return s[--last];	
	}
	
	public Iterator<Item> iterator()
	{ return new ReverseArrayIterator(); }
	
	
	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i = last;
		
		public boolean hasNext() { return i > 0; }
		public void remove() { /* not supported */ }
		public Item next() { return s[--i]; }
	}
	
}
