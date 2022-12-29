package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackImpl(5);
		stack2 = new StackImpl(2);
		stack3 = new StackImpl(5);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(7);
		stack1.push(7);
		stack1.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
										// permitir outra insercao
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		
		assertEquals(new Integer(3), stack3.pop()); // levanta excecao apenas se
													// stack1 for vazia
	}
	
	// Meus testes
	
	@Test
	public void testIsEmptyStack3() throws StackOverflowException {
		assertTrue(stack3.isEmpty());
		stack3.push(7);
		assertFalse(stack3.isEmpty());
	}
	
	@Test
	public void testTopStack3() throws StackOverflowException {
		stack3.push(7);
		assertEquals(new Integer(7), stack3.top());
	}

	@Test
	public void testFullStack3False(){
		assertFalse(stack3.isFull());
	}
	
	@Test
	public void testFullStack2True() throws StackOverflowException{
		assertTrue(stack2.isFull());
	}
	
	@Test
	public void testTopStack2() throws StackOverflowException {
		assertEquals(new Integer(2), stack2.top());
	}
	
	@Test
	public void tespopStack2() throws StackUnderflowException {
		stack2.pop();
		assertEquals(new Integer(1), stack2.top());
	}
	
	@Test
	public void testFullStack2FalseAposRemocaoDe1Elemento() throws StackUnderflowException{
		stack2.pop();
		assertFalse(stack2.isFull());
	}
	
	@Test
	public void testTopComPilhaVazia() {
		try {
			stack3.top();
			fail("Era esperado uma excessão aqui");
		} catch(RuntimeException e) {
			
		}
	}
	
	@Test
	public void testPilhaTop () throws StackUnderflowException, StackOverflowException {
		stack3.push(1);
		assertEquals(Integer.valueOf(1), stack3.top());
		stack3.push(2);
		assertEquals(Integer.valueOf(2), stack3.top());
		stack3.push(7);
		assertEquals(Integer.valueOf(7), stack3.top());

		stack3.pop();
		assertEquals(Integer.valueOf(2), stack3.top());
		stack3.pop();
		assertEquals(Integer.valueOf(1), stack3.top());
		stack3.pop();
		
	}
	
}