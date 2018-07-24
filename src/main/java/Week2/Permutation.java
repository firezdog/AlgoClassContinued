package Week2;

import java.util.Random;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	public static void main(String[] args) {
		
		//Load a specified number of uniformly distributed random ints
		int PermNum = Integer.parseInt(args[0]);
		String[] PermStrs = new String[PermNum];
		int read = 0;
		Random ayn = new Random();
		while (!StdIn.isEmpty()) {
			while (read < PermNum) {
				PermStrs[read++] = StdIn.readString();
			}
			try {
				String candidate = StdIn.readString();
				read++;	
				int random = ayn.nextInt(read);
				if (random <= PermNum) PermStrs[random] = candidate;
			} catch(Exception e) {}
		}
		
		//Permute the specified number of ints
		RandQ<String> q = new RandQ<String>();
		for (String s : PermStrs) {
			q.enqueue(s);
		}
		//Ouput the result.
		for (String s : q) System.out.print(s + " ");
		System.out.println();
	}
}
