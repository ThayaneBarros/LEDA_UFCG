package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(checkEntry(array, leftIndex, rightIndex)) {
			selectionSortRecursivo(array, leftIndex, rightIndex);
		}
	}

	private void selectionSortRecursivo(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0) {
			int smaller = leftIndex;
			for(int j = leftIndex + 1; j <= rightIndex; j++) {
				if(array[j].compareTo(array[smaller]) < 0) {
					smaller = j;
				}
			}
			T aux = array[leftIndex];
			array[leftIndex] = array[smaller];
			array[smaller] = aux;
			
			selectionSortRecursivo(array, leftIndex + 1, rightIndex);
		}
		
	}

	private boolean checkEntry(T[] array, int leftIndex, int rightIndex) {
		if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			return true;
		}
		return false;
	}

}
