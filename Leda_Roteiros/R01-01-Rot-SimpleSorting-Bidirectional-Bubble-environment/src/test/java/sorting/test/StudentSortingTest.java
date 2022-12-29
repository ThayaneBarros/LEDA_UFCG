package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorValoresNegativos;
	private Integer[] vetorOrdenado;
	private Integer[] vetorOrdenadoReverso;
	private Integer[] vetorCom1Elemento;
	private Integer[] vetorNulo;
	private Integer[] vetorComSoUmNumeroDiferente;
	
	private String[] vetorNomesDiferentes;
	private String[] vetorNomesLevementeIguais;
	private String[] vetorCom1Nome;
	private String[] vetorVazioString = {};
	private String[] vetorNomesRepetidos;
	private String[] vetorNomesOrdenados;
	private String[] vetorNomesOrdenadosInverso;
	private String[] vetorNuloString;
	
	public AbstractSorting<Integer> implementation;
	public AbstractSorting<String> implementationString;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorNegativo(new Integer[] { -1, 0, -40, -8, -2, -7 });
		populaVetorOrdenado(new Integer[] {1, 2, 3, 4, 5});
		populaVetorOrdenadoReverso(new Integer[] {5, 4, 3, 2, 1});
		populaVetorCom1Elemento(new Integer[] {1});
		populaVetorNulo(new Integer[] {null});
		populaVetor1NumeroDiferente(new Integer[] {0, 0, 0, 1, 0, 0});
		
		populaVetorNomesDiferentes(new String[] {"Mia" , "Theo", "Rocco", "Antonio", "Clara", "Frederico", "Ana"});
		populaVetorNomesNomesLevementeIguais(new String[] {"Ava" , "Ana", "Ama", "Ano"});
		populaVetorNomesCom1Nome(new String[] {"Mia"});
		populaVetorNomesRepetidos(new String[] {"Mia" , "Theo", "Mia", "Antonio", "Clara"});
		populaVetorNomesOrdenados(new String[] {"Ana" , "Antonio", "Clara", "Frederico", "Mia", "Rocco", "Theo"});
		populaVetorNomesOrdenadosInverso(new String[] {"Theo" , "Rocco", "Mia", "Frederico", "Clara", "Antonio", "Ana"});
		populaVetorNuloString(new String[] {null});

		getImplementation();
		getImplementationString();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new BubbleSort<Integer>();
		//Assert.fail("Implementation not provided");
	}
	
	private void getImplementationString() {
		this.implementationString = new InsertionSort<String>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	public void populaVetorNegativo(Integer[] arrayPadrao) {
		this.vetorValoresNegativos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	public void populaVetorOrdenado(Integer[] arrayPadrao) {
		this.vetorOrdenado = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}

	public void populaVetorOrdenadoReverso(Integer[] arrayPadrao) {
		this.vetorOrdenadoReverso = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetorCom1Elemento(Integer[] arrayPadrao) {
		this.vetorCom1Elemento = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
		
	}
	
	public void populaVetorNulo(Integer[] arrayPadrao) {
		this.vetorNulo = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetor1NumeroDiferente(Integer[] arrayPadrao) {
		this.vetorComSoUmNumeroDiferente = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetorNomesDiferentes(String[] arrayPadrao) {
		this.vetorNomesDiferentes = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetorNomesNomesLevementeIguais(String[] arrayPadrao) {
		this.vetorNomesLevementeIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetorNomesCom1Nome(String[] arrayPadrao) {
		this.vetorCom1Nome = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetorNomesRepetidos(String[] arrayPadrao) {
		this.vetorNomesRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetorNomesOrdenados(String[] arrayPadrao) {
		this.vetorNomesOrdenados = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetorNomesOrdenadosInverso(String[] arrayPadrao) {
		this.vetorNomesOrdenadosInverso = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	public void populaVetorNuloString(String[] arrayPadrao) {
		this.vetorNuloString = Arrays.copyOf(arrayPadrao, arrayPadrao.length);	
	}
	
	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}
	
	public void genericStringTest(String[] array) {
		String[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementationString.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}
	
	public void testOrdenaPrimeirasPosicoes(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, 0, 2);
		Arrays.sort(copy1, 0, 3);
		Assert.assertArrayEquals(copy1, array);	
	}
	
	public void testOrdenaUltimasPosicoes(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, array.length - 3, array.length - 1);
		Arrays.sort(copy1, array.length - 3, array.length);
		Assert.assertArrayEquals(copy1, array);	
	}
	
	public void testOrdenaPosicoesDoMeio(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		int meio = array.length / 2;
		implementation.sort(array, meio - 1, meio + 1);
		Arrays.sort(copy1, meio - 1, meio + 2);
		Assert.assertArrayEquals(copy1, array);	
	}

	public void testLeftIndexNegativo(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, - 1, array.length - 1);
		Assert.assertArrayEquals(copy1, array);	
	}
	
	public void testLeftIndexMaiorQueArray(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, array.length, array.length - 1);
		Assert.assertArrayEquals(copy1, array);	
	}
	
	public void testRightIndexMaiorQueArray(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, 0, array.length);
		Assert.assertArrayEquals(copy1, array);	
	}
	
	public void testLeftIndexMaiorQueRightIndex(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, array.length, 1);
		Assert.assertArrayEquals(copy1, array);	
	}
	
	public void testLeftIndexIgualRightIndex(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, 1, 1);
		Assert.assertArrayEquals(copy1, array);	
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	
	@Test
	public void testSortValoresNegativos() {
		genericTest(vetorValoresNegativos);
	}
	
	@Test
	public void testVetorOrdenado() {
		genericTest(vetorOrdenado);
	}
	
	@Test
	public void testOrdenadoReverso() {
		genericTest(vetorOrdenadoReverso);
	}
	
	@Test
	public void testVetorCom1Elemento() {
		genericTest(vetorCom1Elemento);
	}
	
	@Test
	public void testVetorNulo() {
		genericTest(vetorNulo);
	}
	
	@Test
	public void testVetor1NumeroDiferente() {
		genericTest(vetorComSoUmNumeroDiferente);
	}
	
	@Test
	public void testvetorNomesDiferentes() {
		genericStringTest(vetorNomesDiferentes);
	}
	
	@Test
	public void testvetorNomesLevementeIguais() {
		genericStringTest(vetorNomesLevementeIguais);
	}
	
	@Test
	public void testvetorCom1Nome() {
		genericStringTest(vetorCom1Nome);
	}
	
	@Test
	public void testvetorNomesRepetidos() {
		genericStringTest(vetorNomesRepetidos);
	}
	
	@Test
	public void testvetorNomesOrdenadosInverso() {
		genericStringTest(vetorNomesOrdenadosInverso);
	}
	
	@Test
	public void testvetorNomesOrdenados() {
		genericStringTest(vetorNomesOrdenados);
	}
	
	@Test
	public void testvetorNuloString() {
		genericStringTest(vetorNuloString);
	}
	
	@Test
	public void testSortVetorVazioString() {
		genericStringTest(vetorVazioString);
	}
	
	@Test
	public void testSortOrdenaPrimeirasPosicoes() {
		testOrdenaPrimeirasPosicoes(vetorTamPar);
	}
	
	@Test
	public void testSortOrdenaUltimasPosicoes() {
		testOrdenaUltimasPosicoes(vetorTamPar);
	}
	
	@Test
	public void testSortOrdenaPosicoesDoMeio() {
		testOrdenaPosicoesDoMeio(vetorTamPar);
	}
	
	@Test
	public void testSortLeftIndexNegativo() {
		testLeftIndexNegativo(vetorTamPar);
	}
	
	@Test
	public void testSortLeftIndexMaiorQueArray() {
		testLeftIndexMaiorQueArray(vetorTamPar);
	}
	
	@Test
	public void testSortRightIndexMaiorQueArray() {
		testRightIndexMaiorQueArray(vetorTamPar);
	}
	
	@Test
	public void testSortLeftIndexMaiorQueRightIndex() {
		testLeftIndexMaiorQueRightIndex(vetorTamPar);
	}
	
	@Test
	public void testSortLeftIndexIgualRightIndex() {
		testLeftIndexIgualRightIndex(vetorTamPar);
	}
	
}