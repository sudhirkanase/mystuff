package Java8_Training;

public class Test {

	public static void main(String[] args) {

		printTriangele(10);
		printTriangele1(10);
		printTriangele2(9);
		printTriangele3(9);
		printTriangele4(9);
		printTriangele5(5);
	}

	private static void printTriangele5(int rows) {
		int coef = 1;
		for (int i = 0; i < rows; i++) {
			for (int space = 1; space <= rows - i; space++)
				System.out.print(" ");

			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == 0)
					coef = 1;
				else
					coef = coef * (i - j + 1) / j;

				System.out.print(coef + " ");
			}
			System.out.println();
		}
	}

	private static void printTriangele4(int length) {

		for (int row = 1; row <= length; row++) {

			for (int cnt = length; cnt > row; cnt--) {
				System.out.print(" ");
			}

			boolean decrement = false;
			for (int cnt1 = 1; cnt1 <= row; cnt1++) {
				if (cnt1 % row == 0) {
					decrement = true;
				}
				if (decrement) {
					System.out.print((cnt1 - cnt1 % row - 1) + " ");
				} else {
					System.out.print((cnt1) + " ");
				}
			}
			System.out.println("");
		}

	}

	private static void printTriangele3(int i) {

//		for(int row = i; row > 0; row--) {
//			
//			for(int cnt = i; cnt > row; cnt--) {
//				System.out.print(" ");
//			}
//			
//			for(int cnt1 = 0; cnt1 < row; cnt1++ ) {
//				System.out.print("*");
//			}
//			System.out.println();
//			
//		}

		int rows = 5;

		for (int b = rows; b >= 1; --b) {
			for (int j = 1; j <= b; ++j) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void printTriangele2(int i) {
		for (int row = 1; row <= i; row++) {

			for (int cnt = i; cnt > row; cnt--) {
				System.out.print(" ");
			}
			for (int col = 1; col <= row; col++) {
				System.out.print(col);
			}
			System.out.println();
		}

	}

	private static void printTriangele1(int i) {
		for (int row = 0; row < i; row++) {

			for (int cnt = i; cnt > row; cnt--) {
				System.out.print(" ");
			}
			for (int cnt1 = 0; cnt1 <= row; cnt1++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	private static void printTriangele(int i) {

		for (int cnt = 0; cnt < i; cnt++) {

			for (int j = i; j > cnt; j--) {
				System.out.print(" ");
			}

			for (int cnt1 = 0; cnt1 <= cnt; cnt1++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
}
