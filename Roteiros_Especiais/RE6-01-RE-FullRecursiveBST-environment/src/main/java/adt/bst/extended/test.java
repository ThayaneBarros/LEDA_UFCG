package adt.bst.extended;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		FullRecursiveBSTImpl<Integer> t = new FullRecursiveBSTImpl<>();
		
		Integer[] array = {50, 30, 70, 20, 40,60, 80};
		
		for(int i = 0; i < array.length; i++) {
			t.insert(array[i]);
		}

		
		System.out.println(Arrays.toString(t.elementsAtDistance(1)));
		

	}

}
