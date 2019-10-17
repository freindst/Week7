import java.util.LinkedList;

public class Memory {
	private LinkedList<MemoryBucket> buckets;
	private int bitwidth = 0;
	
	public Memory(int size, int bitwidth) {
		this.bitwidth = bitwidth;
		buckets = new LinkedList<MemoryBucket>();
		for(int i = 0; i < size; i++) {
			MemoryBucket mb = new MemoryBucket(i, bitwidth);
			buckets.add(mb);
		}
	}
	
	public LinkedList<Integer> read(int address) {
		MemoryBucket mb = lookForBucket(address);
		System.out.println(mb.toString());
		return mb.getContent();
	}
	
	public void write(int address, LinkedList<Integer> value) {
		MemoryBucket mb = lookForBucket(address);
		mb.setContent(value);
	}
	
	public void setState(int address, int ren, int wen) {
		MemoryBucket mb = lookForBucket(address);
		String output = "";
		output += "@" + mb.getAddress();
		if (mb.getRen() != ren) {
			output += "\tren:" + mb.getRen() + "->" + ren;
		}
		mb.setRen(ren);
		if (mb.getWen() != wen) {
			output += "\twen:" + mb.getWen() + "->" + wen;
		}
		mb.setWen(wen);
		System.out.println(output);
	}
	
	private MemoryBucket lookForBucket(int address) {
		if (address > this.bitwidth) {
			throw new RuntimeException("Memory overflow!");
		}
		else {
			return buckets.get(address);
		}
	}
}
