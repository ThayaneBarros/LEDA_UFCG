package adt.bst.extended;

import java.util.ArrayList;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FullRecursiveBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FullRecursiveBST<T> {

	/**
	 * Sobrescreva este metodo usando recursao.
	 */
	@Override
	public BSTNode<T> maximum(){
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}
	
	/**
	 * Sobrescreva este metodo usando recursao.
	 */
	@Override
	public BSTNode<T> minimum(){
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");	
	}
	
	/**
	 * Sobrescreva este metodo usando recursao. Quando um no tem filho a direita
	 * entao o sucessor sera o minimum do filho a direita. Caso contrario
	 * o sucessor sera o primeiro ascendente a ter um valor maior.
	 */
	@Override
	public BSTNode<T> sucessor(T element) {
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Sobrescreva este metodo usando recursao. Quando um no tem filho a esquerda
	 * entao o predecessor sera o maximum do filho a esquerda. Caso contrario
	 * o predecessor sera o primeiro ascendente a ter um valor menor.
	 */
	@Override
	public BSTNode<T> predecessor(T element) {
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] elementsAtDistance(int k) {
		ArrayList list = new ArrayList<T>();
		recursiveElementsAtDistance(this.root, k, 0, list);
		return (T[]) list.toArray(new Comparable[0]);
	}

	private void recursiveElementsAtDistance(BSTNode<T> curent, int k, int i, ArrayList<T> list) {
		if(k == i) {
			list.add(curent.getData());
		} else {
			i += 1;
			recursiveElementsAtDistance((BSTNode<T>) curent.getLeft(), k, i, list);
			recursiveElementsAtDistance((BSTNode<T>) curent.getRight(), k, i, list);
		}
	}
}
