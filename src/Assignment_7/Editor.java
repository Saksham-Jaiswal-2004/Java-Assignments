package Assignment_7;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Editor
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int size = 26;
        String sentence = "";
        List<String> lines = new ArrayList<>();

        System.out.println("\n************    STRING MODIFIER    ************");
        System.out.println("\nInitial Para\n");

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/Assignment_7/data.txt"));
            String line;

            while ((line = br.readLine()) != null)
            {
                lines.add(line);
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error: "+e);
            e.printStackTrace();
        }

        System.out.print("\n\nEnter line number to modify: ");
        int ln = sc.nextInt();

        System.out.println("\n1. Add a word");
        System.out.println("2. Modify spelling of any word");
        System.out.println("3. Delete any word");
        System.out.println("4. Add punctuation");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        sentence = lines.get(ln-1);

        switch(ch)
        {
            case 1:
                sentence = addWord(sentence);
                break;
            case 2:
                sentence = modifySpelling(sentence);
                break;
            case 3:
                sentence = deleteWord(sentence);
                break;
            case 4:
                sentence = addPunctuation(sentence);
                break;
            default: System.out.println("\nInvalid Input!");
        }

        lines.set(ln-1, sentence);

        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Assignment_7/summary.txt", true));
            BufferedWriter bwData = new BufferedWriter(new FileWriter("src/Assignment_7/data.txt"));
            bw.newLine();
            for(String line : lines)
            {
                bw.write(line);
                bw.newLine();

                bwData.write(line);
                bwData.newLine();
            }
            bw.close();
            bwData.close();

            System.out.println();

            BufferedReader br = new BufferedReader(new FileReader("src/Assignment_7/summary.txt"));
            String line;

            while ((line = br.readLine()) != null)
            {
                lines.add(line);
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error: "+e);
            e.printStackTrace();
        }
    }

    static String addWord(String sentence)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter word to append: ");
        String newWord = sc.next();
        System.out.print("Enter index to append: ");
        int index = sc.nextInt();

        String[] words = sentence.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.add(index, newWord);
        sentence = String.join(" ", list);

        System.out.println(sentence);
        return sentence;
    }

    static String modifySpelling(String sentence)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter index of word to modify spelling: ");
        int index = sc.nextInt();
        System.out.print("Enter new spelling: ");
        String newWord = sc.next();

        String[] words = sentence.split(" ");
        words[index-1] = newWord;
        sentence = String.join(" ", words);

        System.out.println(sentence);
        return sentence;
    }

    static String deleteWord(String sentence)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index of word to delete: ");
        int index = sc.nextInt();

        String[] words = sentence.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.remove(index);
        sentence = String.join(" ", list);

        System.out.println(sentence);
        return sentence;
    }

    static String addPunctuation(String sentence)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter punctuation to append: ");
        String pun = sc.next();
        System.out.print("Enter index word to append punctuation: ");
        int index = sc.nextInt();

        String[] words = sentence.split(" ");
        words[index-1] = words[index-1]+pun;
        sentence = String.join(" ", words);

        System.out.println(sentence);
        return sentence;
    }
}
