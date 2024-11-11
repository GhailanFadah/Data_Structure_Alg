/*
Author: Ghailan Fadah
Course: 231
class: Customer
Date: 11/08/21
Description: creates a comparator that compares two strings
*/

import java.util.Comparator;

public class AscendingString implements Comparator<String> {
    public int compare(String a, String b) {

        // calls the compareto() method of the string
        return a.compareTo(b);
    }

}