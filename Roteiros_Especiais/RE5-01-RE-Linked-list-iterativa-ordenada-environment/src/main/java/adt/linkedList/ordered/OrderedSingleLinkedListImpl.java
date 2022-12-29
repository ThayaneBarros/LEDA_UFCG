package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.SingleLinkedListImpl;
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
public class OrderedSingleLinkedListImpl<T extends Comparable<T>> extends SingleLinkedListImpl<T> implements
		OrderedLinkedList<T> {

	private Comparator<T> comparator;

	public OrderedSingleLinkedListImpl(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public T minimum() {
		if(!this.isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			
			T menor = this.head.getData();
			while(!aux.isNIL()) {
				if(comparator.compare(aux.getData(), menor) < 0) {
					menor = aux.getData();
				}
				aux = aux.getNext();
			}
			
			return menor;
		} 
		return null;
	}

	@Override
	public T maximum() {
		if(!this.isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			
			T maior = this.head.getData();
			while(!aux.isNIL()) {
				if(comparator.compare(aux.getData(), maior) > 0) {
					maior = aux.getData();
				}
				aux = aux.getNext();
			}
		}
		return null;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
}
