import java.util.LinkedList;

public class MemoryBucket {
	public void setRen(int ren) {
		this.ren = ren;
	}
	
	public int getRen() {
		return this.ren;
	}

	public void setWen(int wen) {
		this.wen = wen;
	}
	
	public int getWen() {
		return this.wen;
	}

	public void setContent(LinkedList<Integer> content) {
		if (this.wen == 1 && this.ren  == 0) {
			if (content.size() > this.size) {
				throw new RuntimeException("Content wrong bitwidth");
			}
			this.content = content;
		}		
	}

	public int getAddress() {
		return address;
	}

	public Boolean isReadable() {
		return ren == 1;
	}

	public Boolean isWritable() {
		return wen == 1;
	}

	public LinkedList<Integer> getContent() {
		if (this.ren == 1) {
			return content;
		} else {
			LinkedList<Integer> returnVal = new LinkedList<Integer>();
			for(int i = 0; i < this.size; i++) {
				returnVal.add(0);
			}
			return returnVal;
		}
	}

	private int address;
	private int ren;
	private int wen;
	private LinkedList<Integer> content;
	private int size;
	
	public MemoryBucket(int address, int size) {
		this.address = address;
		this.size = size;
		this.content = new LinkedList<Integer>();
		for(int i = 0; i < size; i++) {
			content.add(0);
		}
		this.ren = 1;
		this.wen = 1;
	}

	@Override
	public String toString() {
		String output = "";
		output += "@" + this.address + ":" + this.getContent();
		output += "\tren:" + this.ren + "\twen:" + this.wen;
		return output;
	}
}
