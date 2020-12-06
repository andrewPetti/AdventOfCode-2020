package com.chemies.AoC2020.day;
import com.chemies.AoC2020.util.FileHelper;
import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import java.util.Scanner;

public abstract class AbstractDay {
    private Scanner _scanner = new Scanner(System.in);
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
        while (stop == false) {
            System.out.println(String.format("Run %s part a or b? (q to quit)", getFormattedName()));
            stop = true;
            String response = _scanner.next().toLowerCase();
            if (response.equals("a")) {
                executePartA();
            } else if (response.equals("b")) {
                executePartB();
            } else if (response.equals("q")) {
                System.out.println(String.format("Exiting %s", getFormattedName()));
                return;
            } else {
                stop = false;
                System.out.println("Invalid choice. Please pick again");
            }
        }
    }

    public String formatAnswer(int result) {
        return Ansi.colorize(String.format("%d", result), Attribute.GREEN_TEXT());
    }
}
