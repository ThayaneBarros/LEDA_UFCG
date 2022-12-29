package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

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
		if(verificaEntrada(array, leftIndex, rightIndex)) {
			if(leftIndex < rightIndex) {
				int indiceMenor = leftIndex;
				for(int j = leftIndex + 1; j <= rightIndex; j++) {
					if(array[j].compareTo(array[indiceMenor]) < 0) {
						indiceMenor = j;
					}
				}
				Util.swap(array, leftIndex, indiceMenor);
				sort(array, leftIndex + 1, rightIndex);
			}
		}
		
	}
	
	private boolean verificaEntrada(T[] array, int leftIndex, int rightIndex) {
		if(array != null && array.length > 0 && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			return true;
		}
		return false;
	}

}
