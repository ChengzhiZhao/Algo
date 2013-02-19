package algoHw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = read("input/sample");
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void quickSort(int[] a) {
		sort(a, 0, a.length -1);
	}
	
	private static void sort(int[] a, int l, int r) {
		if( l < r) {
			int q = partitionFirst(a, l, r);
			sort(a, l, q-1);
			sort(a, q+1, r);
		}
	}
	
	private static int partitionFirst(int[] a, int p, int r) {
		int pivot = p;
		int i = p + 1;
		for (int j = i; j <= r; ++j) {
			if (a[j] < a[pivot]) {
				swap(a, i++, j);
			}
		}
		swap(a, pivot, i-1);
		return i - 1;

	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static int[] read(String filename) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Integer> input = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			input.add(scanner.nextInt());
		}
		int[] ret = new int[input.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = input.get(i).intValue();
		}
		return ret;
	}

}
