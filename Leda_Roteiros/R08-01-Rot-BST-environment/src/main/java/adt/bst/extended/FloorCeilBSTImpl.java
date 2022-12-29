package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for(int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		return recursiveFloor(this.root, numero, null);
	}

	private Integer recursiveFloor(BSTNode<Integer> current, double numero, Integer floor) {
		if(!current.isEmpty()) {
			if(current.getData() == numero) floor = current.getData();
			else if(current.getData() < numero) { 
				floor = recursiveFloor((BSTNode<Integer>) current.getRight(), numero, current.getData());
			} else {
				floor = recursiveFloor((BSTNode<Integer>) current.getLeft(), numero, floor);
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for(int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		
		return recursiveCeil(this.root, numero, null);
	}

	private Integer recursiveCeil(BSTNode<Integer> current, double numero, Integer ceil) {
		if(!current.isEmpty()) {
			if(current.getData() == numero) ceil = current.getData();
			else if(current.getData() < numero) {
				ceil = recursiveCeil((BSTNode<Integer>) current.getRight(), numero, ceil);
			} else {
				ceil = recursiveCeil((BSTNode<Integer>) current.getLeft(), numero, current.getData());
			} 
		}
		return ceil;
	}

}
