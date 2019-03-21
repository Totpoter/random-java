import java.util.ArrayList;
import java.util.Scanner;
public class secure_doors {
    private ArrayList<String> checkedIn;

    public static void main(String[] args) {
	new secure_doors();
    }

    public secure_doors() {
	readDataAnalyzePrint();
    }

    private void readDataAnalyzePrint() {
	Scanner input = new Scanner(System.in);
	checkedIn = new ArrayList<String>();
	int logAmount = Integer.parseInt(input.nextLine());
	for (int i = 0; i < logAmount; i++) {
	    String[] entry = input.nextLine().split(" ");

	    if (entry[0].equals("entry") && checkedIn.contains(entry[1])) {
		System.out.println(entry[1] + " entered (ANOMALY)");
	    } else if (entry[0].equals("exit")
		    && !checkedIn.contains(entry[1])) {
		System.out.println(entry[1] + " entered (ANOMALY)");
	    } else if (entry[0].equals("entry")) {
		checkedIn.add(entry[1]);
		System.out.println(entry[1] + " entered");
	    } else {
		checkedIn.remove(entry[1]);
		System.out.println(entry[1] + " exited");
	    }
	}
	input.close();
    }

}