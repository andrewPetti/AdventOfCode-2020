package com.chemies.AoC2020.day;

import com.chemies.AoC2020.util.FileHelper;
import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public abstract class AbstractDay {
    private Scanner _scanner = new Scanner(in);
    protected FileHelper _fileHelper = new FileHelper();

    protected String dayName;

    public abstract void executePartA();

    public abstract void executePartB();

    protected abstract String getName();

    public String getFormattedName() {
        return Ansi.colorize(getName(), Attribute.RED_TEXT());
    }

    public void executeDay() {
        boolean stop = false;
        while (!stop) {
            out.printf("Run %s part a or b? (q to quit)%n", getFormattedName());
            stop = true;
            String response = _scanner.next().toLowerCase();
            switch (response) {
                case "a":
                    executePartA();
                    break;
                case "b":
                    executePartB();
                    break;
                case "q":
                    out.printf("Exiting %s%n", getFormattedName());
                    return;
                default:
                    stop = false;
                    out.println("Invalid choice. Please pick again");
                    break;
            }
        }
    }

    public String formatAnswer(int result) {
        return Ansi.colorize(String.format("%d", result), Attribute.GREEN_TEXT());
    }

    public String formatAnswer(long result) {
        return Ansi.colorize(String.format("%d", result), Attribute.GREEN_TEXT());
    }
}
