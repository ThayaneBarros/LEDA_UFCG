package adt.linkedList.batch;

import util.GenericException;

public class test {

	public static void main(String[] args) throws GenericException {
		BatchLinkedListImpl<Integer> b = new BatchLinkedListImpl<>();
		Integer[] a = {3,9,4,2};
		b.inserirEmBatch(0,a);
		System.out.println(b.toStringFromHead());
		
		Integer[] ar = {15,28,7,11};
		b.inserirEmBatch(2, ar);
		System.out.println(b.toStringFromHead());
		Integer[] arr = {1,2,8,10};
		b.inserirEmBatch(0, arr);
		System.out.println(b.toStringFromHead());
		Integer[] arra = {5};
		b.inserirEmBatch(12, arra);
		System.out.println(b.toStringFromHead());
		b.removerEmBatch(0, 2);
		System.out.println(b.toStringFromHead());
		b.removerEmBatch(9, 2);
		System.out.println(b.toStringFromHead());
		
		
		System.out.println("-------------------");
		b.doIt(1);
		System.out.println(b.toStringFromHead());
		

	}

}
