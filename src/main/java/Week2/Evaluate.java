package Week2;

import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) { 
        Stack<String> ops  = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("));
            // I had to add this as a hack because StdIn.isEmpty() is never true?
            else if (s.equals("T")) {
            	StdOut.println(vals.pop());
            	break;
            }
            else if (s.equals("+"))    	ops.push(s);
            else if (s.equals("-"))    	ops.push(s);
            else if (s.equals("*"))    	ops.push(s);
            else if (s.equals("/")) 	ops.push(s);
            else if (s.equals("sqrt")) 	ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if      (op.equals("+"))    v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }
    }
}