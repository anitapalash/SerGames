package word_game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Mech {
    public static void main(String[] args) throws IOException {
       String fileName = "C:\\Users\\Анна\\Desktop\\word.txt";
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       ArrayList<String> words = new ArrayList<>();

       System.out.println("Enter base word:");
       String base = input.readLine();
       List<Character> baseList;

       String line;
       while ((line = reader.readLine()) != null) {
           baseList = sortList(base);
           List<Character> word = sortList(line);
           if (contain(baseList, word))
               words.add(line);
       }

       System.out.println("All possible words:");
       if (words == null || words.size() == 0)
           System.out.println("None.");
       else
           for (String s : words)
               System.out.println(s);


       reader.close();
       input.close();
    }

    public static List<Character> sortList(String word) {
        word.toLowerCase();
        char[] wordArr = word.toCharArray();
        Arrays.sort(wordArr);
        List<Character> list = new ArrayList<>();
        for (char c : wordArr)
            list.add(c);

        return list;
    }

    public static boolean contain(final List<Character> base, final List<Character> word) {
        boolean result = true;
        List<Character> copy = base;
        for(Character c : word){
            if (!base.contains(c)) {
                result = false;
                break;
            }
            else
                base.remove(c);
        }

        return result;
    }
}
