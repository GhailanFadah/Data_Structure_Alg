/*
Author: Ghailan Fadah
Course: 231
class: WordCounter2
Date: 11/14/21
Description: creates a program to analyze files using either a hashmap or bst tree
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WordCounter2 {

    // fields for the class
    MapSet<String, Integer> structure;
    int totalWords;

    // constructor
    public WordCounter2(String dataStructure) {
        this.totalWords = 0;

        // checks whether to create a bst map or hashmap based on what dataStructure is

        // creates a bst map for the structure field
        if (dataStructure.compareToIgnoreCase("bst") == 0) {
            BSTMap<String, Integer> bst = new BSTMap<>(new AscendingString());
            this.structure = bst;
        }

        // creates a hashmap for the structure field
        if (dataStructure.compareToIgnoreCase("hashmap") == 0) {
            Hashmap<String, Integer> map = new Hashmap<>(new AscendingString());
            this.structure = map;
        }

    }

    // splits the file into its words and returns them in an Arraylist
    public ArrayList<String> readWords(String filename) {

        // creates a new ArrayList
        ArrayList<String> list = new ArrayList<String>();
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

                    // if the word has atleast one character
                    if (word.length() != 0) {
                        this.totalWords++;
                        // add it to the list
                        list.add(word);
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

        // return the list
        return list;
    }

    // builds a map of the arrayList of words using a structure field
    public double buildMap(ArrayList<String> words) {

        // start time
        double start = System.nanoTime();

        // loops over all the words in the list
        for (String word : words) {

            // increases the total count by 1

            // makes sure the word is atleast one character long
            if (word.length() != 0) {

                // if the key isn't already in the map call the put method on it with a value of
                // 1
                if (this.structure.containsKey(word) == false) {
                    this.structure.put(word, 1);

                } else {

                    // else call the put method with the new value being increased by one
                    this.structure.put(word, (Integer) this.structure.get(word) + 1);

                }
            }

        }

        // end time
        double end = System.nanoTime();

        // returns the time it took to run method
        return (end - start) / 1000000;
    }

    // clears the structure field
    public void clearMap() {
        this.structure.clear();

        // Extension: lose referance to the old structure

    }

    // returns the total word field
    public int totalWordCount() {
        return totalWords;
    }

    // returns the number of unique words
    public int uniqueWordCount() {

        return this.structure.size();
    }

    // gets the value of a word : the number of times it appears in the text
    public int getCount(String word) {
        if (this.structure.get(word) != null) {
            return (int) this.structure.get(word);
        }

        // returns zero if no word is found
        return 0;

    }

    // returns the frequency of a word
    public double getFrequency(String word) {

        // divides the number of times the word appears by the the total word count
        double frequency = (double) (getCount(word) / (double) totalWordCount());

        return frequency;
    }

    // writes the map to a wordcount file
    public boolean writeWordCount(String filename) {

        try {

            // creates a filereader object
            FileWriter file = new FileWriter(filename);

            // writes the first line and moves to the next line
            file.write("totalWordCount: " + totalWordCount());
            file.write("\n");

            // for each loop loops the arrayList of pairs given by entryset and write it to
            // the file and moves to the next line
            for (int i = 0; i < this.structure.keySet().size(); i++) {
                String key = (String) this.structure.keySet().get(i);
                file.write(key + " " + this.getCount(key));
                file.write("\n");

            }

            // closes the file
            file.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Board.read():: unable to open file " + filename);
        } catch (IOException ex) {
            System.out.println("Board.read():: error reading file " + filename);
        }

        return true;

    }

    // reads a wordcount file
    public boolean readWordCount(String filename) throws IOException {

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
            Integer value = Integer.parseInt(words[1]) * this.totalWords;

            // creates a node and puts it in the tree
            this.structure.put(key, value);

            // reads next line
            line = buffer.readLine();
        }

        // closes buffer
        buffer.close();
        return true;
    }

    // test area
    public static void main(String[] argv) throws IOException {

        WordCounter2 wordcount = new WordCounter2("2012");
        ArrayList<String> list = wordcount.readWords("reddit_comments_2010.txt");

        wordcount.clearMap();
        System.out.println(wordcount.buildMap(list));
        System.out.println(wordcount.totalWords);
        System.out.println(wordcount.uniqueWordCount());
        System.out.println("depth " + wordcount.structure.toString());
        System.out.println("*************************");

        // wordcount.writeWordCount("thebest.txt");

    }

}