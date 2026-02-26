package Assignment_5;

import java.util.*;
import java.util.regex.*;

public class Editor
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int size = 26;
        LinkedList<String>[] table = new LinkedList[size];

        for (int i = 0; i < size; i++)
        {
            table[i] = new LinkedList<>();
        }

        System.out.print("Enter a Sentence: ");
        String sentence = sc.nextLine();
        //String sentence = "I am a Student of IIIT Kalyani, of the batch 2028";
        String[] allWords = sentence.split(" ");

        for (String word : allWords)
        {
            int index = hashFunction(word, size);
            table[index].add(word);
        }

        System.out.println("\n************    STRING MODIFIER    ************");
        System.out.println("\nInitial Sentence: "+sentence);
        System.out.println("\n1. Add a word");
        System.out.println("2. Modify spelling of any word");
        System.out.println("3. Delete any word");
        System.out.println("4. Add punctuation");
        System.out.println("5. Display Sentence HashTable");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        switch(ch)
        {
            case 1:
                sentence = addWord(sentence);
                rebuildHashTable(sentence, table, size);
                break;
            case 2:
                sentence = modifySpelling(sentence);
                rebuildHashTable(sentence, table, size);
                break;
            case 3:
                sentence = deleteWord(sentence);
                rebuildHashTable(sentence, table, size);
                break;
            case 4:
                sentence = addPunctuation(sentence);
                rebuildHashTable(sentence, table, size);
                break;
            case 5: displayHashTable(table, size);
                break;
            default: System.out.println("\nInvalid Input!");
        }
    }

    static int hashFunction(String word, int size)
    {
        char firstChar = word.charAt(0);
        return ((int) firstChar) % size;
    }

    static String addWord(String sentence)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word to append: ");
        String word = sc.next();
//        System.out.print("Enter index to append the word: ");
//        int index = sc.nextInt();
        sentence = sentence.concat(" ").concat(word);
        System.out.println(sentence);
        return sentence;
    }

    static String modifySpelling(String sentence)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter old spelling: ");
        String oldWord = sc.next();
        System.out.print("Enter new spelling: ");
        String newWord = sc.next();
        sentence = sentence.replaceAll(oldWord, newWord);
        System.out.println(sentence);
        return sentence;
    }

    static String deleteWord(String sentence)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word to delete: ");
        String word = sc.next();
        sentence = sentence.replaceAll(word, "");
        System.out.println(sentence);
        return sentence;
    }

    static String addPunctuation(String sentence)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter punctuation to append: ");
        String pun = sc.next();
        System.out.print("Enter word to append punctuation: ");
        String word = sc.next();
        sentence = sentence.replaceAll(word, word+pun);
        System.out.println(sentence);
        return sentence;
    }

    static void displayHashTable(LinkedList<String>[] table, int size)
    {
        System.out.println("\nHashtable Contents:");
        for (int i = 0; i < size; i++)
        {
            System.out.print("Index " + i + ": ");
            for (String word : table[i])
            {
                System.out.print(word + " -> ");
            }
            System.out.println("null");
        }
    }

    static void rebuildHashTable(String sentence, LinkedList<String>[] table, int size)
    {
        for (int i = 0; i < size; i++)
        {
            table[i].clear();
        }

        String[] words = sentence.split(" ");
        for (String word : words)
        {
            if (!word.isEmpty())
            {
                int index = hashFunction(word, size);
                table[index].add(word);
            }
        }
    }

}
