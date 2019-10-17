import java.util.LinkedList;

public class CompositeMemoryVertical {
	private Memory[] chips;
	private int size;
	private int bitwidth;
	
	public CompositeMemoryVertical(int chip, int size, int bitwidth) {
		chips = new Memory[chip];
		for(int i = 0; i < chip; i++) {
			chips[i] = new Memory(size, bitwidth);
		}
		this.size = size;
		this.bitwidth = bitwidth;
	}
	
	public void write(int address, LinkedList<Integer> value) {	
		int[] position = this.GetMemoryByAddress(address);
		Memory curr = this.chips[position[1]];
		curr.write(position[0], value);
	}
	
	public LinkedList<Integer> read(int address) {
		int[] position = this.GetMemoryByAddress(address);
		Memory curr = this.chips[position[1]];
		return curr.read(position[0]);
	}
	
	public void setState(int address, int ren, int wen) {
		int[] position = this.GetMemoryByAddress(address);
		Memory curr = this.chips[position[1]];
		curr.setState(position[0], ren, wen);
	}
	
	private int[] GetMemoryByAddress(int address) {
		int[] returnVal = new int[2];
		returnVal[0] = address % this.size;
		returnVal[1] = address / this.size;
		return returnVal;
	}
}
