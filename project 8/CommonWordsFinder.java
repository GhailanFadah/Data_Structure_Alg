/*
Author: Ghailan Fadah
Course: 231
class: CommonWordsFinder
Date: 11/23/21
Description: Program finds the most common words in a file using a PQ 
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommonWordsFinder {

    // field for the class
    PQHeap<KeyValuePair<String, Integer>> pQueue;

    public CommonWordsFinder() {
        pQueue = new PQHeap<KeyValuePair<String, Integer>>(new BiggerFloat());
    }

    // reads a wordcount file
    public void readWordCount(String filename) throws IOException {

        // creates a filereader object
        FileReader read = new FileReader(filename);

        // creates buffer object
        BufferedReader buffer = new BufferedReader(read);

        // reades the first line
        buffer.readLine();

        // assigns each line read to line
        String line = buffer.readLine();

        // while loop to read each line
        while (line != null) {

            // splits each line into words based on a space
            String[] words = line.split(" ");

            // gets the word at index 0 and sets it equal to key
            String key = words[0];

            // gets the word at index 1 and converts it to a integer and sets it equal to
            // value
            Integer value = Integer.parseInt(words[1]);

            KeyValuePair pair = new KeyValuePair<String, Integer>(key, value);

            // creates a node and puts it in the tree
            this.pQueue.add(pair);

            // reads next line
            line = buffer.readLine();
        }

        // closes buffer
        buffer.close();
    }

    public static void main(String[] argv) throws IOException {
        
        // prints usage statement if needs be
        if(argv.length < 2){
            System.out.println("Usage: CommonWordsFinder <N> <WC file 1>"
            + "\n" + "Reports the N most common words in the provided Word Count file.");
            System.exit(1);
        }
        
        // creates instance of the class
        CommonWordsFinder find = new CommonWordsFinder();

        // sets the command line arguments 0 and 1 to the variables
        String filename = argv[1];
        int n = Integer.parseInt(argv[0]);
        
        // calls the readwordcount method on the given file
         find.readWordCount(filename);

        // // a for loop that loops n times each time printing out the item at index 0 and removing it from the PQ
        for (int i = 0; i < n; i++) {
            System.out.println(find.pQueue.remove());
        
            

         }
       
       

    }

}