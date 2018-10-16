package word_game.mechanism;

import word_game.view.ConsoleHelper;

import java.io.IOException;

public class Controller {
    public static void main(String[] args) throws InterruptedException, IOException {
        ConsoleHelper helper = new ConsoleHelper();
        Mech mech;

        //Введение
        helper.start();
        //вместо аргумента будет подаваться резульат метода createBaseWord
        mech = new Mech("картошка");
        //Старт
        System.out.println(mech.getBase());
        //обратный отсчет
        helper.countDown();
        //игра
        mech.run();

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

    //метод, который будет давать нам базовое слово
    private String createBaseWord() {
        return null;
    }
}
