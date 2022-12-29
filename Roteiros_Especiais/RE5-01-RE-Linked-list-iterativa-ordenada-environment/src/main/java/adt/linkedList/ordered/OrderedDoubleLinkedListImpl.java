package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;

/**
 * Para testar essa classe voce deve implementar seu comparador. Primeiro
 * implemente todos os métodos requeridos. Depois implemente dois comparadores
 * (com idéias opostas) e teste sua classe com eles. Dependendo do comparador
 * que você utilizar a lista funcionar como ascendente ou descendente, mas a
 * implemntação dos métodos é a mesma.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class OrderedDoubleLinkedListImpl<T extends Comparable<T>> extends OrderedSingleLinkedListImpl<T> implements
		OrderedLinkedList<T>,DoubleLinkedList<T> {

	private DoubleLinkedListNode<T> last;

	public OrderedDoubleLinkedListImpl(Comparator<T> comparator) {
		super(comparator);
	}
	
	/**
	 * Este método faz sentido apenas se o elemento a ser inserido pode 
	 * realmente ficar na primeira posição (devido a ordem)
	 */
	@Override
	public void insertFirst(T element) {
		if(element != null) {
			if(this.isEmpty() || (this.getComparator().compare(element, this.head.getData()) < 0)) {
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
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()) {
			this.head = this.head.getNext();
			
			if(this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			} else {
				DoubleLinkedListNode<T> newNil = new DoubleLinkedListNode<>();
				newNil.setNext(this.head);
				((DoubleLinkedListNode<T>) this.head).setPrevious(newNil);
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
				newNil.setPrevious(this.last);
				this.last.setNext(newNil);
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
