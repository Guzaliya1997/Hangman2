package java2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {

        String str;
        boolean isPlaying = true;
        List<String> lines = null;

        Scanner sc = new Scanner(System.in);
        while (isPlaying) {
            System.out.println("Меню игры");
            System.out.println("========================");
            System.out.println("1. Новая игра");
            System.out.println("2. Выход");
            System.out.println("========================");
            str = sc.next();
            if ((int) str.charAt(0) == '2') {
                System.out.println("Игра окончена");
                isPlaying = false;
            } else if ((int) str.charAt(0) == '1' && !Dictionary2.isInit ) {
                lines = Dictionary2.init();
                String word = Dictionary2.getWord(lines);
                Launcher.go(word, sc);
            }
            else if ((int) str.charAt(0) == '1' && Dictionary2.isInit ) {
                String word = Dictionary2.getWord(lines);
                Launcher.go(word, sc);
            } else
                System.out.println("Вы ввели не корректный пункт меню, повторите попытку");
        }

    }
}