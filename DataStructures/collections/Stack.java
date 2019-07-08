package collections;

import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<E>{
    private LinkedList<E> s;
    
    public Stack(){
        s = new LinkedList<E>();
    }
    /**
     * Test if stack is empty
     */
    public boolean empty(){
        return s.size()==0;
    }

    /**
     * Look at top of stack without removing
     * @throws EmptyStackException() if no elements
     */
    public E peek(){
        if (empty()){
            throw new EmptyStackException();
        }
        return s.back();
    }

    /**
     * Remove top element of stack 
     * @return value of removed element
     * @throws EmptyStackException if empty stack
     */
    public E pop(){
        if (empty()){
            throw new EmptyStackException();
        }
        return s.removeBack();
    }

    /**
     * pushes new element onto top of stack
     * @return value of new element
     */
    public E push(E item){
        s.add(item);
        return item;
    }

    /**
     * Finds index of object o
     * @return index of found object, else -1
     */
    public int search(Object o){
        int count = 0;
        for (E i : s){
            if (i==o){
                return count;
            }
            count++;
        }
        return -1;
    }

    public String toString(){
        if (empty()){
            return "{ }";
        }
        StringBuilder str = new StringBuilder();
        str.append("{ ");
        Iterator<E> it = s.iterator();
        it.next();
        for (int i=0; i<s.size(); ++i){
            if (i == s.size()-1){
                str.append("[ " + it + " ]}");
                break;
            }
            str.append(it + ", ");
            it.next();
        }
        return str.toString();
    }
}