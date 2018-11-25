package word_game.mechanism;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LevelCreator {
    int level;
    double levelCoef;
    Mech mech;
    ArrayList<String> winnerList;

    public LevelCreator(Mech mech) throws IOException {
        this.mech = mech;
        this.mech.setBase(createBaseWord());
    }

    public void setLevel(int level) {
        this.level = level;
        this.levelCoef = (double)level / 20.0;
    }



    //функция, которая создает текущий уровень
    public void createLevel() {
        winnerList = thisLevelList(mech.words);
    }

    //функция, которая формирует список слов для победы
    ArrayList<String> thisLevelList(ArrayList<String> words) {
        int resultListSize = (int) ((double)words.size() * levelCoef);      //рассчитываем сколько должно быть в массиве для победы,учитывая коэф уровня
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> copy = words;                                     //создаем копию входящего массива, чтобы при удалении из него не удалялось
        for (int i = 0; i < resultListSize; i++)
        {
            int randomIndex = (int) (Math.random() * copy.size());         //случайно берем слово из слов
            result.add(copy.get(randomIndex));                              //добавляем
            copy.remove(randomIndex);                                       //удаляем из копии, чтобы избежать повторов
        }

        return result;
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

    //функция определения победы
    public boolean isGameWon() {
        if (mech.userWords.size() >= winnerList.size())
            return true;
        else return false;
    }
}
