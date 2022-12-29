package adt.heap.extended;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		HeapMergeImpl t = new HeapMergeImpl();
		
		Integer[] array = {1,3,5,7,9,11,13,15,17};
		
		for(int i = 0; i < array.length; i++) {
			t.add(array[i]);
		}
		
		System.out.println(t.sumRange(3, 8));

	}

}
