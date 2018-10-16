package word_game.view;

public class ConsoleHelper {
    public void start() {
        System.out.println("Привет! Хочешь сыграть?");
        System.out.println("Правила просты: у тебя минута, чтобы составить слова из данного тебе слова");
        System.out.print("Вот тебе слово: ");
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
}
