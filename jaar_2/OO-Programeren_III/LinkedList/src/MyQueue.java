/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author bram
 */
public class MyQueue<T> {
    
    private MyList<T> list;
    
    public MyQueue(){
        list = new MyList<>();
    }
    
    public MyQueue(String name){
        list = new MyList<>(name);
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public String toString(){
        return list.toString();
    }
    
    public void offer(T data){
        list.insertAtBack(data);
    }
    
    public T poll(){
        return list.removeFromFront();
    }
}
