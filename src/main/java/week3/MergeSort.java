package week3;

public class MergeSort {

	private static void sort(int[] a, int[] aux, int lo, int hi) {
		//performance tweak (missing): s
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		//performance tweak: only merge if the right half does not pick up where the left half leaves off, i.e. if first right is lower than last left
		//if the first right is higher than the last left, then, since each side is sorted, the array is already in order
		if (!(a[mid+1] < a[mid])) return;
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(int[] a) {
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length -1);
	}
	
	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		
		//pre -- each half is sorted
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		//copy contents of a[] into aux[] -- first index is lo, last index is hi b/c a[] will be a much larger array?
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (aux[j] < aux[i]) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
		//post -- all is sorted
		assert isSorted(a, lo, hi);
		
	}

	private static boolean isSorted(int[] a, int lo, int hi) {
		for (int i = lo; i < hi-1; i++) {
			if (a[i] > a[i+1]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] test = {1,-1000,100,3,4,1,-5,0,11};
		sort(test);
		for (int i: test) System.out.print(i + ", ");
	}
}
