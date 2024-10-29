/*
Author: Ghailan Fadah
Course: 231
class: MyQueue
Date: 10/30/21
Description: implements a queue (kinda)
*/

import java.util.Iterator; // defines the Iterator interface
import java.util.ArrayList;

public class MyQueue<T> implements Iterable<T> {

    // class for the iterator
    private class QLIterator implements Iterator<T> {

        // creates a node field
        private Node<T> current;

        // sets the node to the head of the linkedlist
        public QLIterator(Node<T> head) {
            this.current = head;
        }

        // checks to see if the current node is not null
        public boolean hasNext() {

            return this.current != null;
        }

        // returns the data contained in the current node and moves it to the next node
        public T next() {
            if (this.hasNext() == true) {

                T data = this.current.getData();
                this.current = this.current.getNext();
                return data;
            }
            return null;

        }

    }

    private class Node<T> {

        // fields for the node class
        private Node<T> next;
        private Node<T> previous;
        private T data;

        // constructor
        public Node(T data) {
            this.next = null;
            this.previous = null;
            this.data = data;
        }

        // getter for the data in the node
        public T getData() {
            return this.data;
        }

        // getter for the next field
        public Node<T> getNext() {
            return this.next;
        }

        // getter for the previous node
        public Node<T> getPrevious() {
            return this.previous;
        }

        // setter for the next field
        public void setNext(Node<T> n) {
            this.next = n;
        }

        // setter for the previous node
        public void setPrevious(Node<T> p) {
            this.previous = p;
        }
    }

    // fields for the class
    private Node<T> tail;
    private Node<T> head;
    private int size;

    // constructor
    public MyQueue() {

        this.tail = null;
        this.head = null;
        this.size = 0;

    }

    // offer method: adds an element to the end of the list
    public void offer(T data) {
        Node<T> newNode = new Node<T>(data);

        // if the list is empty
        // set head and tail to newNode and increase size field by one
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;

            // else adds the newNode to the end of the list
            // increases size field by one
        } else {

            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.size++;
        }
    }

    // poll method: removes and returns the first element in the list
    public T poll() {
        T remove = null;

        // if list is empty nothing to remove
        if (this.size == 0) {
            System.out.println("Empty queue, cannot poll!");
        }

        // if there is 1 set remove to the data at head and set head and tail to null
        // decrease sie field by one
        if (this.size == 1) {
            remove = this.head.getData();
            this.head = null;
            this.tail = null;
            size--;

            /*
             * set remove equal to the data at head set head to the head's next field set
             * head's previous field to null decrease size by one
             */
        } else {
            remove = this.head.getData();
            this.head = this.head.getNext();
            this.head.setPrevious(null);
            size--;
        }

        // return data
        return remove;
    }

    public T peek() {

        if (this.head == null) {
            return null;
        }

        return this.head.getData();

    }

    // getter for the size field
    public int getSize() {
        return this.size;
    }

    // method calls the iterator interface
    public Iterator<T> iterator() {
        return new QLIterator(this.head);

    }

    // converts the linkedlist to an array list
    public ArrayList<T> toArrayList() {

        // creates new arraylist
        ArrayList<T> result = new ArrayList<T>();

        // creates ilterater
        Iterator<T> iter = this.iterator();

        // adds each item in the linkedlist to the arraylist
        while (iter.hasNext()) {
            result.add(iter.next());
        }

        // returns the arraylist
        return result;
    }

    // used for testing
    public static void main(String[] args) {
        // MyQueue<Integer> llist = new MyQueue<Integer>();

        // llist.offer(5);
        // llist.offer(4);
        // llist.offer(3);
        // System.out.println("size :" + llist.size);
        // System.out.println(llist.head);
        // System.out.println(llist.head);

        // for (Integer num : llist) {
        //     System.out.println(num);
        // }

        // llist.poll();

        // System.out.println("size :" + llist.size);

        // for (Integer num : llist) {
        //     System.out.println(num);
        // }

        // System.out.println("ppek " + llist.peek());

    }

}
