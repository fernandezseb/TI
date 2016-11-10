package domein;

import exceptions.EmptyListException;
import java.io.Serializable;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sebastiaan
 * @param <T>
 */
public class MyList<T extends Serializable> implements Iterable<T>, Serializable {

    private String name;

    private Node<T> firstNode;
    private Node<T> lastNode;

    /**
     * Create a new list
     */
    public MyList() {
        this("List");
    }

    /**
     * Create a new list with a given name
     *
     * @param name The name for the new list
     */
    public MyList(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the list
     *
     * @return The new name for the list
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the LinkedList
     *
     * @param name The new name for the list
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns true if the list is empty, false otherwise
     *
     * @return Returns true if the list is empty, otherwise false
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Insert data to the front of the LinkedList
     *
     * @param data The data to add
     */
    public void insertAtFront(T data) {

        Node<T> newNode = new Node<>(data);

        // We kijken of er al iets in zit
        if (isEmpty()) {
            // Indien niet zijn firstNode en lastNode de nieuwe node
            firstNode = lastNode = newNode;
        } else {
            newNode.setNext(firstNode);
            firstNode = newNode;
        }

    }

    /**
     * Insert data to the back of the LinkedList
     *
     * @param data The data to add
     */
    public void insertAtBack(T data) {

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            firstNode = lastNode = newNode;
        } else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
    }

    /**
     * Removes the first node from the LinkedList
     *
     * @return The former first node of the LinkedList
     */
    public T removeFromFront() {
        if (firstNode == null) {
            throw new EmptyListException("List is empty!");
        } else {
            T data = firstNode.getData();

            // We gaan naar een lege lijst?
            if (firstNode == lastNode) {
                firstNode = lastNode = null;
            } else {
                firstNode = firstNode.getNext();
            }

            return data;
        }
    }

    /**
     * Create a String representation of the LinkedList
     *
     * @return A String representation of the LinkedList
     * @see java.util.LinkedList
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return getName() + " is empty";
        } else {
            StringBuilder sb = new StringBuilder()
                    .append("The ")
                    .append(getName())
                    .append(" is:");


            /*
            for (T element : this) {
                sb.append(" ").append(element);
            }
*/
            
            // JAVA 8 AWESOMENESS
            /*this. voor mensen die eraan verslaafd zijn*/
            forEach(elem -> sb.append(elem).append(" "));
            
            return sb.toString();
        }
    }

    private class MyIterator implements Iterator<T> {

        private Node<T> nextNode = firstNode;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            T data = nextNode.getData();
            nextNode = nextNode.getNext();
            return data;
        }
        
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

}
