/*
Author: Ghailan Fadah
Course: 231
class: BiggerFloat
Date: 11/23/21
Description: creates a comparator that compares the value of keyvalue pairs
*/

import java.util.Comparator;

public class BiggerFloat implements Comparator<KeyValuePair>{
    
    public int compare(KeyValuePair a, KeyValuePair b) {

        if( (Integer) a.getValue() > (Integer) b.getValue()){
            return 1;
        }

        if( (Integer) a.getValue() < (Integer) b.getValue()){
            return -1;
        }

        return 0;
        
    }

}