package sorting.variationsOfBubblesort;

import java.util.Arrays;

public class tes {

	public static void main(String[] args) {
		RecursiveBubbleSort<Integer> t = new RecursiveBubbleSort();
		
		Integer[] array = {4, 15, 25, 30, 8, 20, 28};
		t.sort(array);
		System.out.println(Arrays.toString(array)); 

	}

}
