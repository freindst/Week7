import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Mux m = new Mux();
		String[] input = new String[] {"a0", "a1", "a2", "a3", "a4"};
		m.DisplayTabble(input);
		
		Memory ram = new Memory(4096, 8);
		ram.read(0);
		
		ram.setState(0, 0, 0);
		
		LinkedList<Integer> value = new LinkedList<Integer>();
		for(int i = 0; i < 8; i++) {
			value.add(1);
		}
		
		ram.write(0, value);
		ram.read(0);
		
		ram.setState(0, 0, 1);
		ram.write(0, value);
		ram.read(0);
		
		ram.setState(0, 1, 0);
		ram.read(0);
		
	}

}
