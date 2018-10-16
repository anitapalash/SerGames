package word_game.mechanism;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Mech {
    private static String base;
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> userWords = new ArrayList<>();
    private List<Character> baseList;

    public void run() throws IOException {
        //создаем поток чтения из файла
       String fileName = "C:\\Users\\Анна\\Desktop\\word.txt";
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

       //считываем слова из файла до его конца
       String line;
       while ((line = reader.readLine()) != null) {
           baseList = sortList(base);
           List<Character> word = sortList(line);

           //проверяем, можно ли из букв базового слова составить считанное
           if (contain(baseList, word))
               words.add(line);
       }
       words.remove(base);

       //Таймер
        TimerTask task = new TimerTask() {
            //запускаем механизм
            public void run() {
                try {
                    while (true){
                        //ввод слова
                        System.out.println("Введи слово:");
                        String in = input.readLine();
                        List<Character> word = sortList(in);
                        baseList = sortList(base);

                        //проверяем, можно ли из букв базового слова составить считанное
                        if (contain(baseList, word)) {
                            if (userWords.contains(in))
                                System.out.println("Такое слово уже было!");
                            else {
                                userWords.add(in);
                                System.out.println();
                            }
                        } else
                            System.out.println("Такое слово нельзя составить :(");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        long lasting = 60_000L;                        //Длительность уровня
        timer.schedule(task, 10L, lasting);    //Запуск игры на время

        //закрываем потоки
       reader.close();
       //input.close();
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
    private void output(ArrayList<String> list) {
        //сортируем по алфавиту
        Collections.sort(list);

        //найдем максимальную длину слова из всего списка
        int maxLength = 2;
        for (String s : list)
            if (s.length() > maxLength)
                maxLength = s.length();

        //вывод
        for (int i = 2; i <= maxLength; i++) {
            //создание подгруппы
            List<String> group = new ArrayList<>();
            for (String word : list) {
                if (word.length() == i)
                    group.add(word);
            }

            //вывод подгруппы
            if (group.size() == 0)
                continue;

            System.out.println("Слова из " + i + " букв (Количество слов: " + group.size() + "):");
            for (String k : group)
                System.out.print(k + " ");

            System.out.println("\n");
        }
    }

    public String getBase() {
        return base;
    }

    public Mech(String base) {
        Mech.base = base;
    }

    public void finish () {
        //вывод общего количества
        if (words.size() == 0) {
            System.out.println("Из этого слова нельзя составить ничего :)");
            return;
        }
        System.out.print("Всего из слова \"" + base + "\" можно составить " + words.size() + " слов");
        if (words.size() == 1 || words.size() == 21)
            System.out.println("о");
        else if (words.size() < 5 || (words.size() > 21 && words.size() < 25))
            System.out.println("a");
        else
            System.out.println("\n");
        output(words);   //вывод
    }

    public void results() {
        //вывод общего количества
        if (words.size() == 0) {
            System.out.println("Вы не составили ни одного слова, очень жаль :(");
            return;
        }

        System.out.print("Всего из слова \"" + base + "\" было составлено " + userWords.size() + " слов");
        if (words.size() == 1)
            System.out.println("о");
        else if (words.size() < 5 || (words.size() > 21 && words.size() < 25))
            System.out.println("a");
        else
            System.out.println("\n");
        output(userWords);   //вывод
    }
}
