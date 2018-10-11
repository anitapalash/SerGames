package word_game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Mech {
    private static String base;
    public static void main(String[] args) throws IOException {
        //создаем поток чтения из файла
       String fileName = "C:\\Users\\Анна\\Desktop\\word.txt";
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //поток чтения из консоли
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       //список слов на вывод
       ArrayList<String> words = new ArrayList<>();

       //запрашиваем базовое слово
       System.out.println("Введите базовое слово:");
       base = input.readLine();
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
        output(words);

        //закрываем потоки
       reader.close();
       input.close();
    }

    //функция для обработки слова
    private static List<Character> sortList(String word) {
        //все слова переводим в нижний регистр
        word = word.toLowerCase();
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

    //функция для вывода
    private static void output(List<String> list) {
        //вывод в случае пустого списка
        if (list.size() == 0) {
            System.out.println("Слов нет");
            return;
        }

        //сортируем по алфавиту
        Collections.sort(list);

        //найдем максимальную длину слова из всего списка
        int maxLength = 2;
        for (String s : list)
            if (s.length() > maxLength)
                maxLength = s.length();

        //вывод
        for (int i = 2; i < maxLength; i++) {
            System.out.println("Слова из " + i + " букв, составленные из слова \"" + base +  "\":");
            for (String word : list) {
                if (word.length() == i)
                    System.out.print(word + " ");
            }
            System.out.println("\n");
        }
    }
}
