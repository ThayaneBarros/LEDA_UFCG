package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length) {
			if(leftIndex < rightIndex) {
				int indexPivot = partition(array, leftIndex, rightIndex);
				sort(array, leftIndex, indexPivot - 1);
				sort(array, indexPivot + 1, rightIndex);
			}
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {	
		int indexPivot = pickPivotIndex(array, leftIndex, rightIndex);
		Util.swap(array, indexPivot, rightIndex - 1);
		T pivot = array[rightIndex - 1];
		
		int i = rightIndex - 1;
		for(int j = rightIndex - 2; j > leftIndex; j--) {
			if(array[j].compareTo(pivot) > 0) {
				i--;
				Util.swap(array, j, i);
			}
		}
		Util.swap(array, rightIndex - 1, i);
		return i;
	}

	private int pickPivotIndex(T[] array, int leftIndex, int rightIndex) {
		 int mid = (leftIndex + rightIndex) / 2;

		 if(array[leftIndex].compareTo(array[mid]) > 0) {
			 Util.swap(array, leftIndex, mid);
		 }
		 
		 if(array[mid].compareTo(array[rightIndex]) > 0) {
			 Util.swap(array, rightIndex, mid);
		 }
		 
		 if(array[leftIndex].compareTo(array[mid]) > 0) {
			 Util.swap(array, leftIndex, mid);
		 }
		 
		 return mid;

	}
}
