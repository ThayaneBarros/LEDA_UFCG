package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> auxNode = this.head;
		int cont = 0;
		
		while(!auxNode.isNIL()) {
			cont++;
			auxNode = auxNode.getNext();
		}
		
		return cont;
	}

	@Override
	public T search(T element) {
		if(element != null) {
			SingleLinkedListNode<T> auxNode = this.head;
			
			while(!auxNode.isNIL()) {
				if(!auxNode.getData().equals(element)) {
					return auxNode.getData();
				}
				auxNode = auxNode.getNext();
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			SingleLinkedListNode<T> auxNode = this.head;
			
			while(!auxNode.isNIL()) {
				auxNode = auxNode.getNext();
			}
			
			auxNode.setData(element);
			auxNode.setNext(new SingleLinkedListNode<T>());
			
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()) {
			SingleLinkedListNode<T> auxNode = this.head;
			
			while(!auxNode.isNIL() && !auxNode.getData().equals(element)) {
				auxNode = auxNode.getNext();
			}
			
			if(!auxNode.isNIL()) {
				auxNode.setData(auxNode.getNext().getData());
				auxNode.setNext(auxNode.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxNode = this.head;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = auxNode.getData();
			auxNode = auxNode.getNext();
		}
		
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
