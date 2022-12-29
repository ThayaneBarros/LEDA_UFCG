package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return recursiveHeight(this.root);
	}

	private int recursiveHeight(BSTNode<T> current) {
		if(current.isEmpty()) return -1;
		else return 1 + Math.max(recursiveHeight((BSTNode<T>) current.getLeft()), recursiveHeight((BSTNode<T>) current.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		if(element != null) {
			return recursiveSearch(this.root, element);
		}
		return new BSTNode<T>();
	}

	private BSTNode<T> recursiveSearch(BSTNode<T> current, T element) {
		if(current.isEmpty() || current.getData().equals(element)) return current;
		if(element.compareTo(current.getData()) < 0) {
			return recursiveSearch((BSTNode<T>) current.getLeft(), element);
		} else {
			return recursiveSearch((BSTNode<T>) current.getRight(), element);
		}
	}

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
		}
		
	}

	@Override
	public BSTNode<T> maximum() {
		if(this.isEmpty()) return null;
		return recursiveMaximum(this.root);
	}

	private BSTNode<T> recursiveMaximum(BSTNode<T> current) {
		if(current.getRight().isEmpty()) return current;
		else return recursiveMaximum((BSTNode<T>) current.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if(this.isEmpty()) return null;
		return recursiveMinimum(this.root);
	}

	private BSTNode<T> recursiveMinimum(BSTNode<T> current) {
		if(current.getLeft().isEmpty()) return current;
		else return recursiveMinimum((BSTNode<T>) current.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		if(element != null) {
			BSTNode<T> nodeElement = this.search(element);
			
			if(!nodeElement.isEmpty()) {
				if(!nodeElement.getRight().isEmpty()) {
					return this.recursiveMinimum((BSTNode<T>) nodeElement.getRight());
				} else {
					return recursiveSucessor(nodeElement, element);
				}
			}
		}
		return null;
	}

	private BSTNode<T> recursiveSucessor(BSTNode<T> currentNodeElement, T element) {
		if(currentNodeElement != null && currentNodeElement.getData().compareTo(element) <= 0) {
			return recursiveSucessor((BSTNode<T>) currentNodeElement.getParent(), element);
		} else {
			return currentNodeElement;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		if(element != null) {
			BSTNode<T> nodeElement = this.search(element);
			
			if(!nodeElement.isEmpty()) {
				if(!nodeElement.getLeft().isEmpty()) {
					return this.recursiveMaximum((BSTNode<T>) nodeElement.getLeft());
				} else {
					return recursivePredecessor(nodeElement, element);
				}
			}
		}
		return null;
	}

	private BSTNode<T> recursivePredecessor(BSTNode<T> currentNodeElement, T element) {
		if(currentNodeElement != null && currentNodeElement.getData().compareTo(element) >= 0) {
			return recursivePredecessor((BSTNode<T>) currentNodeElement.getParent(), element);
		} else {
			return currentNodeElement;
		}
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			BSTNode<T> nodeElement = this.search(element);
			
			if(!nodeElement.isEmpty()) {
				if(nodeElement.isLeaf()) { // 1º Caso
					nodeElement.setData(null);
					nodeElement.setLeft(null);
					nodeElement.setRight(null);
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
				} else { // 3º Caso
					T sucessor = this.sucessor(nodeElement.getData()).getData();
					this.remove(sucessor);
					nodeElement.setData(sucessor);	
				}
			}
		}
	}

	@Override
	public T[] preOrder() {
		return recursivePreOrder(this.root, new ArrayList<T>());
	}

	private T[] recursivePreOrder(BSTNode<T> current, ArrayList<T> list) {
		if(!current.isEmpty()) {
			list.add(current.getData());
			this.recursivePreOrder((BSTNode<T>) current.getLeft(), list);
			this.recursivePreOrder((BSTNode<T>) current.getRight(), list);
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] order() {
		return recursiveOrder(this.root, new ArrayList<T>());
	}

	private T[] recursiveOrder(BSTNode<T> current, ArrayList<T> list) {
		if(!current.isEmpty()) {
			this.recursiveOrder((BSTNode<T>) current.getLeft(), list);
			list.add(current.getData());
			this.recursiveOrder((BSTNode<T>) current.getRight(), list);
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] postOrder() {
		return recursivePostOrder(this.root, new ArrayList<T>());
	}

	private T[] recursivePostOrder(BSTNode<T> current, ArrayList<T> list) {
		if(!current.isEmpty()) {
			this.recursivePostOrder((BSTNode<T>) current.getLeft(), list);
			this.recursivePostOrder((BSTNode<T>) current.getRight(), list);
			list.add(current.getData());
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
