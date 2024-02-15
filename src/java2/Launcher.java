package java2;

import java.util.*;

public class Launcher {
    public static void go(String secretWord, Scanner scanner) {
        char ch;
        String str;
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> guessedWord = new HashMap<>();
        Set<Character> wrongChars = new HashSet<>();
        String[] visibleForPlayer = Image.getVisibleForPlayerMask(secretWord);
        System.out.println("Отгадайте слово: ");
        System.out.println(Arrays.toString(visibleForPlayer));
        for (int i = 0; i < secretWord.length(); i++) {
            char value = secretWord.charAt(i);
            guessedWord.put(i, value);
        }
        for (int i = 0; i < secretWord.length(); i++) {
            char key = secretWord.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int wordsKey = 0;
        int count = 0;
        while (!map.isEmpty() && count < 6) {
            ch = scanner.next().toLowerCase().charAt(0);
            if (Character.isWhitespace(ch)) {
                continue;
            }
            if(CharChecker.isContains(ch, visibleForPlayer) || !CharChecker.isCharValid(ch)){
                CharChecker.isCharUnusable(wrongChars,visibleForPlayer,ch);
            }
            else if(map.get(ch) != null && CharChecker.isCharValid(ch)){
                CharChecker.isCharUsable(map,guessedWord,visibleForPlayer,ch,count,wordsKey);
            }
            else{
                CharChecker.isCharWrong(wrongChars,ch,count);
                count++;
            }

        }
        if (visibleForPlayer.equals(secretWord)) {
            System.out.println("Вы победили!");
    }
        else {
            System.out.println("К сожалению, Вы проиграли.");
            System.out.println("Загаданное слово: " + secretWord);
            System.out.println("количество ошибок: " + count);
        }
    }
}
