package binarySearch;

public class PeakIndexInAMountainArray {

	public static int peakIndexInMountainArray(int[] A) {
		if (A.length == 3) {
			return 1;
		}

		int left = 0;
		int right = A.length - 1;
		int mid;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			}

			if (A[mid] > A[mid - 1]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}


	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
		System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));
		System.out.println(peakIndexInMountainArray(new int[]{0,2,3,4,3,2,1,0}));
		System.out.println(peakIndexInMountainArray(new int[]{0,2,3,4,5,6,1,0}));
	}
}
