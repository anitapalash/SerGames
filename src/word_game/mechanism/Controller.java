package word_game.mechanism;

import word_game.view.ConsoleHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) throws InterruptedException, IOException {
        ConsoleHelper helper = new ConsoleHelper();
        Mech mech = new Mech();
        mech.setBase(createBaseWord());
        boolean auto_game;

        //выбор режима игры
        auto_game = helper.chooseMode();

        if (auto_game) {
            helper.startGameWithoutPlayer();
            System.out.println(mech.getBase());
            System.out.println("Компьютер готов!");
            mech.run();
            helper.space();
            mech.finish();
        } else {
            helper.startGameWithPlayer();
            System.out.println(mech.getBase());
            mech.run();
            mech.playerGame();
            Thread.sleep(60_000);

            //Финиш и результаты
            helper.space();
            System.out.println("Финиш!");
            helper.space();

            //вывод слов пользователя
            System.out.println("Слова, которые ты составил:");
            mech.results();
            helper.space();

            //вывод возможных слов
            System.out.println("Слова, которые можно было составить:");
            mech.finish();
        }
    }

    //метод, который будет давать нам базовое слово
    public static String createBaseWord() throws IOException {
        String fileName = "src/word_game/dictionaries/base_words.txt";
        BufferedReader dict_reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> dictionary = new ArrayList<>();
        String line;
        while ((line = dict_reader.readLine()) != null) {
            line = line.toLowerCase();
            dictionary.add(line);
        }
        int index = (int) (Math.random() * dictionary.size());
        return dictionary.get(index);
    }
}
