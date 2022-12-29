package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(element != null) {
			if(this.isFull()) {
				throw new StackOverflowException();
			}
			
			this.top.insertFirst(element);
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}
		
		T value = this.top();
		
		this.top.removeFirst();
		return value;
		
	}

	@Override
	public T top() {
		if(this.isEmpty()) {
			return null;
		}
		
		return ((DoubleLinkedListImpl<T>) this.top).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
