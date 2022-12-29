package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return recursiveEquals(tree1.getRoot(), tree2.getRoot());
	}

	private boolean recursiveEquals(BTNode<T> currentTree1, BTNode<T> currentTree2) {
		if(currentTree1.equals(currentTree2)) {
			if(!currentTree1.isEmpty() && !currentTree2.isEmpty()) {
				return recursiveEquals(currentTree1.getLeft(), currentTree2.getLeft())
						&& recursiveEquals(currentTree1.getRight(), currentTree2.getRight());
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return recursiveIsSimilar(tree1.getRoot(), tree2.getRoot());
	}

	private boolean recursiveIsSimilar(BTNode<T> currentTree1, BTNode<T> currentTree2) {
		if(!currentTree1.isEmpty() && !currentTree2.isEmpty()) {
			return recursiveIsSimilar(currentTree1.getLeft(), currentTree2.getLeft()) &&
					recursiveIsSimilar(currentTree1.getRight(), currentTree2.getRight());
		} else {
			return (currentTree1.isEmpty() && currentTree2.isEmpty());
		}
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		int size = tree.size();
		
		if(k >=1 && k <= size) {
			if(k == 1) return tree.minimum().getData();
			if(k == size) return tree.maximum().getData();
			
			return recursiveOrderStatistic(tree, k, tree.minimum());
		}
		return null;
	}

	private T recursiveOrderStatistic(BST<T> tree, int k, BSTNode<T> current) {
		if(k == 1) {
			return current.getData();
		} else {
			return recursiveOrderStatistic(tree, --k, tree.sucessor(current.getData()));
		}
	}

}
