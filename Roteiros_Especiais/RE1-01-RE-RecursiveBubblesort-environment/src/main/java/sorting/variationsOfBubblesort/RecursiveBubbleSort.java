package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(checkEntry(array, leftIndex, rightIndex)) {
			bubbleSort(array, leftIndex, rightIndex, leftIndex);
		}
	}

	private void bubbleSort(T[] array, int leftIndex, int rightIndex, int posicao) {
		if(posicao <= rightIndex) {
			boolean trocou = false;
			for(int j = leftIndex; j <= rightIndex - posicao - 1; j++) {
				if(array[j].compareTo(array[j + 1]) > 0) {
					T aux = array[j];
					array[j] = array[j+ 1];
					array[j + 1] = aux;
					trocou = true;
				}
			}
			if(!trocou) {
				return;
			}
			bubbleSort(array, leftIndex, rightIndex, posicao + 1);
		}
		
	}

	private boolean checkEntry(T[] array, int leftIndex, int rightIndex) {
		if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			return true;
		}
		return false;
	}

}
