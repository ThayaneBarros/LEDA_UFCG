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
		return 1 + Math.max(recursiveHeight((BSTNode<T>) current.getLeft()), recursiveHeight((BSTNode<T>) current.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		if(element != null) {
			return recursiveSearch(this.root, element);
		}
		return new BSTNode<T>(); 
	}

	private BSTNode<T> recursiveSearch(BSTNode<T> current, T element) {
		if(current.isEmpty()) return current;
		if(current.getData().equals(element)) return current;
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
		} else if(element.compareTo(current.getData()) < 0) {
			recursiveInsert((BSTNode<T>) current.getLeft(), element);
		} else if(element.compareTo(current.getData()) > 0) {
			recursiveInsert((BSTNode<T>) current.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if(this.isEmpty()) return null;
		return recursiveMaximun(this.root);
	}

	private BSTNode<T> recursiveMaximun(BSTNode<T> current) {
		if(current.getRight().isEmpty()) return current;
		return recursiveMaximun((BSTNode<T>) current.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if(this.isEmpty())return null;
		return recursiveMinimum(this.root);
	}

	private BSTNode<T> recursiveMinimum(BSTNode<T> current) {
		if(current.getLeft().isEmpty()) return current;
		return recursiveMinimum((BSTNode<T>) current.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		if(element != null) {
			BSTNode<T> node = this.search(element);
			
			if(!node.isEmpty()) {
				if(!node.getRight().isEmpty()) {
					return this.recursiveMinimum((BSTNode<T>) node.getRight());
				} else {
					return recursiveSucessor(node, element);
				}
			}
		}
		return null;
	}

	private BSTNode<T> recursiveSucessor(BSTNode<T> node, T element) {
		if(node != null && node.getData().compareTo(element) <= 0) {
			return recursiveSucessor((BSTNode<T>) node.getParent(), element);
		} else {
			return node;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		if(element != null) {
			BSTNode<T> node = this.search(element);
			
			if(!node.isEmpty()) {
				if(!node.getLeft().isEmpty()) {
					return this.recursiveMaximun((BSTNode<T>) node.getLeft());
				} else {
					return recursivePredecessor(node, element);
				}
			}
		}
		
		return null;
	}

	private BSTNode<T> recursivePredecessor(BSTNode<T> node, T element) {
		if(node != null && node.getData().compareTo(element) >= 0) {
			return recursivePredecessor((BSTNode<T>) node.getParent(), element);
		}
		return node;
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			BSTNode<T> node = this.search(element);
			
			if(!node.isEmpty()) {
				recursiveRemove(node);
			}
		}
	}

	private void recursiveRemove(BSTNode<T> node) {
		if(node.isLeaf()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		} 
		else if(!node.getLeft().isEmpty() && node.getRight().isEmpty()) {
			if(node.equals(this.root)) {
				this.root = (BSTNode<T>) node.getLeft();
				this.root.setParent(null);
			} else {
				node.getLeft().setParent(node.getParent());
				if(node.getParent().getData().compareTo(node.getData()) > 0) {
					node.getParent().setLeft(node.getLeft());
				} else {
					node.getParent().setRight(node.getLeft());
				}
			}
			
		} 
		else if(node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
			if(node.equals(this.root)) {
				this.root = (BSTNode<T>) node.getRight();
				this.root.setParent(null);
			} else {
				node.getRight().setParent(node);
				if(node.getData().compareTo(node.getParent().getData()) < 0) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
			}
			
		}
		else {
			BSTNode<T> sucessor = this.sucessor(node.getData());
			T valueSucessor = sucessor.getData();
			this.recursiveRemove(sucessor);
			node.setData(valueSucessor);
		}
		
	}

	@Override
	public T[] preOrder() {
		return recursivePreOrder(this.root, new ArrayList<T>());
	}

	private T[] recursivePreOrder(BSTNode<T> current, ArrayList<T> list) {
		if(!current.isEmpty()) {
			list.add(current.getData());
			recursivePreOrder((BSTNode<T>) current.getLeft(),list);
			recursivePreOrder((BSTNode<T>) current.getRight(),list);
		}
		
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] order() {
		return recursiveOrder(this.root, new ArrayList<T>());
	}

	private T[] recursiveOrder(BSTNode<T> current, ArrayList<T> list) {
		if(!current.isEmpty()) {
			recursiveOrder((BSTNode<T>) current.getLeft(), list);
			list.add(current.getData());
			recursiveOrder((BSTNode<T>) current.getRight(), list);
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] postOrder() {
		return recursivePostOrder(this.root, new ArrayList<T>());
	}

	private T[] recursivePostOrder(BSTNode<T> current, ArrayList<T> list) {
		if(!current.isEmpty()) {
			recursivePostOrder((BSTNode<T>) current.getLeft(), list);
			recursivePostOrder((BSTNode<T>) current.getRight(), list);
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
