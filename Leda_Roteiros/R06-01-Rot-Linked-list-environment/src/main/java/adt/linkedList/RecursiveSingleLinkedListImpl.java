package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

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
		T out = null;
		if(element != null && !this.isEmpty()) {
			if(this.getData().equals(element)) {
				out = this.data;
			} else {
				out = this.next.search(element);
			}
		}
		return out;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(this.isEmpty()) {
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
			if(this.getData().equals(element)) {
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		toArray2(array, this);
		return (T[]) array.toArray();
	}

	private void toArray2(List<T> array, RecursiveSingleLinkedListImpl<T> node) {
		if(!node.isEmpty()) {
			array.add(node.getData());
			toArray2(array, node.next);
		}
		
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
