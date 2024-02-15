package java2;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Dictionary2 {


    public static boolean isInit = false;
    public static String getWord(List<String> lines ) throws IOException {
        return  lines.get(new Random().nextInt(lines.size()));

    }
    public static List<String> init() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./src/russian_nouns.txt"));
        isInit = true;
        return lines;
    }
}

