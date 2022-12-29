package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(verificaEntrada(array, leftIndex, rightIndex)) {
			int[] C = new int[maiorValor(array, leftIndex, rightIndex) + 1];
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]] += 1;
			}
			
			for(int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}
			
			int[] B = new int[rightIndex - leftIndex + 1];
			for(int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i]] - 1] = array[i];
				C[array[i]] -= 1;
			}
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[i - leftIndex];
			}
		}
	}

	private int maiorValor(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

	private boolean verificaEntrada(Integer[] array, int leftIndex, int rightIndex) {
		if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			return true;
		}
		return false;
	}

}
