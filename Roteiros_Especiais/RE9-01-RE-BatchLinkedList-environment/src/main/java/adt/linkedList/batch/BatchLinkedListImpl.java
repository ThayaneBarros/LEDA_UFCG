package adt.linkedList.batch;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import util.GenericException;

/**
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * ATENÇÃO: NAO MODIFIQUE NENHUMA OUTRA CLASSE ALEM DESTA !!!!! 
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public class BatchLinkedListImpl<T> extends DoubleLinkedListImpl<T> implements BatchLinkedList<T> {

	/* 
	 * Nao modifique nem remova este metodo.
	 */
	public BatchLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>)head;
	}

	@Override
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException {
		if(posicao < 0 || posicao > this.size() || elementos== null) {
			throw new GenericException();
		}
		
		DoubleLinkedListNode<T> nodeHead = new DoubleLinkedListNode<>();
		DoubleLinkedListNode<T> nodeLast = nodeHead;
		for(int i = 0; i < elementos.length; i++) {
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>();
			
			nodeLast.setData(elementos[i]);
			nodeLast.setNext(node);
			node.setPrevious(nodeLast);
			
			nodeLast = node;
		}
		nodeLast = nodeLast.getPrevious();
		
		if(this.isEmpty()) {
			DoubleLinkedListNode<T> newNil = new DoubleLinkedListNode<>();
			nodeLast.setNext(newNil);
			newNil.setPrevious(nodeLast);
			this.head.setNext(nodeHead);
			nodeHead.setPrevious((DoubleLinkedListNode<T>) this.head);
			
			this.head = nodeHead;
			this.last = nodeLast;
		
		} else {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;	
			for(int i = 0; i < posicao; i++) {
				aux = (DoubleLinkedListNode<T>) aux.getNext();
			}
			aux = aux.getPrevious();
			
			nodeLast.setNext(aux.getNext());
			((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(nodeLast);
			aux.setNext(nodeHead);
			nodeHead.setPrevious(aux);
		}
		
		if(posicao == 0) {
			this.head = nodeHead;
		} else if(posicao == size()) {
			this.last = nodeLast;
		}
			
	}

	@Override
	public void removerEmBatch(int posicao, int quantidade) throws GenericException {
		if(posicao < 0 || posicao > size() || quantidade < 0 || (quantidade + posicao) > size()) {
			throw new GenericException(); 
		}
		
		DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
		for(int i = 0; i < posicao; i++) {
			aux = (DoubleLinkedListNode<T>) aux.getNext();
		}
		aux = aux.getPrevious();
		
		DoubleLinkedListNode<T> aux2 = aux;;
		for(int i = 0; i <= quantidade; i++) {
			aux2 = (DoubleLinkedListNode<T>) aux2.getNext();
		}
		
		aux.setNext(aux2);
		aux2.setPrevious(aux);
		
		if(aux.isNIL() && aux2.isNIL()) {
			this.head = aux;
			this.last = aux;
		}
		if(aux.isNIL() && !this.isEmpty()) {
			this.head = aux.getNext();
			this.last = aux2.getPrevious();
		}
	}
	
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * comecando a navegacao pelo Head
	 */
	public String toStringFromHead() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = (DoubleLinkedListNode<T>)getHead();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result += " ";
			}
				
			result += aNode.getData();
			aNode = (DoubleLinkedListNode<T>) aNode.getNext();
			
		}
		
		return result;
	}
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * porem comecando a navegacao pelo Last
	 * 
	 * Este metodo produz o MESMO RESULTADO de toStringFromHead() 
	 * 
	 */
	public String toStringFromLast() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = getLast();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result = " " + result;
			}
				
			result = aNode.getData() + result;
			aNode = (DoubleLinkedListNode<T>) aNode.getPrevious();
			
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return toStringFromHead();
	}
	
	public void doIt(T elem) {
		if(elem != null) {
			
			if(this.isEmpty()) {
				DoubleLinkedListNode<T> value = new DoubleLinkedListNode<>();
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();
				
				value.setData(elem);
				value.setNext(nil);
			} else {
				DoubleLinkedListNode<T> value = new DoubleLinkedListNode<>();
				value.setData(elem);
				value.setNext(this.head);
				
				DoubleLinkedListNode<T> aux1 = (DoubleLinkedListNode<T>) this.head;
				DoubleLinkedListNode<T> aux2 = (DoubleLinkedListNode<T>) this.head.getNext();
				
				while(!aux2.isNIL()) {
					value.setNext(aux2);
					aux2 = (DoubleLinkedListNode<T>) aux2.getNext();
					value.getNext().setNext(aux1);
					aux1 = (DoubleLinkedListNode<T>) value.getNext();
				}
				
				head.setNext(aux2);
				this.last = (DoubleLinkedListNode<T>) this.head;
				this.head = value;
				 
				
			}
		}
	}


}
