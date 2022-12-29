package adt.linkedList.extended;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import adt.linkedList.RecursiveSingleLinkedListImpl;

public class test {

	public static void main(String[] args) {
		DescendingOrderedRecursiveLinkedListImpl<Integer> t = new DescendingOrderedRecursiveLinkedListImpl<>(new comparator1());
		
		RecursiveSingleLinkedListImpl<Integer> a = new RecursiveSingleLinkedListImpl<>();
		
		t.insert(1);
		t.insert(1);
		t.insert(1);
		t.insert(1);
		
		a.insert(2);
		a.insert(5);
		a.insert(9);
		a.insert(4);
		
		System.out.println(t.equalsAsSet(a));
		t.insertAll(a);
		System.out.println(Arrays.toString(t.toArray()));
		System.out.println(t.equalsAsSet(a));
		

	}

}
