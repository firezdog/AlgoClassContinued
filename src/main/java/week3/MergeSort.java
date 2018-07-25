package week3;

public class MergeSort {

	public static int[] merge(int[] a, int[] aux, int lo, int mid, int hi) {
		//pre -- each half is sorted
//		assert isSorted(a, lo, mid);
//		assert isSorted(a, mid+1, hi);
		
		//copy contents of a[] into aux[] -- first index is lo, last index is hi b/c a[] will be a much larger array?
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		//method: walk through the two halves with i and j; walk through aux[] with k
		//	1) if aux[i] is less, put it in a[k] and advance i
		//	2) if aux[i] is equal, put it and aux[j] in a[k], a[k+1] and advance both
		//	3) if aux[i] is greater, put aux[j] in a[k] and advance j
		//	**Don't put the other one in yet -- you don't know what comes after i
		int i = lo, j = mid+1;
		int k = lo;
		while(i <= mid) {
			if(aux[i] < aux[j]) a[k++] = aux[i++];
			else if (aux[i] == aux[j]) { a[k++] = aux[i]; a[k++] = aux[j];}
			else a[k++] = aux[j++];
		}
		
		return a;
		
		//post -- all is sorted
//		assert isSorted(a, lo, hi);
	}

	private boolean isSorted(int[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		int[] test = merge(new int[] {1,5,7,10,2,3,12,13}, new int[8], 0, 3, 7);
		for (int i: test) System.out.println(i);
	}
}
