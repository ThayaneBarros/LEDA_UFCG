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
		int size = 0;
		SingleLinkedListNode<T> auxCurrentNode = this.head;
		
		while(!auxCurrentNode.isNIL()) {
			size++;
			auxCurrentNode = auxCurrentNode.getNext();
		}
		
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxCurrentNode = this.head;
		while(!auxCurrentNode.isNIL() && !auxCurrentNode.getData().equals(element)) {
			auxCurrentNode = auxCurrentNode.getNext();
		}
		return auxCurrentNode.getData();	
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			SingleLinkedListNode<T> auxCurrentNode = this.head;
			
			while(!auxCurrentNode.isNIL()) {
				auxCurrentNode = auxCurrentNode.getNext();
				}
						
			auxCurrentNode.setData(element);
			auxCurrentNode.setNext(new SingleLinkedListNode<>());
			

		}
		
	}

	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()) {
			SingleLinkedListNode<T> auxCurrentNode = this.head;
			
			while(!(auxCurrentNode.isNIL()) && !(auxCurrentNode.getData().equals(element))) {
				auxCurrentNode = auxCurrentNode.getNext();
			}
			
			if(!auxCurrentNode.isNIL()) {
				auxCurrentNode.setData(auxCurrentNode.getNext().getData());
				auxCurrentNode.setNext(auxCurrentNode.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxCurrentNode = this.head;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = auxCurrentNode.getData();
			auxCurrentNode = auxCurrentNode.getNext();
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
