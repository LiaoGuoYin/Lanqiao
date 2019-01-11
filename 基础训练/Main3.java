import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();
		char[] arr = s.toCharArray();
		
		String[] dic_list =new String[] {
				"ling","yi","er","san","si","wu","liu","qi","ba","jiu"
		};
		
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] !='-') {
				int tmp = Integer.valueOf(arr[i]);
				System.out.print(dic_list[tmp]+" ");
			}else if(arr[i] == '-'){
				System.out.print("fu ");
			}
		}
		System.out.print(arr[arr.length-1]);
	}
}