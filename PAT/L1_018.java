import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		Double time = Double.parseDouble(str.replace(":", "."));

		if (time <= 12.00) {
			System.out.format("Only %s.  Too early to Dang.", str);
		} else if (str.split(":")[1].equals("00")) {
			for (int i = 1; i <= (int) (time - 12); i++) {
				System.out.print("Dang");
			}
		} else {
			for (int i = 1; i <= (int) (time - 11); i++) {
				System.out.print("Dang");
			}
			System.out.println((int) (time - 11));
		}
	}
}
// 要将整点的情况特殊考虑,恶星星..