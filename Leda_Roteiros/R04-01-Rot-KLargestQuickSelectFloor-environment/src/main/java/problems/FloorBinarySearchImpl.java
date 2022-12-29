package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {
	
	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(checkEntry(array, x)) {
			return floorBinarySearch(array, x, 0, array.length - 1);
		}
		return null;	
	}

	private Integer floorBinarySearch(Integer[] array, Integer x, int left, int right) {
		Integer floor = null;
		if (left <= right) {    
			int indexPivot = partition(array, left, right);
	        
	        if (array[indexPivot] == x) {
	        	floor = array[indexPivot];
	        }

	        if (array[indexPivot] > x) {
	        	return floorBinarySearch(array, x, left, indexPivot - 1);
	        }else if(array[indexPivot] < x) {
	        	floor = floorBinarySearch(array, x, indexPivot + 1, right);
	        	if(floor == null) {
	        		floor = array[indexPivot];
	        	}
	        }
	        
		}
		return floor;
	
}

	private int partition(Integer[] array, int left, int right) {
		pickPivotIndex(array, left, right);
		int pivot = array[left];
		int i = left;
		
		for(int j = left + 1; j <= right; j++) {
			if(array[j] <= pivot) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, left, i);
		return i;
	}

	private void pickPivotIndex(Integer[] array, int left, int right) {
		int mid = (left + right) / 2;
		
		if(array[left] > array[mid]) {
			Util.swap(array, left, mid);
		}
		if(array[mid] > array[right]) {
			Util.swap(array, mid, right);
		}
		if(array[left] > array[mid]) {
			Util.swap(array, left, mid);
		}
		
		Util.swap(array, left, mid);
	}

	private boolean checkEntry(Integer[] array, Integer x) {
		return (array != null && array.length > 0 && x != null);
	}

}
