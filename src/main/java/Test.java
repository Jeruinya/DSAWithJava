import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		if (n >= 1 && n <= 10) {
			for (int i = 0; i < n; i++) {

				int a = s.nextInt();
				boolean flag = false;
				for (int j = 1; j * j <= a; j++) {
					if (j * j == a) {
						flag = true;
						break;
					}

				}

				if (flag == true)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}

	}
}