package S2.homework.hw03;
/* SELF ASSESSMENT

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, I defined the return type as ArrayList<>
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: Yes, I used file reader and buffer reader to import the file
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:]
- Comment:I add every element into a wordList array list and then return it.

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment:Yes, I set the return type as an array and it returns a sequence of string
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:]
- Comment:Yes, I used the split(",") in order to separate every single element in the wordList

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment:Yes, I set the return type as boolean to detect whether the word list is a unique list or not
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment:Yes, I wrote a for loop to compare two of the string array and check whether they are equal with each other
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment:Yes, I set the boolean as false when a character of the string index
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment:after running out of the for loop, the program set the boolean as true

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment:Yes, I set the return type as boolean to detect whether the word list is a english word or not
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment:Yes, I wrote the binarySearch method in the program
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment:I set an if and else statement in order to return true or false

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment:Yes, I set the return type as boolean to detect whether the word list is a different by one or not
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment:I set a count to check how many character are different from each other. And set a if statement to return true if and only if the count = 1

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment:Yes, I set the return type as boolean to detect whether the word list is a word chain or not
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment:To check whether a word list is a word chain, we need to call every boolean function we wrote above, and use 3 if statement to check the object.
and then finally give it a true if this object don't fit the 3 situation

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment:Yes, I wrote this program using all the lecture notes provided from the recordings and program files and tutorial programs
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment:Yes, the program will ask the the user to input several words separated by comma and the program will act like the example does.

 Total Mark out of 100 (Add all the previous marks):100.
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Wordlinks {
    public static void main(String[] args) {
        boolean quit = false;
        boolean isValid = false;
        Scanner input = new Scanner(System.in);
        while (!quit) {
            System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
            String wordList = input.nextLine();
            String[] wordCheck = readWordList(wordList);
            if(wordCheck == null){
                quit = true;
            }
            else {
                isValid = isWordChain(wordCheck);
                System.out.println((isValid ? "Valid " : "Not a valid ") + "chain of words from Lewis Carroll's word-links game.");
            }
        }
        input.close();
}

    public static ArrayList<String> readDictionary(){
        ArrayList<String> wordList = new ArrayList<String>();
        try
        {
            FileReader fileReader = new FileReader("words.txt");// Enter the entire path of the file if needed
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;

            while(!endOfFile)
            {
                String wordLine = bufferedReader.readLine();
                if (wordLine != null)
                {
                    wordList.add(wordLine);
                }
                else
                {
                    endOfFile = true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } // End try

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return wordList;
    }

    public static String[] readWordList(String words){
        String changedWords = words.trim();
        if(changedWords.length() == 0){          //if(words.equals(""));
            return null;
        }
        String[] string = changedWords.split(",");
        for(int index = 0; index < string.length; index++){
            string[index] = string[index].trim();
        }
        return string;
    }

    public static boolean isUniqueList(String[] uniqueString){
        if(uniqueString.length == 0 ) {
            return false;
        }
        if(uniqueString == null){
            return false;
        }
        for(int i = 0; i < uniqueString.length; i++){
            for(int j = i+1; j < uniqueString.length; j++) {
                if (uniqueString[i].equals(uniqueString[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEnglishWord(String word){
        ArrayList<String> Dictionary = readDictionary();
        if(word == null){
            return false;
        }
        if(Arrays.binarySearch(Dictionary.toArray(),word) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean isDifferentByOne(String firstString, String secondString){
        int count = 0;
        if(firstString.length() != secondString.length()){
            return false;
        }
        for(int i = 0; i < firstString.length(); i++){
            if(firstString.charAt(i) != secondString.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        else
            return false;
    }

    public static boolean isWordChain(String[] wordList){
        if(!isUniqueList(wordList)){
            return false;
        }
        for(String word : wordList){
            if(!isEnglishWord(word)){
                return false;
            }
        }
        for(int i = 0; i < wordList.length - 1; i++){
            if(!isDifferentByOne(wordList[i], wordList[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
