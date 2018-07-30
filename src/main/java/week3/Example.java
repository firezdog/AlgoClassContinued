package week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Example of a sort class.

public class Example {

	public static void sort(Comparable[] a) 
	{ 		/*sorting method goes here*/	}
	
	private static boolean less(Comparable v, Comparable w) 
	{ return v.compareTo(w) < 0; }
	
	private static void exch(Comparable[] a, int i, int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
	
	private static void show(Comparable[] a) 
	{ //print the array on one line
		for (int i=0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
			StdOut.println();
		}
	}
	
	public static boolean isSorted(Comparable[] a) 
	{ //test whether array is sorted.
		for (int i = 1; i < a.length; i++) {
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) 
	{ //read strings from standard input, sort them, then print.
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
