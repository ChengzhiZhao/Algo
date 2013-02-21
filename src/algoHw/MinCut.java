package algoHw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MinCut {
	private static final int N = 8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = read("input/sample");
		Graph g = new Graph(arr);
		System.out.println(g.toString());

	}
	public static int[][] read(String filename) {
		int[][] ret = new int[8][];
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String[] tmp = scanner.nextLine().split(" ");
			int[] row = new int[tmp.length];
			for(int i = 0; i < tmp.length; ++i){
				row[i] = Integer.parseInt(tmp[i]);
			}
			ret[row[0] - 1] = row;
		}
		scanner.close();
		return ret;
	}
	
	private static void print(int[][] a){
		for(int[] arr : a){
			System.out.println(Arrays.toString(arr));
		}
	}
}
