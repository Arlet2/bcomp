package ru.ifmo.cs.bcomp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MicroCodeReader {
    public static ArrayList<Pair<String, String>> readMicroCodeFromFile(String path)
            throws FileNotFoundException, NumberFormatException {
        Scanner scanner = new Scanner(new FileInputStream(path));
        StringBuilder lines = new StringBuilder();
        while (scanner.hasNextLine())
            lines.append(scanner.nextLine()).append("\n");
        return splitMicroProgram(lines.toString().split("\n"));
    }
    private static ArrayList<Pair<String, String>> splitMicroProgram(String[] microprogramLines) {
        ArrayList<Pair<String, String>> codeWithLabel = new ArrayList<>();
        String[] args;
        for (String microprogramLine : microprogramLines) {
            args = microprogramLine.split(" ");
            if (args.length == 2)
                codeWithLabel.add(new Pair<>(args[0], args[1]));
            else
                codeWithLabel.add(new Pair<>(args[0], null));
        }
        return codeWithLabel;
    }
    public static ArrayList<Pair<String, String>> readMicroCodeFromString(String microcode) {
        return splitMicroProgram(microcode.split("\n"));
    }

}
