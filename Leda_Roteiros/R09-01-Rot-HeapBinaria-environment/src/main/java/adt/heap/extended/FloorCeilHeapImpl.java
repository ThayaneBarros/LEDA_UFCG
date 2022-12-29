package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		if(array != null) {
			for(int i = 0; i < array.length; i++) {
				this.insert(array[i]);
			}	
		}
		return recursiveFloor(numero, null);
	}

	private Integer recursiveFloor(double numero, Integer floor) {
		Integer value = this.extractRootElement();
		
		if(value != null) {
			if(value <= numero && (floor == null || floor <= value)) {
				floor = recursiveFloor(numero, value);
			} else {
				floor = recursiveFloor(numero, floor);
			}
		}
		
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		if(array != null) {
			for(int i = 0; i < array.length; i++) {
				this.insert(array[i]);
			}	
		}
		return recursiveCeil(numero, null);
	}

	private Integer recursiveCeil(double numero, Integer ceil) {
		Integer value = this.extractRootElement();
		
		if(value != null) {
			if(value >= numero && (ceil == null || ceil >= value)) {
				ceil = recursiveCeil(numero, value);
			} else {
				ceil = recursiveCeil(numero, ceil);
			}
		}
		
		return ceil;
	}

}
