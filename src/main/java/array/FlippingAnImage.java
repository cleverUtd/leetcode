package array;

public class FlippingAnImage {

	public static int[][] flipAndInvertImage(int[][] A) {
		int i,j,temp;
		for (int[] ints : A) {
			i=0;j=ints.length-1;
			while (i<j) {
				ints[i] = ints[i] == 1 ? 0 : 1;
				ints[j] = ints[j] == 1 ? 0 : 1;
				temp = ints[i];
				ints[i] = ints[j];
				ints[j] = temp;

				i++;
				j--;
			}

			if (i == j) {
				ints[i] = ints[i] == 1 ? 0 : 1;
			}
		}

		return A;
	}


	public static void print(int[][] A) {
		for (int[] ints : A) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}

			System.out.println();
		}

		System.out.println();
	}

	public static void main(String[] args) {
		print(flipAndInvertImage(new int[][]{{1},{1},{0}}));
		print(flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}));
	}
}
