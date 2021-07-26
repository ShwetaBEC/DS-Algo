package algorithms;

public class PrintArray {

	public static void main(String[] args) {
		
		//String []nemo = {"nemo"};
		String []people = {"abc", "mnp", "nemo", "john", "millena"};
		
		findNemo(people);
	}
	
	private static void findNemo(String []array) {
		for(int i = 0; i< array.length; i++) {
			if(array[i].equals("nemo")) {
				System.out.print("Fount NEMO!");
			}
		}
	}

}
