package devprog;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SerDict {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String> dictionary = new ArrayList<>();
    //путь к словарю
    static String path = "C:\\Users\\Анна\\IdeaProjects\\Serg1\\src\\word_game\\dictionaries\\singular.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("Please, wait a minute...");
        DictionaryMaker maker = new DictionaryMaker();
        maker.run();

        while (true) {
            System.out.println("Choose function: (enter a number of it)");
            System.out.println("1. Check if dictionary has this word or not");
            System.out.println("2. Fuse files");
            System.out.println("3. Exit");
            int choice;

            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Something gone wrong. Try one more time");
                continue;
            }catch (IOException e) {
                System.out.println("Something gone wrong. Try one more time");
                continue;
            }

            if(choice == 3) {
                System.out.println("Bye!");
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

            Collections.sort(dictionary);
            FileWriter fw = new FileWriter(path,false);
            for (String s : dictionary) {
                fw.write(s);
                fw.write("\n");
            }
        }
    }

    //функция для ввода слова и добавления его в случае необходимости
    public static void addWord() {

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
    }
}
