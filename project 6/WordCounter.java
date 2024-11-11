
/*
Author: Ghailan Fadah
Course: 231
class: Customer
Date: 10/30/21
Description: creates a program that splits a textfile into its unique words using a BST tree
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WordCounter {

    // total word count;
    private int wordCount;

    // BST tree
    BSTMap<String, Integer> tree;

    // default constructor
    public WordCounter() {
        this.wordCount = 0;
        this.tree = new BSTMap<String, Integer>(new AscendingString());

    }

    // anlyzes the given file to create BST tree
    public void analyze(String filename) {
        try {

            // assign to a variable of type FileReader a new FileReader object, passing
            // filename to the constructor
            FileReader read = new FileReader(filename);

            // assign to a variable of type BufferedReader a new BufferedReader, passing the
            // FileReader variable to the constructor
            BufferedReader buffer = new BufferedReader(read);

            // assign to a variable of type String line the result of calling the readLine
            // method of your BufferedReader object.
            String line = buffer.readLine();

            // start a while loop that loops while line isn't null
            while (!(line == null)) {

                // split line into words. The regular expression can be interpreted
                // as split on anything that is not (^) (a-z or A-Z or 0-9 or ').
                String[] words = line.split("[^a-zA-Z0-9']");

                // go over each word in the list words
                for (int i = 0; i < words.length; i++) {
                    String word = words[i].trim().toLowerCase();

                    // add one to total words
                    this.wordCount++;

                    // if the word has atleast one character
                    // put it in the tree with value one if it is unique
                    // else just increase its value by one
                    if (word.length() != 0) {
                        if (tree.containsKey(word) == false) {
                            tree.put(word, 1);

                        } else {

                            tree.put(word, tree.get(word) + 1);

                        }
                    }

                }

                // read another line
                line = buffer.readLine();

            }
            // call the close method of the BufferedReader
            buffer.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Board.read():: unable to open file " + filename);
        } catch (IOException ex) {
            System.out.println("Board.read():: error reading file " + filename);
        }

    }

    // getter for the total word count
    public int getTotalWordCount() {
        return this.wordCount;
    }

    // getter for the number if unique words
    public int getUniqueWordCount() {
        return this.tree.size();
    }

    // returns the value associated with the given key
    public int getCount(String word) {
        int value = this.tree.get(word);

        return value;
    }

    // retuurns the frequency of a given word
    public double getFrequency(String word) {

        double frequency = getCount(word) / getTotalWordCount();

        return frequency;

    }

    // writes the tree to a file
    public void writeWordCountFile(String filename) throws IOException {
        try {

            // creates a filereader object
            FileWriter file = new FileWriter(filename);

            // writes the first line and moves to the next line
            file.write("totalWordCount: " + getTotalWordCount());
            file.write("\n");

            // for each loop loops the arrayList of pairs given by entryset and write it to
            // the file and moves to the next line
            for (KeyValuePair<String, Integer> pair : tree.entrySet()) {
                file.write(pair.toString());
                file.write("\n");
            }

            // closes the file
            file.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Board.read():: unable to open file " + filename);
        } catch (IOException ex) {
            System.out.println("Board.read():: error reading file " + filename);
        }

    }

    // reads a word file
    public void readWordCountFile(String filename) throws IOException {

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

            // creates a node and puts it in the tree
            this.tree.put(key, value);

            // reads next line
            line = buffer.readLine();
        }

        // closes buffer
        buffer.close();

    }

    // Extension: returns an ArrayList of most common words
    public ArrayList<String> mostWords(int num) {

        // creates two arrayLists
        ArrayList<Integer> vList = new ArrayList<Integer>();
        ArrayList<String> kList = new ArrayList<String>();

        // sets the vList equal to the arrayList of values
        vList = this.tree.values();

        // loop
        for (int i = 0; i < num; i++) {

            // finds the index of the most used word
            int max = vList.indexOf(Collections.max(vList));

            // gets the key at that index
            String key = this.tree.keySet().get(max);

            // adds the key to kList arrayList
            kList.add(key);

            // removes the value from vList in order to find the next most used word
            vList.remove(max);
        }

        // returns the kList
        return kList;

    }

    // testing area
    public static void main(String[] argv) throws IOException {
        WordCounter wCounter = new WordCounter();

        String filename = argv[0];
        String analyzedFile = argv[1];
        double startTime = System.currentTimeMillis();
        wCounter.analyze(filename);
        System.out.println(
                "list of most common words, starting with the most common at index 0: " + wCounter.mostWords(10));
        double endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime));
        System.out.println("Unique words: " + wCounter.getUniqueWordCount());
        System.out.println("Total words: " + wCounter.getTotalWordCount());
        wCounter.writeWordCountFile(analyzedFile);
    }

}
