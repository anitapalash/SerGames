package word_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void startGameWithPlayer() {
        System.out.println("Правила просты: у тебя минута, чтобы составить слова из данного тебе слова");
        System.out.print("Вот тебе слово: ");
    }

    public void startGameWithoutPlayer() {
        System.out.println("Правила просты: необходимо составить слова из данного слова");
        System.out.print("Вот слово: ");
    }

    public void countDown() throws InterruptedException {
        System.out.println("Стартуем через 5 секунд!");
        //Обратный отсчет
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Старт!");
    }

    public void space() {
        System.out.println("\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n");
    }

    public boolean chooseMode() {
        System.out.println("Привет! Хочешь сыграть?");
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
}
