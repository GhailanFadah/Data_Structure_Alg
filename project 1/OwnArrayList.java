/*
File: OwnArrayList.java
Author: Ghailan Fadah
Date: 09/13/2021
*/

public class OwnArrayList{

	// creates fields for an array and its size
    private Object [] array;
    private int size;
    private int nextIndex = 0;

    // a constructor that builds an object array with size 10
    public OwnArrayList(){
        this.size = 10;
        this.nextIndex = 0;
        this.array = new Object [this.size];

    }

	// an add method that adds an object to the array list
    public void add(Object newItem){

		if(this.nextIndex < this.size){

			this.array[this.nextIndex] = newItem;
			this.nextIndex++;
		}else{

			// creates an array twice the orginal one
			Object [] tempArray = new Object[this.size * 2];

			// stores the indices of the old array into the new array
			for (int i = 0; i < this.size; i++){
				tempArray[i] = this.array[i];
			}

			// assigns the new array to the old one
			this.array = tempArray;
			this.size *= 2;

			this.array[this.nextIndex] = newItem;
			this.nextIndex++;
		}
	}

	// prints out the inputs of the array
	public String toString(){

		String result = "[";

		for(int i = 0; i < this.nextIndex; i++){
			result += this.array[i] + ", ";
		}

		return result + "]";
	}

	public static void main(String [] args){

		OwnArrayList myList = new OwnArrayList();
		myList.add(6);
		myList.add("hello");
		System.out.print(myList);
	}

}