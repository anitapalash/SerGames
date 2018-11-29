package devprog;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SerDict {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String> dictionary = new ArrayList<>();
    //путь к словарю
    static String path = "C:\\Users\\Анна\\IdeaProjects\\Serg1\\src\\word_game\\dictionaries\\singular.txt";
    static boolean flag = false;        //флаг того, что были какие-либо изменения

    public static void main(String[] args) throws IOException {
        System.out.println("Подожди минуту, пожалуйста...");
        DictionaryMaker maker = new DictionaryMaker();
        maker.run();

        while (true) {
            System.out.println("Выбери функцию: (введи её номер)");
            System.out.println("1. Проверить наличие слова в словаре");
            System.out.println("2. Соединить файлы");
            System.out.println("3. Выход");
            int choice;

            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Что-то пошло не так. Попробуй ещё раз");
                continue;
            }catch (IOException e) {
                System.out.println("Что-то пошло не так. Попробуй ещё раз");
                continue;
            }

            if(choice == 3) {
                System.out.println("Пока!");
                break;
            }

            switch (choice) {
                case 1:
                    addWord();
                    break;
                case 2:
                    fuse();
                    break;
                    default:
                        continue;
            }
            if (flag)
                maker.end();
        }
    }

    //функция для ввода слова и добавления его в случае необходимости
    public static void addWord() throws IOException {
        while (true) {
            System.out.println("\nВведи слово:");
            String word = reader.readLine();
            if (dictionary.contains(word))
                System.out.println("Такое уже есть");
            else {
                System.out.println("Да, такого нет, хочешь добавить? (д/н/e)");
                String choice = reader.readLine();
                if (choice.equals("д")) {
                    dictionary.add(word);
                    flag = true;
                }
                else if (choice.equals("н"))
                    System.out.println("Окей, тогда продолжим");
                else {
                    System.out.println("Я верну тебя в главное меню");
                    return;
                }
            }
        }
    }

    public static void fuse() {

    }

    public static class DictionaryMaker extends Thread {
        public void run() {
            //перенесем все слова в словарь
            String line;
            try (BufferedReader fileReader = new BufferedReader(new FileReader(path))){
                while ((line = fileReader.readLine()) != null) {
                    if (!dictionary.contains(line))
                        dictionary.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void end() throws IOException {
            Collections.sort(dictionary);
            //чистим файл
            PrintWriter printWriter = new PrintWriter(path);
            printWriter.print("");
            printWriter.close();

            //пишем в файл наш обновленный словарь
            BufferedWriter fw = new BufferedWriter(new FileWriter(new File(path)));
            for (String s : dictionary) {
                fw.write(s);
                fw.newLine();
            }
            fw.close();
        }
    }
}
