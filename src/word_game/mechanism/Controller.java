package word_game.mechanism;

import word_game.view.ConsoleHelper;
import java.io.IOException;

public class Controller {
    public static void main(String[] args) throws InterruptedException, IOException {
        ConsoleHelper helper = new ConsoleHelper();
        Mech mech = new Mech();
        LevelCreator levelCreator = new LevelCreator(mech);
        boolean auto_game;

        //выбор режима игры
        auto_game = helper.chooseMode();
        levelCreator.setLevel(helper.chooseLevel());

        if (auto_game) {
            helper.startGameWithoutPlayer();
            System.out.println(mech.base);
            System.out.println("Компьютер готов!");
            mech.run();
            levelCreator.createLevel();
            helper.space();
            mech.finish(levelCreator.winnerList);
            helper.space();
            helper.gameWon();
        } else {
            helper.startGameWithPlayer();
            System.out.println(mech.base);
            mech.run();
            levelCreator.createLevel();
            mech.playerGame();
            Thread.sleep(60_000*2);

            //Финиш и результаты
            helper.space();
            System.out.println("Финиш!");
            helper.space();

            //вывод слов пользователя
            System.out.println("Слова, которые ты составил:");
            mech.results();
            helper.space();

            //вывод возможных слов
            System.out.println("Слова, которые нужно было составить для победы:");
            mech.finish(levelCreator.winnerList);

            //вывод результата игры
            helper.space();
            if (levelCreator.isGameWon())
                helper.gameWon();
            else
                helper.gameLost();
        }
    }
}
