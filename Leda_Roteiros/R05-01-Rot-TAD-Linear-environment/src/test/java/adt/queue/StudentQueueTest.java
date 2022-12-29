package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueImpl(5);
		queue2 = new CircularQueue(2);
		queue3 = new QueueUsingStack(5);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}
	
	// Meus testes
	
	@Test
	public void testFilaIsEmpty () throws QueueOverflowException {
		assertTrue(queue3.isEmpty());
		queue3.enqueue(1);
		assertFalse(queue3.isEmpty());
	}
	
	@Test
	public void testEnqueueElementNull () throws QueueOverflowException {
		queue3.enqueue(null);
		assertTrue(queue3.isEmpty());
	}
	
	@Test
	public void testEnqueuePushAndHead () throws QueueOverflowException {
		queue3.enqueue(1);
		assertEquals(Integer.valueOf(1), queue3.head());
		queue3.enqueue(2);
		assertEquals(Integer.valueOf(1), queue3.head());
		queue3.enqueue(3);
		queue3.enqueue(4);
		queue3.enqueue(5);
		assertEquals(Integer.valueOf(1), queue3.head());
	}
	
	@Test
	public void testDequeuePopAndHead () throws QueueUnderflowException, QueueOverflowException {
		testEnqueuePushAndHead ();
		queue3.dequeue();
		assertEquals(Integer.valueOf(2), queue3.head());
		queue3.dequeue();
		assertEquals(Integer.valueOf(3), queue3.head());
		queue3.dequeue();
		assertEquals(Integer.valueOf(4), queue3.head());
		queue3.dequeue();
		assertEquals(Integer.valueOf(5), queue3.head());
		queue3.dequeue();

	}
	
	@Test
	public void testFilaIsFull () throws QueueOverflowException {
		assertFalse(queue3.isFull());
		testEnqueuePushAndHead ();
		assertTrue(queue3.isFull());
	}
	
	@Test(expected = QueueUnderflowException.class)
	public void testDequeueSemElementos() throws QueueUnderflowException {
		this.queue3.dequeue();
	}
	
	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComFilaCheia() throws QueueOverflowException {
		testEnqueuePushAndHead ();
		this.queue3.enqueue(6);
	}

}