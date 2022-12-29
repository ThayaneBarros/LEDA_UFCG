package adt.heap.extended;


import java.util.List;
import java.util.PriorityQueue;

public class HeapMergeImpl extends PriorityQueue<Integer> implements HeapMerge {

	@Override
	public Integer[] mergeArraysAndOrder(List<Integer[]> arrays) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int sumRange(int k1, int k2) {
		int out  = 0;
		if(k1 >= 1 && k1 <= this.size() && k2 >= 1 && k2 <= this.size()) {
			for(int i = 0; i < k2 - 1; i++) {
				int n = this.poll();
				if(i >= k1) {
					out += n;
				}
			}
		}
		return out;
	}

}
