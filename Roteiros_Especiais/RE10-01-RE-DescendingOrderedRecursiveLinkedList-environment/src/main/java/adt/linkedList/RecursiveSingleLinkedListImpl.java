package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if(this.isEmpty()) {
			return 0;
		} else {
			return 1 + this.next.size();
		}
	}

	@Override
	public T search(T element) {
		if(element != null && !this.isEmpty()) {
			if(this.data.equals(element)) {
				return this.data;
			} else {
				return this.next.search(element);
			}
		}
		
		return null;	
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(this.data == null) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<T>();
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()) {
			if(this.data.equals(element)) {
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		ArrayList<T> array = new ArrayList<>();
		return (T[]) toArray(array, this).toArray();
	}


	private ArrayList<T> toArray(ArrayList<T> array, RecursiveSingleLinkedListImpl<T> node) {
		if(!node.isEmpty()) {
			array.add(node.getData());
			return node.next.toArray(array, node.next);
		}
		return array;
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
