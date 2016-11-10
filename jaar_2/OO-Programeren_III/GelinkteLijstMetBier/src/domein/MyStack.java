package domein;

import java.io.Serializable;

public class MyStack<T extends Serializable> {

    private MyList<T> list;
    
    public MyStack(String name) {
        list = new MyList<>(name);
    }
    
    public MyStack() {
        list = new MyList<>();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void push(T data) {
        list.insertAtFront(data);
    }
    
    public T pop() {
        return list.removeFromFront();
    }
    
    public String toString() {
        return list.toString();
    }
    
}