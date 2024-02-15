package java2;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class CharChecker {
   public static boolean isCharValid(char ch) {
        String s = Character.toString(ch);
       boolean test = s.matches("^[а-я]+") ;
       return  test;
    }

    public static boolean isContains(char ch, String[] arr) {
        boolean test = Arrays.stream(arr)
                .anyMatch(x -> x.equals(String.valueOf(ch)));
        return test;
    }

    public static void isCharUsable(Map<Character, Integer> map, Map<Integer, Character> guessedWord, String[] visibleForPlayer, char ch, int count, int wordsKey) {
        if (map.get(ch) == 1) {
            map.remove(ch);
            System.out.println(Image.getImage(count));
        } else {
            while (map.get(ch) != 0) {
                map.put(ch, map.get(ch) - 1);
                Image.getMaskWithGuessedChar(guessedWord, visibleForPlayer, wordsKey, ch);
            }
            map.remove(ch);
        }
        System.out.println("Правильно! " + " Отгаданная буква " + ch + " Слово " + Image.getMaskWithGuessedChar(guessedWord, visibleForPlayer, wordsKey, ch));
        System.out.println(Image.getImage(count));

    }
    public static void isCharUnusable(Set<Character> wrongChars, String[] visibleForPlayer, char ch){
        if (CharChecker.isContains(ch, visibleForPlayer)) {
            System.out.println("Эту букву в слове вы уже угадали");
        }
        else if (!wrongChars.add(ch)) {
            System.out.println("Эту букву вы уже писали, она не подходит");
        } else {
            System.out.println("Вводите только буквы русского алфавита");
        }
    }
    public static void isCharWrong(Set<Character> wrongChars,char ch,int count){
      if(wrongChars.add(ch)){
          count++;
          System.out.println("Количество ошибок: " + count + " Неправильная буква  " + ch);
          System.out.println(Image.getImage(count));
      }
    }

}




