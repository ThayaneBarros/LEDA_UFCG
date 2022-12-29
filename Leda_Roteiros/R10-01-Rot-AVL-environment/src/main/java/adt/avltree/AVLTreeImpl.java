package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.
	@Override
	public void insert(T element) {
		if(element != null) {
			recursiveInsert(this.root, element);
		}
	}

	private void recursiveInsert(BSTNode<T> current, T element) {
		if(current.isEmpty()) {
			current.setData(element);
			current.setLeft(new BSTNode.Builder<T>().parent(current).build());
			current.setRight(new BSTNode.Builder<T>().parent(current).build());
			
		} else {
			if(element.compareTo(current.getData()) < 0) {
				recursiveInsert((BSTNode<T>) current.getLeft(), element);
			} else {
				recursiveInsert((BSTNode<T>) current.getRight(), element);
			}
			rebalance(current);
		}	
	}
	
	@Override
	public void remove(T element) {
		BSTNode<T> nodeElement = this.search(element);
		if(!nodeElement.isEmpty()) {
			this.remove(nodeElement);
		}	
	}
	
	private void remove(BSTNode<T> nodeElement) {
		if(nodeElement.isLeaf()) { // 1º Caso
			nodeElement.setData(null);
			nodeElement.setLeft(null);
			nodeElement.setRight(null);
			rebalanceUp(nodeElement);
			
		} else if(!nodeElement.getLeft().isEmpty() && nodeElement.getRight().isEmpty()) { // 2º Caso
			if(nodeElement.equals(this.root)) {
				this.root = (BSTNode<T>) nodeElement.getLeft();
				this.root.setParent(null);
			} else {
				nodeElement.getLeft().setParent(nodeElement.getParent());
				
				if(nodeElement.getData().compareTo(nodeElement.getParent().getData()) < 0) {
					nodeElement.getParent().setLeft(nodeElement.getLeft());
				} else {
					nodeElement.getParent().setRight(nodeElement.getLeft());
				}
			}
			rebalanceUp(nodeElement);
			
		} else if(nodeElement.getLeft().isEmpty() && !nodeElement.getRight().isEmpty()) {
			if(nodeElement.equals(this.root)) {
				this.root = (BSTNode<T>) nodeElement.getRight();
				this.root.setParent(null);
			} else {
				nodeElement.getRight().setParent(nodeElement.getParent());
				
				if(nodeElement.getData().compareTo(nodeElement.getParent().getData()) < 0) {
					nodeElement.getParent().setLeft(nodeElement.getRight());
				} else {
					nodeElement.getParent().setRight(nodeElement.getRight());
				}
			} 
			rebalanceUp(nodeElement);
			
		} else { // 3º Caso
			BSTNode<T> sucessor = this.sucessor(nodeElement.getData());
			T element = sucessor.getData();
			this.remove(sucessor);
			nodeElement.setData(element);
		}
		
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if(node.isEmpty()) return 0;
		return this.recursiveHeight((BSTNode<T>) node.getLeft())
				- this.recursiveHeight((BSTNode<T>) node.getRight());
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);
		
		BSTNode<T> rootAux = null;
		if(Math.abs(balance) > 1) {
			if(balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					rootAux = Util.rightRotation(node);
				} else {
					Util.leftRotation((BSTNode<T>) node.getLeft());
					rootAux = Util.rightRotation(node);
				}
			} else {
				if(this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					rootAux = Util.leftRotation(node);
				} else {
					Util.rightRotation((BSTNode<T>) node.getRight());
					rootAux = Util.leftRotation(node);
				}
			}
		}
		
		if (this.getRoot().equals(node) && rootAux != null) {
			this.root = rootAux;
		}
	}

	

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node.getParent() != null) {
			this.rebalance((BSTNode<T>) node.getParent());
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
}
