package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(element != null) {
			if(this.isFull()) {
				throw new QueueOverflowException();
			} 
			
			try {
				this.stack1.push(element);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T value = this.stack1.top();
		
		try {
			transfersElements(this.stack1, this.stack2);
			value = this.stack2.pop();
			transfersElements(this.stack2, this.stack1);
		} catch (StackOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}
		
		return value;
	}

	private void transfersElements(Stack<T> stack1, Stack<T> stack2) throws StackOverflowException, StackUnderflowException {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}	
	}

	@Override
	public T head() {
		if(isEmpty()) {
			throw new RuntimeException("Pilha vazia");
		}
		
		T value = this.stack1.top();
		
		try {
			transfersElements(this.stack1, this.stack2);
			value = this.stack2.top();
			transfersElements(this.stack2, this.stack1);
		} catch (StackOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

}
