import java.util.LinkedList;
import java.util.Stack;


public class Mux {
	private String selector = "s";
	public void DisplayTabble(String[] input) {
		int selectorCount = 0;
		int support = 1;
		while(support < input.length) {
			selectorCount++;
			support *= 2;
		}
		if (selectorCount == 0) {
			selectorCount = 1;
		}
		String output = "";
		if (input.length > 0) {
			for(int i = 0; i < selectorCount; i++) {
				output += selector + i + "\t";
			}
			output += "|\ty\n";
			output += "\n";
			for(int i = 0; i < input.length; i++) {
				LinkedList<Integer> binary = Int2Binary(i, selectorCount);
				for(int bit: binary) {
					output += bit + "\t";
				}
				output += "|\t" + input[i] + "\n";
			}
		}
		System.out.print(output);
	}
	
	private LinkedList<Integer> Int2Binary(int input, int numberDigit){
		LinkedList<Integer> result = new LinkedList<Integer>();
		Stack<Integer> temp = new Stack<Integer>();
		int remain = input;
		int mod = 0;
		while (remain > 0) {
			mod = remain % 2;
			temp.push(mod);
			remain = (remain - mod) / 2;			
		}
		while (numberDigit > temp.size()) {
			temp.push(0);
		}
		while(temp.size() > 0) {
			result.add(temp.pop());
		}
		return result;
	}
}
