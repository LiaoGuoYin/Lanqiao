import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();

		// input data
		for (;;) {
			String str = scanner.nextLine();
			if (str.equals("."))
				break;
			else
				arr.add(str);
		}

		// output
		if (arr.size() <= 1)
			System.out.print("Momo... No one is for you ...");
		else if (arr.size() <= 13)
			System.out.format("%s is the only one for you...", arr.get(1));
		else
			System.out.format("%s and %s are inviting you to dinner...", arr.get(1), arr.get(13));
	}
}
// 因为输入的数据不固定，用ArrayList
// 注意情况节点要考虑完整