import java.util.LinkedList;

public class CompositeMemoryHorizontal {
	private Memory[] chips;
	private int size;
	private int bitwidth;
	
	public CompositeMemoryHorizontal(int chip, int size, int bitwidth) {
		chips = new Memory[chip];
		for(int i = 0; i < chip; i++) {
			chips[i] = new Memory(size, bitwidth);
		}
		this.size = size;
		this.bitwidth = bitwidth;
	}
	
	public void write(int address, LinkedList<Integer> value) {		
		for(int i = 0; i < chips.length; i++) {
			Memory curr = chips[i];
			LinkedList<Integer> currVal = new LinkedList<Integer>();
			for(int j = this.size * i; j < this.size; j++) {
				currVal.add(value.get(j));
			}
			curr.write(address, currVal);
		}
	}
	
	public LinkedList<Integer> read(int address) {
		LinkedList<Integer> returnVal = new LinkedList<Integer>();
		for(int i = 0; i < chips.length; i++) {
			Memory curr = chips[i];
			for(int j = 0; j < this.bitwidth; j++) {
				returnVal.add(curr.read(address).get(j));
			}
		}
		return returnVal;
	}

	public void setState(int address, int ren, int wen) {
		for(int i = 0; i < chips.length; i++) {
			Memory curr = chips[i];
			for(int j = 0; j < this.bitwidth; j++) {
				curr.setState(address, ren, wen);
			}
		}
	}
}
