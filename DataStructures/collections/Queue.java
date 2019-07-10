package collections;

public class Queue<E>{
    private LinkedList<E> q;

    public Queue(){
        q = new LinkedList<E>();
    }

    public boolean add( E e ){
        q.add(e);
        return true;
    }

    public boolean addAll(Collection<? extends E> c){
		for(E i : c)
			add(i);
		return true;
	}

    public E element(){
        return q.begin();
    }

    public E peek(){
        if (isEmpty()){
            return null;
        }
        return q.front();
    }

    public E poll(){
        if (isEmpty()){
            return null;
        }
        return q.remove();
    }

    public E poll(){
        return q.remove();
    }

    public int size(){
        return q.size();
    }

    public boolean isEmpty(){
        return q.empty();
    }
}