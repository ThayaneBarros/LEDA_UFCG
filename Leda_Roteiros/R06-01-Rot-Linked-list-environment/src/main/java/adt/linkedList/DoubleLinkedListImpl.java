package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<>();
		this.head = this.last;
		}
	

	@Override
	public void insert(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newNil = new DoubleLinkedListNode<>();
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
			
			newNode.setData(element);
			newNode.setNext(newNil);
			newNil.setPrevious(newNode);
			
			this.last.setNext(newNode);
			newNode.setPrevious(this.last);

			
			if(this.last.isNIL()) {
				this.head = newNode;
			}
			
			this.last = newNode;
		}
	}
	
	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newNil = new DoubleLinkedListNode<>();
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
			
			newHead.setData(element);
			newHead.setNext(this.head);
			newHead.setPrevious(newNil);
			newNil.setNext(newHead);
			((DoubleLinkedListNode<T>) this.head).setPrevious(newHead);
			
			if(this.head.isNIL()) {
				this.last = newHead;
			}
			
			this.head = newHead;
			
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
			
			if(this.last.isNIL()) {
				this.head = this.last;
			} else {
				DoubleLinkedListNode<T> newNil = new DoubleLinkedListNode<>();
				this.last.setNext(newNil);
				newNil.setPrevious(this.last);
			}
		}
	}
	
	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()) {
			DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.head;
			
			int tamanhoLista = this.size();
			for(int i = 0; i < tamanhoLista; i++) {
				if(auxNode.getData().equals(element)) {
					if(i == 0) this.removeFirst();
					else if(i == tamanhoLista - 1) this.removeLast();
					else {
						auxNode.getPrevious().setNext(auxNode.getNext());
						((DoubleLinkedListNode<T>) auxNode.getNext()).setPrevious(auxNode.getPrevious());
					}
					return;
				}
				
				auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
