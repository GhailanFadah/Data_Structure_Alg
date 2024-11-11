/*
Author: Ghailan Fadah
Course: 231
class: LinkedList 
Date: 10/22/21
Description: implends a linklist data structure with an Iterator
*/

import java.util.Iterator; // defines the Iterator interface
import java.util.ArrayList;
import java.util.Collections; // contains a shuffle function

public class LinkedList<T> implements Iterable<T> {

    // class for the iterator
    private class LLIterator implements Iterator<T> {

        // creates a node field
        private Node<T> current;

        // sets the node to the head of the linkedlist
        public LLIterator(Node<T> head) {
            this.current = head;
        }

        // checks to see if the current node is not null
        public boolean hasNext() {

            return this.current != null;
        }

        // returns the data contained in the current node and moves it to the next node
        public T next() {
            if (this.hasNext() == true) {

                T data = this.current.getThing();
                this.current = this.current.getNext();
                return data;
            }
            return null;

        }

    }

    // class for the node
    private class Node<T> {

        // fields for the node class
        private Node<T> next;
        private T data;

        // constructor
        public Node(T item) {
            this.data = item;
            this.next = null;
        }

        // returns the data in the node
        public T getThing() {
            return this.data;
        }

        // setter for the next field
        public void setNext(Node<T> n) {
            this.next = n;
        }

        // getter for the next field
        public Node<T> getNext() {
            return this.next;
        }

    }

    // fields for the linkedlist class
    private Node<T> head;
    private int size;

    // constructor
    public LinkedList() {
        this.head = null;

        this.size = 0;
    }

    // resets the fields
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    // getter for the size field
    public int size() {
        return this.size;
    }

    // adds a node to the begining of the list
    public void addFirst(T item) {

        // creates a node with item as its data
        Node<T> newNode = new Node<T>(item);

        // makes the head referance the newNode and adds 1 to size field
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;

    }

    // adds a node to the end of the list
    public void addLast(T item) {

        // if the list is empty call the addFirst method
        if (this.size() == 0) {
            this.addFirst(item);

        } else {
            // create a newNode with item as its data
            Node<T> newNode = new Node<T>(item);

            // create a temp head and make make it referance head
            Node<T> temp = this.head;

            // loop over all the list to the end
            int counter = 0;
            while (counter < this.size - 1) {

                temp = temp.getNext();

                counter++;
            }

            // place the newNode at the end of the list
            newNode.setNext(temp.getNext());

            temp.setNext(newNode);

            // adds 1 to size
            this.size++;

        }
    }

    // adds a node at a specific index
    public void add(int index, T item) {

        // calls the addFirst method if the index is at 0 or the list is empty
        if (this.size() == 0 || index == 0) {
            this.addFirst(item);
        } else {

            // create a newNode with item as its data
            Node<T> newNode = new Node<T>(item);

            // create a temp head and make make it referance head
            Node<T> temp = this.head;

            // loop over all the list to the index given
            int counter = 0;
            while (counter < index - 1) {

                temp = temp.getNext();

                counter++;
            }

            // creates a node there sets its referance
            newNode.setNext(temp.getNext());

            temp.setNext(newNode);

            // adds 1 to size
            size++;
        }
    }

    // removes a node from a specific index
    public T remove(int index) {

        // makes sure list is not empty
        if (this.size != 0) {

            // creates a current and previous node
            Node<T> current = this.head;
            Node<T> previous = null;

            // loop over the list to the index
            int counter = 0;
            while (counter < index) {

                previous = current;
                current = current.getNext();

                counter++;
            }

            /*
             * if the current node == head get the data contained there set head equal to
             * head,getnext() which is the next node since we removed all referance for the
             * orginal head node it will get deleted
             */
            if (current == this.head) {
                T result = current.getThing();
                this.head = this.head.getNext();

                // decrease size by 1 and return result
                this.size--;
                return result;

            } else {

                // else get the data contained in the current node
                T result = current.getThing();

                // set the next field for previous to the current.getnext()
                previous.setNext(current.getNext());

                // decrease size by 1 and return result
                this.size--;
                return result;
            }

        }

        // return null if not possible
        return null;

    }

    // turns a linkedList to an arrayList
    public ArrayList<T> toArrayList() {

        // creates an ArrayList
        ArrayList<T> array = new ArrayList<T>();

        // creates a node and make it referance head
        Node<T> temp = this.head;

        // loop over all the nodes in the list and adds each of its data into the
        // arrayList
        int counter = 0;
        while (counter < this.size) {
            array.add(temp.getThing());
            temp = temp.getNext();

            counter++;

        }

        // returns the arrayList
        return array;
    }

    // shuffles the arrayList
    public ArrayList<T> toShuffledList() {

        // creates an arrayList
        ArrayList<T> array = new ArrayList<T>();

        // sets the arrayList equal to the arrayList we get from calling the toArrayList
        // method
        array = this.toArrayList();

        // uses collections shuffle method to shuffle the list
        Collections.shuffle(array);

        // returns the shuffled list
        return array;
    }

    // method calls the iterator interface
    public Iterator<T> iterator() {
        return new LLIterator(this.head);

    }

    // testing code
    public static void main(String[] args) {
        // LinkedList<Integer> llist = new LinkedList<Integer>();

        // llist.addFirst(5);
        // llist.addFirst(10);
        // llist.addFirst(20);
        // llist.clear();
        // llist.addLast(5);
        // llist.addLast(6);
        // llist.addLast(7);
        // llist.addLast(7);

        // System.out.println(llist);
        // System.out.println(llist.toArrayList());

        // for (Integer num : llist) {
        // System.out.println(num);
        // }

        // llist.remove(1);
        // System.out.println(llist);
        // System.out.println(llist.head.getNext().getThing());

        // System.out.println(llist.toArrayList());
        // System.out.println(llist.toShuffledList());
    }

}
