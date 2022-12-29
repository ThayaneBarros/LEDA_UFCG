package adt.linkedList.extended;

import java.util.Comparator;

public class comparator1 implements Comparator<Integer> {
	

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
}
