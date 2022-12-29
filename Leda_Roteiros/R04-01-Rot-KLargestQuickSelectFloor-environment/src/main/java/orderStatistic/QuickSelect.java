package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento
	 *            este array normalmente nao esta ordenado
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 *
	 */
	public T quickSelect(T[] array, int k) {
		if(verificaEntrada(array, k)) {
			return quickSort(array, 0, array.length - 1, k);
		}
		return null;
	}

	private T quickSort(T[] array, int left, int right, int k) {
		if(left <= right) {
			int indexPivot = partition(array, left, right);
			if(indexPivot == k - 1) { return array[k - 1]; }
			
			if(indexPivot < k - 1) {
				return quickSort(array, indexPivot + 1, right, k);
			} else {
				return quickSort(array, left, indexPivot - 1, k);
			}
		}
		return null;
	}

	private int partition(T[] array, int left, int right) {
		medianPivot(array, left, right);
		
		T pivot = array[left];
		int i = left;
		
		for(int j = left + 1; j <= right; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, left, i);
		return i;
	}

	private void medianPivot(T[] array, int left, int right) {
		int mid = (left + right) / 2;
		
		if(array[left].compareTo(array[mid]) > 0) {
			Util.swap(array, left, mid);
		}
		if(array[mid].compareTo(array[right]) > 0) {
			Util.swap(array, mid, right);
		}
		if(array[left].compareTo(array[mid]) > 0) {
			Util.swap(array, left, mid);
		}
		
		Util.swap(array, left, mid);
	}

	private boolean verificaEntrada(T[] array, int k) {
		if(array != null && array.length > 0 && k > 0 && k <= array.length) {
			return true;
		}
		return false;
	}
}