package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
			DoubleLinkedListNode<T> newNil = new DoubleLinkedListNode<>();
			
			newNode.setData(element);
			newNode.setPrevious(newNil);
			newNil.setNext(newNode);
			newNode.setNext(this.head);
			((DoubleLinkedListNode<T>) this.head).setPrevious(newNode);
			
			if(this.head.isNIL()) {
				this.last = newNode;
			}
			
			this.head = newNode;
		}
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()) {
			this.head = this.head.getNext();
			
			if(this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			} else {
				DoubleLinkedListNode<T> newNil = new DoubleLinkedListNode<>();
				((DoubleLinkedListNode<T>) this.head).setPrevious(newNil);
				newNil.setNext(this.head);		
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty()) {
			this.last = this.last.getPrevious();
		}
		
		if(this.last.isNIL()) {
			this.head = this.last;
		} else {
			DoubleLinkedListNode<T> newNil = new DoubleLinkedListNode<>();
			this.last.setNext(newNil);
			newNil.setPrevious(this.last);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
