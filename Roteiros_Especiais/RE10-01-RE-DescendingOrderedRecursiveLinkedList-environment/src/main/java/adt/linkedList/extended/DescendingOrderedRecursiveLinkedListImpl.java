package adt.linkedList.extended;

import java.util.Comparator;

import adt.linkedList.LinkedList;
import adt.linkedList.RecursiveSingleLinkedListImpl;

/**
 * This class is an implementation of an ordered recursive single linked list
 * that behaves like a Set (it cannot contain repeated elements). The constraint
 * of this list is that the elements MUST be ordered in descending order. Tip:
 * think about if it is necessary to override insert, search and remove to use
 * the comparator and respect the constraint.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class DescendingOrderedRecursiveLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> {

	private Comparator<T> comparator;

	public DescendingOrderedRecursiveLinkedListImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	/**
	 * It returns the maximum element of the list or null if the list is empty.
	 * 
	 * @return
	 */
	public T maximum() {
		if(this.isEmpty()) {
			return null;
		} else {
			return pegaMaior(this);
		}
		
	}
		

	private T pegaMaior(RecursiveSingleLinkedListImpl<T> current) {
		if(!current.isEmpty()) {
			T maior = current.getData();
			T pMaior = pegaMaior(current.getNext());
			
			if(pMaior != null && this.comparator.compare(pMaior, maior) > 0) {
				maior = pMaior;
			}
			
			return maior;
		}
		return null;
	}

	/**
	 * It puts all elements of otherList in this list. Try to make this methods
	 * as fast as possible.
	 * 
	 * @param otherList
	 */
	public void insertAll(LinkedList<T> otherList) {
		T[] array = otherList.toArray();
		if(array != null) {
			for(int i = 0; i < array.length; i++) {
				this.insert(array[i]);
			}
		}
	}

	/**
	 * This methods compares (for set equality) this list with otherList
	 * (possibly containing repeated elements). This this method returns true if
	 * the lists have the same elements. It does not matter how many times they
	 * appear in otherList.
	 * 
	 * @param otherList
	 */
	public boolean equalsAsSet(LinkedList<T> otherList) {
		T[] array = otherList.toArray();
		if(array != null) {
			for(int i = 0; i < array.length; i++) {
				if(this.search(array[i]) == null) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

}
