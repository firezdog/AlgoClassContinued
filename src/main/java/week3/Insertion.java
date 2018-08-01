package week3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Example of a sort class.

public class Insertion {

	public static void sort(Comparable[] a) 
	{ 	
		int N = a.length;
		for (int i = 1; i < N; i++) {
			
			Comparable toCompare = a[i];
			
//			A yet more efficient version? -- just move larger entries one to the right and replace at the end
			int j = i;
			while(j > 0 && less(toCompare,a[j-1])) { 
				a[j] = a[j-1];
				j--;
			}
			a[j] = toCompare;
			
//			A more efficient version -- go from back and stop checking when elements are in order
//			for (int j = i; j > 0 && less(a[j],a[j-1]); j--) exch(a, j, j-1);
			
//			for (int j = 0; j < i; j++) {
//				if (less(toCompare,a[j])) exch(a, i, j);
//			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) 
	{ return v.compareTo(w) < 0; }
	
	private static void exch(Comparable[] a, int i, int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
	
	private static void show(Comparable[] a) 
	{ //print the array on one line
		for (int i=0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
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
