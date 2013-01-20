
public class calculator {
	public static void main(String[] args) {
		 String fileName = "story.txt";

		long startTime = System.currentTimeMillis();
		String[] answer = Entry.mostFrequent(fileName);
		long endTime = System.currentTimeMillis();

		for (String s : answer) {
		 System.out.println(s);
		}

		System.out.println("Time = " + (endTime - startTime));
		}

}
