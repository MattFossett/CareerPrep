package collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly LinkedList data structure implementation
 * @MattFossett
 * Complexity Analysis:
 *   searching/indexing: O(N)
 *   inserting: O(1)
 *   removing:  O(1)
 */
public class Array<E> implements Iterable<E>, Cloneable {
	private E[] m_array;
    private int size;
    private int capacity;
	
	/**
	 * 
	 */
	public Array(){
        m_array = new E[10];
        size = 0;
        capacity = 10;
    }
    
    public Array(Array<E> arr){
        m_array = new E[arr.size()*2];
        size = 0;
        capacity = m_array.length;
        for (E i : arr){
            add(i);
        }
    }
	
	/**
	 * Adds element data to the end of the list
	 * @param data
	 */
	public void add( E data ){
        ensureCapacity(size+1);
        m_array[size] = data;
        size++;
	}
	
	/**
	 * adds element data to specified index
	 * @throws IndexOutOfBoundsException
	 * @param index
	 * @param data
	 */
	public void add( int index, E data ){
        ensureCapacity()
	}
    
    public void ensureCapacity(int minCapacity){
        if (capacity < minCapacity){
            E[] big = new E[capacity * 2];
            System.arraycopy(m_array, 0, big, 0, size);
            m_array = big;
            capacity *= 2;
        }
    }



	/**
	 * Adds iterable collection to end of this LinkedList
	 * @param c
	 * @return
	 */
	public boolean addAll(Collection<? extends E> c){
		for(E i : c)
			add(i);
		return true;
	}
	
	/**
	 * Adds iterable collection starting at index 
	 * @param index
	 * @param c 
	 * @return true if success
	 */
	public boolean addAll(int index, Collection<? extends E> c){
        ensureRange(index);
        // Optimization to make sure capacity change is not called many times
        ensureCapacity(c.size()+size);
        // Storing values will be faster than individual insertions into middle off m_array
        E[] temp = new E[size-index];
        System.arraycopy(m_array, index, temp, 0, size-index);
        
        int tempSize = size;
        for(E i : c){
			if (index < tempSize){
                set(index, i);
            } else {
                add(index, i);
            }
			index++;
        }
        System.arraycopy(temp, 0, m_array, size, temp.length());
		return true;
	}
	
	/**
	 * 
	 */
	public void clear(){
        E[] blank = new E[10];
        capacity = 10;
        size = 0;
        m_array = blank;
	}
	
	/**
	 * Returns shallow copy of Array object
	 */
	public Object clone(){
        Array<E> clone = new Array<E>();
        System.arraycopy(m_array, 0, clone, 0, size);
		return clone;
	}
    
    public boolean contains(Object o){
        int index = indexOf(o);
        return index > -1;
    }

    public int indexOf(Object o){
        int ret = 0;
        for (E i : m_array){
            if (i==o){
                return ret; 
            }
            ret++;
        }
        return -1;
    }
    public int lastIndexOf(Object o){
        for (int i=size-1; i>=0; i-- ){
            if (m_array[i] == o ){
                return i;
            }
        }
        return -1;
    }

	/**
	 * Get data located at index
	 * @param index
	 * @return data
	 */
	public E get(int index){
        ensureRange(index);
        return m_array[index];
	}
    
    /**
	 * change a nodes element at specified index
	 * @param index
	 * @param element
	 * @return element
	 */
	public E set(int index, E element){
        ensureRange(index);
        m_array[index] = element;
        return element;
	}

    private void ensureRange(int i){
        if (i > size || i<0){
            throw new IndexOutOfBoundsException();
        }
    }

	/**
	 * @param index
	 * @return data from that node
	 */
	public E remove(int index){
        ensureRange();
        E temp = m_array[index];
        System.arraycopy(m_array, index+1, m_array, index, size-1 );
        size--;
        return temp;
    }

    public boolean remove(Object o){
        int index = indexOf(o);
        if (index < 0) return false;
        remove (index);
        return true;
    }
    /**
     * Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.
     */
    public protected void removeRange (int fromIndex, int toIndex){
        ensureRange(fromIndex);
        ensureRange(toIndex);
        System.arraycopy(m_array, toIndex, m_array, fromIndex, size-(toIndex-fromIndex));
        size-= (toIndex-fromIndex);

    }    
    
	/**
	 * Current number of elements in list
	 * @return
	 */
	public int size(){
		return size;
	}

    public boolean isEmpty(){
        return size==0;
    }

	public String toString(){
		StringBuilder values = new StringBuilder();
		if (this.size()==0){
			return "{ }";
		}
		values.append("{ ");
		for (E i : this){
			values.append(i + ", ");
		}

		values.delete(values.length()-2, values.length());
		values.append(" }");
		return values.toString();
	}
	
	@Override
	public Iterator<E> iterator() {
		ArrayIterator<E> it = new ArrayIterator<E>(this);
		return it;
	}
}

/**
 * This is the implementation for the custom Array iterator.
 */
class ArrayIterator<E> implements Iterator<E> {
    private Array<E> elements;
    private int index;

	/**
	 * Start iterator at index 0
	 *   
	 */
	public ArrayIterator(Array<E> arr){
        elements = arr;
        index = 0;
	}

	@Override
	public boolean hasNext() {
		return index+1 < elements.size();
	}
    
	public boolean hasPrevious(){
		return index-1 > -1;
	}

	@Override
	public E next() {
		if (!hasNext()){
			throw new NoSuchElementException();
		}
		index++;
		return elements[index];
	}

	public E previous(){
		if (!hasPrevious()){
			throw new NoSuchElementException();
		}
		index--;
		return elements[index];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString(){
		return elements[index] + "";
	}
}