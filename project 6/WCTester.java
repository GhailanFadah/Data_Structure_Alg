
/*
Author: Ghailan Fadah
Course: 231
class: Customer
Date: 10/30/21
Description: tests the WordCounter class
*/

import java.io.IOException;

public class WCTester {
    public static void main(String[] argv) throws IOException {

        // creates WordCounter object
        WordCounter wCounter = new WordCounter();

        // file name
        String filename = "counttest.txt";

        // calls analyze method
        wCounter.analyze(filename);

        System.out.println(wCounter.getUniqueWordCount());

        // file name 2
        String filename2 = "counts_ct.txt";
        // calles the write method
        wCounter.writeWordCountFile(filename2);
        // calls the read method
        wCounter.readWordCountFile(filename2);
        // file name 3
        String filename3 = "counts_ct_v2.txt";
        // calls the write method
        wCounter.writeWordCountFile(filename3);

    }
}