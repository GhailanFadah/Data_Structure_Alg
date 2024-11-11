/*
Author: Ghailan Fadah
Course: 231
class: PQHeap
Date: 11/23/21
Description: implemends a PQ for keyvalue pairs using the biggerFloat comparator 
*/
import java.util.Comparator;

public class PQHeap<T> {

    // fields for the PQ
    private Object[] heap;
    private int size;
    private int maxSize = 32;
    private Comparator comp;

    // default constructor
    public PQHeap(Comparator comparator) {
        this.size = 0;
        this.comp = comparator;
        this.heap = new Object[maxSize];
    }

    // getter for the size field 
    public int size() {
        return this.size;
    }

    
    // returns the index of the parent of the given index
    private int parent(int position) {

        return ((position - 1) / 2);
    }

    // returns the index of the right child of the given index
    private int rightChild(int position) {

        return ((2 * position) + 2);
    }

    // returns the index of the left child of the given index
    private int leftChild(int position) {

        return ((2 * position) + 1);
    }

    // swaps the two given positions
    private void swap(int firstPos, int secondPos) {
        Object temp;

        temp = this.heap[firstPos];

        this.heap[firstPos] = this.heap[secondPos];

        this.heap[secondPos] = temp;

    }

    // returns whether the position given is a leaf or not
    private boolean isLeaf(int position) {

        if (position >= (size / 2) && position <= size) {
            return true;
        }
        return false;
    }

    // maintains the complete tree property of the PQ
    private void maxHeapify(int position) {

        // gets the position of the children of the given position
        int left = this.leftChild(position);
        int right = this.rightChild(position);

        // while loop that first finds the bigger of the two children than compares it to the given position's value
        // if it is than swap the two positions therefore bubbling down the parent. rinse and repeat till loop is broken
        while (left <= this.size) {
            Integer maxIndex = left;

            // finds the bigger of the two children
            if (right < this.size && this.comp.compare((T) this.heap[right], (T) this.heap[left]) > 0) {
                maxIndex = right;
            }

            // compares bigger child to the given position
            if(comp.compare((T) heap[position], (T) heap[maxIndex]) < 0){
                this.swap(position, maxIndex);
                position = maxIndex;
                left = this.leftChild(position);
                right = this.rightChild(position);
            }else{
                return;
            }
        }
    }

    // adds an element to the PQ
    public void add(T obj) {

        // if statement checks if the array is full
        // if so creates an array double the size and copies all the data to it and sets it as the field array
        if(this.size == (this.maxSize - 1)){
            Object[] temp = new Object[maxSize * 2];
            this.maxSize *= 2;

            for(int i = 0; i < this.size; i++){
                temp[i] = this.heap[i];
            }

            this.heap = temp;
        }

        // sets the element at the size field position then increases size by one
        this.heap[this.size++] = obj;

        // finds the position of the added item
        int current = this.size - 1;

        // while loop that maintains the complete tree property of the PQ
        // if the added element is bigger than its current parent than swap the two and set current
        // equal to the parent of the current 
        while (comp.compare((T) this.heap[current], (T) this.heap[this.parent(current)]) > 0) {
            this.swap(current, this.parent(current));
            current = this.parent(current);
        }

    }

    // removes an element from the PQ
    public T remove(){

        // returns null if PQ is empty
        if(this.size == 0){
            return null;
        }

        // sets popped equal to the elemnt at index 0
        T popped = (T) this.heap[0];

        // sets index zero equal to the element at the end of the PQ
        this.heap[0] = this.heap[--this.size];

        // sort the element to the second half of the array
        this.heap[size + 1] = popped;

        // call the maxHeapify for index zero since it breaks the property
        maxHeapify(0);

        // return the removed element
        return popped;
    }

    // returns the element at index 0 without doing anything to it
    public Object peek() {
        return this.heap[0];
    }

}
