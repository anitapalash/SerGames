package word_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void startGameWithPlayer() {
        System.out.print("Вот тебе слово: ");
    }

    public void startGameWithoutPlayer() {
        System.out.print("Вот слово: ");
    }

    /*
    public void countDown() throws InterruptedException {
        System.out.println("Стартуем через 5 секунд!");
        //Обратный отсчет
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Старт!");
    }
    */

    public void space() {
        System.out.println("\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n");
    }

    public boolean chooseMode() {
        System.out.println("Привет! Хочешь сыграть?");
        System.out.println("Правила просты: необходимо составить слова из данного слова");
        System.out.println("Выбери режим: 1-Игра с компьютером; 2-Компьютер играет с компьютером");
        System.out.print("Твой выбор: ");
        try {
            int choice = Integer.parseInt(reader.readLine());
            if (choice > 2)
                throw new NumberFormatException();
            if (choice == 1)
                return false;
            else if (choice == 2)
                return true;
        } catch (NumberFormatException e) {
            System.out.println("Ты ввел что-то не то :(");
        }
        catch (IOException e) {
            System.out.println("Что-то пошло нет так, извини :(");
        }
        return false;
    }

    public int chooseLevel() throws IOException {
        System.out.println("Тебе также предстоит выбрать уровень. Введи, пожалуйста, число от 1 до 20");
        int level = Integer.parseInt(reader.readLine());
        if (level > 0 || level <= 10) {
            return level;
        } else {
            System.out.println("You've done smt wrong. Try again");
            return chooseLevel();
        }
    }

    public void gameWon() {
        System.out.println("Поздравляем! Уровень пройден!");
    }

    public void gameLost() {
        System.out.println("Сожалеем, уровень не пройден");
    }
}
