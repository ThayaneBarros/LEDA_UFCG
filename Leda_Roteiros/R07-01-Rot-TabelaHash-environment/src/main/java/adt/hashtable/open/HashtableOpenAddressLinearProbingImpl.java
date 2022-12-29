package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(element != null && this.indexOf(element) == -1) {
			int sondagem = 0;
			int hash;
			
			while(sondagem < this.capacity()) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, sondagem);
				
				if(this.table[hash] == null || this.table[hash].equals(this.deletedElement)) {
					this.table[hash] = element;
					this.elements++;
					return;
				} else {
					this.COLLISIONS++;
				}
				
				sondagem++;
			}
			
			if(sondagem == this.capacity()) {
				throw new HashtableOverflowException();
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()) {
			int sondagem = 0;
			int hash;
			
			while(sondagem < this.capacity()) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, sondagem);
				
				if(this.table[hash] == null) return;
				else if(this.table[hash].equals(element)) {
					this.table[hash] = this.deletedElement;
					this.elements--;
					this.COLLISIONS -= sondagem;
					return;
				}
				sondagem++;	
			}
		}
	}

	@Override
	public T search(T element) {
		int index = this.indexOf(element);
		
		if(index == -1) return null;
		else return element;
	}

	@Override
	public int indexOf(T element) {
		if(element != null && !this.isEmpty()) {
			int sondagem = 0;
			int hash;
			
			while(sondagem < this.capacity()) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, sondagem);
				
				if(this.table[hash] == null) break;
				else if(this.table[hash].equals(element)) return hash;
				
				sondagem++;
			}
		}
		
		return -1;
	}

}
