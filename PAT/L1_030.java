import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		ArrayList<String> boy = new ArrayList<>();
		ArrayList<String> gril = new ArrayList<>();
		scanner.nextLine();
		int[] order = new int[N / 2];

		for (int i = 0; i < N; i++) {
			String str = scanner.nextLine();
			int sex = Integer.parseInt(str.split(" ")[0]);// get性别参数

			if (i < N / 2)
				order[i] = sex;// 获取正向顺序

			String name = str.split(" ")[1];// get名字

			if (sex == 0)
				gril.add(name);
			else if (sex == 1)
				boy.add(name);
		}

		int countboy = 0, countgril = 0;
		// System.out.println(Arrays.toString(order));
		for (int i = 0; i < boy.size(); i++) {
			if (order[i] == 0) {
				System.out.println(gril.get(countgril) + " " + boy.get(boy.size() - countgril - 1));
				countgril++;
			}
			if (order[i] == 1) {
				System.out.println(boy.get(countboy) + " " + gril.get(gril.size() - countboy - 1));
				countboy++;
			}
		}
	}
}
// 我这解法有点暴力，真正意义上它想考察的应该是 队列