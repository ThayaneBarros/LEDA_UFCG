package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return this.bst.isEmpty() || recursiveIsBST(this.bst.getRoot());
	}

	private boolean recursiveIsBST(BSTNode<T> currentNode) {
		boolean out = true;
		if(!currentNode.isEmpty()) {
			if(isValidNodeLeft(currentNode) && isValidNodeRight(currentNode)) {
				out = recursiveIsBST((BSTNode<T>) currentNode.getLeft()) && recursiveIsBST((BSTNode<T>) currentNode.getRight());
			} else {
				out = false;
			}
		} 
				
		return out;	
	}

	private boolean isValidNodeRight(BSTNode<T> currentNode) {
		return recursiveIsValidNodeRight(currentNode.getRight(), currentNode);
	}

	private boolean recursiveIsValidNodeRight(BTNode<T> right, BSTNode<T> currentNode) {
		boolean out = true;
		if(!right.isEmpty()) {
			if(right.getData().compareTo(currentNode.getData()) > 0) {
				out = recursiveIsValidNodeRight(right.getLeft(), currentNode)
						&& recursiveIsValidNodeRight(right.getRight(), currentNode);
			} else {
				out = false;
			}
		}
		return out;
	}

	private boolean isValidNodeLeft(BTNode<T> currentNode) {
		return recursiveIsValidNodeLeft(currentNode.getLeft(), currentNode);
	}

	private boolean recursiveIsValidNodeLeft(BTNode<T> left, BTNode<T> currentNode) {
		boolean out = true;
		if(!left.isEmpty()) {
			if(left.getData().compareTo(currentNode.getData()) < 0) {
				out = recursiveIsValidNodeLeft(left.getLeft(), currentNode)
						&& recursiveIsValidNodeLeft(left.getRight(), currentNode);
			} else {
				out = false;
			}
		}
		return out;
		
	}
	
}
