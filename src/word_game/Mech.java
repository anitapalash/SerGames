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
        //создаем поток чтения из файла
       String fileName = "C:\\Users\\Анна\\Desktop\\word.txt";
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //поток чтения из консоли
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       //список слов на вывод
       ArrayList<String> words = new ArrayList<>();

       //запрашиваем базовое слово
       System.out.println("Enter base word:");
       String base = input.readLine();
       List<Character> baseList;

       //считываем слова из файла до его конца
       String line;
       while ((line = reader.readLine()) != null) {
           baseList = sortList(base);
           List<Character> word = sortList(line);

           //проверяем, можно ли из букв базового слова составить считанное
           if (contain(baseList, word))
               words.add(line);
       }

       //вывод результатов
       System.out.println("All possible words:");
       if (words.size() == 0)
           System.out.println("None.");
       else
           for (String s : words)
               System.out.println(s);

        //закрываем потоки
       reader.close();
       input.close();
    }

    //функция для обработки слова
    private static List<Character> sortList(String word) {
        //все слова переводим в нижний регистр
        word.toLowerCase();
        //превращаем слово в массив и сортируем по алфавиту
        char[] wordArr = word.toCharArray();
        Arrays.sort(wordArr);
        //превращаем массив в лист для удобства работы с ним
        List<Character> list = new ArrayList<>();
        for (char c : wordArr)
            list.add(c);

        return list;
    }

    //функция, проверяющая вхождение слова в базовое слово
    private static boolean contain(final List<Character> base, final List<Character> word) {
        boolean result = true;
        for(Character c : word){
            if (!base.contains(c)) {
                result = false;
                break;
            }
            else
                base.remove(c);     //вычеркиваем найденные буквы из базового слова
        }

        return result;
    }
}
