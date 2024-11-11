/*
Author: Ghailan Fadah
Course: 231
class: WordTrendsFinder
Date: 11/23/21
Description: Program that finds the frequency of given words over muitple reddit files
*/

import java.io.IOException;
import java.util.ArrayList;


public class WordTrendsFinder {

    public static void main(String[] args) throws IOException {

        // prints usage statement if needs be
        if(args.length < 3){
            System.out.println("USAGE java WordTrendsFinder <BaseFilename> <FileNumberBegin> <FileNumberEnd> <Word1> <Word2> ..." + "\n" +
            "where <BaseFilename> contains the text part of the name of each WordCount file to analyze." + "\n" +
            "and <FileNumberBegin> specifies the first file's number suffix" + "\n" +
            "and <FileNumberEnd> specifies the last number suffix in the range of word files to analyze." + "\n" +
            "<Word1> <Word2> ... is the list of words to analyze.");
            System.exit(1);
        }



        // creates an instance of the WordCounter2 class with a hashmap as the map type
        WordCounter2 wordcount = new WordCounter2("hashmap");

        // creates to arrayLists of strings
        ArrayList<String> yearList = new ArrayList<String>();
        ArrayList<String> wordList = new ArrayList<String>();
        
        // adds all the values between the given range of years to the yearlist as strings
        for(int i = Integer.parseInt(args[1]); i <= Integer.parseInt(args[2]); i++){

            // converts i to its string value before adding to yearList
            yearList.add(String.valueOf(i));

        }
       
        // adds all the command line arguments to the wordList
        for(String s : args){
            wordList.add(s);
        }

        // removes the first 3 arguemtns since they are not words to find the frequency of
        wordList.remove(0);
        wordList.remove(0);
        wordList.remove(0);

        // nested for loop that goes over all the elements in both list and prints prints out the desired data
        for (String year : yearList) {
            
            // first it access the file of each year
            wordcount.readWordCount(year + args[0]);

            // prints out what year's file it is accessing
            System.out.println("current year file :" + year);

            // access each word in wordList and finds its frequency
            for (String word : wordList) {

                // prints out the word along with its frequency
                System.out.println(word + " " + wordcount.getFrequency(word));

            }

            // prints out a diver between each year's file
            System.out.println("**********************");
        }
    }

}