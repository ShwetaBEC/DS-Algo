package datastructures;

class MyArray {
	
	int length;
	String[] data;
	
	public MyArray(){
		this.length = 0;
		this.data = new String[14];
	}
	
	String get(int index) {
		return this.data[index];
	}
	
	void push(String item) {
		this.data[this.length] = item;
		this.length++;
	}
	
	String pop() {
		String removedItem = this.data[this.length];
		//Java Garbage collection will remove the last item here since that is not used by array anymore
		this.length--;
		return removedItem;
	}
	
	String delete(int index) {
		String item = this.data[index];
		shiftItems(index);
		return item;
	}
	
	void shiftItems(int index) {
		for(int i=index; i< this.length-1; i++) {
			this.data[i] = this.data[i+1];
		}
		this.length--;
	}
}

public class MyCustomArray{
	public static void main(String[] args) {
	
		MyArray a = new MyArray();
		a.push("hi ");
		a.push("I ");
		a.push("am ");
		a.push("Shweta");
		a.pop();
		a.delete(1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a.get(i));
		}
	}
}
