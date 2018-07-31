package week3;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Example of a sort class.

public class Selection {

	public static void sort(Comparable<Integer>[] a) 
	{
		
		assert !isSorted(a);
		
		for (int i = 0; i < a.length; i++) {
			int smallestIndex = i;
			for (int j = i; j < a.length; j++) {
				if (less(a[j],a[smallestIndex])) smallestIndex = j;
			}
			if (i != smallestIndex) exch(a, i, smallestIndex);
			
		}
		
		assert isSorted(a);
		
	}
	
	private static boolean less(Comparable<Integer> a, Comparable<Integer> a2) 
	{ return a.compareTo((Integer) a2) < 0; }
	
	private static void exch(Comparable<Integer>[] a, int i, int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
	
	private static void show(Comparable<Integer>[] a) 
	{ //print the array on one line
		for (int i=0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean isSorted(Comparable<Integer>[] a) 
	{ //test whether array is sorted.
		for (int i = 1; i < a.length; i++) {
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) 
	{ //read strings from standard input, sort them, then print.
		int[] input = StdIn.readAllInts();
		Integer[] a = new Integer[input.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = (Integer) input[i];
		}
		sort(a);
		show(a);
	}

}
