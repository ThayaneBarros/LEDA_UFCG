import java.util.Arrays;

import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class test {

	public static void main(String[] args) {
		RecursiveSelectionSort<Integer> t = new RecursiveSelectionSort();
		
		Integer[] array = {4, 15, 25, 30, 8, 20, 28};
		t.sort(array);
		System.out.println(Arrays.toString(array)); 
		

	}

}
