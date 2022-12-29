package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if(checkEntry(array, k)) {
			int smaller = 0;
			int larger = 0;
			for(int i = 1; i < array.length; i++) {
				if(array[i].compareTo(array[smaller]) < 0) {
					smaller = i;
				}
				if(array[i].compareTo(array[larger]) > 0) {
					larger = i;
				}
			}
			
			return selectionSortOrderStatistics(array, 1, smaller, larger, k);
		}
		return null;
	}

	private T selectionSortOrderStatistics(T[] array, int i, int smaller, int larger, int k) {
		if(i <= k) {
			if(i == k) { return array[smaller]; }
			
			T lastSmaller = array[smaller];
			smaller = larger;
			for(int j = 0; j < array.length; j++) {
				if((array[j].compareTo(array[larger]) < 0) && (array[j].compareTo(lastSmaller) > 0)) {
					if(array[j].compareTo(array[smaller]) < 0) {
						smaller = j;
					}
				}
			}
			
			return selectionSortOrderStatistics(array, i+1, smaller, larger, k);
		}
		return null;
		
	}

	private boolean checkEntry(T[] array, int k) {
		if(array != null && array.length > 0 && k > 0 && k <= array.length) {
			return true;
		}
		return false;
	}

}
